package Capstone.VoQal.global.auth.service;

import Capstone.VoQal.domain.member.domain.Coach;
import Capstone.VoQal.domain.member.domain.CoachAndStudent;
import Capstone.VoQal.domain.member.domain.Member;
import Capstone.VoQal.domain.member.domain.Student;
import Capstone.VoQal.domain.member.repository.CoachAndStudent.CoachAndStudentRepository;
import Capstone.VoQal.domain.member.repository.Coach.CoachRepository;
import Capstone.VoQal.domain.member.repository.Student.StudentRepository;
import Capstone.VoQal.global.auth.dto.ChangeNicknameDTO;
import Capstone.VoQal.domain.member.repository.Member.MemberRepository;
import Capstone.VoQal.global.auth.dto.MemberListDTO;
import Capstone.VoQal.global.auth.dto.RequestStudentListDTO;
import Capstone.VoQal.global.enums.ErrorCode;
import Capstone.VoQal.global.enums.RequestStatus;
import Capstone.VoQal.global.enums.Role;
import Capstone.VoQal.global.error.exception.BusinessException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProfileService {
    private final MemberRepository memberRepository;
    private final CoachRepository coachRepository;
    private final StudentRepository studentRepository;
    private final CoachAndStudentRepository coachAndStudentRepository;
    private final AuthService authService;
    private final JwtTokenIdDecoder jwtTokenIdDecoder;

    @Transactional
    public void setRoleToCoach() {
        Member member = getCurrentMember();
        Coach coach = Coach.builder()
                .member(member)
                .build();

        member.setCoach(coach);
        member.setRole(Role.COACH);

        coachRepository.save(coach);
        memberRepository.save(member);
    }

    @Transactional
    public List<MemberListDTO> getCoachList() {
        List<Member> coachList = memberRepository.findByRole(Role.COACH);
        List<MemberListDTO> coachListDTO = new ArrayList<>();
        for (Member coach : coachList) {
            coachListDTO.add(new MemberListDTO(coach.getId(), coach.getName()));
        }
        return coachListDTO;
    }

    @Transactional
    public void updateNickname(Long id, ChangeNicknameDTO changeNicknameDTO) {
        Member member = getMemberById(id);
        if (authService.dupliacteNickname(changeNicknameDTO.getNickname())) {
            throw new BusinessException(ErrorCode.NICKNAME_DUPLICATE);
        }
        member.setNickName(changeNicknameDTO.getNickname());
        memberRepository.save(member);
    }



    public List<RequestStudentListDTO> getRequestStudentList() {
        Coach coach = getCurrentCoach();
        List<CoachAndStudent> coachAndStudentList = coachAndStudentRepository.findByCoachIdAndStatus(coach.getId(), RequestStatus.PENDING);
        List<RequestStudentListDTO> requestStudentList = new ArrayList<>();

        for (CoachAndStudent coachAndStudent : coachAndStudentList) {
            Student student = coachAndStudent.getStudent();
            if (student != null) {
                Member studentMember = student.getMember();
                RequestStudentListDTO dto = new RequestStudentListDTO(studentMember.getId(), studentMember.getName());
                requestStudentList.add(dto);
            }
        }

        return requestStudentList;
    }

    @Transactional
    public void requestCoach(Long studentMemberId, Long coachMemberId) {
        Member studentMember = getMemberById(studentMemberId);
        Student student = studentMember.getStudent();

        if (student == null) {
            student = Student.builder()
                    .member(studentMember)
                    .build();
            studentMember.setStudent(student);
            student = studentRepository.save(student);
        }

        Member coachMember = getMemberById(coachMemberId);
        Coach coach = coachMember.getCoach();


        Optional<CoachAndStudent> existingRequest = coachAndStudentRepository.findByCoachIdAndStudentId(coach.getId(), student.getId());
        if (existingRequest.isPresent() && existingRequest.get().getStatus() == RequestStatus.PENDING) {
            throw new BusinessException(ErrorCode.NOT_PENDING_STATUS);
        }

        CoachAndStudent coachAndStudent = CoachAndStudent.builder()
                .coach(coach)
                .student(student)
                .status(RequestStatus.PENDING)
                .build();

        coachAndStudentRepository.save(coachAndStudent);
    }

    @Transactional
    public void approveRequest(Long studentMemberId) {
        Coach coach = getCurrentCoach();
        Member studentMember = getMemberById(studentMemberId);
        Student student = studentMember.getStudent();
        validateStudentEntity(student);

        CoachAndStudent coachAndStudent = getCoachAndStudent(coach.getId(), student.getId());
        if (coachAndStudent.getStatus() != RequestStatus.PENDING) {
            throw new IllegalArgumentException("Invalid request status");
        }
        coachAndStudent.setStatus(RequestStatus.APPROVED);

        studentMember.setRole(Role.STUDENT);
        memberRepository.save(studentMember);
        coachAndStudentRepository.save(coachAndStudent);
    }

    @Transactional
    public void rejectRequest(Long requestId) {
        Coach coach = getCurrentCoach();
        Member studentMember = getMemberById(requestId);
        Student student = studentMember.getStudent();
        validateStudentEntity(student);

        CoachAndStudent coachAndStudent = getCoachAndStudent(coach.getId(), student.getId());
        if (coachAndStudent.getStatus() != RequestStatus.PENDING) {
            throw new IllegalArgumentException("Invalid request status");
        }
        coachAndStudent.setStatus(RequestStatus.REJECTED);

        coachAndStudentRepository.save(coachAndStudent);
    }

    public List<MemberListDTO> getStudentList() {
        Member coach = getCurrentMember();
        List<CoachAndStudent> approveStudent = coachAndStudentRepository.findApprovedStudentsByCoachId(coach.getId());
        List<MemberListDTO> studentList = new ArrayList<>();
        for (CoachAndStudent coachAndStudent : approveStudent) {
            studentList.add(new MemberListDTO(coachAndStudent.getStudent().getId(),
                    coachAndStudent.getStudent().getMember().getName()));
        }
        return studentList;
    }


    @Transactional
    public void deleteStudent(Long studentId) {
        Member coach = getCurrentMember();
        coachAndStudentRepository.deleteByCoachIdAndStudentId(coach.getId(), studentId);
        Member member = getMemberById(studentId);
        member.setRole(Role.GUEST);
    }

    //todo
    // 로직 테스트 다시하기


    private Coach getCurrentCoach() {
        Member coachMember = getCurrentMember();
        Coach coach = coachMember.getCoach();
        if (coach == null) {
            throw new BusinessException(ErrorCode.MEMBER_NOT_FOUND);
        }
        return coach;
    }

    private Member getCurrentMember() {
        long memberId = jwtTokenIdDecoder.getCurrentUserId();
        return getMemberById(memberId);
    }

    private Member getMemberById(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new BusinessException(ErrorCode.INVALID_MEMBER_ID));
    }

    private CoachAndStudent getCoachAndStudent(Long coachId, Long studentId) {
        return coachAndStudentRepository.findByCoachIdAndStudentId(coachId, studentId)
                .orElseThrow(() -> new BusinessException(ErrorCode.INVALID_REQUEST));
    }

    private void validateStudentEntity(Student student) {
        if (student == null) {
            throw new BusinessException(ErrorCode.MEMBER_NOT_FOUND);
        }
    }
}

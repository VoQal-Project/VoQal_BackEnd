package Capstone.VoQal.domain.member.repository.CoachAndStudent;

import Capstone.VoQal.domain.member.domain.CoachAndStudent;
import Capstone.VoQal.domain.member.domain.Member;
import Capstone.VoQal.global.enums.RequestStatus;

import java.util.List;
import java.util.Optional;

public interface CoachAndStudentRepositoryCustom {
    //    Optional<Member> findMemberWithCoachAndStudentById(Long memberId);
    Optional<CoachAndStudent> findByCoachIdAndStudentId(Long coachId, Long studentId);

    List<CoachAndStudent> findByCoachIdAndStatus(Long coachId, RequestStatus status);

    List<CoachAndStudent> findApprovedStudentsByCoachId(Long coachMemberId);

    void deleteByCoachIdAndStudentId(Long coachId, Long studentId);
}

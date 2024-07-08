package Capstone.VoQal.global.auth.controller;


import Capstone.VoQal.global.auth.dto.*;
import Capstone.VoQal.global.auth.service.ProfileService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping("/role/coach")
    @Operation(summary = " 코치로 역할 설정 로직 ", description = "역할을 코치로 설정할 경우")
    public ResponseEntity<String> setRoleCoach() {
        profileService.setRoleToCoach();

        return ResponseEntity.ok("코치로 설정되었습니다");
    }

    @GetMapping("/role/coach")
    @Operation(summary = " 코치 조회 ", description = "학생일 경우를 선택했을 때 코치 리스트 조회")
    public List<MemberListDTO> getCoachList() {
        return profileService.getCoachList();
    }

    @PatchMapping("/{id}/change-nickname")
    @Operation(summary = " 닉네임 변경 ", description = "닉네임을 변경하는 로직")
    public ResponseEntity<String> updateNickname(@PathVariable("id") Long id, @RequestBody ChangeNicknameDTO changeNicknameDTO) {
        profileService.updateNickname(id, changeNicknameDTO);
        return ResponseEntity.ok().body("닉네임 변경에 성공했습니다.");

    }

    //todo
    // Exception 전부 커스텀 exception으로 바꾸기
    // 노션 확인 후 추가로 구현해야할 로직 구현


    @PostMapping("/request")
    @Operation(summary = " 담당 코치 신청 ", description = "코치에게 담당코치로 신청합니다")
    public ResponseEntity<String> requestCoach(@RequestBody StudentRequestDTO studentRequestDTO) {
        Long studentId = studentRequestDTO.getStudentId();
        Long coachId = studentRequestDTO.getCoachId();
        profileService.requestCoach(studentId, coachId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/request")
    @Operation(summary = " 코치에게 신청한 학생 조회 ", description = "코치에게 담당코치로 신청한 학생의 목록을 조회합니다")
    public List<RequestStudentListDTO> getRequestStudentList() {
        return profileService.getRequestStudentList();
    }

    @PostMapping("/approve")
    @Operation(summary = " 코치에게 신청한 학생 승인 ", description = "코치에게 담당코치로 신청한 학생을 승인하여 담당 코치와 학생 관계가 됩니다.")
    public ResponseEntity<String> approveRequest(@RequestBody ApproveRequestDTO approveRequestDTO) {
        Long studentId = approveRequestDTO.getStudentId();
        profileService.approveRequest(studentId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/reject")
    @Operation(summary = " 코치에게 신청한 학생 거절 ", description = "코치에게 담당코치로 신청한 학생을 거절합니다.")
    public ResponseEntity<String> rejectRequest(@RequestBody ApproveRequestDTO approveRequestDTO) {
        Long requestId = approveRequestDTO.getStudentId();
        profileService.rejectRequest(requestId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/student")
    @Operation(summary = "담당 학생 조회 ", description = "본인이 담당하는 학생들의 리스트를 조회합니다.")
    public List<MemberListDTO> studentList() {
        return profileService.getStudentList();
    }

    @DeleteMapping("{id}")
    @Operation(summary = "담당 학생 삭제 ", description = "본인이 담당하는 학생을 삭제합니다.")
    public void studentDelete(@PathVariable("id") Long id) {
        profileService.deleteStudent(id);
    }

}

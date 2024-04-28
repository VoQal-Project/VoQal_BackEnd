package Capstone.VoQal.global.auth.controller;

import Capstone.VoQal.global.auth.dto.*;
import Capstone.VoQal.global.auth.service.AuthService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    @Operation(summary = "회원가입 로직", description = "이메일, 이름, 전화번호, 닉네임, 비밀번호를 입력하면 검증 후 회원가입을 진행합니다.")
    public ResponseEntity<SignUpResponseDTO> signUp(@RequestBody @Valid SignUpRequestDTO signUpRequestDTO) {

        SignUpResponseDTO responseDTO = authService.signUp(signUpRequestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping("/login")
    @Operation(summary = "로그인 로직", description = "이메일, 비밀번호를 입력하면 검증 후 로그인을 진행하고 성공하면 access Token, Refresh Token을 발급합니다.")
    public ResponseEntity<GeneratedTokenDTO> login(@RequestBody @Valid LoginRequestDTO loginRequestDTO) {

        GeneratedTokenDTO generatedTokenDTO = authService.login(loginRequestDTO);
        return ResponseEntity.ok(generatedTokenDTO);

    }

    @PostMapping("/duplicate/nickname")
    @Operation(summary = "닉네임 중복 검사 로직", description = "닉네임이 중복되었는지 검사합니다.")
    public ResponseEntity<String> duplicateNickname(@RequestBody DuplicateDTO.NickName duplicateNicknameDTO) {
        String requestNickname = duplicateNicknameDTO.getNickName();
        boolean isDuplicate = authService.dupliacteNickname(requestNickname);
        if (isDuplicate) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("이미 사용 중인 닉네임 입니다");
        }
        return ResponseEntity.ok("사용 가능한 닉네임 입니다");
    }

    @PostMapping("/duplicate/email")
    @Operation(summary = "이메일 검증 로직", description = "이메일이 중복되었는지 검사합니다")
    public ResponseEntity<String> duplicateEmail(@RequestBody DuplicateDTO.Email duplicateEmailDTO) {
        String requsetEmail = duplicateEmailDTO.getEmail();
        boolean isDuplicate = authService.duplicateEmail(requsetEmail);
        if (isDuplicate) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("이미 사용 중인 이메일 입니다");
        }
        return ResponseEntity.ok("사용 가능한 이메일 입니다");
    }


    @PostMapping("/find/email")
    @Operation(summary = "이메일 찾기 ", description = "전화번호와 이름을 확인하여 이메일을 조회합니다. ver2에는 본인인증도 구현 예정")
    public ResponseEntity<FindEmailResponseDTO> findEmail(@Valid @RequestBody  FindRequestDTO findRequestDTO) {
        String name = findRequestDTO.getName();
        String phoneNumber = findRequestDTO.getPhoneNumber();
        FindEmailResponseDTO findEmailResponseDTO = authService.findEmail(name, phoneNumber);
        return ResponseEntity.ok(findEmailResponseDTO);
    }

    // todo ( 모하지 발표 후 완료된 것들은 삭제 )
    // 1. 컨트롤러에서 올바르지 않은 경우에 대한 응답값도 설정하기
    // 2. mapper 로 코드 리펙토링 (고민중)
    // 3. @PathVariabe 에 관한 의문 ( 해결 )
    // 4. 너무 api 요청을 자주 해서 서버에 무리가 가는건 아닌지..
    // 5. JSON 직렬화, 역직렬화에 대한 개념 정리 (해결)


    @PostMapping("/find/member")
    @Operation(summary = "회원인지 찾기 ", description = "이름과 전화번호 이메일을 사용해서 가입된 회원인지 확인합니다.")
    public ResponseEntity<String> checkMember(@Valid @RequestBody  FindRequestDTO.Password findPasswordRequestDTO) {
        boolean isChecked = authService.checkMember(findPasswordRequestDTO);
        if (isChecked) {
            return ResponseEntity.ok("회원이 맞습니다");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("일치하는 회원 정보가 없습니다");
    }

    @PostMapping("/reset/password")
    @Operation(summary = "비밀번호 재설정 로직 ", description = "이전에 검증할때 사용했던 이메일도 함께 첨부 바람, 비밀번호 재설정 로직")
    public ResponseEntity<String> resetPassword(@Valid @RequestBody FindRequestDTO.ResetPassword resetPasswordDTO) {
        authService.resetPassword(resetPasswordDTO);
        return ResponseEntity.ok("성공적으로 변경되었습니다");

    }

    @PostMapping("/role/coach")
    @Operation(summary = " 코치로 역할 설정 로직 ", description = "역할을 코치로 설정할 경우")
    public ResponseEntity<String> setRoleCoach(@Valid @RequestBody RoleDTO roleDTO) {
        authService.setRoleToCoach(roleDTO);

        return ResponseEntity.ok("코치로 설정되었습니다");
    }

    @GetMapping("/role/coach")
    @Operation(summary = " 코치 조회 ", description = "학생일 경우를 선택했을 때 코치 리스트 조회")
    public List<MemberListDTO> getCoachList() {
        List<MemberListDTO> coachList = authService.getCoachList();
        return coachList;
    }

    @PatchMapping("/{id}/change-nickname")
    @Operation(summary = " 닉네임 변경 ", description = "닉네임을 변경하는 로직")
    public ResponseEntity<String> updateNickname(@PathVariable("id") Long id, @RequestBody ChangeNicknameDTO changeNicknameDTO) {
        authService.updateNickname(id, changeNicknameDTO);
        return ResponseEntity.ok().body("닉네임 변경에 성공했습니다.");

    }
    @PostMapping("/test")
    public String test() {
        return "sucess";
    }
}

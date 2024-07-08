package Capstone.VoQal.global.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpRequestDTO {

    @NotBlank
    private String nickName;

    @NotBlank
    @Email(message = "잘못된 이메일 형식입니다")
    private String email;

    @NotBlank
    private String name;

    @NotBlank
    private String phoneNum;

    @NotBlank
//    @Pattern(message = "잘못된 비밀번호 형식입니다."
//            , regexp = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,15}")
    private String password;

}

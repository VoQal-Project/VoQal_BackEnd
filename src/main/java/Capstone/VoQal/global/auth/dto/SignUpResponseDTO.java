package Capstone.VoQal.global.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@AllArgsConstructor
@Builder
public class SignUpResponseDTO {

    private String nickName;
    private String email;
    private String name;
    private String  phoneNum;

}

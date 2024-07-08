package Capstone.VoQal.global.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
public class DuplicateDTO {

    @Getter
    @Setter
    public static class Email {
        @JsonProperty("email")
        private String email;
    }

    @Getter
    @Setter
    public static class NickName {
        @JsonProperty("nickName")
        private String nickName;
    }
}

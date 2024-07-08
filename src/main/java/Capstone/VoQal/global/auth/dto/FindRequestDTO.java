package Capstone.VoQal.global.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindRequestDTO {

    @NotNull
    private String phoneNumber;
    @NotNull
    private String name;

    @Getter
    @Setter
    public static class Password extends FindRequestDTO {

        @NotNull
        @Email
        private String email;
    }

    @Getter
    @Setter
    public static class ResetPassword  {

        @NotNull
        @Email
        private String email;
        @NotNull
        private String password;
    }

}

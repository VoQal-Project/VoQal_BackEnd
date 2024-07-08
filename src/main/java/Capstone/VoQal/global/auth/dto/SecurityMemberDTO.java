package Capstone.VoQal.global.auth.dto;

import Capstone.VoQal.global.enums.Provider;
import Capstone.VoQal.global.enums.Role;
import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@AllArgsConstructor
public class SecurityMemberDTO {
    private final Long id;
    @Setter
    private Role role;
    private final String email;
    private final String name;
    private final String nickName;
    private final String phoneNum;

    public static SecurityMemberDTO fromClaims(Claims claims) {
        return SecurityMemberDTO.builder().id(Long.valueOf(claims.getId())).email(claims.get("email", String.class)).name(claims.get("name", String.class)).role(Role.fromValue(claims.get("role", String.class))).build();
    }
}

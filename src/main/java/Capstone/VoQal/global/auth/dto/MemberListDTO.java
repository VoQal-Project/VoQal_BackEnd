package Capstone.VoQal.global.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MemberListDTO {
    private Long id;
    private String name;
}

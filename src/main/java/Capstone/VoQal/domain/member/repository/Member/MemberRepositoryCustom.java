package Capstone.VoQal.domain.member.repository.Member;

import Capstone.VoQal.domain.member.domain.Member;
import Capstone.VoQal.global.enums.Role;

import java.util.List;
import java.util.Optional;

public interface MemberRepositoryCustom {
    Optional<Member> findByMemberId(Long memberId);
    void updateRefreshToken(Long id, String refreshToken);
    void updateRole(Long id, Role role);
    List<Member> findAllByIdIn(List<Long> id);
}

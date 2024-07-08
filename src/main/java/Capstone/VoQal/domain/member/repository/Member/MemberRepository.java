package Capstone.VoQal.domain.member.repository.Member;



import Capstone.VoQal.domain.member.domain.Member;
import Capstone.VoQal.global.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {

    Optional<Member> findByNickName(String nickName);

    Optional<Member> findByEmail(String email);

    Optional<Member> findByName(String name);

    Optional<Member> findByPhoneNumber(String phoneNumber);

    List<Member> findByRole(Role role);

    Optional<Member> findByNameAndPhoneNumber(String name, String phoneNumber);

    Optional<Member> findByNameAndPhoneNumberAndEmail(String name, String phoneNumber, String email);
}

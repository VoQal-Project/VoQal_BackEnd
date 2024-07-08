package Capstone.VoQal.domain.member.repository.Member;

import Capstone.VoQal.domain.member.domain.Member;
import Capstone.VoQal.domain.member.domain.QMember;
import Capstone.VoQal.global.enums.Role;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryCustomImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<Member> findByMemberId(Long memberId) {
        QMember member = QMember.member;

        Member foundMember = queryFactory.selectFrom(member)
                .where(member.id.eq(memberId))
                .fetchOne();

        return Optional.ofNullable(foundMember);
    }

    @Override
    @Transactional
    public void updateRefreshToken(Long id, String refreshToken) {
        QMember member = QMember.member;

        queryFactory.update(member)
                .set(member.refreshToken, refreshToken)
                .where(member.id.eq(id))
                .execute();
    }

    @Override
    @Transactional
    public void updateRole(Long id, Role role) {
        QMember member = QMember.member;

        queryFactory.update(member)
                .set(member.role, role)
                .where(member.id.eq(id))
                .execute();
    }

    @Override
    public List<Member> findAllByIdIn(List<Long> id) {
        QMember member = QMember.member;

        return queryFactory.selectFrom(member)
                .where(member.id.in(id))
                .fetch();
    }
}

package Capstone.VoQal.domain.challenge.domain;

import Capstone.VoQal.domain.member.domain.Member;
import Capstone.VoQal.global.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "challenge_post")
public class ChallengePost extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private String challengeRecordUrl;

    private String thumbnailUrl;

    @ManyToOne
    @JoinColumn(name = "challengeKeyword")
    private ChallengeKeyword challengeKeyword;
}

package Capstone.VoQal.domain.challenge.domain;

import Capstone.VoQal.global.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "challenge_keyword")
public class ChallengeKeyword extends BaseEntity {

    @OneToMany(mappedBy = "challengeKeyword")
    private List<ChallengePost> challengePost;
}

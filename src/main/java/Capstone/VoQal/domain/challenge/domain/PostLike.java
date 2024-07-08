package Capstone.VoQal.domain.challenge.domain;

import Capstone.VoQal.global.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "post_like")
public class PostLike extends BaseEntity {

    @OneToMany(mappedBy = "postLike")
    private Set<MemberAndPostLike> memberAndPostLike;

}

package Capstone.VoQal.domain.member.domain;


import Capstone.VoQal.domain.lesson.domain.LessonNote;
import Capstone.VoQal.global.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.*;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "coach")
public class Coach extends BaseEntity {

    @Id
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "member_id")
    private Member member;


    @OneToMany(mappedBy = "coach", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<CoachAndStudent> coachAndStudents;

    @OneToOne(mappedBy = "coach", fetch = FetchType.LAZY)
    private LessonNote lessonNote;


    public void setMember(Member member) {
        this.member = member;
    }
}

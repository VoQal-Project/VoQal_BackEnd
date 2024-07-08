package Capstone.VoQal.domain.member.domain;

import Capstone.VoQal.domain.challenge.domain.ChallengePost;
import Capstone.VoQal.domain.challenge.domain.MemberAndPostLike;
import Capstone.VoQal.domain.chatting.domain.MemberAndChatRoom;
import Capstone.VoQal.global.domain.BaseEntity;
import Capstone.VoQal.global.enums.Provider;
import Capstone.VoQal.global.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@SuperBuilder
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "member")
public class Member extends BaseEntity {


    @Setter
    private String refreshToken;

    @Column(length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    @Setter
    private Role role;

    @Column(length = 20, nullable = true)
    @Setter
    private String nickName;


    private String password;

    private String email;

    private String phoneNumber;

    private String name;

    @OneToOne(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Student student;

    @OneToOne(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Coach coach;

    @OneToOne(mappedBy = "member", fetch = FetchType.LAZY)
    private ChallengePost challengePost;


    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private Set<MemberAndPostLike> memberAndPostLike;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private Set<MemberAndChatRoom> memberAndChatRoom;


    public void changePassword(String newPassword) {
        this.password = newPassword;
    }
    public void setStudent(Student student) {
        this.student = student;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }
}

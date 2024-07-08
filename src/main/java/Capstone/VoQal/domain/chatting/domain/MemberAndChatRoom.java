package Capstone.VoQal.domain.chatting.domain;

import Capstone.VoQal.domain.member.domain.Member;
import Capstone.VoQal.global.domain.BaseEntity;
import jakarta.persistence.*;
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
@Table(name = "member_and_chatroom")
public class MemberAndChatRoom extends BaseEntity {

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chatroom")
    private ChatRoom chatRoom;


    @OneToMany(mappedBy = "memberAndChatRoom", fetch = FetchType.LAZY)
    private List<ChatContent> chatContent;
}

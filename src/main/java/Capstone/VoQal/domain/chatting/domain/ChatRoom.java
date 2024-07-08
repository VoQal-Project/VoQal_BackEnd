package Capstone.VoQal.domain.chatting.domain;


import Capstone.VoQal.global.domain.BaseEntity;
import jakarta.persistence.*;
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
@Table(name = "chatroom")
public class ChatRoom extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @OneToMany(mappedBy = "chatRoom", fetch = FetchType.LAZY)
    private Set<MemberAndChatRoom> memberAndChatRoom;


}

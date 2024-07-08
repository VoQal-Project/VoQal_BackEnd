package Capstone.VoQal.domain.chatting.domain;

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
@Table(name = "chat_content")
public class ChatContent extends BaseEntity {

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "memberAndChatRoom")
    private MemberAndChatRoom memberAndChatRoom;

    @Column(nullable = false)
    private String chatText;

    @Column(nullable = false)
    private String chatFilesUrl;

}

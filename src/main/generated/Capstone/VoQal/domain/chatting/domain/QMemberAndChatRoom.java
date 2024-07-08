package Capstone.VoQal.domain.chatting.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberAndChatRoom is a Querydsl query type for MemberAndChatRoom
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberAndChatRoom extends EntityPathBase<MemberAndChatRoom> {

    private static final long serialVersionUID = 595616682L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemberAndChatRoom memberAndChatRoom = new QMemberAndChatRoom("memberAndChatRoom");

    public final Capstone.VoQal.global.domain.QBaseEntity _super = new Capstone.VoQal.global.domain.QBaseEntity(this);

    public final ListPath<ChatContent, QChatContent> chatContent = this.<ChatContent, QChatContent>createList("chatContent", ChatContent.class, QChatContent.class, PathInits.DIRECT2);

    public final QChatRoom chatRoom;

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final Capstone.VoQal.domain.member.domain.QMember member;

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    public QMemberAndChatRoom(String variable) {
        this(MemberAndChatRoom.class, forVariable(variable), INITS);
    }

    public QMemberAndChatRoom(Path<? extends MemberAndChatRoom> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMemberAndChatRoom(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMemberAndChatRoom(PathMetadata metadata, PathInits inits) {
        this(MemberAndChatRoom.class, metadata, inits);
    }

    public QMemberAndChatRoom(Class<? extends MemberAndChatRoom> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.chatRoom = inits.isInitialized("chatRoom") ? new QChatRoom(forProperty("chatRoom")) : null;
        this.member = inits.isInitialized("member") ? new Capstone.VoQal.domain.member.domain.QMember(forProperty("member"), inits.get("member")) : null;
    }

}


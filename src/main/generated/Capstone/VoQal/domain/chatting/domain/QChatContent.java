package Capstone.VoQal.domain.chatting.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QChatContent is a Querydsl query type for ChatContent
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QChatContent extends EntityPathBase<ChatContent> {

    private static final long serialVersionUID = -1804719909L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QChatContent chatContent = new QChatContent("chatContent");

    public final Capstone.VoQal.global.domain.QBaseEntity _super = new Capstone.VoQal.global.domain.QBaseEntity(this);

    public final StringPath chatFilesUrl = createString("chatFilesUrl");

    public final StringPath chatText = createString("chatText");

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final QMemberAndChatRoom memberAndChatRoom;

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    public QChatContent(String variable) {
        this(ChatContent.class, forVariable(variable), INITS);
    }

    public QChatContent(Path<? extends ChatContent> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QChatContent(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QChatContent(PathMetadata metadata, PathInits inits) {
        this(ChatContent.class, metadata, inits);
    }

    public QChatContent(Class<? extends ChatContent> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.memberAndChatRoom = inits.isInitialized("memberAndChatRoom") ? new QMemberAndChatRoom(forProperty("memberAndChatRoom"), inits.get("memberAndChatRoom")) : null;
    }

}


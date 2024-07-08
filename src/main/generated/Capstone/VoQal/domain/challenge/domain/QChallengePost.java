package Capstone.VoQal.domain.challenge.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QChallengePost is a Querydsl query type for ChallengePost
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QChallengePost extends EntityPathBase<ChallengePost> {

    private static final long serialVersionUID = 1710465672L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QChallengePost challengePost = new QChallengePost("challengePost");

    public final Capstone.VoQal.global.domain.QBaseEntity _super = new Capstone.VoQal.global.domain.QBaseEntity(this);

    public final QChallengeKeyword challengeKeyword;

    public final StringPath challengeRecordUrl = createString("challengeRecordUrl");

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final Capstone.VoQal.domain.member.domain.QMember member;

    public final StringPath thumbnailUrl = createString("thumbnailUrl");

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    public QChallengePost(String variable) {
        this(ChallengePost.class, forVariable(variable), INITS);
    }

    public QChallengePost(Path<? extends ChallengePost> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QChallengePost(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QChallengePost(PathMetadata metadata, PathInits inits) {
        this(ChallengePost.class, metadata, inits);
    }

    public QChallengePost(Class<? extends ChallengePost> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.challengeKeyword = inits.isInitialized("challengeKeyword") ? new QChallengeKeyword(forProperty("challengeKeyword")) : null;
        this.member = inits.isInitialized("member") ? new Capstone.VoQal.domain.member.domain.QMember(forProperty("member"), inits.get("member")) : null;
    }

}


package Capstone.VoQal.domain.challenge.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QChallengeKeyword is a Querydsl query type for ChallengeKeyword
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QChallengeKeyword extends EntityPathBase<ChallengeKeyword> {

    private static final long serialVersionUID = 567732993L;

    public static final QChallengeKeyword challengeKeyword = new QChallengeKeyword("challengeKeyword");

    public final Capstone.VoQal.global.domain.QBaseEntity _super = new Capstone.VoQal.global.domain.QBaseEntity(this);

    public final ListPath<ChallengePost, QChallengePost> challengePost = this.<ChallengePost, QChallengePost>createList("challengePost", ChallengePost.class, QChallengePost.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    public QChallengeKeyword(String variable) {
        super(ChallengeKeyword.class, forVariable(variable));
    }

    public QChallengeKeyword(Path<? extends ChallengeKeyword> path) {
        super(path.getType(), path.getMetadata());
    }

    public QChallengeKeyword(PathMetadata metadata) {
        super(ChallengeKeyword.class, metadata);
    }

}


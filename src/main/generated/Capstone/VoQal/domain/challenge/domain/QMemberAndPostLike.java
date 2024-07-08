package Capstone.VoQal.domain.challenge.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberAndPostLike is a Querydsl query type for MemberAndPostLike
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberAndPostLike extends EntityPathBase<MemberAndPostLike> {

    private static final long serialVersionUID = -663100231L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemberAndPostLike memberAndPostLike = new QMemberAndPostLike("memberAndPostLike");

    public final Capstone.VoQal.global.domain.QBaseEntity _super = new Capstone.VoQal.global.domain.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final Capstone.VoQal.domain.member.domain.QMember member;

    public final QPostLike postLike;

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    public QMemberAndPostLike(String variable) {
        this(MemberAndPostLike.class, forVariable(variable), INITS);
    }

    public QMemberAndPostLike(Path<? extends MemberAndPostLike> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMemberAndPostLike(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMemberAndPostLike(PathMetadata metadata, PathInits inits) {
        this(MemberAndPostLike.class, metadata, inits);
    }

    public QMemberAndPostLike(Class<? extends MemberAndPostLike> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new Capstone.VoQal.domain.member.domain.QMember(forProperty("member"), inits.get("member")) : null;
        this.postLike = inits.isInitialized("postLike") ? new QPostLike(forProperty("postLike")) : null;
    }

}


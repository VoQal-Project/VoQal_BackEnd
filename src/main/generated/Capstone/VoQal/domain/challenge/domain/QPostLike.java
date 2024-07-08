package Capstone.VoQal.domain.challenge.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPostLike is a Querydsl query type for PostLike
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPostLike extends EntityPathBase<PostLike> {

    private static final long serialVersionUID = -892965294L;

    public static final QPostLike postLike = new QPostLike("postLike");

    public final Capstone.VoQal.global.domain.QBaseEntity _super = new Capstone.VoQal.global.domain.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final SetPath<MemberAndPostLike, QMemberAndPostLike> memberAndPostLike = this.<MemberAndPostLike, QMemberAndPostLike>createSet("memberAndPostLike", MemberAndPostLike.class, QMemberAndPostLike.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    public QPostLike(String variable) {
        super(PostLike.class, forVariable(variable));
    }

    public QPostLike(Path<? extends PostLike> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPostLike(PathMetadata metadata) {
        super(PostLike.class, metadata);
    }

}


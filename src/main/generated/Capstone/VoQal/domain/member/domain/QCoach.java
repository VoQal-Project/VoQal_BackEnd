package Capstone.VoQal.domain.member.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCoach is a Querydsl query type for Coach
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCoach extends EntityPathBase<Coach> {

    private static final long serialVersionUID = 268425760L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCoach coach = new QCoach("coach");

    public final Capstone.VoQal.global.domain.QBaseEntity _super = new Capstone.VoQal.global.domain.QBaseEntity(this);

    public final SetPath<CoachAndStudent, QCoachAndStudent> coachAndStudents = this.<CoachAndStudent, QCoachAndStudent>createSet("coachAndStudents", CoachAndStudent.class, QCoachAndStudent.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final Capstone.VoQal.domain.lesson.domain.QLessonNote lessonNote;

    public final QMember member;

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    public QCoach(String variable) {
        this(Coach.class, forVariable(variable), INITS);
    }

    public QCoach(Path<? extends Coach> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCoach(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCoach(PathMetadata metadata, PathInits inits) {
        this(Coach.class, metadata, inits);
    }

    public QCoach(Class<? extends Coach> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.lessonNote = inits.isInitialized("lessonNote") ? new Capstone.VoQal.domain.lesson.domain.QLessonNote(forProperty("lessonNote"), inits.get("lessonNote")) : null;
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member"), inits.get("member")) : null;
    }

}


package Capstone.VoQal.domain.member.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCoachAndStudent is a Querydsl query type for CoachAndStudent
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCoachAndStudent extends EntityPathBase<CoachAndStudent> {

    private static final long serialVersionUID = -45629788L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCoachAndStudent coachAndStudent = new QCoachAndStudent("coachAndStudent");

    public final Capstone.VoQal.global.domain.QBaseEntity _super = new Capstone.VoQal.global.domain.QBaseEntity(this);

    public final QCoach coach;

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath lessonSongUrl = createString("lessonSongUrl");

    public final EnumPath<Capstone.VoQal.global.enums.RequestStatus> status = createEnum("status", Capstone.VoQal.global.enums.RequestStatus.class);

    public final QStudent student;

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    public QCoachAndStudent(String variable) {
        this(CoachAndStudent.class, forVariable(variable), INITS);
    }

    public QCoachAndStudent(Path<? extends CoachAndStudent> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCoachAndStudent(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCoachAndStudent(PathMetadata metadata, PathInits inits) {
        this(CoachAndStudent.class, metadata, inits);
    }

    public QCoachAndStudent(Class<? extends CoachAndStudent> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.coach = inits.isInitialized("coach") ? new QCoach(forProperty("coach"), inits.get("coach")) : null;
        this.student = inits.isInitialized("student") ? new QStudent(forProperty("student"), inits.get("student")) : null;
    }

}


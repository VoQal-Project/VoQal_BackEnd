package Capstone.VoQal.domain.member.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStudent is a Querydsl query type for Student
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStudent extends EntityPathBase<Student> {

    private static final long serialVersionUID = 1735921217L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStudent student = new QStudent("student");

    public final Capstone.VoQal.global.domain.QBaseEntity _super = new Capstone.VoQal.global.domain.QBaseEntity(this);

    public final SetPath<CoachAndStudent, QCoachAndStudent> coachAndStudents = this.<CoachAndStudent, QCoachAndStudent>createSet("coachAndStudents", CoachAndStudent.class, QCoachAndStudent.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final Capstone.VoQal.domain.lesson.domain.QLessonNote lessonNote;

    public final StringPath lessonSong = createString("lessonSong");

    public final QMember member;

    public final SetPath<Capstone.VoQal.domain.reservation.domain.Reservation, Capstone.VoQal.domain.reservation.domain.QReservation> reservation = this.<Capstone.VoQal.domain.reservation.domain.Reservation, Capstone.VoQal.domain.reservation.domain.QReservation>createSet("reservation", Capstone.VoQal.domain.reservation.domain.Reservation.class, Capstone.VoQal.domain.reservation.domain.QReservation.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    public QStudent(String variable) {
        this(Student.class, forVariable(variable), INITS);
    }

    public QStudent(Path<? extends Student> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStudent(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStudent(PathMetadata metadata, PathInits inits) {
        this(Student.class, metadata, inits);
    }

    public QStudent(Class<? extends Student> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.lessonNote = inits.isInitialized("lessonNote") ? new Capstone.VoQal.domain.lesson.domain.QLessonNote(forProperty("lessonNote"), inits.get("lessonNote")) : null;
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member"), inits.get("member")) : null;
    }

}


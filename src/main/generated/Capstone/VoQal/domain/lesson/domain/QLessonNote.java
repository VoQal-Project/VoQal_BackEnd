package Capstone.VoQal.domain.lesson.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLessonNote is a Querydsl query type for LessonNote
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLessonNote extends EntityPathBase<LessonNote> {

    private static final long serialVersionUID = -1616110942L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLessonNote lessonNote = new QLessonNote("lessonNote");

    public final Capstone.VoQal.global.domain.QBaseEntity _super = new Capstone.VoQal.global.domain.QBaseEntity(this);

    public final Capstone.VoQal.domain.member.domain.QCoach coach;

    public final StringPath contents = createString("contents");

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath lessonNoteTitle = createString("lessonNoteTitle");

    public final StringPath recordUrl = createString("recordUrl");

    public final StringPath songTitle = createString("songTitle");

    public final Capstone.VoQal.domain.member.domain.QStudent student;

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    public QLessonNote(String variable) {
        this(LessonNote.class, forVariable(variable), INITS);
    }

    public QLessonNote(Path<? extends LessonNote> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLessonNote(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLessonNote(PathMetadata metadata, PathInits inits) {
        this(LessonNote.class, metadata, inits);
    }

    public QLessonNote(Class<? extends LessonNote> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.coach = inits.isInitialized("coach") ? new Capstone.VoQal.domain.member.domain.QCoach(forProperty("coach"), inits.get("coach")) : null;
        this.student = inits.isInitialized("student") ? new Capstone.VoQal.domain.member.domain.QStudent(forProperty("student"), inits.get("student")) : null;
    }

}


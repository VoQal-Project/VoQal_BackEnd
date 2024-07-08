package Capstone.VoQal.domain.member.domain;

import Capstone.VoQal.global.domain.BaseEntity;
import Capstone.VoQal.global.enums.RequestStatus;
import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "coach_and_student")
public class CoachAndStudent extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coach_id")
    private Coach coach;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @Enumerated(EnumType.STRING)
    @Setter
    private RequestStatus status;

    private String lessonSongUrl;



}

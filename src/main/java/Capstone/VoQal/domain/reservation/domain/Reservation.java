package Capstone.VoQal.domain.reservation.domain;

import Capstone.VoQal.domain.member.domain.Student;
import Capstone.VoQal.global.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "reservations")
public class Reservation extends BaseEntity {

    @Column(nullable = false)
    private int roomNumber;

    @Column(nullable = false)
    private LocalDate reservationDate;

    @Column(nullable = false)
    private LocalTime reservationTime;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;
}

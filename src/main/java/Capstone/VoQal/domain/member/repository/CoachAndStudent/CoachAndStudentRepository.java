package Capstone.VoQal.domain.member.repository.CoachAndStudent;

import Capstone.VoQal.domain.member.domain.Coach;
import Capstone.VoQal.domain.member.domain.CoachAndStudent;
import Capstone.VoQal.global.enums.RequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CoachAndStudentRepository extends JpaRepository<CoachAndStudent, Long>, CoachAndStudentRepositoryCustom {

    List<CoachAndStudent> findByCoachId(Long coachId);

    List<CoachAndStudent> findByStatus(RequestStatus status);
}

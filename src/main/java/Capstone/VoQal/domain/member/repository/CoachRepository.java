package Capstone.VoQal.domain.member.repository;

import Capstone.VoQal.domain.member.domain.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachRepository extends JpaRepository<Coach, Long> {
}

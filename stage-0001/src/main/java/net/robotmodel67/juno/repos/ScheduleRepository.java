package net.robotmodel67.juno.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import net.robotmodel67.juno.models.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
	Schedule findByUuid(String uuid);
}

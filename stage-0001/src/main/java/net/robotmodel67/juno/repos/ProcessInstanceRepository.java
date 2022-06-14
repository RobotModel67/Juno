package net.robotmodel67.juno.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import net.robotmodel67.juno.models.ProcessInstance;

public interface ProcessInstanceRepository extends JpaRepository<ProcessInstance, Long> {
	ProcessInstance findByScheduleId(long scheduleId);
}

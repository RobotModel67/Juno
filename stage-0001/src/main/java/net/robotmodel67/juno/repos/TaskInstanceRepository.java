package net.robotmodel67.juno.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.robotmodel67.juno.models.TaskInstance;

public interface TaskInstanceRepository extends JpaRepository<TaskInstance, Long> {
	List<TaskInstance> findByActivityInstanceId(long activityId);
}

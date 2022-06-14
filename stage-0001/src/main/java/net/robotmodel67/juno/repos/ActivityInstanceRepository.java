package net.robotmodel67.juno.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import net.robotmodel67.juno.models.ActivityInstance;

public interface ActivityInstanceRepository extends JpaRepository<ActivityInstance, Long> {
	List<ActivityInstance> findByOperationInstanceId(long operationId);
}

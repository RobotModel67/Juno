package net.robotmodel67.juno.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.robotmodel67.juno.models.OperationInstance;

public interface OperationInstanceRepository extends JpaRepository<OperationInstance, Long> {
	List<OperationInstance> findByProcessInstanceId(long processId);
}

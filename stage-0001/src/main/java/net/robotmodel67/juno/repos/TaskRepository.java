package net.robotmodel67.juno.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import net.robotmodel67.juno.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}

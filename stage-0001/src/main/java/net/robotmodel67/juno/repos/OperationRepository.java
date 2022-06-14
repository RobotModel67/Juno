package net.robotmodel67.juno.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import net.robotmodel67.juno.models.Operation;


public interface OperationRepository extends JpaRepository<Operation, Long> {

}

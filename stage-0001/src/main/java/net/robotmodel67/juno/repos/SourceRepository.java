package net.robotmodel67.juno.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.robotmodel67.juno.models.Source;


public interface SourceRepository extends JpaRepository<Source, Long> {
	List<Source> findSourcesByLegacyId(long legacyId);
}
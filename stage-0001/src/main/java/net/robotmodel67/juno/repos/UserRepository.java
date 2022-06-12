package net.robotmodel67.juno.repos;



import org.springframework.data.jpa.repository.JpaRepository;

import net.robotmodel67.juno.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
	User findByUsernameAndPassword(String userName, String password);
}

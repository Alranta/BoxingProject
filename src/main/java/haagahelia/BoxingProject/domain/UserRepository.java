package haagahelia.BoxingProject.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	// FINDBYUSERNAME
	User findByUsername(String username);
}

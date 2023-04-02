package haagahelia.BoxingProject.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface StanceRepository extends CrudRepository<Stance, Long>{
	List<Stance> findByStance(String stance);
	//INHERITS METHODS FROM CRUDREPOSITORY
}

package haagahelia.BoxingProject.domain;

import org.springframework.data.repository.CrudRepository;

public interface BoxerRepository extends CrudRepository <Boxer, Long> {
	//THIS IS USED TO INHERIT findAll(); deleteById(); ETC
}

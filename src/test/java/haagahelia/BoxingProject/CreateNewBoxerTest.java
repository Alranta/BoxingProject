package haagahelia.BoxingProject;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import haagahelia.BoxingProject.domain.Boxer;
import haagahelia.BoxingProject.domain.BoxerRepository;
import haagahelia.BoxingProject.domain.Stance;

@DataJpaTest
public class CreateNewBoxerTest {
	@Autowired
	private BoxerRepository boxerRepository;
	
	@Test
	public void createNewBoxer() throws Exception {
		Boxer testBoxer = new Boxer("Alvari", "Rantapelkonen", 1998, 72.5, 3, new Stance("Orthodox"));
		boxerRepository.save(testBoxer);
		assertThat(testBoxer.getId()).isNotNull();
	}
}

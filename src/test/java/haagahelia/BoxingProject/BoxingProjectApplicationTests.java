package haagahelia.BoxingProject;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import haagahelia.BoxingProject.web.BoxingProjectController;

@SpringBootTest
class BoxingProjectApplicationTests {

	@Autowired
	private BoxingProjectController BoxingProjectController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(BoxingProjectController).isNotNull();
	}
	

}

package haagahelia.BoxingProject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import haagahelia.BoxingProject.domain.Boxer;
import haagahelia.BoxingProject.domain.BoxerRepository;
import haagahelia.BoxingProject.domain.Stance;
import haagahelia.BoxingProject.domain.StanceRepository;

@SpringBootApplication
public class BoxingProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoxingProjectApplication.class, args);
	}

	// COMMANDLINE RUNNER FOR TEST DB
	@Bean
	public CommandLineRunner testdataToDatabase(BoxerRepository boxerreposity, StanceRepository stancerepository) {
		return (arg) -> {
			Stance stanceOrthodox = new Stance("Orthodox");
			Stance stanceSouthpaw = new Stance("Southpaw");
			stancerepository.save(stanceOrthodox);
			stancerepository.save(stanceSouthpaw);
			
			Boxer boxer1 = new Boxer("Elias", "Okkonen", 2001, 66.5, 4, stanceOrthodox);
			Boxer boxer2 = new Boxer("Aku", "Kanninen", 2000, 72.5, 15, stanceOrthodox);
			Boxer boxer3 = new Boxer("Vikke", "Kanninen", 1998, 75.0, 3, stanceSouthpaw);
			boxerreposity.save(boxer1);
			boxerreposity.save(boxer2);
			boxerreposity.save(boxer3);

		};
	}
}

package haagahelia.BoxingProject;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import haagahelia.BoxingProject.domain.Boxer;
import haagahelia.BoxingProject.domain.BoxerRepository;
import haagahelia.BoxingProject.domain.Gloves;
import haagahelia.BoxingProject.domain.GlovesRepository;
import haagahelia.BoxingProject.domain.Stance;
import haagahelia.BoxingProject.domain.StanceRepository;
import haagahelia.BoxingProject.domain.User;
import haagahelia.BoxingProject.domain.UserRepository;

@SpringBootApplication
public class BoxingProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoxingProjectApplication.class, args);
	}

	// COMMANDLINE RUNNER FOR TEST DB
	@Bean
	public CommandLineRunner testdataToDatabase(BoxerRepository boxerreposity, StanceRepository stancerepository, UserRepository userrepository, GlovesRepository glovesRepository) {
		return (arg) -> {
			//User user = new User("user", "$2a$10$CHvqG2LHPUd9cvqpvNJj2.h/CTjfDVe.I2t.JijYmZSv.YN0TlHcu", "USER");
			//User user1 = new User("user", "$2a$10$QloyikO59jTgqye/N0y1SueadKPrsGYi7yzgLPO2l02YTwGjaHF56", "USER");
			User admin = new User("admin", "$2a$10$khB7zimb0wKWIaPscobtLuJzTvkA4hbs9.0JNIZg9VnsFDhIHh70a", "ADMIN");
			//userrepository.save(user1);
			userrepository.save(admin);

			Gloves gloves1 = new Gloves("Winning Japan", 10);
			Gloves gloves2 = new Gloves("Cleto reyes", 10);
			Gloves gloves3 = new Gloves("Everlast", 10);
			
			List<Gloves> gloveslist =  Arrays.asList(gloves1, gloves2, gloves3);
			
			glovesRepository.saveAll(gloveslist);
			
			Stance stanceOrthodox = new Stance("Orthodox");
			Stance stanceSouthpaw = new Stance("Southpaw");
			stancerepository.save(stanceOrthodox);
			stancerepository.save(stanceSouthpaw);
			
			Boxer boxer1 = new Boxer("Elias", "Okkonen", 2001, 66.5, 4, stanceOrthodox, gloves1);
			Boxer boxer2 = new Boxer("Aku", "Kanninen", 2000, 72.5, 15, stanceOrthodox, gloves2);
			Boxer boxer3 = new Boxer("Vikke", "Kanninen", 1998, 75.0, 3, stanceSouthpaw, gloves3);
			boxerreposity.save(boxer1);
			boxerreposity.save(boxer2);
			boxerreposity.save(boxer3);

		};
	}
}

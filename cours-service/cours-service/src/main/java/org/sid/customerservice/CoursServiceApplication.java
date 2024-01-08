package org.sid.customerservice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
class Cours {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String name;
	private String prof;

}
@RepositoryRestResource
interface CoursRepository extends JpaRepository<Cours, Long>{

}
@SpringBootApplication
public class CoursServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoursServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(CoursRepository customerRepository){
		return  args -> {
            customerRepository.save(new Cours(null,"Unix","ahmed"));
			customerRepository.save(new Cours(null,"Math","mustapha"));
			customerRepository.save(new Cours(null,"Web","hanan"));
			customerRepository.findAll().forEach(System.out::println);

		};
	}

}

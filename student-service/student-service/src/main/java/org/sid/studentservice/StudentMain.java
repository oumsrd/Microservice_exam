package org.sid.studentservice;

import jakarta.persistence.*;
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
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;


    

}
@RepositoryRestResource
interface StudentRepository extends JpaRepository<Student, Long> {

}
@SpringBootApplication
public class StudentMain {

	public static void main(String[] args) {
		SpringApplication.run(StudentMain.class, args);
	}
	@Bean
	CommandLineRunner start(StudentRepository studentRepository){
		return  args -> {
			studentRepository.save(new Student(null,"Omaima"));
			studentRepository.save(new Student(null,"Mohamed"));
			studentRepository.save(new Student(null,"Ali"));
			studentRepository.findAll().forEach(System.out::println);

		};
	}

}

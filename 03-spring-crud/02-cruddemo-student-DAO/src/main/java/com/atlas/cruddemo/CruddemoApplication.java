package com.atlas.cruddemo;

import com.atlas.cruddemo.dao.StudentDAO;
import com.atlas.cruddemo.dao.StudentDAOImpl;
import com.atlas.cruddemo.entities.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner -> {
			// createStudent(studentDAO);
			createMultipleStudents(studentDAO);
		};
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		System.out.println("Creating multiple students...");
		Student student1 = new Student("Alexa", "Grandler", "Alexa@gmail.com");
		Student student2 = new Student("Braham", "Truder", "Braham@gmail.com");
		Student student3 = new Student("Graham", "Frankly", "Graham@gmail.com");

		System.out.println("Saving the students...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);

		System.out.println("The students with id's: " + student1.getId() + ", " + student2.getId() + ", " + student3.getId() + " saved." );
	}

	private void createStudent(StudentDAO studentDAO) {

		// create student object
		System.out.println("Creating new student...");
		Student tempStudent = new Student("Paul", "Doe", "paul@gmail.com");

		// save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("The student with id: " + tempStudent.getId() + " saved.");

	}

}

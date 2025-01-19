package com.atlas.cruddemo;

import com.atlas.cruddemo.dao.StudentDAO;
import com.atlas.cruddemo.dao.StudentDAOImpl;
import com.atlas.cruddemo.entities.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.swing.text.Style;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner -> {

			// createStudent(studentDAO);
			// createMultipleStudents(studentDAO);
			// readStudent(studentDAO);
			// queryForStudents(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
			// deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {

		System.out.println("Deleting all students...");
		int rowsDeleted = studentDAO.deleteAll();

		System.out.println( rowsDeleted + " rows deleted.");
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId = 3;

		System.out.println("Deleting student with id: " + studentId);

		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);

		Student myStudent = studentDAO.findById(studentId);

		System.out.println("Updating student...");

		myStudent.setFirstName("Scooby");
		studentDAO.update(myStudent);

		System.out.println("Updated student: " + myStudent);
	}

	private void queryForStudents(StudentDAO studentDAO) {

		// get a list of students
		List<Student> studentList = studentDAO.findAll();




		// display list of students
		for(Student tempStudent: studentList){
			System.out.println(tempStudent);
		}

	}

	private void readStudent(StudentDAO studentDAO) {

		System.out.println("Creating new student...");
		Student tempstudent = new Student("Arda", "Demir", "arda@gmail.com");

		studentDAO.save(tempstudent);
		int theID = tempstudent.getId();

		System.out.println("Saved student. Generated Id: " + theID);

		System.out.println("Retrieving student with id: " + theID);

		Student myStudent = studentDAO.findById(theID);

		System.out.println("Found student: " + myStudent);



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

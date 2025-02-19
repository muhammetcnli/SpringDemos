package com.atlas.cruddemo;

import com.atlas.cruddemo.dao.AppDAO;
import com.atlas.cruddemo.dao.AppDAOImpl;
import com.atlas.cruddemo.entity.Course;
import com.atlas.cruddemo.entity.Instructor;
import com.atlas.cruddemo.entity.InstructorDetail;
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
	public CommandLineRunner commandLineRunner(AppDAOImpl appDAO){

		return runner -> {
			// createInstructor(appDAO);
			// findInstructor(appDAO);
			// deleteInstructor(appDAO);
			// findInstructorDetail(appDAO);
			// deleteInstructorDetail(appDAO);

			createInstructorWithCourses(appDAO);
		};
	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		Instructor instructor = new Instructor("Arda", "Demir", "arda@gmail.com");

		InstructorDetail instructorDetail = new InstructorDetail(
				"ardanin_Youtube_channel",
				"Arda valo oynar");

		instructor.setInstructorDetail(instructorDetail);

		Course tempcourse1 = new Course("C# for Beginners");
		Course tempcourse2 = new Course("Pinball Masterclass");
		Course tempcourse3 = new Course("Guitar - The ultimate guide");

		instructor.add(tempcourse1);
		instructor.add(tempcourse2);

		System.out.println("Saving instructor: " + instructor);
		System.out.println("The courses: " + instructor.getCourses());
		appDAO.save(instructor);

		System.out.println("Done!");

	}

	private void deleteInstructorDetail(AppDAO appDAO) {

		int theId = 4;
		System.out.println("Deleting the instructor detail id: " + theId);

		appDAO.deleteInstructorDetailById(theId);

		System.out.println("Done!");

	}

	private void findInstructorDetail(AppDAO appDAO) {

		int theId = 2;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		System.out.println("tempInstructorDetail: " + tempInstructorDetail);

		System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());

		System.out.println("Done!");


	}

	private void deleteInstructor(AppDAO appDAO) {

		int theId = 2;

		System.out.println("Deleting the instructor with id: " + theId);

		appDAO.deleteInstructorById(2);

	}

	private void findInstructor(AppDAO appDAO) {

		int theId = 2;
		System.out.println("Finding instructor with id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println(tempInstructor);

		System.out.println("The details" + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		/* // create instructor
		Instructor instructor = new Instructor("Mahmut", "Canli", "mahmut@gmail.com");


		// create instructor detail

		InstructorDetail instructorDetail = new InstructorDetail(
				"random.youtube.channel",
				"Playing Football");

		*/
		Instructor instructor = new Instructor("Arda", "Demir", "arda@gmail.com");

		InstructorDetail instructorDetail = new InstructorDetail(
				"ardanin_Youtube_channel",
				"Arda valo oynar");

		instructor.setInstructorDetail(instructorDetail);

		// this will save the instructorDetail object too thanks to the CascadeType.ALL
		appDAO.save(instructor);

		System.out.println("Done!");

	}



}

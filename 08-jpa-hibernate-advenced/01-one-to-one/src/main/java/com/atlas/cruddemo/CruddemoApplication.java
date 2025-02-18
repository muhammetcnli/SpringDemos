package com.atlas.cruddemo;

import com.atlas.cruddemo.dao.AppDAOImpl;
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
		};
	}

	private void deleteInstructor(AppDAOImpl appDAO) {

		int theId = 2;

		System.out.println("Deleting the instructor with id: " + theId);

		appDAO.deleteInstructorById(2);

	}

	private void findInstructor(AppDAOImpl appDAO) {

		int theId = 2;
		System.out.println("Finding instructor with id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println(tempInstructor);

		System.out.println("The details" + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAOImpl appDAO) {
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

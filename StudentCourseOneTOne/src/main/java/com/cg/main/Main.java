package com.cg.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.student.Course;
import com.cg.student.Student;

public class Main {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Student student = new Student();
		student.setName("Deepak Patil");
		Course course = new Course();
		course.setCourseName("BCA");;
		//homeAddress.setCity("Pune");
		//homeAddress.setState("Maharashtra");
		//homeAddress.setZipCode("411 017");
		//inject address into student
		student.setCourse(course);
		//persist only student, no need to persist Address explicitly
		em.persist(student);
		em.getTransaction().commit();
		System.out.println("Added one student with address to database.");
		em.close();
		factory.close();
		

	}

}

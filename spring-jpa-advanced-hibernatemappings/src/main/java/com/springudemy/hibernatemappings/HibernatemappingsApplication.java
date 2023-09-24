package com.springudemy.hibernatemappings;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springudemy.hibernatemappings.dao.AppDao;
import com.springudemy.hibernatemappings.entity.Course;
import com.springudemy.hibernatemappings.entity.Instructor;
import com.springudemy.hibernatemappings.entity.InstructorDetail;
import com.springudemy.hibernatemappings.entity.Student;

@SpringBootApplication
public class HibernatemappingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernatemappingsApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao) {
		return runner -> {
			System.out.println("Running...");
			//createInstance(appDao);

			//createInstructorWithCourse(appDao);

			//createCourseAndStudent(appDao);
			//findCourseAndStudents(appDao);
			//findStudentAndCourses(appDao);

			// addCoursesToStudents(appDao);

			// deleteCourse(appDao);

			deleteStudent(appDao);
		};
		
	}
	private void deleteStudent(AppDao appDao) {
		int id = 1;
		appDao.deleteStudentByStudentId(id);
	}
	private void deleteCourse(AppDao appDao) {
		int id = 10;
		
		appDao.deleteCourseByCourseId(id);
	}
	private void addCoursesToStudents(AppDao appDao) {
		int id = 1;
		Student student = appDao.findStudentAndCourseByStudentId(id);
		Course course2 = new Course("Spring");
		Course course3 = new Course("Hibernate");
		student.addCourse(course2);
		student.addCourse(course3);

				System.out.println(student);
		System.out.println(student.getCourses());

		appDao.update(student);

	}
	private void findStudentAndCourses(AppDao appDao) {
		int id = 2;
		Student student = appDao.findStudentAndCourseByStudentId(id);
		System.out.println(student);
		System.out.println(student.getCourses());
	}
	private void findCourseAndStudents(AppDao appDao) {
		int id = 10;
		Course course = appDao.findCourseAndStudentsByCourseId(id);
		System.out.println(course);
		System.out.println(course.getStudents());
	}
	private void createCourseAndStudent(AppDao appDao) {

		Course course1 = new Course("Java");
		Course course2 = new Course("Spring");
		Course course3 = new Course("Hibernate");

		Student student1 = new Student("Damn", "Son", "a@b.com");
		Student student2 = new Student("Susan", "Public", "sysan.public@b.com");
		Student student3 = new Student("Dan", "Public", "dan.public@b.com");


		course1.addStudent(student1);
		course1.addStudent(student2);

		appDao.save(course1);



	}
	private void createInstructorWithCourse(AppDao appDao) {
		
		Instructor instructor = new Instructor("Susan", "Public", "sysan.public@b.com");
		
		InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/c/susanpublic", "Games");
		instructor.setInstructorDetail(instructorDetail);

		Course temp1 = new Course("Java");
		Course temp2 = new Course("Spring");
		Course temp3 = new Course("Hibernate");
		instructor.add(temp1);
		instructor.add(temp2);
		instructor.add(temp3);

		System.out.println("Saving istructor: " + instructor);
		System.out.println("The courses: " + instructor.getCourses());

		appDao.save(instructor);

	}
	private void createInstance(AppDao appDao) {

		Instructor instructor = new Instructor("Damn", "Son", "a@b.com");
		InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/c/damnSon", "Bongos");
	
		instructor.setInstructorDetail(instructorDetail);

		System.out.println("Saving: " + instructor);
		appDao.save(instructor);
	}

}

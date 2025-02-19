package com.javaacademy.student;

import com.javaacademy.student.entity.Course;
import com.javaacademy.student.entity.Curator;
import com.javaacademy.student.entity.Faculty;
import com.javaacademy.student.entity.Student;
import com.javaacademy.student.repository.CourseRepository;
import com.javaacademy.student.repository.CuratorRepository;
import com.javaacademy.student.repository.FacultyRepository;
import com.javaacademy.student.repository.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(StudentApplication.class, args);
		FacultyRepository facultyRepository = context.getBean(FacultyRepository.class);
		StudentRepository studentRepository = context.getBean(StudentRepository.class);
		CuratorRepository curatorRepository = context.getBean(CuratorRepository.class);
		CourseRepository courseRepository = context.getBean(CourseRepository.class);
//		Создаем факультет факультет
//		Faculty economicFaculty = new Faculty("Экономический");
//		facultyRepository.save(economicFaculty);

//		Создаем студента, который учится на экономическом факультете
//		Student student = new Student("Гриша", economicFaculty);
//		studentRepository.save(student);

//		Находим факультет по id -> берем с факультета всех студентов -> берем первого студента -> печатаем его
//		Faculty faculty = facultyRepository.findById(1).orElseThrow();
//		List<Student> students = faculty.getStudents();
//		Student grisha = students.get(0);
//		System.out.println(grisha);

//		Создаем куратора
//		Curator curator = new Curator("Вангородская");
//		curatorRepository.save(curator);
//

//		Получаем студента по id, присваиваем ему куратора
//		Student student = studentRepository.findById(1).orElseThrow();
//		student.setCurator(curator);
//		studentRepository.save(student);

//		Создаем курсы
//		List<Course> courses = List.of(new Course("Английский"),
//				new Course("Испанский"),
//				new Course("Ценные бумаги"));
//		courseRepository.saveAll(courses);

//		Получаем студента по id -> Записываем его на все курсы
//		Student student = studentRepository.findById(1).orElseThrow();
//		student.setCourses(courses);
//		studentRepository.save(student);
	}

}

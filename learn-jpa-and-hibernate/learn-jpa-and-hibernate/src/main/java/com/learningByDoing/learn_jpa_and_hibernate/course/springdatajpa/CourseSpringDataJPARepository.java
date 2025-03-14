package com.learningByDoing.learn_jpa_and_hibernate.course.springdatajpa;

import com.learningByDoing.learn_jpa_and_hibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

////http://localhost:8080/h2-console

public interface CourseSpringDataJPARepository extends JpaRepository<Course, Long> {

    public List<Course> findByAuthor(String author);


}

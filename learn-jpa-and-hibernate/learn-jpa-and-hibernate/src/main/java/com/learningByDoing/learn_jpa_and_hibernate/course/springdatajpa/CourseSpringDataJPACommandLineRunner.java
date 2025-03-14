package com.learningByDoing.learn_jpa_and_hibernate.course.springdatajpa;

import com.learningByDoing.learn_jpa_and_hibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseSpringDataJPACommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseSpringDataJPARepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Learn AWS JPA!", "LearningByDoing"));
        repository.save(new Course(2, "Learn Azure JPA!", "LearningByDoing"));
        repository.save(new Course(3, "Learn AWS JPA!", "LearningByDoing"));
        repository.deleteById(3l);
        System.out.println(repository.findById(1l));

        System.out.println(repository.findAll());
        System.out.println(repository.count());

        System.out.println(repository.findByAuthor("LearningByDoing"));



    }
}

//package com.learningByDoing.learn_jpa_and_hibernate.course.jpa;
//
//import com.learningByDoing.learn_jpa_and_hibernate.course.Course;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CourseJPACommandLineRunner implements CommandLineRunner {
//
//    @Autowired
//    private CourseJPARepository repository;
//
//    @Override
//    public void run(String... args) throws Exception {
//        repository.insert(new Course(1, "Learn AWS JPA!", "LearningByDoing"));
//        repository.insert(new Course(2, "Learn Azure JPA!", "LearningByDoing"));
//        repository.insert(new Course(3, "Learn AWS JPA!", "LearningByDoing"));
//        repository.deleteById(3);
//        System.out.println(repository.getById(1));
//    }
//}

//package com.learningByDoing.learn_jpa_and_hibernate.course.jdbc;
//
//import com.learningByDoing.learn_jpa_and_hibernate.course.Course;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CourseJDBCCOmmandLineRunner implements CommandLineRunner {
//
//    @Autowired
//    private CourseJDBCRepository repository;
//
//    @Override
//    public void run(String... args) throws Exception {
//        repository.insert(new Course(1, "Learn AWS Now!", "LearningByDoing"));
//        repository.insert(new Course(2, "Learn Azure Now!", "LearningByDoing"));
//        repository.insert(new Course(3, "Learn AWS Now!", "LearningByDoing"));
//        repository.deleteByID(3);
//        System.out.println(repository.getByID(1));
//    }
//}

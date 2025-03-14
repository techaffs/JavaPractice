//package com.learningByDoing.learn_jpa_and_hibernate.course.jpa;
//
//import com.learningByDoing.learn_jpa_and_hibernate.course.Course;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import jakarta.transaction.Transactional;
//import org.springframework.stereotype.Repository;
//
//@Repository
//@Transactional
//public class CourseJPARepository {
//
//    @PersistenceContext //instead of Autowired, it is a specific annotation for JPA
//    private EntityManager entityManager;
//
//    public void insert (Course course){
//        entityManager.merge(course);
//    }
//
//    public void deleteById(long id){
//        Course course = entityManager.find(Course.class, id);
//        entityManager.remove(course);
//    }
//
//    public Course getById(long id){
//        return entityManager.find(Course.class, id);
//    }
//}

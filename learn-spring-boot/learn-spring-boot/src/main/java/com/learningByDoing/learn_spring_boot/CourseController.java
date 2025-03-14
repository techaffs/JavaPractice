package com.learningByDoing.learn_spring_boot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses(){
        return Arrays.asList(
                new Course(1, "Learn AWS", "learningByDoing"),
                new Course(2, "Learn Devops", "learningByDoing"),
                new Course(3, "Learn Terraform", "learningByDoing"),
                new Course(4, "Learn Java", "learningByDoing"),
                new Course(5, "Learn Azure", "learningByDoing")
        );
    }
}

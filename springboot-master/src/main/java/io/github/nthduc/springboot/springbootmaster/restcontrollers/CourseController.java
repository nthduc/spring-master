package io.github.nthduc.springboot.springbootmaster.restcontrollers;

import io.github.nthduc.springboot.springbootmaster.models.Course;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {
    // Course
    // Course: id, name, author

    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses(){
        return Arrays.asList(
                new Course(1,"AWS","nthduc"),
                new Course(1,"DevOps","nthduc"),
                new Course(1,"Azure","nthduc")
        );
    }
}

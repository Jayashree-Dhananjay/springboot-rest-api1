package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("student")
    public Student getStudent(){
        Student student = new Student(1,"Ramesh","Kumar");
        return student;
    }

    @GetMapping("students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Ramesh", "Kumar" ));
        students.add(new Student(2, "umesh", "Fadatare" ));
        students.add(new Student(3, "Ram", "Jakdhav" ));
        students.add(new Student(4, "Sanjay", "Pawar" ));
        return students;
    }

        //Spring Boot REST API with path variable
        //{id} - URI template variable
        //http://localhost:8080/students/1/Ramesh/Kumar
        @GetMapping("students/{id}/{first-name}/{last-name}")
        public Student studentPathVariable(@PathVariable("id") int studentId,
                                           @PathVariable("first-name") String firstname,
                                           @PathVariable("last-name") String lastname){
            return new Student(studentId, firstname, lastname);
        }

        //Spring boot REST API with Request Param
        //http://localhost:8080/students/query?id=1&firstname=Ramesh&lastname=Kumar
        @GetMapping("students/query")
        public Student studentRequestVariable(@RequestParam int id,
                                              @RequestParam String firstname,
                                              @RequestParam String lastname){
        return new Student(id,firstname,lastname);
        }
}

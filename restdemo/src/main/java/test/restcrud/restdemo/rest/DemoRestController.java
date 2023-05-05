package test.restcrud.restdemo.rest;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.restcrud.restdemo.entity.Student;
import test.restcrud.restdemo.exception.StudNotFoundExc;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class DemoRestController {

    private List<Student> studentList;

    @PostConstruct
    private void loadStudents() {
        studentList = new ArrayList<Student>();
        studentList.add(new Student("John", "Public"));
        studentList.add(new Student("Jane", "Public"));
        studentList.add(new Student("Tim", "Public"));
    }

    @GetMapping("/students")
    public List<Student> listAllStudents() {
        return studentList;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {

        if (studentId > studentList.size() || studentId < 0) {
            throw new StudNotFoundExc("Student not found for id: " + studentId);
        }

        return studentList.get(studentId);
    }
}

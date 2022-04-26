package hu.TimeTableApi.controllers;


import hu.TimeTableApi.domain.Student;
import hu.TimeTableApi.domain.StudentClass;
import hu.TimeTableApi.domain.StudentList;
import hu.TimeTableApi.domain.Subject;
import hu.TimeTableApi.services.StudentClassService;
import hu.TimeTableApi.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
@RestController
public class StudentController {

    @Autowired
    private StudentService service;


    @GetMapping("/students")
    public List<StudentList> getStudents(){
        return service.getStudents();
    }



/*
    @GetMapping("/students")
    public List<Student> getStudents() {
        return service.getStudents();
    }


 */
@GetMapping("/students/{OMA_STUDENT}")
public Student getStudent(@PathVariable("OMA_STUDENT") BigInteger OMA_STUDENT){
    System.out.println("eljut ide");
    return service.getStudent(OMA_STUDENT);

}
/*
    @GetMapping("/students/class/{CLASS_ID}")
    public Student getStudentFromClass(@PathVariable("CLASS_ID") int CLASS_ID){
        return service.getStudentFromClass(CLASS_ID);


    }
 */

    @GetMapping("/studentlists/{CLASS_ID}")
    public List<StudentList> getStudentList(@PathVariable("CLASS_ID") int CLASS_ID){
        return service.getStudentList(CLASS_ID);
    }



    @PostMapping("/{CLASS_ID}/students")
    @ResponseStatus(HttpStatus.CREATED)
    public Student addStudent(@PathVariable("CLASS_ID") int CLASS_ID,@RequestBody Student student){
        return service.addStudent(CLASS_ID,student);
    }

 /*
@PostMapping("/students")
@ResponseStatus(HttpStatus.CREATED)
public Student addStudent(@RequestBody NewStudentRequest newStudentRequest){
    return service.addStudent(newStudentRequest);
}

  */


    @PatchMapping("/students/{OMA_STUDENT}")
    public Student updateStudent(@PathVariable("OMA_STUDENT") BigInteger OMA_STUDENT,
                                 @RequestBody Student student)
                                  {
    String name = student.getName();
        return service.updateStudent(OMA_STUDENT, name);
    }



    @DeleteMapping("/students/{OMA_STUDENT}")
    public void deleteStudent(@PathVariable("OMA_STUDENT") BigInteger OMA_STUDENT){
        service.deleteStudent(OMA_STUDENT);
    }





}

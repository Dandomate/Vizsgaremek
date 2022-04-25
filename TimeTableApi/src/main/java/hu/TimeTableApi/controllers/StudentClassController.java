package hu.TimeTableApi.controllers;

import hu.TimeTableApi.domain.StudentClass;
import hu.TimeTableApi.domain.StudentClassList;
import hu.TimeTableApi.dto.NewStudentClassRequest;
import hu.TimeTableApi.services.StudentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class StudentClassController {

    @Autowired
    private StudentClassService classservice;

    @GetMapping("/studentclasses")
    public List<StudentClassList> getStudentClasses(){
        return classservice.getStudentClasses();
    }

    @GetMapping("/studentclasses/{CLASS_ID}")
    public StudentClass getStudentClass(@PathVariable("CLASS_ID") int CLASS_ID){
        return classservice.getStudentClass(CLASS_ID);

    }
/*
    @PostMapping("/studentclasses")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentClass addStudentClass(@RequestBody StudentClass studentclass){
        return classservice.addStudentClass(studentclass);
    }
 */
    @PostMapping("/studentclasses")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentClass addStudentClass(@RequestBody NewStudentClassRequest newStudentClassRequest){
    return classservice.addStudentClass(newStudentClassRequest);
}

    @PatchMapping("/studentclasses/{CLASS_ID}")
    public StudentClass updateStudentClass(@PathVariable("CLASS_ID") int CLASS_ID, @RequestBody StudentClass studentclass){
        String cname = studentclass.getCname();
        return classservice.updateStudentClass(CLASS_ID,cname);
    }

    @DeleteMapping("/studentclasses/{CLASS_ID}")
    public void deleteStudentClass(@PathVariable("CLASS_ID") int CLASS_ID){
        classservice.deleteStudentClass(CLASS_ID);
    }

}

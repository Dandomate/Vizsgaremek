/*
package hu.fisherRaceAPI.controllers;

import hu.fisherRaceAPI.domain.*;
import hu.fisherRaceAPI.services.SubjectService;
import hu.fisherRaceAPI.services.TeacherSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class TeacherSubjectController {

    @Autowired
    private TeacherSubjectService service;

        @GetMapping("/teachersubjects")
        public List<TeacherSubjectList> getTeacherSubjects(){
            return service.getTeacherSubjects();
        }



@GetMapping("/teachersubjects/{OMA_TEACHER}")
public List<TeacherSubjectList> getTeacherSubjectList(@PathVariable("OMA_TEACHER") long OMA_TEACHER){
    System.out.println("Valami2");
    return service.getTeacherSubjects(OMA_TEACHER);
}



    @GetMapping("/teachersubjects/{OMA_TEACHER}")
    public TeacherSubject getTeacherSubject(@PathVariable("OMA_TEACHER") long OMA_TEACHER){
        return service.getTeacherSubjects(OMA_TEACHER);

    }




    @PostMapping("/teachersubjects")
    @ResponseStatus(HttpStatus.CREATED)
    public TeacherSubject addTeacherSubject(@RequestBody TeacherSubject teachersubject){
        return service.addTeacherSubject(teachersubject);
    }


    @PatchMapping("/teachersubjects/{TEACHER_SUBJECT_ID}")
    public TeacherSubject updateTeacherSubject(@PathVariable("TEACHER_SUBJECT_ID") int TEACHER_SUBJECT_ID, @RequestBody TeacherSubject teachersubject){
        String sname = subject.getSname();
        return service.updateSubject(SUBJECT_ID, sname);
    }

    @DeleteMapping("/teachersubjects/{TEACHER_SUBJECT_ID}")
    public void deleteTeacherSubject(@PathVariable("TEACHER_SUBJECT_ID") int TEACHER_SUBJECT_ID){
        service.deleteTeacherSubject(TEACHER_SUBJECT_ID);
    }



}



 */




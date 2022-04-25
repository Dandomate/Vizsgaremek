package hu.TimeTableApi.controllers;


import hu.TimeTableApi.domain.Subject;
import hu.TimeTableApi.domain.Teacher;
import hu.TimeTableApi.domain.TeacherSubjectList;
import hu.TimeTableApi.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {

    @Autowired
    private TeacherService service;

    @GetMapping("/teachers")
    public List<Teacher> getTeachers() {
        System.out.println("teachers");
        return service.getTeachers();
    }

    @GetMapping("/teachers/{OMA_TEACHER}")
    public Teacher getTeacher(@PathVariable("OMA_TEACHER") long OMA_TEACHER){
        System.out.println("teacher");
        return service.getTeacher(OMA_TEACHER);

    }


    @GetMapping("/teachersubjectlist/{OMA_TEACHER}")
    public List<TeacherSubjectList> getTeacherSubjectList(@PathVariable("OMA_TEACHER") long OMA_TEACHER){
        System.out.println("Valami2");
        return service.getTeacherSubjectList(OMA_TEACHER);
    }


    @GetMapping("/teachers/{OMA_TEACHER}/subjects")
    public List<Subject> getSubjects(@PathVariable("OMA_TEACHER") long OMA_TEACHER){
        Teacher teacher = getTeacher(OMA_TEACHER);
        return teacher.getSubjectList();
    }

/*
    @PostMapping("/teachersubjects")
    @ResponseStatus(HttpStatus.CREATED)
    public TeacherSubject addTeacherSubject(@RequestBody TeacherSubject teachersubject){
        return service.addTeacherSubject(teachersubject);
    }


 */
    @PostMapping("/teachers")
    @ResponseStatus(HttpStatus.CREATED)
    public Teacher addTeacher(@RequestBody Teacher teacher){
        return service.addTeacher(teacher);
    }
/*
    @PostMapping("/teachersubjects")
    @ResponseStatus(HttpStatus.CREATED)
    public TeacherSubject addTeacherSubject(@RequestBody TeacherSubject teacherSubject){
        return service.addTeacherSubject(teacherSubject);
    }


 */

    @PatchMapping("/teachers/{OMA_TEACHER}")
    public Teacher updateTeacher(@PathVariable("OMA_TEACHER") long OMA_TEACHER, @RequestBody Teacher teacher){
        String Name = teacher.getName();
        String Phone = teacher.getPhone();
        String Password = teacher.getPassword();
        return service.updateTeacher(OMA_TEACHER, Name,Phone,Password);
    }
/*
    @PatchMapping("/teachers/{OMA_TEACHER}")
    public Teacher updateTeacherPhone(@PathVariable("OMA_TEACHER") long OMA_TEACHER, @RequestBody Teacher teacher){
        String Phone = teacher.getPhone();
        return service.updateTeacherPhone(OMA_TEACHER, Phone);
    }

    @PatchMapping("/teachers/{OMA_TEACHER}")
    public Teacher updateTeacherPassword(@PathVariable("OMA_TEACHER") long OMA_TEACHER, @RequestBody Teacher teacher){
        String Password = teacher.getPassword();
        return service.updateTeacherPassword(OMA_TEACHER, Password);
    }


 */
    @DeleteMapping("/teachers/{OMA_TEACHER}")
    public void deleteTeacher(@PathVariable("OMA_TEACHER") long OMA_TEACHER){
        service.deleteTeacher(OMA_TEACHER);
    }









}



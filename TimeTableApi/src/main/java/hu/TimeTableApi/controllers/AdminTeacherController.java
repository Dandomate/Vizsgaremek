package hu.TimeTableApi.controllers;


import hu.TimeTableApi.domain.AdminTeacher;
import hu.TimeTableApi.services.AdminTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminTeacherController {

    @Autowired
    private AdminTeacherService service;

    @GetMapping("/adminteachers")
    public List<AdminTeacher> getAdminTeachers() {
        System.out.println("adminteachers");
        return service.getAdminTeachers();
    }

    @GetMapping("/adminteachers/{OMA_TEACHER}")
    public AdminTeacher getAdminTeacher(@PathVariable("OMA_TEACHER") long OMA_TEACHER){
        System.out.println("adminteacher");
        return service.getAdminTeacher(OMA_TEACHER);

    }


}

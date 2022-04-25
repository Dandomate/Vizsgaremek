package hu.TimeTableFront.controllers;



import hu.TimeTableFront.config.Counter;
import hu.TimeTableFront.domain.StudentClassList;
import hu.TimeTableFront.domain.TimeTableList;
import hu.TimeTableFront.services.TeacherService;
import hu.TimeTableFront.services.TimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class TeacherController {

    @Autowired
    private TimeTableService timetableService;
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/teacherhome")
    public String home(Model model){
        model.addAttribute("activemenu", 1);
            return "teacherhome";
    }


    @GetMapping("/timetablelist/{OMA_TEACHER}/{day}")
    public String getTimeTableListTeacher(@PathVariable("OMA_TEACHER") long OMA_TEACHER, @PathVariable("day") String day,
                                   Model model){
        List<TimeTableList> timetablelist = timetableService.getTimeTableListTeacher(OMA_TEACHER,day);
        model.addAttribute("timetablelist", timetablelist);
        model.addAttribute("activemenu", 2);
        return "timetablelist";
    }

    @GetMapping("/teachers/{OMA_TEACHER}")
    public String Teachers(@PathVariable("OMA_TEACHER") long OMA_TEACHER,Model model){
        model.addAttribute("teacher",teacherService.getTeacher(OMA_TEACHER));
        model.addAttribute("activemenu", 3);
        return "teacher";
    }


}

package hu.TimeTableFront.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TeacherController {
    @GetMapping("/teacherhome")
    public String home(Model model){
        model.addAttribute("activemenu", 1);
        return "teacherhome";
    }
}

package hu.TimeTableFront.controllers;

import hu.TimeTableFront.config.Counter;
import hu.TimeTableFront.domain.*;
import hu.TimeTableFront.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassRoomService classRoomService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentClassService studentClassService;
    @Autowired
    private TimeTableService timetableService;


    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("activemenu", 1);
        return "index";
    }

    @GetMapping("/c-students")
    public String getStudentList(Model model){
        List<StudentList> studentList = studentService.getStudentList();
        if(studentList.size()>0) {
            model.addAttribute("counter", new Counter());
            model.addAttribute("studentlist", studentList);
            model.addAttribute("name", studentList.get(0).getOMA_STUDENT());
        }
        model.addAttribute("activemenu", "2");
        return "studentlist";
    }


    @GetMapping("/c-studentclasses")
    public String getStudentClassList(Model model){
        List<StudentClassList> studentClassList = studentClassService.getStudentClassList();
        if(studentClassList.size()>0) {
            model.addAttribute("counter", new Counter());
            model.addAttribute("studentclasslist", studentClassList);
            model.addAttribute("cname", studentClassList.get(0).getCLASS_ID());
        }
        model.addAttribute("activemenu", "5");
        return "studentclasslist";
    }

    @GetMapping("/c-studentlists/{CLASS_ID}")
    public String getStudentList(@PathVariable("CLASS_ID") int CLASS_ID,
                                 Model model){
        List<StudentList> studentlist = studentService.getStudentList(CLASS_ID);
        model.addAttribute("studentlist", studentlist);
        model.addAttribute("activemenu", 5);
        return "studentlist";
    }

//!!!!
    @GetMapping("/c-timetablelists")
    public String getStudentClass(Model model){
        List<StudentClassList> studentClassList = studentClassService.getStudentClassList();
        if(studentClassList.size()>0) {
            model.addAttribute("counter", new Counter());
            model.addAttribute("studentclass", studentClassList);
            model.addAttribute("cname", studentClassList.get(0).getCLASS_ID());
        }
        model.addAttribute("activemenu", "7");
        return "studentclass";
    }
//!!

    @GetMapping("/c-timetablelists/{CLASS_ID}/{day}")
    public String getTimeTableList(@PathVariable("CLASS_ID") int CLASS_ID,@PathVariable("day") String day,
                                 Model model){
        List<TimeTableList> timetablelist = timetableService.getTimeTableList(CLASS_ID,day);
        model.addAttribute("timetablelists", timetablelist);
        model.addAttribute("activemenu", 7);
        return "timetablelists";
    }


    @GetMapping("/c-subjects")
    public String getSubjectList(Model model){
        List<SubjectList> subjectList = subjectService.getSubjectList();
        if(subjectList.size()>0) {
            model.addAttribute("counter", new Counter());
            model.addAttribute("subjectlist", subjectList);
            model.addAttribute("name", subjectList.get(0).getSUBJECT_ID());
        }
        model.addAttribute("activemenu", "6");
        return "subjectlist";
    }

    @GetMapping("/c-classrooms")
    public String getClassRoomList(Model model){
        List<ClassRoomList> classRoomList = classRoomService.getClassRoomList();
        if(classRoomList.size()>0) {
            model.addAttribute("counter", new Counter());
            model.addAttribute("classroomlist", classRoomList);
            model.addAttribute("door", classRoomList.get(0).getDOORNUMBER_ID());
        }
        model.addAttribute("activemenu", "3");
        return "roomlist";
    }


    @GetMapping("/c-teachers")
    public String Teachers(Model model){
        //System.out.println(teacherService.getTeachers());
        model.addAttribute("teachers",teacherService.getTeachers());
        model.addAttribute("activemenu", 4);
        return "teachers";
    }

/*

    @GetMapping("/c-studentclasses")
    public String StudentClassList(Model model){
        System.out.println("eljutott ide");
        model.addAttribute("studentclasses",studentClassService.getStudentClassLists());
        System.out.println("eljutott ide");
        model.addAttribute("activemenu", 5);
        return "studentclasses";
    }
 */



    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }





    @GetMapping("/c-teachersubjectlist/{OMA_TEACHER}")
    public String getTeacherSubjectList(@PathVariable("OMA_TEACHER") long OMA_TEACHER,
                                        Model model){
        List<TeacherSubjectList> teachersubject = teacherService.getTeacherSubjectList(OMA_TEACHER);
        model.addAttribute("teachersubjects", teachersubject);
        model.addAttribute("activemenu", 4);
        System.out.println(teachersubject.get(0).getName());
        return "teachersubjectlist";
    }
     /*
    @GetMapping("/c-teacher/{OMA_TEACHER}/subject")
    public String getTeacherSubjectList(@PathVariable("OMA_TEACHER") long OMA_TEACHER,
                                        Model model){
        List<TeacherSubjectList> teachersubject = teacherService.getTeacherSubjectList(OMA_TEACHER);
        model.addAttribute("teacherSubject", teachersubject);
        model.addAttribute("activemenu", 4);
        return "teachersubjectlist";
    }



     */





}

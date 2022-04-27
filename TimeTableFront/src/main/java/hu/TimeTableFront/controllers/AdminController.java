
package hu.TimeTableFront.controllers;

import hu.TimeTableFront.domain.*;
import hu.TimeTableFront.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@Controller
public class AdminController {

    @Autowired
    private TeacherService service;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private ClassRoomService classRoomService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentClassService studentclassService;

    @Autowired
    private TimeTableService timeTableService;

    @GetMapping("/adminteacher") // menüpontból navigál
    public String newTeacher(Model model){
        model.addAttribute("teachers", service.getTeachers());
        return "adminteacher";
    }

    @PostMapping("/addteacher") // űrlapon Add gombot megnyom
    public String addTeacher(@RequestParam("OMA_TEACHER") long OMA_TEACHER,
                            @RequestParam("Name") String Name,
                            @RequestParam("Phone") String Phone,
                             @RequestParam("Password") String Password,
                             @RequestParam("Admin") Boolean Admin,
                            Model model){
        int statusCode = service.addTeacher(OMA_TEACHER, Name, Phone,Password,Admin);
        model.addAttribute("status", statusCode);
        model.addAttribute("teachers", service.getTeachers());
        return "adminteacher";
    }

    @PostMapping("updateteacher") // menüpontból navigál
    public String updatingTeacher(@RequestParam("OMA_TEACHER") long OMA_TEACHER, Model model){
        Teacher teacher = service.getTeacher(OMA_TEACHER);
        model.addAttribute("teacher", teacher);
        return "updateteacher";
    }
/*
    @PostMapping("updateteacherphone") // menüpontból navigál
    public String updatingTeacherPhone(@RequestParam("OMA_TEACHER") long OMA_TEACHER, Model model){
        Teacher teacher = service.getTeacher(OMA_TEACHER);
        model.addAttribute("teacher", teacher);
        return "updateteacherphone";
    }

    @PostMapping("updateteacherpassword") // menüpontból navigál
    public String updatingTeacherPassword(@RequestParam("OMA_TEACHER") long OMA_TEACHER, Model model){
        Teacher teacher = service.getTeacher(OMA_TEACHER);
        model.addAttribute("teacher", teacher);
        return "updateteacherpassword";
    }


 */


    @PostMapping("/update-name") // nevet cserél
    public String updateTeacher(@RequestParam("OMA_TEACHER") long OMA_TEACHER,
                               @RequestParam("Name") String Name,
                                @RequestParam("Phone") String Phone,
                                @RequestParam("Password") String Password,
                               Model model){
        int status = service.updateTeacher(OMA_TEACHER, Name,Phone,Password);
        model.addAttribute("status", status);
        model.addAttribute("teachers", service.getTeachers());
        return "index";
    }

/*
    @PostMapping("/update-phone") // telt cserél
    public String updateTeacherPhone(@RequestParam("OMA_TEACHER") long OMA_TEACHER,
                                @RequestParam("Phone") String Phone,
                                Model model){
        int status = service.updateTeacher(OMA_TEACHER, Phone);
        model.addAttribute("status", status);
        model.addAttribute("teachers", service.getTeachers());
        return "adminteacher";
    }

    @PostMapping("/update-password") // nevet cserél
    public String updateTeacherPassword(@RequestParam("OMA_TEACHER") long OMA_TEACHER,
                                @RequestParam("Password") String Password,
                                Model model){
        int status = service.updateTeacher(OMA_TEACHER, Password);
        model.addAttribute("status", status);
        model.addAttribute("teachers", service.getTeachers());
        return "adminteacher";
    }


 */
    @PostMapping("/delete-teacher")
    public String deleteTeacher(@RequestParam("OMA_TEACHER") long OMA_TEACHER, Model model){
        System.out.println("@DeleteMapping: "+OMA_TEACHER);
        int status = service.deleteTeacher(OMA_TEACHER);
        System.out.println("status code: "+status);
        model.addAttribute("status", status);
        model.addAttribute("teachers", service.getTeachers());
        return "adminteacher";
    }

    //******************************************************************-

    @GetMapping("/adminsubject") // menüpontból navigál
    public String newSubject(Model model){
        model.addAttribute("subjects", subjectService.getSubjectList());
        return "adminsubject";
    }

    @PostMapping("/addsubject") // űrlapon Add gombot megnyom
    public String addSubject(@RequestParam("sname") String sname,
                             Model model){
        int statusCode = subjectService.addSubject(sname);
        model.addAttribute("status", statusCode);
        model.addAttribute("subjects", subjectService.getSubjectList());
        return "adminsubject";
    }

    @PostMapping("updatesubject") // menüpontból navigál
    public String updatingSubject(@RequestParam("SUBJECT_ID") int SUBJECT_ID, Model model){
        Subject subject = subjectService.getSubject(SUBJECT_ID);
        model.addAttribute("subject", subject);
        return "updatesubject";
    }



    @PostMapping("/update-sname") // nevet  cserél
    public String updateSubject(@RequestParam("SUBJECT_ID") int SUBJECT_ID,
                                @RequestParam("sname") String sname,
                                Model model){
        int status = subjectService.updateSubject(SUBJECT_ID, sname);
        model.addAttribute("status", status);
        model.addAttribute("subjects", subjectService.getSubjectList());
        return "adminsubject";
    }

    @PostMapping("/delete-subject")
    public String deleteSubject(@RequestParam("SUBJECT_ID") int SUBJECT_ID, Model model){
        System.out.println("@DeleteMapping: "+SUBJECT_ID);
        int status = subjectService.deleteSubject(SUBJECT_ID);
        System.out.println("status code: "+status);
        model.addAttribute("status", status);
        model.addAttribute("subjects",subjectService.getSubjectList());
        return "adminsubject";
    }

    //******************************************************************-

    @GetMapping("/adminclassroom") // menüpontból navigál
    public String newClassRoom(Model model){
        model.addAttribute("classrooms", classRoomService.getClassRoomList());
        return "adminclassroom";
    }

    @PostMapping("/addclassroom") // űrlapon Add gombot megnyom
    public String addClassRoom(@RequestParam("space") int space,@RequestParam("door") String door,

                             Model model){
        int statusCode = classRoomService.addClassRoom(door,space);
        model.addAttribute("status", statusCode);
        model.addAttribute("classrooms", classRoomService.getClassRoomList());
        return "adminclassroom";
    }

    @PostMapping("updateclassroom") // menüpontból navigál
    public String updatingClassRoom(@RequestParam("DOORNUMBER_ID") int DOORNUMBER_ID, Model model){
        ClassRoom classroom = classRoomService.getClassRoom(DOORNUMBER_ID);
        model.addAttribute("classroom", classroom);
        return "updateclassroom";
    }



    @PostMapping("/update-space") // nevet cserél
    public String updateClassRoom(@RequestParam("DOORNUMBER_ID") int DOORNUMBER_ID,
                                @RequestParam("space") int space,
                                Model model){
        int status = classRoomService.updateClassRoom(DOORNUMBER_ID,space);
        model.addAttribute("status", status);
        model.addAttribute("classrooms", classRoomService.getClassRoomList());
        return "adminclassroom";
    }

    @PostMapping("/delete-classroom")
    public String deleteClassRoom(@RequestParam("DOORNUMBER_ID") int DOORNUMBER_ID, Model model){
        System.out.println("@DeleteMapping: "+DOORNUMBER_ID);
        int status = classRoomService.deleteClassRoom(DOORNUMBER_ID);
        System.out.println("status code: "+status);
        model.addAttribute("status", status);
        model.addAttribute("classrooms",classRoomService.getClassRoomList());
        return "adminclassroom";
    }

    //******************************************************************-

    @GetMapping("/adminstudent") // menüpontból navigál
    public String newStudent(Model model){
        model.addAttribute("students",studentService.getStudentList());
        model.addAttribute("studentclasses",studentclassService.getStudentClassList());
        return "adminstudent";
    }

    @PostMapping("/addstudent") // űrlapon Add gombot megnyom
    public String addStudent(@RequestParam("OMA_STUDENT") BigInteger OMA_STUDENT,
                               @RequestParam("Name") String Name,
                               @RequestParam("CLASS_ID") int CLASS_ID,
                               Model model){
        int statusCode = studentService.addStudent(OMA_STUDENT,Name,CLASS_ID);
        model.addAttribute("status", statusCode);
        model.addAttribute("students", studentService.getStudentList());
        model.addAttribute("studentclasses",studentclassService.getStudentClassList());
        return "adminstudent";
    }

    @PostMapping("updatestudent") // menüpontból navigál
    public String updatingStudent(@RequestParam("OMA_STUDENT") BigInteger OMA_STUDENT, Model model){
        Student student = studentService.getStudent(OMA_STUDENT);
        model.addAttribute("student", student);
        return "updatestudent";
    }



    @PostMapping("/update-stname") // nevet cserél
    public String updateStudent(@RequestParam("OMA_STUDENT") BigInteger OMA_STUDENT,
                                  @RequestParam("Name") String Name,
                                  Model model){
        int status = studentService.updateStudent(OMA_STUDENT,Name);
        model.addAttribute("status", status);
        model.addAttribute("students", studentService.getStudentList());
        return "adminstudent";
    }



    @PostMapping("/delete-student")
    public String deleteStudent(@RequestParam("OMA_STUDENT") BigInteger OMA_STUDENT, Model model){
        System.out.println("@DeleteMapping: "+OMA_STUDENT);
        int status = studentService.deleteStudent(OMA_STUDENT);
        System.out.println("status code: "+status);
        model.addAttribute("status", status);
        model.addAttribute("students",studentService.getStudentList());
        return "adminstudent";
    }

    //******************************************************************-

    @GetMapping("/adminstudentclass") // menüpontból navigál
    public String newStudentClass(Model model){
        model.addAttribute("studentclasses",studentclassService.getStudentClassList());
        return "adminstudentclass";
    }

    @PostMapping("/addstudentclass") // űrlapon Add gombot megnyom
    public String addStudentClass(@RequestParam("cname") String cname,
                             Model model){
        int statusCode = studentclassService.addStudentClass(cname);
        model.addAttribute("status", statusCode);
        model.addAttribute("studentclasses", studentclassService.getStudentClassList());
        return "adminstudentclass";
    }

    @PostMapping("/updatestudentclass") // menüpontból navigál
    public String updatingStudentClass(@RequestParam("CLASS_ID") int CLASS_ID, Model model){
        StudentClass studentclass = studentclassService.getStudentClass(CLASS_ID);
        model.addAttribute("studentclass", studentclass);
        return "updatestudentclass";
    }



    @PostMapping("/update-cname") // nevet cserél
    public String updateStudentClass(@RequestParam("CLASS_ID") int CLASS_ID,
                                @RequestParam("cname") String cname,
                                Model model){
        int status = studentclassService.updateStudentClass(CLASS_ID,cname);
        model.addAttribute("status", status);
        model.addAttribute("studentclasses", studentclassService.getStudentClassList());
        return "adminstudentclass";
    }

    @PostMapping("/delete-studentclass")
    public String deleteStudentClass(@RequestParam("CLASS_ID") int CLASS_ID, Model model){
        System.out.println("@DeleteMapping: "+CLASS_ID);
        int status = studentclassService.deleteStudentClass(CLASS_ID);
        System.out.println("status code: "+status);
        model.addAttribute("status", status);
        model.addAttribute("studentclasses",studentclassService.getStudentClassList());
        return "adminstudentclass";
    }

    //****************************************************************************

    @GetMapping("/admintimetable") // menüpontból navigál
    public String newTimeTable(/*int CLASS_ID, String day,Model model*/){
       // model.addAttribute("timetables", timeTableService.getTimeTableList(CLASS_ID,day));
       // return "admintimetable";
        return "sajathiba";
    }
/*
    @PostMapping("/addtimetable") // űrlapon Add gombot megnyom
        return "admintimetable";
    }

 */
/*
    @PostMapping("/updatetimetable") // menüpontból navigál
        return "updatetimetable";
    }



    @PostMapping("/update-timetable") // nevet cserél
        return "adminstimetable";
    }
 */

    @PostMapping("/timetables/{TIMETABLE_ID}")
    public String deleteTimeTable(@RequestParam("TIMETABLE_ID") int TIMETABLE_ID, Model model){
        System.out.println("@DeleteMapping: "+TIMETABLE_ID);
        int status = studentclassService.deleteStudentClass(TIMETABLE_ID);
        System.out.println("status code: "+status);
        model.addAttribute("status", status);
        //model.addAttribute("timetables",timeTableService.getTimeTableList());
        return "admintimetable";
    }


    @GetMapping("/adminteachersubject") // menüpontból navigál
    public String newTeacherSubject(){
        // model.addAttribute("timetables", timeTableService.getTimeTableList(CLASS_ID,day));
        // return "admintimetable";
        return "sajathiba";
    }
}



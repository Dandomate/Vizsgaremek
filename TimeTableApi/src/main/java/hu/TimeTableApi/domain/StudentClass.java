package hu.TimeTableApi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "class")
public class StudentClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CLASS_ID;
    @Size(min = 1,max = 10, message = "Az classname min 1 max 10 karakter")
    private String cname;

     /*
    @OneToMany(mappedBy = "studentclass", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Student> student;



      */

    @OneToMany(mappedBy = "studentclass")
    @JsonIgnore
    private List<Student> student;

/*
    @OneToOne
    @JoinColumn(name="CLASS_ID",nullable = false, referencedColumnName = "CLASS_ID")
    private TimeTable timetable;


 */
    public StudentClass() {
    }

    public StudentClass(int CLASS_ID, String cname, List<Student> student) {
        this.CLASS_ID = CLASS_ID;
        this.cname = cname;
        this.student = student;
    }

    /*
    public StudentClass(int CLASS_ID, String ClassName){
    this.CLASS_ID=CLASS_ID;
    this.ClassName=ClassName;
    }


     */


    public int getCLASS_ID() {
        return CLASS_ID;
    }

    public void setCLASS_ID(int CLASS_ID) {
        this.CLASS_ID = CLASS_ID;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
/*
    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }
 */
/*
    public TimeTable getTimetable() {
        return timetable;
    }

    public void setTimetable(TimeTable timetable) {
        this.timetable = timetable;
    }

 */

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }
}

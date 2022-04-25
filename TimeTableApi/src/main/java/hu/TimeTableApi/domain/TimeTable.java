package hu.TimeTableApi.domain;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Table(name = "timetable")
public class TimeTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int TIMETABLE_ID;
    /*
    @OneToMany(mappedBy = "timetable", cascade = CascadeType.ALL)
    private List<TeacherSubject> teachersubject;
    @OneToOne(mappedBy = "timetable", cascade = CascadeType.ALL)
    private List<StudentClass> studentclass;
    @OneToMany(mappedBy = "timetable", cascade = CascadeType.ALL)
    private List<ClassRoom> classroom;
*/
    //validálása
    private String day;
    @Min(value = 1)
    @Max(20)
    private int lesson;

    @OneToOne
    @JoinColumn(name="DOORNUMBER_ID",nullable = false, referencedColumnName = "DOORNUMBER_ID")
    private ClassRoom classRoom;

    @OneToOne
    @JoinColumn(name="CLASS_ID",nullable = false, referencedColumnName = "CLASS_ID")
    private StudentClass studentClass;

    @OneToOne
    @JoinColumn(name="SUBJECT_TEACHER_ID",nullable = false, referencedColumnName = "SUBJECT_TEACHER_ID")
    private TeacherSubject teacherSubject;


    public TimeTable(int TIMETABLE_ID,String day, int lesson) {
        this.TIMETABLE_ID = TIMETABLE_ID;
        this.day = day;
        this.lesson = lesson;
    }


    public TimeTable() {
    }

    public int getTIMETABLE_ID() {
        return TIMETABLE_ID;
    }

    public void setTIMETABLE_ID(int TIMETABLE_ID) {
        this.TIMETABLE_ID = TIMETABLE_ID;
    }


    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getLesson() {
        return lesson;
    }

    public void setLesson(int lesson) {
        this.lesson = lesson;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public StudentClass getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(StudentClass studentClass) {
        this.studentClass = studentClass;
    }

    public TeacherSubject getTeacherSubject() {
        return teacherSubject;
    }

    public void setTeacherSubject(TeacherSubject teacherSubject) {
        this.teacherSubject = teacherSubject;
    }
}


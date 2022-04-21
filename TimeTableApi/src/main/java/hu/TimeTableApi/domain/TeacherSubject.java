package hu.TimeTableApi.domain;

import javax.persistence.*;

@Entity
@Table(name = "teachersubject")
public class TeacherSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int SUBJECT_TEACHER_ID;
  /*
    @ManyToOne
    private Teacher teacher;
    @ManyToOne
    private Subject subject;

   */
    private int SUBJECT_ID;
    private long OMA_TEACHER;
   /*
    @ManyToOne
    @JoinColumn(name="SUBJECT_TEACHER_ID",nullable = false, referencedColumnName = "SUBJECT_TEACHER_ID")
    private TimeTable timetable;
*/
    public TeacherSubject(int SUBJECT_TEACHER_ID, /*Teacher teacher, Subject subject,*/ int SUBJECT_ID, long OMA_TEACHER){
        this.SUBJECT_TEACHER_ID = SUBJECT_TEACHER_ID;
    //    this.teacher = teacher;
      //  this.subject = subject;
        this.SUBJECT_ID = SUBJECT_ID;
        this.OMA_TEACHER= OMA_TEACHER;
    }

    public TeacherSubject() {
    }

    public int getSUBJECT_TEACHER_ID() {
        return SUBJECT_TEACHER_ID;
    }

    public void setSUBJECT_TEACHER_ID(int SUBJECT_TEACHER_ID) {
        this.SUBJECT_TEACHER_ID = SUBJECT_TEACHER_ID;
    }
/*
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }


 */
    public int getSUBJECT_ID() {
        return SUBJECT_ID;
    }

    public void setSUBJECT_ID(int SUBJECT_ID) {
        this.SUBJECT_ID = SUBJECT_ID;
    }

    public long getOMA_TEACHER() {
        return OMA_TEACHER;
    }

    public void setOMA_TEACHER(long OMA_TEACHER) {
        this.OMA_TEACHER = OMA_TEACHER;
    }
/*
    public TimeTable getTimetable() {
        return timetable;
    }

    public void setTimetable(TimeTable timetable) {
        this.timetable = timetable;
    }

 */
}


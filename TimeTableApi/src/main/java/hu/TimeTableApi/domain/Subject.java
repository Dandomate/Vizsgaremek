package hu.TimeTableApi.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int SUBJECT_ID;
    @Column(name = "sname")
    @NotNull
    @Size(min = 1,max = 15,message = "Subject Title min 1 characters and max 15 characters")
    private String sname;
    @ManyToMany(mappedBy = "subjectList")
    @JsonIgnore
    private List<Teacher> teacherList;

    public Subject(int SUBJECT_ID, String sname) {
        this.SUBJECT_ID = SUBJECT_ID;
        this.sname = sname;
    }

    public Subject() {
    }

    public int getSUBJECT_ID() {
        return SUBJECT_ID;
    }

    public void setSUBJECT_ID(int SUBJECT_ID) {
        this.SUBJECT_ID = SUBJECT_ID;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }
}


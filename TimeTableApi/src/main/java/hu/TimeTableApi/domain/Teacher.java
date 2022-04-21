package hu.TimeTableApi.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Teacher {

    @Id
    private long OMA_TEACHER;
    @NotNull
    @Size(min = 5,max = 30,message = "Your Name min 5 characters and max 30 characters")
    private String Name;
    private String Phone; //át kell irni varcharra mert ha van benne plusz
    private String Password;
    private boolean Admin;


    @ManyToMany
    @JoinTable(
            name = "teacherSubject",joinColumns = {@JoinColumn(name = "OMA_TEACHER")},inverseJoinColumns = {@JoinColumn(name = "SUBJECT_ID")}
    )
    @JsonIgnore
    private List<Subject> subjectList;




    public Teacher() {
    }

    public Teacher(long OMA_TEACHER, String Name, String Phone, String Password,boolean Admin) {
        this.OMA_TEACHER = OMA_TEACHER;
        this.Name = Name;
        this.Phone = Phone;
        this.Password = Password;
        this.Admin = Admin;
    }

    public long getOMA_TEACHER() {
        return OMA_TEACHER;
    }

    public void setOMA_TEACHER(long OMA_TEACHER) {
        this.OMA_TEACHER = OMA_TEACHER;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        this.Phone = phone;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public boolean isAdmin() {
        return Admin;
    }

    public void setAdmin(boolean admin) {
        this.Admin = admin;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }
}


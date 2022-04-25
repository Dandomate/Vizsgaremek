package hu.TimeTableApi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    @Id
    //@Size(min = 11,max = 11, message = "Az érték hosszabb mint 11 karakter")
    //@Pattern(regexp="^[0-9]",message="Nem megfelelő formátum")
    private BigInteger OMA_STUDENT;
    @Pattern(regexp="^[a-zA-Z]{1,30}$",message="Nem megfelelő formátum, vagy üres a mező vagy 30 nál nagyobb")
    private String name;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="CLASS_ID",nullable = false, referencedColumnName = "CLASS_ID")
    private StudentClass studentclass;


    /*
    @ManyToOne
    @JoinColumn(name = "CLASS_ID")
    private StudentClass studentClass;


     */
    //private int CLASS_ID= studentclass.getCLASS_ID();
/*
    public Student(BigInteger OMA_STUDENT, String name, int CLASS_ID) {
        this.OMA_STUDENT = OMA_STUDENT;
        this.name = name;
        this.CLASS_ID = CLASS_ID;
    }


 */





    public Student(BigInteger OMA_STUDENT, String name, StudentClass studentclass) {
        this.OMA_STUDENT = OMA_STUDENT;
        this.name = name;
        this.studentclass = studentclass;
    }

    public Student() {
    }

    public BigInteger getOMA_STUDENT() {
        return OMA_STUDENT;
    }

    public void setOMA_STUDENT(BigInteger OMA_STUDENT) {
        this.OMA_STUDENT = OMA_STUDENT;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StudentClass getStudentclass() {
        return studentclass;
    }

    public void setStudentclass(StudentClass studentclass) {
        this.studentclass = studentclass;
    }

/*
    public void setStudentclass(StudentClass studentclass) {
        this.studentclass = studentclass;
    }


 */

/*
    public void setCLASS_ID(int CLASS_ID) {
        this.CLASS_ID = CLASS_ID;
    }


 */

/*
    public StudentClass getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(StudentClass studentClass) {
        this.studentClass = studentClass;
    }

 */

}

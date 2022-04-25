
package hu.TimeTableFront.domain;

import java.math.BigInteger;

public class Student {
    private BigInteger OMA_STUDENT;
    private String Name;
    private int CLASS_ID;
    private String Cname;
   // private StudentClass studentClass;

    public Student() {
    }

    public Student(BigInteger OMA_STUDENT, String Name) {
        this.OMA_STUDENT= OMA_STUDENT;
        this.Name= Name;

    }
/*
    public Student(BigInteger OMA_STUDENT, String Name, StudentClass studentClass ) {
        this.OMA_STUDENT= OMA_STUDENT;
        this.Name= Name;
        this.studentClass=studentClass;

    }


 */
    public Student(BigInteger OMA_STUDENT, String Name, int CLASS_ID ) {
        this.OMA_STUDENT= OMA_STUDENT;
        this.Name= Name;
        this.CLASS_ID=CLASS_ID;

    }

    public Student(BigInteger OMA_STUDENT, String Name,int CLASS_ID,String Cname) {
        this.OMA_STUDENT= OMA_STUDENT;
        this.Name= Name;
        this.CLASS_ID=CLASS_ID;
        this.Cname=Cname;

    }



    public BigInteger getOMA_STUDENT() {
        return OMA_STUDENT;
    }

    public void setOMA_STUDENT(BigInteger OMA_STUDENT) {
        this.OMA_STUDENT = OMA_STUDENT;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name= Name;
    }
/*

    public StudentClass getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(StudentClass studentClass) {
        this.studentClass = studentClass;
    }


 */
    public int getCLASS_ID() {
        return CLASS_ID;
    }

    public void setCLASS_ID(int CLASS_ID) {
        this.CLASS_ID = CLASS_ID;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }
}

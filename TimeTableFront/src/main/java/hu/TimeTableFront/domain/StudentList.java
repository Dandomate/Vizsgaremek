package hu.TimeTableFront.domain;

import java.math.BigInteger;

public class StudentList {
    private BigInteger OMA_STUDENT;
    private String Name;
    private int CLASS_ID;
    private String cname;

    public StudentList() {
    }

    public StudentList(BigInteger OMA_STUDENT, String Name) {
        this.OMA_STUDENT= OMA_STUDENT;
        this.Name= Name;

    }

    public StudentList(BigInteger OMA_STUDENT, String Name,int CLASS_ID,String cname) {
        this.OMA_STUDENT= OMA_STUDENT;
        this.Name= Name;
        this.CLASS_ID=CLASS_ID;
        this.cname=cname;

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
}

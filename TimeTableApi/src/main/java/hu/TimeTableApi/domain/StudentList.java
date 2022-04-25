
package hu.TimeTableApi.domain;

import java.math.BigInteger;

public class StudentList {
    private BigInteger OMA_STUDENT;
    private String name;
    private int CLASS_ID;
    private String cname;

    public StudentList() {
    }

    public StudentList(BigInteger OMA_STUDENT, String name, int CLASS_ID,String cname) {
        this.OMA_STUDENT = OMA_STUDENT;
        this.name = name;
        this.CLASS_ID = CLASS_ID;
        this.cname=cname;
    }
    public StudentList(String name,String cname,BigInteger OMA_STUDENT) {
        this.name = name;
        this.cname=cname;
        this.OMA_STUDENT=OMA_STUDENT;

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

    public int getCLASS_ID() {return CLASS_ID;}

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



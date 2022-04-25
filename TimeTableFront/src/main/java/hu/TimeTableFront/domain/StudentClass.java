package hu.TimeTableFront.domain;

public class StudentClass {
    private int CLASS_ID;
    private String cname;

    public StudentClass(int CLASS_ID, String cname){
        this.CLASS_ID=CLASS_ID;
        this.cname=cname;
    }

    public StudentClass(String cname){
        this.cname=cname;
    }


    public StudentClass() {
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

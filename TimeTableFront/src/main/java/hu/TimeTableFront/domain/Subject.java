package hu.TimeTableFront.domain;

public class Subject {
    private int SUBJECT_ID;
    private String sname;

    public Subject() {
    }

    public Subject(int SUBJECT_ID, String sname) {
        this.SUBJECT_ID = SUBJECT_ID;
        this.sname=sname;
    }

    public Subject(String sname) {
        this.sname=sname;
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
}

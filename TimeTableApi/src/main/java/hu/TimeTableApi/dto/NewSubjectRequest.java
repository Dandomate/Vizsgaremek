package hu.TimeTableApi.dto;


import hu.TimeTableApi.domain.Subject;

public class NewSubjectRequest {
    private String sname;

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Subject toSubject(){
        Subject subject = new Subject();
        subject.setSname(this.sname);
        return subject;

    }
}

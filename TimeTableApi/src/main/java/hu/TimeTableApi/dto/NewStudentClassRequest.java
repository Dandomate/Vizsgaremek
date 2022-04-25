package hu.TimeTableApi.dto;


import hu.TimeTableApi.domain.StudentClass;

public class NewStudentClassRequest {
    private String cname;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public StudentClass toStudentClass() {
        StudentClass studentClass = new StudentClass();
        studentClass.setCname(this.cname);
        return studentClass;

    }
}
package hu.TimeTableApi.domain;

import javax.persistence.Column;

public class TeacherSubjectList {
    private String sname;
    private String Name;

    public TeacherSubjectList(String sname, String Name) {
        this.sname = sname;
        this.Name = Name;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }


}

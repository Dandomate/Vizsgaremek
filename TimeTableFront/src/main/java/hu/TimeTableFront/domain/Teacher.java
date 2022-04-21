package hu.TimeTableFront.domain;

public class Teacher {
    private long OMA_TEACHER;
    private String Name;
    private String Password;
    private String Phone;
    private Boolean Admin;


    public Teacher(long OMA_TEACHER, String Name, String Phone, String Password, Boolean Admin) {
        this.OMA_TEACHER = OMA_TEACHER;
        this.Name = Name;
        this.Password = Password;
        this.Phone = Phone;
        this.Admin = Admin;
    }

    public Teacher(long OMA_TEACHER, String Name) {
        this.OMA_TEACHER = OMA_TEACHER;
        this.Name = Name;
    }

    public Teacher() {
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

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public Boolean getAdmin() {
        return Admin;
    }

    public void setAdmin(Boolean admin) {
        Admin = admin;
    }
}

package hu.TimeTableApi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "teacher")
public class AdminTeacher {

    @Id
    @NotNull
    @Size(min = 11,max = 11, message = "Az érték hosszabb mint 11 karakter")
    @Pattern(regexp="^[0-9]",message="Nem megfelelő formátum")
    private long OMA_TEACHER;
   // @Size(min = 5,max = 50, message = "A jelszó hossza kevesebb mint 5 karakter vagy több mint 50")
    @Size(min = 5,max = 30,message = "min 5 max 30")
    private String Password;
    private boolean Admin;


    public AdminTeacher() {
    }

    public AdminTeacher(long OMA_TEACHER,String Password,boolean Admin) {
        this.OMA_TEACHER = OMA_TEACHER;
        this.Password = Password;
        this.Admin = Admin;
    }

    public long getOMA_TEACHER() {
        return OMA_TEACHER;
    }

    public void setOMA_TEACHER(long OMA_TEACHER) {
        this.OMA_TEACHER = OMA_TEACHER;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public boolean isAdmin() {
        return Admin;
    }

    public void setAdmin(boolean admin) {
        this.Admin = admin;
    }


}


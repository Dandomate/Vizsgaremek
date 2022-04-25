package hu.TimeTableApi.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "classroom")
public class ClassRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int DOORNUMBER_ID;
    @Size(min = 1,max = 10, message = "Az ajtoszám min 1 max 10 karakter")
    private String door;
    @Min(value = 1,message = "érték 1 nél kisebb")
    @Max(value = 100, message = "érték 100 nál nagyobb")
    private int space;
    /*
    @ManyToOne
    @JoinColumn(name="DOORNUMBER_ID",nullable = false, referencedColumnName = "DOORNUMBER_ID")
    private TimeTable timetable;
     */



    public ClassRoom(int DOORNUMBER_ID, String door, int space) {
        this.DOORNUMBER_ID = DOORNUMBER_ID;
        this.door = door;
        this.space = space;
    }

    public ClassRoom() {
    }

    public int getDOORNUMBER_ID() {
        return DOORNUMBER_ID;
    }

    public void setDOORNUMBER_ID(int DOORNUMBER_ID) {
        this.DOORNUMBER_ID = DOORNUMBER_ID;
    }

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }



}

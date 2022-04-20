package hu.TimeTableApi.domain;

import javax.persistence.*;

@Entity
@Table(name = "classroom")
public class ClassRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int DOORNUMBER_ID;
    private String door;
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

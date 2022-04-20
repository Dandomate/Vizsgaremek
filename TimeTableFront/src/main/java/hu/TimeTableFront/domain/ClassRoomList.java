package hu.TimeTableFront.domain;

public class ClassRoomList {
    private int DOORNUMBER_ID;
    private String door;
    private int space;

    public ClassRoomList() {
    }

    public ClassRoomList(int DOORNUMBER_ID, String door, int space) {
        this.DOORNUMBER_ID = DOORNUMBER_ID;
        this.door = door;
        this.space = space;
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

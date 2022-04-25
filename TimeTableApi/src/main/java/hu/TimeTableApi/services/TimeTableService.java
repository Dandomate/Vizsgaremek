
package hu.TimeTableApi.services;


import hu.TimeTableApi.domain.TimeTable;
import hu.TimeTableApi.domain.TimeTableList;
import hu.TimeTableApi.repositories.TimeTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TimeTableService {
    @Autowired
    private TimeTableRepository repository;
    @Value("${server.port}")
    private int port;

    /*
    public List<TimeTableList> getTimeTables() {
        List<TimeTableList> timetables = new ArrayList<>();
        List<Object[]> data = repository.getTimeTables();
        for (Object[] object : data) {
            int TIMETABLE_ID = (Integer) object[0];
            String name = (String) object[1];
            String sname = (String) object[2];
            String cname = (String) object[3];
            String door = (String) object[4];
            String day = (String) object[5];
            int lesson = (Integer) object[6];
            timetables.add(new TimeTableList(TIMETABLE_ID, name,sname,cname,door, day, lesson));
        }
        return timetables;
    }


     */

    public List<TimeTableList> getTimeTableList(int CLASS_ID, String day) {
        List<TimeTableList> result = new ArrayList<>();
        List<Object[]> timeTablesLists = repository.TimeTablesList(CLASS_ID, day);
        for (Object[] tomb : timeTablesLists) {
            int TIMETABLE_ID = (Integer) tomb[0];
            String name = (String) tomb[1];
            String sname = (String) tomb[2];
            String cname = (String) tomb[3];
            String door = (String) tomb[4];
            day = (String) tomb[5];
            Integer lesson = (Integer) tomb[6];
            result.add(new TimeTableList(TIMETABLE_ID,name,sname,cname,door,day,lesson));
        }
        return result;
    }

    public List<TimeTableList> getTimeTableListTeacher(long OMA_TEACHER, String day) {
        List<TimeTableList> result = new ArrayList<>();
        List<Object[]> timeTablesLists = repository.TimeTablesListTeacher(OMA_TEACHER, day);
        for (Object[] tomb : timeTablesLists) {
            int TIMETABLE_ID = (Integer) tomb[0];
            String sname = (String) tomb[1];
            String cname = (String) tomb[2];
            String door = (String) tomb[3];
            day = (String) tomb[4];
            Integer lesson = (Integer) tomb[5];
            result.add(new TimeTableList(TIMETABLE_ID,sname,cname,door,day,lesson));
        }
        return result;
    }


    public TimeTable getTimeTable(int TIMETABLE_ID) {
        Optional<TimeTable> timetable = repository.findById(TIMETABLE_ID);
        if (timetable.isPresent())
            return timetable.get();
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    }











    public TimeTable addTimeTable(TimeTable timetable){
        Optional<TimeTable> optionalTimeTable = repository.findById(timetable.getTIMETABLE_ID());
        if(!optionalTimeTable.isPresent()){
            return repository.save(timetable);
        }
        throw new ResponseStatusException(HttpStatus.CONFLICT);
    }

    public void deleteTimeTable(int TIMETABLE_ID) {
        Optional<TimeTable> optionalTimeTable = repository.findById(TIMETABLE_ID);
        if(optionalTimeTable.isPresent()){
            repository.deleteById(TIMETABLE_ID);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


}

/*
    public List<TimeTableList> getTimeTableList(String cname) {
        List<TimeTableList> result = new ArrayList<>();
        List<Object[]> timeTableLists = repository.TimeTableList(cname);
        for (Object[] tomb : timeTableLists) {
        //    int TIMETABLE_ID = (Integer) tomb[0];
            String name = (String) tomb[0];
            String sname = (String) tomb[1];
         //   String cname = (String) tomb[3];
            String door = (String) tomb[2];
            String day = (String) tomb[3];
            Integer lesson = (Integer) tomb[4];
            result.add(new TimeTableList(name,sname,cname,door, day,lesson));
        }
        return result;
    }
}

/*
/*
    public TimeTable updateTimeTable(int TIMETABLE_ID,int SUBJECT_TEACHER_ID,int CLASS_ID,int DOORNUMBER_ID,String day,int lesson) {
        Optional<TimeTable> optionalTimeTable = repository.findById(TIMETABLE_ID);
        if(optionalTimeTable.isPresent()){
            TimeTable timetable = optionalTimeTable.get();
            timetable.setSUBJECT_TEACHER_ID(SUBJECT_TEACHER_ID);
            timetable.setCLASS_ID(CLASS_ID);
            timetable.setDOORNUMBER_ID(DOORNUMBER_ID);
            timetable.setDay(day);
            timetable.setLesson(lesson);
            return repository.save(timetable);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


 */
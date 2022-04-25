
package hu.TimeTableApi.controllers;


import hu.TimeTableApi.domain.TimeTable;
import hu.TimeTableApi.domain.TimeTableList;
import hu.TimeTableApi.services.TimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimeTableController {

    @Autowired
    private TimeTableService service;
/*
    @GetMapping("/timetables")
    public List<TimeTableList> getTimeTables() {
        return service.getTimeTables();
    }


 */
    @GetMapping("/timetablelists/{CLASS_ID}/{day}")
    public List<TimeTableList> getTimeTableList(@PathVariable("CLASS_ID") int CLASS_ID, @PathVariable("day") String day) {
        return service.getTimeTableList(CLASS_ID, day);
    }

    @GetMapping("/timetablelist/{OMA_TEACHER}/{day}")
    public List<TimeTableList> getTimeTableListTeacher(@PathVariable("OMA_TEACHER") long OMA_TEACHER, @PathVariable("day") String day) {
        return service.getTimeTableListTeacher(OMA_TEACHER, day);
    }

/*
    @GetMapping("/timetablelists/{cname}")
    public List<TimeTableList> getTimeTableList(@PathVariable("cname") String cname){
        return service.getTimeTableList(cname);
    }
}


 */




    @GetMapping("/timetables/{TIMETABLE_ID}")
    public TimeTable getTimeTable(@PathVariable("TIMETABLE_ID") int TIMETABLE_ID){
        return service.getTimeTable(TIMETABLE_ID);

    }



    @PostMapping("/timetables")
    @ResponseStatus(HttpStatus.CREATED)
    public TimeTable addTimeTable(@RequestBody TimeTable timetable){
        return service.addTimeTable(timetable);
    }
/*
    @PatchMapping("/timetables/{TIMETABLE_ID}")
    public TimeTable updateTimeTable(@PathVariable("TIMETABLE_ID") int TIMETABLE_ID, @RequestBody TimeTable timetable){
        int SUBJECT_TEACHER_ID = timetable.getSUBJECT_TEACHER_ID();
        int CLASS_ID = timetable.getCLASS_ID();
        int DOORNUMBER_ID = timetable.getDOORNUMBER_ID();
        String day = timetable.getDay();
        int lesson = timetable.getLesson();
        return service.updateTimeTable(TIMETABLE_ID,SUBJECT_TEACHER_ID,CLASS_ID,DOORNUMBER_ID,day,lesson);
    }


 */
    @DeleteMapping("/timetables/{TIMETABLE_ID}")
    public void deleteTimeTable(@PathVariable("TIMETABLE_ID") int TIMETABLE_ID){
        service.deleteTimeTable(TIMETABLE_ID);
    }


}


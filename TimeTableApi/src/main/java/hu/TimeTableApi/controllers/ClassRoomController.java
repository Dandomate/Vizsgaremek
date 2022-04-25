package hu.TimeTableApi.controllers;


import hu.TimeTableApi.domain.ClassRoom;
import hu.TimeTableApi.domain.ClassRoomList;
import hu.TimeTableApi.dto.NewClassRoomRequest;
import hu.TimeTableApi.services.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
public class ClassRoomController {

    @Autowired
    private ClassRoomService service;

    @GetMapping("/classrooms")
    public List<ClassRoomList> getClassRooms(){
        System.out.println("classrooms controller");
            return service.getClassRooms();
        }

    @GetMapping("/classrooms/{DOORNUMBER_ID}")
    public ClassRoom getClassRoom(@PathVariable("DOORNUMBER_ID") int DOORNUMBER_ID){
        return service.getClassRoom(DOORNUMBER_ID);
    }
/*
    @PostMapping("/classrooms")
    @ResponseStatus(HttpStatus.CREATED)
    public ClassRoom addClassRoom(@RequestBody ClassRoom classroom){
        return service.addClassRoom(classroom);
    }


 */
@PostMapping("/classrooms")
@ResponseStatus(HttpStatus.CREATED)
public ClassRoom addClassRoom(@RequestBody NewClassRoomRequest newClassRoomRequest){
    return service.addClassRoom(newClassRoomRequest);
}

    @PatchMapping("/classrooms/{DOORNUMBER_ID}")
    public ClassRoom updateClassRoom(@PathVariable("DOORNUMBER_ID") int DOORNUMBER_ID, @RequestBody ClassRoom classroom){
        Integer space = classroom.getSpace();
        return service.updateClassRoom(DOORNUMBER_ID,space);
    }

    @DeleteMapping("/classrooms/{DOORNUMBER_ID}")
    public void deleteClassRoom(@PathVariable("DOORNUMBER_ID") int DOORNUMBER_ID){
        service.deleteClassRoom(DOORNUMBER_ID);
    }

}

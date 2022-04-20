package hu.TimeTableApi.services;


import hu.TimeTableApi.domain.ClassRoom;
import hu.TimeTableApi.domain.ClassRoomList;
import hu.TimeTableApi.dto.NewClassRoomRequest;
import hu.TimeTableApi.repositories.ClassRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClassRoomService {

    @Autowired
    private ClassRoomRepository repository;


    public List<ClassRoomList> getClassRooms() {
        List<ClassRoomList> classrooms = new ArrayList<>();
        List<Object[]> data = repository.getClassRooms();
        for (Object[] object : data) {
            int DOORNUMBER_ID = (Integer)object[0];
            String door = (String) object[1];
            int space = (Integer) object[2];
            classrooms.add(new ClassRoomList(DOORNUMBER_ID, door, space));
        }
        System.out.println("classrooms service");
        return classrooms;
    }

    public ClassRoom getClassRoom(int DOORNUMBER_ID){
        Optional<ClassRoom> classroom = repository.findById(DOORNUMBER_ID);
        if(classroom.isPresent())
            return classroom.get();
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public ClassRoom updateClassRoom(int DOORNUMBER_ID,int space) {
        Optional<ClassRoom> optionalClassRoom = repository.findById(DOORNUMBER_ID);
        if(optionalClassRoom.isPresent()){
            ClassRoom classroom = optionalClassRoom.get();
            classroom.setSpace(space);
            return repository.save(classroom);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

/*
    public ClassRoom addClassRoom(ClassRoom classroom){
        Optional<ClassRoom> optionalClassRoom = repository.findById(classroom.getDOORNUMBER_ID());
        if(!optionalClassRoom.isPresent()){
            return repository.save(classroom);
        }
        throw new ResponseStatusException(HttpStatus.CONFLICT);
    }
 */
public ClassRoom addClassRoom(NewClassRoomRequest newClassRoomRequest){
    ClassRoom classRoom=newClassRoomRequest.toClassRoom();
    System.out.println(newClassRoomRequest);
    return repository.save(classRoom);
}


    public void deleteClassRoom(int DOORNUMBER_ID) {
        Optional<ClassRoom> optionalClassRoom = repository.findById(DOORNUMBER_ID);
        if(optionalClassRoom.isPresent()){
            repository.deleteById(DOORNUMBER_ID);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
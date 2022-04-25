package hu.TimeTableApi.services;


import hu.TimeTableApi.domain.StudentClass;
import hu.TimeTableApi.domain.StudentClassList;
import hu.TimeTableApi.dto.NewStudentClassRequest;
import hu.TimeTableApi.repositories.StudentClassRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

@Service
public class StudentClassService {
    @Autowired
    private StudentClassRepository repository;


    public List<StudentClassList> getStudentClasses() {
        List<StudentClassList> studentclasses = new ArrayList<>();
        List<Object[]> data = repository.getStudentClasses();
        for (Object[] object : data) {
            int CLASS_ID = (Integer)object[0];
            String cname = (String) object[1];
            studentclasses.add(new StudentClassList(CLASS_ID, cname));
        }
        return studentclasses;
    }


    public StudentClass getStudentClass(int CLASS_ID) {
        Optional<StudentClass> studentclass = repository.findById(CLASS_ID);
        if (studentclass.isPresent())
            return studentclass.get();
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    }

    public StudentClass updateStudentClass(int CLASS_ID,String cname) {
        Optional<StudentClass> optionalStudentClass = repository.findById(CLASS_ID);
        if(optionalStudentClass.isPresent()){
            StudentClass studentclass = optionalStudentClass.get();
            studentclass.setCname(cname);
            return repository.save(studentclass);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

/*
    public StudentClass addStudentClass(StudentClass studentclass){
        Optional<StudentClass> optionalStudentClass = repository.findById(studentclass.getCLASS_ID());
        if(!optionalStudentClass.isPresent()){
            return repository.save(studentclass);
        }
        throw new ResponseStatusException(HttpStatus.CONFLICT);
    }
 */
    public StudentClass addStudentClass(NewStudentClassRequest newStudentClassRequest){
    StudentClass studentClass=newStudentClassRequest.toStudentClass();
    return repository.save(studentClass);

}

    public void deleteStudentClass(int CLASS_ID) {
        Optional<StudentClass> optionalStudentClass = repository.findById(CLASS_ID);
        if(optionalStudentClass.isPresent()){
            repository.deleteById(CLASS_ID);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
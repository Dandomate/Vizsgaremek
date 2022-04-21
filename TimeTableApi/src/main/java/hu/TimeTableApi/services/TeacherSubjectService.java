/*
package hu.TimeTableApi.services;

import hu.fisherRaceAPI.domain.SubjectList;
import hu.fisherRaceAPI.domain.Subject;
import hu.fisherRaceAPI.domain.TeacherSubject;
import hu.fisherRaceAPI.domain.TeacherSubjectList;
import hu.fisherRaceAPI.repositories.SubjectRepository;
import hu.fisherRaceAPI.repositories.TeacherSubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherSubjectService {

    @Autowired
    private TeacherSubjectRepository repository;
    @Value("${server.port}")
    private int port;

    public List<TeacherSubjectList> getTeacherSubjects(long OMA_TEACHER) {
        List<TeacherSubjectList> result = new ArrayList<>();
        List<Object[]> teacherSubjectLists = repository.teacherSubjects(OMA_TEACHER);
        for (Object[] tomb : teacherSubjectLists) {
            String name = (String) tomb[0];
            String sname = (String) tomb[1];
            result.add(new TeacherSubjectList(name,sname));
        }
        return result;
    }



    public TeacherSubject getTeacherSubject(int TEACHER_SUBJECT_ID) {
        Optional<TeacherSubject> teacherSubject = repository.findById(TEACHER_SUBJECT_ID);
        if (teacherSubject.isPresent())
            return teacherSubject.get();
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    }



    public Subject updateSubject(int SUBJECT_ID, String sname) {
        Optional<Subject> optionalSubject = repository.findById(SUBJECT_ID);
        if(optionalSubject.isPresent()){
            Subject subject = optionalSubject.get();
            subject.setSname(sname);
            return repository.save(subject);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }




    public TeacherSubject addTeacherSubject(TeacherSubject teachersubject){
        Optional<TeacherSubject> optionalTeacherSubject = repository.findById(teachersubject.getSUBJECT_TEACHER_ID());
        if(!optionalTeacherSubject.isPresent()){
            return repository.save(teachersubject);
        }
        throw new ResponseStatusException(HttpStatus.CONFLICT);
    }

    public void deleteTeacherSubject(int TEACHER_SUBJECT_ID) {
        Optional<TeacherSubject> optionalTeacherSubject = repository.findById(TEACHER_SUBJECT_ID);
        if(optionalTeacherSubject.isPresent()){
            repository.deleteById(TEACHER_SUBJECT_ID);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }




}




 */
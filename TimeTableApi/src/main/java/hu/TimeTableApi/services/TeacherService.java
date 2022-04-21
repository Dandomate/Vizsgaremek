
package hu.TimeTableApi.services;


import hu.TimeTableApi.domain.Teacher;
import hu.TimeTableApi.domain.TeacherSubjectList;
import hu.TimeTableApi.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository repository;

    public List<Teacher> getTeachers() {
        return repository.nativeFindTeachers();
    }

    public Teacher getTeacher(long OMA_TEACHER) {
        Optional<Teacher> teacher = repository.findById(OMA_TEACHER);
        if (teacher.isPresent())
            return teacher.get();
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);

}

    public List<TeacherSubjectList> getTeacherSubjectList(long OMA_TEACHER) {
        List<TeacherSubjectList> result = new ArrayList<>();
        List<Object[]> teacherSubjectLists = repository.teacherSubjectList(OMA_TEACHER);
        for (Object[] tomb : teacherSubjectLists) {
            String name = (String) tomb[0];
            String sname = (String) tomb[1];
            result.add(new TeacherSubjectList(name,sname));
        }
        return result;
    }

/*
    public TeacherSubject addTeacherSubject(TeacherSubject teachersubject){
        Optional<TeacherSubject> optionalTeacherSubject = repository.findById(teachersubject.getSUBJECT_TEACHER_ID());
        if(!optionalTeacherSubject.isPresent()){
            return repository.save(teachersubject);
        }
        throw new ResponseStatusException(HttpStatus.CONFLICT);
    }



 */




    public Teacher updateTeacher(long OMA_TEACHER, String Name/*,String Phone,String Password,boolean Admin*/) {
        Optional<Teacher> optionalTeacher = repository.findById(OMA_TEACHER);
        if(optionalTeacher.isPresent()){
            Teacher teacher = optionalTeacher.get();
            teacher.setName(Name);
           // teacher.setPhone(Phone);
            //teacher.setPassword(Password);
            //teacher.setAdmin(Admin);
            return repository.save(teacher);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }



    public Teacher addTeacher(Teacher teacher){
        Optional<Teacher> optionalTeacher = repository.findById(teacher.getOMA_TEACHER());
        if(!optionalTeacher.isPresent()){
            return repository.save(teacher);
        }
        throw new ResponseStatusException(HttpStatus.CONFLICT);
    }
/*
    public TeacherSubject addTeacherSubject(TeacherSubject teacherSubject){
        Optional<TeacherSubject> optionalTeacherSubject = repository.findById(teacherSubject.getSUBJECT_TEACHER_ID());
        if(!optionalTeacherSubject.isPresent()){
            return repository.save(teacherSubject);
        }
        throw new ResponseStatusException(HttpStatus.CONFLICT);
    }


 */
    public void deleteTeacher(long OMA_TEACHER) {
        Optional<Teacher> optionalTeacher = repository.findById(OMA_TEACHER);
        if(optionalTeacher.isPresent()){
            repository.deleteById(OMA_TEACHER);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


}



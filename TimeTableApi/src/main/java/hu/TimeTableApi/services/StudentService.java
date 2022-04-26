package hu.TimeTableApi.services;


import hu.TimeTableApi.domain.Student;
import hu.TimeTableApi.domain.StudentClass;
import hu.TimeTableApi.domain.StudentList;
import hu.TimeTableApi.dto.NewStudentClassRequest;
import hu.TimeTableApi.repositories.StudentClassRepository;
import hu.TimeTableApi.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import org.springframework.web.server.ResponseStatusException;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import javax.validation.Valid;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;
    @Autowired
    private StudentClassRepository studentClassRepository;
    /*
    @Value("${server.port}")
    private int port;


     */

    public List<StudentList> getStudents() {
        List<StudentList> students = new ArrayList<>();
        List<Object[]> data = repository.getStudents();
        for (Object[] object : data) {
            BigInteger OMA_STUDENT = (BigInteger) object[0];
            String name = (String) object[1];
            int CLASS_ID = (Integer) object[2];
            String cname= (String) object[3];
            students.add(new StudentList(OMA_STUDENT, name, CLASS_ID, cname));
        }
        return students;
    }



/*
    public List<Student> getStudents() {
        return repository.nativeFindStudents();
        }



 */


    public Student getStudent(BigInteger OMA_STUDENT) {
        Optional<Student> student = repository.findById(OMA_STUDENT);
        if (student.isPresent())
            return student.get();
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    }


/*
    public Student getStudentFromClass(int CLASS_ID) {
        Optional<Student> student = repository.getClassStudent(CLASS_ID);
        if (student.isPresent())
            return student.get();
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


 */


    public List<StudentList> getStudentList(int CLASS_ID) {
        List<StudentList> result = new ArrayList<>();
        List<Object[]> studentLists = repository.studentList(CLASS_ID);
        for (Object[] tomb : studentLists) {
            String name = (String) tomb[0];
            String cname = (String) tomb[1];
            BigInteger OMA_STUDENT=(BigInteger) tomb[2];
            result.add(new StudentList(name,cname,OMA_STUDENT));
        }
        return result;
    }


    public Student updateStudent(BigInteger OMA_STUDENT, String name) {
        Optional<Student> optionalStudent = repository.findById(OMA_STUDENT);
        if(optionalStudent.isPresent()){
            Student student = optionalStudent.get();
            student.setName(name);
            return repository.save(student);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

/*
    public Student updateStudent(BigInteger OMA_STUDENT, String name, int studentclass) {
        Optional<Student> optionalStudent = repository.findById(OMA_STUDENT);
        if(optionalStudent.isPresent()){
            Student updatingStudent = optionalStudent.get();
            updatingStudent.setName(name);
            Optional<StudentClass> optionalStudentClass = studentClassRepository.findById(studentclass);
            if(optionalStudentClass.isPresent()){
                return repository.save(updatingStudent);
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }




 */

    public Student addStudent(int CLASS_ID,Student student){
        StudentClass studentClass=studentClassRepository.findById(CLASS_ID).orElseThrow( () -> new ResponseStatusException(HttpStatus.CONFLICT));
        repository.findById(student.getOMA_STUDENT()).ifPresentOrElse(s -> {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }, () -> {
            student.setStudentclass(studentClass);
            repository.save(student);
        });
        return student;
    }
/*
    public Student addStudent(NewStudentRequest newStudentRequest){
        Student student=newStudentRequest.toStudent();
        return repository.save(student);

}


 */
    public void deleteStudent(BigInteger OMA_STUDENT) {
        Optional<Student> optionalStudent = repository.findById(OMA_STUDENT);
        if(optionalStudent.isPresent()){
            repository.deleteById(OMA_STUDENT);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }



}
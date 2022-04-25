package hu.TimeTableFront.services;

import hu.TimeTableFront.domain.Student;
import hu.TimeTableFront.domain.StudentClass;
import hu.TimeTableFront.domain.StudentList;
import hu.TimeTableFront.domain.TeacherSubjectList;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private RestTemplate restTemplate;
    private final String API_URL = "http://localhost:8095";

    public List<StudentList> getStudentList() {
        String url = API_URL+"/students";
        StudentList[] studentLists = restTemplate.getForObject(url, StudentList[].class);
        return Arrays.asList(studentLists);
    }

    public Student getStudent(BigInteger OMA_STUDENT) {
        String url = API_URL+"/students/{OMA_STUDENT}";
        Student student = restTemplate.getForObject(url, Student.class, OMA_STUDENT);
        return student;
    }

    public List<StudentList> getStudentList(int CLASS_ID) {
        String url = API_URL+"/studentlists/{CLASS_ID}";
        StudentList[] list = restTemplate.getForObject(url, StudentList[].class, CLASS_ID);
        return Arrays.asList(list);
    }

    public int addStudent(BigInteger OMA_STUDENT, String Name, int CLASS_ID) {
        String url = API_URL+"/{CLASS_ID}/students";
        Student student = new Student(OMA_STUDENT, Name,CLASS_ID);
        HttpEntity<Student> requestEntity = new HttpEntity<>(student);
        try {
            ResponseEntity<Student> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Student.class);
            return responseEntity.getStatusCodeValue();
        } catch(HttpClientErrorException ex){
            return ex.getStatusCode().value(); // conflict ( létező start number)
        }

    }
/*
    public int updateStudent(BigInteger OMA_STUDENT, String Name) {
        String url = API_URL+"/students/{OMA_STUDENT}";
        Student student = new Student(OMA_STUDENT, Name);

        // az alábbi két sorral állítjuk be a restTemplate példányt arra, hogy tudja kezelni a patch kérést
        // ezért kellett a httpclient dependency a pom.xml-be
        CloseableHttpClient client = HttpClientBuilder.create().build();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory(client));

        HttpEntity<Student> requestEntity = new HttpEntity<>(student);
        ResponseEntity<Student> responseEntity = restTemplate.exchange(url, HttpMethod.PATCH, requestEntity, Student.class, OMA_STUDENT);
        return responseEntity.getStatusCodeValue();
    }


 */
    public int deleteStudent(BigInteger OMA_STUDENT) {
        System.out.println("Service: "+(OMA_STUDENT/*-1*/));
        String url = API_URL+"/students/{OMA_STUDENT}";
        restTemplate.delete(url, OMA_STUDENT);
        System.out.println("return 100");
        return 100;
    }
}

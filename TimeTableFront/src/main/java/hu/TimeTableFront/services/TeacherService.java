package hu.TimeTableFront.services;


import hu.TimeTableFront.domain.*;
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

import java.util.Arrays;
import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private RestTemplate restTemplate;
    private final String API_URL = "http://localhost:8095";

    public List<Teacher> getTeachers() {
        String url = API_URL + "/teachers";
        Teacher[] teachers = restTemplate.getForObject(url, Teacher[].class);
        return Arrays.asList(teachers);
    }


    public Teacher getTeacher(long OMA_TEACHER) {
        String url = API_URL+"/teachers/{OMA_TEACHER}";
        Teacher teacher = restTemplate.getForObject(url, Teacher.class, OMA_TEACHER);
        return teacher;
    }




    public List<TeacherSubjectList> getTeacherSubjectList(long OMA_TEACHER) {
        String url = API_URL+"/teachersubjectlist/{OMA_TEACHER}";
        TeacherSubjectList[] list = restTemplate.getForObject(url, TeacherSubjectList[].class, OMA_TEACHER);
        return Arrays.asList(list);
    }


 /*

    public List<TeacherSubjectList> getTeacherSubjectList(long OMA_TEACHER) {
        String url = API_URL+"/teacher/{OMA_TEACHER}/subject";
        TeacherSubjectList[] list = restTemplate.getForObject(url, TeacherSubjectList[].class, OMA_TEACHER);
        return Arrays.asList(list);
    }



  */
    public int addTeacher(long OMA_TEACHER, String Name, String Phone,String Password, Boolean Admin) {
        String url = API_URL+"/teachers";
        Teacher teacher = new Teacher(OMA_TEACHER, Name, Phone,Password,Admin);
        HttpEntity<Teacher> requestEntity = new HttpEntity<>(teacher);
        try {
            ResponseEntity<Teacher> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Teacher.class);
            return responseEntity.getStatusCodeValue();
        } catch(HttpClientErrorException ex){
            return ex.getStatusCode().value(); // conflict ( létező start number)
        }

    }

    public int updateTeacher(long OMA_TEACHER, String Name,String Phone,String Password) {
        String url = API_URL+"/teachers/{OMA_TEACHER}";
        Teacher teacher = new Teacher(OMA_TEACHER, Name,Phone,Password);

        // az alábbi két sorral állítjuk be a restTemplate példányt arra, hogy tudja kezelni a patch kérést
        // ezért kellett a httpclient dependency a pom.xml-be
        CloseableHttpClient client = HttpClientBuilder.create().build();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory(client));

        HttpEntity<Teacher> requestEntity = new HttpEntity<>(teacher);
        ResponseEntity<Teacher> responseEntity = restTemplate.exchange(url, HttpMethod.PATCH, requestEntity, Teacher.class, OMA_TEACHER);
        return responseEntity.getStatusCodeValue();
    }

    public int deleteTeacher(long OMA_TEACHER) {
        System.out.println("Service: "+(OMA_TEACHER-1));
        String url = API_URL+"/teachers/{OMA_TEACHER}";
        restTemplate.delete(url, OMA_TEACHER);
        System.out.println("return 100");
        return 100;
    }

}
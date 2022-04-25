package hu.TimeTableFront.services;


import hu.TimeTableFront.domain.*;
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
public class StudentClassService {

    @Autowired
    private RestTemplate restTemplate;
    private final String API_URL = "http://localhost:8095";
/*
    public List<StudentClassList> getStudentClassLists() {
        String url = API_URL + "/studentclasses";
        StudentClassList[] studentclassLists = restTemplate.getForObject(url, StudentClassList[].class);
        System.out.println(studentclassLists);
        return Arrays.asList(studentclassLists);
    }

    public StudentClass getStudentClass(int CLASS_ID) {
        String url = API_URL+"/studentclasses/{CLASS_ID}";
        StudentClass studentclass = restTemplate.getForObject(url, StudentClass.class, CLASS_ID);
        System.out.println("Eljut service 2");
        return studentclass;
    }


    public int addStudentClass(int CLASS_ID, String cname) {
        String url = API_URL+"/studentclasses";
        StudentClass studentclass = new StudentClass(CLASS_ID, cname);
        HttpEntity<StudentClass> requestEntity = new HttpEntity<>(studentclass);
        try {
            ResponseEntity<StudentClass> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, StudentClass.class);
            return responseEntity.getStatusCodeValue();
        } catch(HttpClientErrorException ex){
            return ex.getStatusCode().value(); // conflict ( létező start number)
        }

    }

    public int updateStudentClass(int CLASS_ID, String cname) {
        String url = API_URL+"/studentclasses/{CLASS_ID}";
        StudentClass studentclass = new StudentClass(CLASS_ID, cname);

        // az alábbi két sorral állítjuk be a restTemplate példányt arra, hogy tudja kezelni a patch kérést
        // ezért kellett a httpclient dependency a pom.xml-be
        CloseableHttpClient client = HttpClientBuilder.create().build();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory(client));

        HttpEntity<StudentClass> requestEntity = new HttpEntity<>(studentclass);
        ResponseEntity<StudentClass> responseEntity = restTemplate.exchange(url, HttpMethod.PATCH, requestEntity, StudentClass.class, CLASS_ID);
        return responseEntity.getStatusCodeValue();
    }

    public int deleteStudentClass(int CLASS_ID) {
        System.out.println("Service: "+(CLASS_ID-1));
        String url = API_URL+"/studentclasses/{CLASS_ID}";
        restTemplate.delete(url, CLASS_ID);
        System.out.println("return 100");
        return 100;
    }



 */

    public List<StudentClassList> getStudentClassList() {
        String url = API_URL + "/studentclasses";
        StudentClassList[] studentClassLists = restTemplate.getForObject(url, StudentClassList[].class);
        return Arrays.asList(studentClassLists);
    }

    public StudentClass getStudentClass(int CLASS_ID) {
        String url = API_URL+"/studentclasses/{CLASS_ID}";
        StudentClass studentclass = restTemplate.getForObject(url, StudentClass.class, CLASS_ID);
        System.out.println("Eljut service 2");
        return studentclass;
    }


    public int addStudentClass(String cname) {
        String url = API_URL+"/studentclasses";
        StudentClass studentclass = new StudentClass(cname);
        HttpEntity<StudentClass> requestEntity = new HttpEntity<>(studentclass);
        try {
            ResponseEntity<StudentClass> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, StudentClass.class);
            return responseEntity.getStatusCodeValue();
        } catch(HttpClientErrorException ex){
            return ex.getStatusCode().value(); // conflict ( létező start number)
        }

    }

    public int updateStudentClass(int CLASS_ID, String cname) {
        String url = API_URL+"/studentclasses/{CLASS_ID}";
        StudentClass studentclass = new StudentClass(CLASS_ID, cname);

        // az alábbi két sorral állítjuk be a restTemplate példányt arra, hogy tudja kezelni a patch kérést
        // ezért kellett a httpclient dependency a pom.xml-be
        CloseableHttpClient client = HttpClientBuilder.create().build();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory(client));

        HttpEntity<StudentClass> requestEntity = new HttpEntity<>(studentclass);
        ResponseEntity<StudentClass> responseEntity = restTemplate.exchange(url, HttpMethod.PATCH, requestEntity, StudentClass.class, CLASS_ID);
        return responseEntity.getStatusCodeValue();
    }

    public int deleteStudentClass(int CLASS_ID) {
        System.out.println("Service: "+(CLASS_ID-1));
        String url = API_URL+"/studentclasses/{CLASS_ID}";
        restTemplate.delete(url, CLASS_ID);
        System.out.println("return 100");
        return 100;
    }



}
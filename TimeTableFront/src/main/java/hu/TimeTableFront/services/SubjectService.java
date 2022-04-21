package hu.TimeTableFront.services;

import hu.TimeTableFront.domain.Subject;
import hu.TimeTableFront.domain.SubjectList;
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
public class SubjectService {

    @Autowired
    private RestTemplate restTemplate;
    private final String API_URL = "http://localhost:8095";

    public List<SubjectList> getSubjectList() {
        String url = API_URL+"/subjects";
        SubjectList[] subjectLists = restTemplate.getForObject(url, SubjectList[].class);
        return Arrays.asList(subjectLists);
    }

    public Subject getSubject(int SUBJECT_ID) {
        String url = API_URL+"/subjects/{SUBJECT_ID}";
        Subject subject = restTemplate.getForObject(url, Subject.class, SUBJECT_ID);
        return subject;
    }

    public int addSubject(String sname) {
        String url = API_URL+"/subjects";
        Subject subject = new Subject(sname);
        HttpEntity<Subject> requestEntity = new HttpEntity<>(subject);
        try {
            ResponseEntity<Subject> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Subject.class);
            return responseEntity.getStatusCodeValue();
        } catch(HttpClientErrorException ex){
            return ex.getStatusCode().value(); // conflict ( létező start number)
        }

    }

    public int updateSubject(int SUBJECT_ID, String sname) {
        String url = API_URL+"/subjects/{SUBJECT_ID}";
        Subject subject = new Subject(SUBJECT_ID, sname);

        // az alábbi két sorral állítjuk be a restTemplate példányt arra, hogy tudja kezelni a patch kérést
        // ezért kellett a httpclient dependency a pom.xml-be
        CloseableHttpClient client = HttpClientBuilder.create().build();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory(client));

        HttpEntity<Subject> requestEntity = new HttpEntity<>(subject);
        ResponseEntity<Subject> responseEntity = restTemplate.exchange(url, HttpMethod.PATCH, requestEntity, Subject.class, SUBJECT_ID);
        return responseEntity.getStatusCodeValue();
    }

    public int deleteSubject(int SUBJECT_ID) {
        System.out.println("Service: "+(SUBJECT_ID-1));
        String url = API_URL+"/subjects/{SUBJECT_ID}";
        restTemplate.delete(url, SUBJECT_ID);
        System.out.println("return 100");
        return 100;
    }
}

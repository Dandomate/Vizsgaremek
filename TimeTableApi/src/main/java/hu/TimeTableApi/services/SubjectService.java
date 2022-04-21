package hu.TimeTableApi.services;


import hu.TimeTableApi.domain.Subject;
import hu.TimeTableApi.domain.SubjectList;
import hu.TimeTableApi.dto.NewSubjectRequest;
import hu.TimeTableApi.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

        @Autowired
        private SubjectRepository repository;
        @Value("${server.port}")
        private int port;

        public List<SubjectList> getSubjects() {
            List<SubjectList> subjects = new ArrayList<>();
            List<Object[]> data = repository.getSubjects();
            for (Object[] object : data) {
                int SUBJECT_ID = (Integer)object[0];
                String sname = (String) object[1];
                subjects.add(new SubjectList(SUBJECT_ID, sname));
            }
            return subjects;
        }

    public Subject getSubject(int SUBJECT_ID) {
        Optional<Subject> subject = repository.findById(SUBJECT_ID);
        if (subject.isPresent())
            return subject.get();
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



    public Subject addSubject(NewSubjectRequest newSubjectRequest){
            Subject subject=newSubjectRequest.toSubject();
//            Optional<Subject> optionalSubject = repository.findById(subject.getSUBJECT_ID());
 //       if(!optionalSubject.isPresent()){
            return repository.save(subject);
    //    }
   //     throw new ResponseStatusException(HttpStatus.CONFLICT);
    }

    public void deleteSubject(int SUBJECT_ID) {
        Optional<Subject> optionalSubject = repository.findById(SUBJECT_ID);
        if(optionalSubject.isPresent()){
            repository.deleteById(SUBJECT_ID);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


    }
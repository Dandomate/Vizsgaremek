package hu.TimeTableApi.controllers;


import hu.TimeTableApi.domain.Subject;
import hu.TimeTableApi.domain.SubjectList;
import hu.TimeTableApi.dto.NewSubjectRequest;
import hu.TimeTableApi.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class SubjectController {

    @Autowired
    private SubjectService service;

    @GetMapping("/subjects")
    public List<SubjectList> getSubjects(){
        return service.getSubjects();
    }

    @GetMapping("/subjects/{SUBJECT_ID}")
    public Subject getSubject(@PathVariable("SUBJECT_ID") int SUBJECT_ID){
        return service.getSubject(SUBJECT_ID);

    }

    @PostMapping("/subjects")
    @ResponseStatus(HttpStatus.CREATED)
    public Subject addSubject(@RequestBody NewSubjectRequest newSubjectRequest){
        return service.addSubject(newSubjectRequest);
    }

    @PatchMapping("/subjects/{SUBJECT_ID}")
    public Subject updateSubject(@PathVariable("SUBJECT_ID") int SUBJECT_ID, @RequestBody Subject subject){
        String sname = subject.getSname();
        return service.updateSubject(SUBJECT_ID, sname);
    }

    @DeleteMapping("/subjects/{SUBJECT_ID}")
    public void deleteSubject(@PathVariable("SUBJECT_ID") int SUBJECT_ID){
        service.deleteSubject(SUBJECT_ID);
    }

}


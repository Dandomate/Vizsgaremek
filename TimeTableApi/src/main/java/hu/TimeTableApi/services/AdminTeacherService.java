package hu.TimeTableApi.services;


import hu.TimeTableApi.domain.AdminTeacher;
import hu.TimeTableApi.repositories.AdminTeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AdminTeacherService {

    @Autowired
    private AdminTeacherRepository repository;

    public List<AdminTeacher> getAdminTeachers() {
        return repository.adminTeachers();
    }

    public AdminTeacher getAdminTeacher(long OMA_TEACHER) {
        Optional<AdminTeacher> adminteacher = repository.findById(OMA_TEACHER);
        if (adminteacher.isPresent())
            return adminteacher.get();
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    }
}

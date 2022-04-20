package hu.TimeTableApi.repositories;

import hu.TimeTableApi.domain.AdminTeacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminTeacherRepository extends JpaRepository<AdminTeacher, Long> {

    @Query(value="SELECT teacher.OMA_TEACHER, teacher.Password,teacher.Admin FROM teacher WHERE teacher.Admin=1;", nativeQuery = true)
    public List<AdminTeacher> adminTeachers();

    @Query(value="SELECT teacher.OMA_TEACHER, teacher.Password,teacher.Admin FROM teacher WHERE teacher.Admin=1 WHERE teacher.OMA_TEACHER=?1;", nativeQuery = true)
    public List<AdminTeacher> adminTeacher(long OMA_TEACHER);
}

/*
package hu.TimeTableApi.repositories;

import hu.fisherRaceAPI.domain.Subject;
import hu.fisherRaceAPI.domain.TeacherSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherSubjectRepository extends JpaRepository<TeacherSubject, Long> {


    @Query(value="SELECT subject.sname, teacher.Name FROM teachersubject INNER JOIN subject ON subject.SUBJECT_ID=teachersubject.SUBJECT_ID INNER JOIN teacher ON teacher.OMA_TEACHER=teachersubject.OMA_TEACHER WHERE teacher.OMA_TEACHER= ?2;", nativeQuery = true)
    public List<Object[]> teacherSubjects(long OMA_TEACHER);


}




 */
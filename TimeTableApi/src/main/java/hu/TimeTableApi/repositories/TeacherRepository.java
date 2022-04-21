
package hu.TimeTableApi.repositories;


import hu.TimeTableApi.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    //public List<Teacher> findAllByOrderByName();

    @Query(value="SELECT * FROM Teacher ORDER BY Name ASC;", nativeQuery = true)
    public List<Teacher> nativeFindTeachers();

    @Query(value="SELECT subject.sname, teacher.Name FROM subject INNER JOIN teachersubject ON teachersubject.SUBJECT_ID=subject.SUBJECT_ID INNER JOIN teacher ON teacher.OMA_TEACHER=teachersubject.OMA_TEACHER WHERE teacher.OMA_TEACHER = ?1 GROUP BY subject.SUBJECT_ID ORDER BY Name DESC", nativeQuery = true)
    public List<Object[]> teacherSubjectList(long OMA_TEACHER);
 /*
    @Query(value="INSERT INTO `teachersubject`(`SUBJECT_TEACHER_ID`, `SUBJECT_ID`, `OMA_TEACHER`) VALUES ('?1','?2','?3')", nativeQuery = true)
    public Optional<TeacherSubject> addTeacherSubject(int SUBJECT_TEACHER_ID, int SUBJECT_ID, long OMA_TEACHER);
*/
/*
    @Query(value="INSERT INTO `teachersubject`(`SUBJECT_TEACHER_ID`, `SUBJECT_ID`, `OMA_TEACHER`) VALUES ('?1','?2','?3');"
            , nativeQuery = true)
    public Optional<TeacherSubject> addTeacherSubject(int SUBJECT_TEACHER_ID,int SUBJECT_ID,long OMA_TEACHER);


 */

}

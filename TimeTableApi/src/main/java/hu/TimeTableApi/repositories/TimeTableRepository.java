
package hu.TimeTableApi.repositories;

import hu.TimeTableApi.domain.TimeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.math.BigInteger;
import java.util.List;

@Repository

public interface TimeTableRepository extends JpaRepository<TimeTable, Integer> {

    @Query(value="SELECT timetable.day, timetable.lesson, classroom.door, subject.sname, class.cname, teacher.Name FROM timetable INNER JOIN classroom ON classroom.DOORNUMBER_ID=timetable.DOORNUMBER_ID INNER JOIN teachersubject ON teachersubject.SUBJECT_TEACHER_ID=timetable.SUBJECT_TEACHER_ID INNER JOIN subject ON subject.SUBJECT_ID=teachersubject.SUBJECT_ID INNER JOIN class ON timetable.CLASS_ID=class.CLASS_ID INNER JOIN teacher ON teachersubject.OMA_TEACHER=teacher.OMA_TEACHER WHERE class.cname=?1 AND timetable.day=?2;"
            , nativeQuery = true)
    public List<TimeTable> selectTimeTables(String cname,String day); //selcetTimeTables


    @Query(value="SELECT timetable.TIMETABLE_ID, teacher.name, subject.sname, class.cname, classroom.door,timetable.day,timetable.lesson FROM timetable INNER JOIN classroom ON classroom.DOORNUMBER_ID=timetable.DOORNUMBER_ID INNER JOIN teachersubject ON teachersubject.SUBJECT_TEACHER_ID=timetable.SUBJECT_TEACHER_ID INNER JOIN subject ON subject.SUBJECT_ID=teachersubject.SUBJECT_ID INNER JOIN class ON timetable.CLASS_ID=class.CLASS_ID INNER JOIN teacher ON teachersubject.OMA_TEACHER=teacher.OMA_TEACHER;", nativeQuery = true)
    public List<Object[]> getTimeTables();

    @Query(value="SELECT timetable.TIMETABLE_ID, teacher.name, subject.sname, class.cname, classroom.door,timetable.day,timetable.lesson FROM timetable INNER JOIN classroom ON classroom.DOORNUMBER_ID=timetable.DOORNUMBER_ID INNER JOIN teachersubject ON teachersubject.SUBJECT_TEACHER_ID=timetable.SUBJECT_TEACHER_ID INNER JOIN subject ON subject.SUBJECT_ID=teachersubject.SUBJECT_ID INNER JOIN class ON timetable.CLASS_ID=class.CLASS_ID INNER JOIN teacher ON teachersubject.OMA_TEACHER=teacher.OMA_TEACHER WHERE class.CLASS_ID= ?1 AND timetable.day= ?2  ORDER by lesson;", nativeQuery = true)
    public List<Object[]> TimeTablesList(int CLASS_ID, String day);

    @Query(value="SELECT timetable.TIMETABLE_ID, subject.sname, class.cname, classroom.door,timetable.day,timetable.lesson FROM timetable INNER JOIN classroom ON classroom.DOORNUMBER_ID=timetable.DOORNUMBER_ID INNER JOIN teachersubject ON teachersubject.SUBJECT_TEACHER_ID=timetable.SUBJECT_TEACHER_ID INNER JOIN subject ON subject.SUBJECT_ID=teachersubject.SUBJECT_ID INNER JOIN class ON timetable.CLASS_ID=class.CLASS_ID INNER JOIN teacher ON teachersubject.OMA_TEACHER=teacher.OMA_TEACHER WHERE teacher.OMA_TEACHER= ?1 AND timetable.day= ?2 ORDER by lesson ;", nativeQuery = true)
    public List<Object[]> TimeTablesListTeacher(long OMA_TEACHER, String day);

/*
    @Query(value="SELECT teacher.name, subject.sname, classroom.door,timetable.day, timetable.lesson FROM timetable INNER JOIN classroom ON classroom.DOORNUMBER_ID=timetable.DOORNUMBER_ID INNER JOIN teachersubject ON teachersubject.SUBJECT_TEACHER_ID=timetable.SUBJECT_TEACHER_ID INNER JOIN subject ON subject.SUBJECT_ID=teachersubject.SUBJECT_ID INNER JOIN class ON timetable.CLASS_ID=class.CLASS_ID INNER JOIN teacher ON teachersubject.OMA_TEACHER=teacher.OMA_TEACHER WHERE class.cname= ?1 ;", nativeQuery = true)
    public List<Object[]> TimeTableList(String cname);
    0
 */

}


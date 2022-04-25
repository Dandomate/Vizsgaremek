package hu.TimeTableApi.repositories;

import hu.TimeTableApi.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository

    public interface StudentRepository extends JpaRepository<Student, BigInteger> {

    @Query(value = "SELECT student.OMA_STUDENT, student.name, class.CLASS_ID,class.cname  FROM student INNER JOIN class ON student.CLASS_ID=class.CLASS_ID ORDER BY CAST(class.cname AS UNSIGNED), student.name;"
            , nativeQuery = true)
    public List<Object[]> getStudents();


    @Query(value = "SELECT student.OMA_STUDENT, student.name, class.CLASS_ID  FROM student INNER JOIN class ON student.CLASS_ID=class.CLASS_ID WHERE student.OMA_STUDENT=?1 ;"
            , nativeQuery = true)
    public Optional<Student> getStudent(BigInteger OMA_STUDENT);

    @Query(value="SELECT student.name, class.cname, student.OMA_STUDENT FROM student INNER JOIN class ON student.CLASS_ID=class.CLASS_ID WHERE class.CLASS_ID= ?1 ;"
            , nativeQuery = true)
    public List<Object[]> studentList(int CLASS_ID);
}

/*
    @Query(value="INSERT INTO `student` (`OMA_STUDENT`, `name`, `CLASS_ID`) VALUES ('?1', '?', '?3');"
            , nativeQuery = true)
    public Optional<Student> addStudent(BigInteger OMA_STUDENT,String name, int CLASS_ID);




    */




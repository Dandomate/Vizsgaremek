package hu.TimeTableApi.repositories;


import hu.TimeTableApi.domain.StudentClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface StudentClassRepository extends JpaRepository<StudentClass, Integer> {
    @Query(value="SELECT* FROM Class ORDER BY CAST(class.cname AS UNSIGNED);", nativeQuery = true)
    public List<Object[]> getStudentClasses();
}

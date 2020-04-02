package io.ridsoftinformatiks.mahad.repo;

import io.ridsoftinformatiks.mahad.models.Student;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "student", path = "students")
public interface StudentRepository extends PagingAndSortingRepository<Student,Long> {
    List<Student> findByLastName(@Param("name") String name);
}

package io.ridsoftinformatiks.mahad.service;

import io.ridsoftinformatiks.mahad.models.Student;
import io.ridsoftinformatiks.mahad.models.response.StudentResponse;
import io.ridsoftinformatiks.mahad.models.response.StudentResponseList;
import io.ridsoftinformatiks.mahad.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentResponseList getAllStudent(int pageNum, int pageSize){
        StudentResponseList studentResponseList = new StudentResponseList();
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        Page<Student> all = studentRepository.findAll(pageable);
        if(!all.getContent().isEmpty()){
            studentResponseList.setCode("200");
            studentResponseList.setNoOfElement(all.getNumberOfElements());
            studentResponseList.setTotalNumberOfPages(all.getTotalPages());
            studentResponseList.setPageSize(all.getSize());
            studentResponseList.setPageNumber(all.getNumber()+1);
            studentResponseList.setStudents(all.getContent());
        }else{
            studentResponseList.setCode("404");
            studentResponseList.setErrorMessage("No record found");
            studentResponseList.setErrorField("Student");
        }

        return studentResponseList;

    }

    public StudentResponse saveStudent(Student student)
    {
        student.setStudentNumber(student.getFirstName().substring(0,3)+student.hashCode());
        student.setStudentHash(student.hashCode());
        try {
            Student save = studentRepository.save(student);
            return response(save,"","201","");
        } catch (DataAccessException e) {
         if(!e.getCause().getMessage().isEmpty()){
             e.printStackTrace();
             return response(null,"Student", "409","Student already exist");
         }
        }
        return response(null,"Student", "400","An error occurred");
    }

    public StudentResponse getStudentById(Long id){
        try {
            Optional<Student> studentById = studentRepository.findById(id);
             if(studentById.isPresent()){
                 return response(studentById.get(),"","200","");
             }
            else{
                return response(null,"student","404","Student record not found");
             }
        }catch (Exception e){
            return response(null,"student","500",e.getMessage());
        }
    }

    public StudentResponse updateStudent(Student student, Long id){
        try {
            Optional<Student> studentById = studentRepository.findById(id);
            if(studentById.isPresent()){
                Student studentUpdate = studentRepository.save(student);
                return response(studentUpdate,"","200", "");
            }
            else{
                return response(null,"student","404","Student record not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return response(null,"student","500","Update failed");
        }
    }
    private static StudentResponse response(Student student, String errorField, String code, String errorMessage){
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setStudent(student);
        studentResponse.setErrorField(errorField);
        studentResponse.setCode(code);
        studentResponse.setErrorMessage(errorMessage);
        return studentResponse;
    }
}

package io.ridsoftinformatiks.mahad.models.response;

import io.ridsoftinformatiks.mahad.models.Student;

public class StudentResponse extends ErrorResponse {
    Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}

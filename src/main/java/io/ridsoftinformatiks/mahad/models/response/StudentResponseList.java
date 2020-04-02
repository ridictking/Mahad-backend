package io.ridsoftinformatiks.mahad.models.response;

import io.ridsoftinformatiks.mahad.models.Student;

import java.util.List;

public class StudentResponseList extends ErrorResponse {
    private int noOfElement;
    private int pageSize;
    private int pageNumber;
    private int totalNumberOfPages;
    private List<Student> students;

    public int getTotalNumberOfPages() {
        return totalNumberOfPages;
    }

    public void setTotalNumberOfPages(int totalNumberOfPages) {
        this.totalNumberOfPages = totalNumberOfPages;
    }

    public int getNoOfElement() {
        return noOfElement;
    }

    public void setNoOfElement(int noOfElement) {
        this.noOfElement = noOfElement;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}

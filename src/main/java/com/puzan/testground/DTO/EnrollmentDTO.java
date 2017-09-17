/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puzan.testground.DTO;

import java.util.Date;

/**
 *
 * @author puzan
 */
public class EnrollmentDTO {

    private Integer enrollmentId;
    private int fees;
    private Date enrolledDate;

    private DiscountDTO discount;
    private TimeDTO time;
    private BatchDTO batch;
    private CourseDTO course;
    private StudentDTO student;
    private AmountDTO amount;

    public AmountDTO getAmount() {
        return amount;
    }

    public void setAmount(AmountDTO amount) {
        this.amount = amount;
    }

    public Integer getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(Integer enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    public Date getEnrolledDate() {
        return enrolledDate;
    }

    public void setEnrolledDate(Date enrolledDate) {
        this.enrolledDate = enrolledDate;
    }

    public DiscountDTO getDiscount() {
        return discount;
    }

    public void setDiscount(DiscountDTO discount) {
        this.discount = discount;
    }

    public TimeDTO getTime() {
        return time;
    }

    public void setTime(TimeDTO time) {
        this.time = time;
    }

    public BatchDTO getBatch() {
        return batch;
    }

    public void setBatch(BatchDTO batch) {
        this.batch = batch;
    }

    public CourseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puzan.testground.DTO;

import com.puzan.testground.Entities.Faculty;
import java.util.Date;

/**
 *
 * @author puzan
 */
public class BatchDTO {

    private Integer batchId;
    private Date createdDate;
    private Date startDate;
    private Date endDate;
    private boolean status;
    private boolean paymentStatus;
    private String agreement;

    private BatchCodeGeneratorDTO batchCode;
    private FacultyDTO faculty;
    private CourseDTO course;
    private TimeDTO time;

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getAgreement() {
        return agreement;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }

    public BatchCodeGeneratorDTO getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(BatchCodeGeneratorDTO batchCode) {
        this.batchCode = batchCode;
    }

    public FacultyDTO getFaculty() {
        return faculty;
    }

    public void setFaculty(FacultyDTO faculty) {
        this.faculty = faculty;
    }

    public CourseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }

    public TimeDTO getTime() {
        return time;
    }

    public void setTime(TimeDTO time) {
        this.time = time;
    }

}

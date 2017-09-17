/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puzan.testground.DTO;

/**
 *
 * @author puzan
 */
public class BatchCodeGeneratorDTO {

    private Integer batchCodeId;
    private String batchCode;
    private CourseDTO course;

    public Integer getBatchCodeId() {
        return batchCodeId;
    }

    public void setBatchCodeId(Integer batchCodeId) {
        this.batchCodeId = batchCodeId;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public CourseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }
    
    
}

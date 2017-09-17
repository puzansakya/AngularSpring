/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puzan.testground.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author puzan
 */
@Entity
@Table(name = "tbl_batch_code_generator")
@NamedQueries({
    @NamedQuery(name = "BatchCodeGenerator.findAll", query = "SELECT b FROM BatchCodeGenerator b")})
public class BatchCodeGenerator implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "batch_code_id")
    private Integer batchCodeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "batch_code")
    private String batchCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    @ManyToOne(optional = false)
    private Course course;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "batchCodeGenerator")
    private List<Batch> batchList;

    public BatchCodeGenerator() {
    }

    public BatchCodeGenerator(Integer batchCodeId) {
        this.batchCodeId = batchCodeId;
    }

    public BatchCodeGenerator(Integer batchCodeId, String batchCode, Date date) {
        this.batchCodeId = batchCodeId;
        this.batchCode = batchCode;
        this.date = date;
    }

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Batch> getBatchList() {
        return batchList;
    }

    public void setBatchList(List<Batch> batchList) {
        this.batchList = batchList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (batchCodeId != null ? batchCodeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BatchCodeGenerator)) {
            return false;
        }
        BatchCodeGenerator other = (BatchCodeGenerator) object;
        if ((this.batchCodeId == null && other.batchCodeId != null) || (this.batchCodeId != null && !this.batchCodeId.equals(other.batchCodeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.puzan.testground.Entities.BatchCodeGenerator[ batchCodeId=" + batchCodeId + " ]";
    }
    
}

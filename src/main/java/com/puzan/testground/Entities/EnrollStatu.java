/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puzan.testground.Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author puzan
 */
@Entity
@Table(name = "tbl_enroll_status")
@NamedQueries({
    @NamedQuery(name = "EnrollStatu.findAll", query = "SELECT e FROM EnrollStatu e")})
public class EnrollStatu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "enroll_id")
    private Integer enrollId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "color")
    private String color;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enrollStatu")
    private List<Enquiry> enquiryList;

    public EnrollStatu() {
    }

    public EnrollStatu(Integer enrollId) {
        this.enrollId = enrollId;
    }

    public EnrollStatu(Integer enrollId, String name, String color) {
        this.enrollId = enrollId;
        this.name = name;
        this.color = color;
    }

    public Integer getEnrollId() {
        return enrollId;
    }

    public void setEnrollId(Integer enrollId) {
        this.enrollId = enrollId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Enquiry> getEnquiryList() {
        return enquiryList;
    }

    public void setEnquiryList(List<Enquiry> enquiryList) {
        this.enquiryList = enquiryList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enrollId != null ? enrollId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnrollStatu)) {
            return false;
        }
        EnrollStatu other = (EnrollStatu) object;
        if ((this.enrollId == null && other.enrollId != null) || (this.enrollId != null && !this.enrollId.equals(other.enrollId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.puzan.testground.Entities.EnrollStatu[ enrollId=" + enrollId + " ]";
    }
    
}

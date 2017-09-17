/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puzan.testground.Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "tbl_follow_ups")
@NamedQueries({
    @NamedQuery(name = "FollowUp.findAll", query = "SELECT f FROM FollowUp f")})
public class FollowUp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "followup_id")
    private Integer followupId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "follow_message")
    private String followMessage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @JoinColumn(name = "enquiry_id", referencedColumnName = "enquiry_id")
    @ManyToOne(optional = false)
    private Enquiry enquiry;

    public FollowUp() {
    }

    public FollowUp(Integer followupId) {
        this.followupId = followupId;
    }

    public FollowUp(Integer followupId, String followMessage, Date createdDate) {
        this.followupId = followupId;
        this.followMessage = followMessage;
        this.createdDate = createdDate;
    }

    public Integer getFollowupId() {
        return followupId;
    }

    public void setFollowupId(Integer followupId) {
        this.followupId = followupId;
    }

    public String getFollowMessage() {
        return followMessage;
    }

    public void setFollowMessage(String followMessage) {
        this.followMessage = followMessage;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Enquiry getEnquiry() {
        return enquiry;
    }

    public void setEnquiry(Enquiry enquiry) {
        this.enquiry = enquiry;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (followupId != null ? followupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FollowUp)) {
            return false;
        }
        FollowUp other = (FollowUp) object;
        if ((this.followupId == null && other.followupId != null) || (this.followupId != null && !this.followupId.equals(other.followupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.puzan.testground.Entities.FollowUp[ followupId=" + followupId + " ]";
    }
    
}

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
@Table(name = "tbl_email_template")
@NamedQueries({
    @NamedQuery(name = "EmailTemplate.findAll", query = "SELECT e FROM EmailTemplate e")})
public class EmailTemplate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "et_id")
    private Integer etId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "et_name")
    private String etName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "slug")
    private int slug;
    @Basic(optional = false)
    @NotNull
    @Column(name = "description")
    private int description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;

    public EmailTemplate() {
    }

    public EmailTemplate(Integer etId) {
        this.etId = etId;
    }

    public EmailTemplate(Integer etId, String etName, int slug, int description, Date date, boolean status) {
        this.etId = etId;
        this.etName = etName;
        this.slug = slug;
        this.description = description;
        this.date = date;
        this.status = status;
    }

    public Integer getEtId() {
        return etId;
    }

    public void setEtId(Integer etId) {
        this.etId = etId;
    }

    public String getEtName() {
        return etName;
    }

    public void setEtName(String etName) {
        this.etName = etName;
    }

    public int getSlug() {
        return slug;
    }

    public void setSlug(int slug) {
        this.slug = slug;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (etId != null ? etId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmailTemplate)) {
            return false;
        }
        EmailTemplate other = (EmailTemplate) object;
        if ((this.etId == null && other.etId != null) || (this.etId != null && !this.etId.equals(other.etId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.puzan.testground.Entities.EmailTemplate[ etId=" + etId + " ]";
    }
    
}

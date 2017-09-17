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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author puzan
 */
@Entity
@Table(name = "tbl_bank_vouchers")
@NamedQueries({
    @NamedQuery(name = "BankVoucher.findAll", query = "SELECT b FROM BankVoucher b")})
public class BankVoucher implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bank_voucher_id")
    private Integer bankVoucherId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private int amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "voucher_no")
    private int voucherNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "added_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedDate;
    @JoinColumn(name = "bank_id", referencedColumnName = "bank_id")
    @ManyToOne(optional = false)
    private Bank bank;

    public BankVoucher() {
    }

    public BankVoucher(Integer bankVoucherId) {
        this.bankVoucherId = bankVoucherId;
    }

    public BankVoucher(Integer bankVoucherId, int amount, int voucherNo, Date addedDate) {
        this.bankVoucherId = bankVoucherId;
        this.amount = amount;
        this.voucherNo = voucherNo;
        this.addedDate = addedDate;
    }

    public Integer getBankVoucherId() {
        return bankVoucherId;
    }

    public void setBankVoucherId(Integer bankVoucherId) {
        this.bankVoucherId = bankVoucherId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(int voucherNo) {
        this.voucherNo = voucherNo;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bankVoucherId != null ? bankVoucherId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BankVoucher)) {
            return false;
        }
        BankVoucher other = (BankVoucher) object;
        if ((this.bankVoucherId == null && other.bankVoucherId != null) || (this.bankVoucherId != null && !this.bankVoucherId.equals(other.bankVoucherId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.puzan.testground.Entities.BankVoucher[ bankVoucherId=" + bankVoucherId + " ]";
    }
    
}

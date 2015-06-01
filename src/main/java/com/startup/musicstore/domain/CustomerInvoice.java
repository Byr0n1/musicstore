/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author 212157582
 */
@Entity
public class CustomerInvoice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date invoiceDate;
    private String invoiceStatus;
    private BigDecimal orderAmount;

    private CustomerInvoice(Builder builder) {
        id = builder.id;
        invoiceDate = builder.invoiceDate;
        invoiceStatus = builder.invoiceStatus;
        orderAmount = builder.orderAmount;
    }

    private CustomerInvoice() {
    }

    public static class Builder {

        private Long id;
        @Temporal(javax.persistence.TemporalType.DATE)
        private Date invoiceDate;
        private String invoiceStatus;
        private BigDecimal orderAmount;

        public Builder(Date invoiceDate) {
            this.invoiceDate = invoiceDate;
        }

        public Builder id(Long value) {
            this.id = value;
            return this;
        }

        public Builder invoiceStatus(String value) {
            this.invoiceStatus = value;
            return this;
        }

        public Builder orderAmount(BigDecimal value) {
            this.orderAmount = value;
            return this;
        }

        public Builder CustomerInvoice(CustomerInvoice value) {
            id = value.getId();
            invoiceDate = value.getInvoicedate();
            invoiceStatus = value.getInvoiceStatus();
            orderAmount = value.getOrderAmount();
            return this;
        }

        public CustomerInvoice build() {
            return new CustomerInvoice(this);
        }
    }

    public Long getId() {
        return id;
    }
   
    public Date getInvoicedate() {
        return invoiceDate;
    }

    public String getInvoiceStatus() {
        return invoiceStatus;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerInvoice)) {
            return false;
        }
        CustomerInvoice other = (CustomerInvoice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.startup.musicstore.domain.CustomerInvoice[ id=" + id + " ]";
    }
    
}

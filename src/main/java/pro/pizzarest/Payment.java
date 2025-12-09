/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pro.pizzarest;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Hala Shakaa4
 */
@Entity
@Table(name = "payment")
@NamedQueries({
    @NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p"),
    @NamedQuery(name = "Payment.findByPaymentid", query = "SELECT p FROM Payment p WHERE p.paymentid = :paymentid"),
    @NamedQuery(name = "Payment.findByAmountpaid", query = "SELECT p FROM Payment p WHERE p.amountpaid = :amountpaid"),
    @NamedQuery(name = "Payment.findByPaymenttype", query = "SELECT p FROM Payment p WHERE p.paymenttype = :paymenttype")})
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "paymentid")
    private Integer paymentid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amountpaid")
    private BigDecimal amountpaid;
    @Column(name = "paymenttype")
    private String paymenttype;
    @JoinColumn(name = "orderid", referencedColumnName = "orderid")
    @OneToOne(optional = false)
    private Order_ orderid;

    public Payment() {
    }

    public Payment(Integer paymentid) {
        this.paymentid = paymentid;
    }

    public Integer getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(Integer paymentid) {
        this.paymentid = paymentid;
    }

    public BigDecimal getAmountpaid() {
        return amountpaid;
    }

    public void setAmountpaid(BigDecimal amountpaid) {
        this.amountpaid = amountpaid;
    }

    public String getPaymenttype() {
        return paymenttype;
    }

    public void setPaymenttype(String paymenttype) {
        this.paymenttype = paymenttype;
    }

    public Order_ getOrderid() {
        return orderid;
    }

    public void setOrderid(Order_ orderid) {
        this.orderid = orderid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentid != null ? paymentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        if ((this.paymentid == null && other.paymentid != null) || (this.paymentid != null && !this.paymentid.equals(other.paymentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pro.pizzarest.Payment[ paymentid=" + paymentid + " ]";
    }
    
}

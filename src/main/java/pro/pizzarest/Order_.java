/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pro.pizzarest;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Hala Shakaa4
 */
@Entity
@Table(name = "Order")
@NamedQueries({
    @NamedQuery(name = "Order1.findAll", query = "SELECT o FROM Order1 o"),
    @NamedQuery(name = "Order1.findByOrderid", query = "SELECT o FROM Order1 o WHERE o.orderid = :orderid"),
    @NamedQuery(name = "Order1.findByOrdertype", query = "SELECT o FROM Order1 o WHERE o.ordertype = :ordertype"),
    @NamedQuery(name = "Order1.findByOrdertime", query = "SELECT o FROM Order1 o WHERE o.ordertime = :ordertime"),
    @NamedQuery(name = "Order1.findByTotalamount", query = "SELECT o FROM Order1 o WHERE o.totalamount = :totalamount"),
    @NamedQuery(name = "Order1.findByDeliverydatetime", query = "SELECT o FROM Order1 o WHERE o.deliverydatetime = :deliverydatetime")})
public class Order_ implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "orderid")
    private Integer orderid;
    @Column(name = "ordertype")
    private String ordertype;
    @Column(name = "ordertime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ordertime;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "totalamount")
    private BigDecimal totalamount;
    @Column(name = "deliverydatetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deliverydatetime;
    @ManyToMany(mappedBy = "order1Collection")
    private Collection<Customer> customerCollection;
    @JoinTable(name = "Contains", joinColumns = {
        @JoinColumn(name = "orid", referencedColumnName = "orderid")}, inverseJoinColumns = {
        @JoinColumn(name = "pzid", referencedColumnName = "pizzaid")})
    @ManyToMany
    private Collection<Pizza> pizzaCollection;
    @JoinColumn(name = "customerid", referencedColumnName = "customerid")
    @ManyToOne(optional = false)
    private Customer customerid;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "orderid")
    private Payment payment;

    public Order_() {
    }

    public Order_(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(String ordertype) {
        this.ordertype = ordertype;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public BigDecimal getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(BigDecimal totalamount) {
        this.totalamount = totalamount;
    }

    public Date getDeliverydatetime() {
        return deliverydatetime;
    }

    public void setDeliverydatetime(Date deliverydatetime) {
        this.deliverydatetime = deliverydatetime;
    }

    public Collection<Customer> getCustomerCollection() {
        return customerCollection;
    }

    public void setCustomerCollection(Collection<Customer> customerCollection) {
        this.customerCollection = customerCollection;
    }

    public Collection<Pizza> getPizzaCollection() {
        return pizzaCollection;
    }

    public void setPizzaCollection(Collection<Pizza> pizzaCollection) {
        this.pizzaCollection = pizzaCollection;
    }

    public Customer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Customer customerid) {
        this.customerid = customerid;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderid != null ? orderid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Order_)) {
            return false;
        }
        Order_ other = (Order_) object;
        if ((this.orderid == null && other.orderid != null) || (this.orderid != null && !this.orderid.equals(other.orderid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pro.pizzarest.Order1[ orderid=" + orderid + " ]";
    }
    
}

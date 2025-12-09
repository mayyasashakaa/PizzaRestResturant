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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Hala Shakaa4
 */
@Entity
@Table(name = "order_")
@NamedQueries({
    @NamedQuery(name = "Order1.findAll", query = "SELECT o FROM Order1 o"),
    @NamedQuery(name = "Order1.findByOrderid", query = "SELECT o FROM Order1 o WHERE o.orderid = :orderid"),
    @NamedQuery(name = "Order1.findByOrderDate", query = "SELECT o FROM Order1 o WHERE o.orderDate = :orderDate"),
    @NamedQuery(name = "Order1.findByDeliveryDateTime", query = "SELECT o FROM Order1 o WHERE o.deliveryDateTime = :deliveryDateTime"),
    @NamedQuery(name = "Order1.findByOrderType", query = "SELECT o FROM Order1 o WHERE o.orderType = :orderType"),
    @NamedQuery(name = "Order1.findByTotalAmount", query = "SELECT o FROM Order1 o WHERE o.totalAmount = :totalAmount")})
public class Order1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "orderid")
    private Integer orderid;
    @Column(name = "OrderDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @Column(name = "DeliveryDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deliveryDateTime;
    @Column(name = "OrderType")
    private String orderType;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TotalAmount")
    private BigDecimal totalAmount;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderid")
    private Collection<Pizzaorders> pizzaordersCollection;
    @JoinColumn(name = "customerid", referencedColumnName = "customerid")
    @ManyToOne
    private Customer customerid;

    public Order1() {
    }

    public Order1(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeliveryDateTime() {
        return deliveryDateTime;
    }

    public void setDeliveryDateTime(Date deliveryDateTime) {
        this.deliveryDateTime = deliveryDateTime;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Collection<Pizzaorders> getPizzaordersCollection() {
        return pizzaordersCollection;
    }

    public void setPizzaordersCollection(Collection<Pizzaorders> pizzaordersCollection) {
        this.pizzaordersCollection = pizzaordersCollection;
    }

    public Customer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Customer customerid) {
        this.customerid = customerid;
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
        if (!(object instanceof Order1)) {
            return false;
        }
        Order1 other = (Order1) object;
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pro.pizzarest;

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

/**
 *
 * @author Hala Shakaa4
 */
@Entity
@Table(name = "delivery")
@NamedQueries({
    @NamedQuery(name = "Delivery.findAll", query = "SELECT d FROM Delivery d"),
    @NamedQuery(name = "Delivery.findByDeliveryid", query = "SELECT d FROM Delivery d WHERE d.deliveryid = :deliveryid"),
    @NamedQuery(name = "Delivery.findByOrderid", query = "SELECT d FROM Delivery d WHERE d.orderid = :orderid"),
    @NamedQuery(name = "Delivery.findByDeliverystatus", query = "SELECT d FROM Delivery d WHERE d.deliverystatus = :deliverystatus"),
    @NamedQuery(name = "Delivery.findByDeliverytime", query = "SELECT d FROM Delivery d WHERE d.deliverytime = :deliverytime")})
public class Delivery implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "deliveryid")
    private Integer deliveryid;
    @Basic(optional = false)
    @Column(name = "orderid")
    private int orderid;
    @Column(name = "deliverystatus")
    private String deliverystatus;
    @Column(name = "deliverytime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deliverytime;
    @JoinColumn(name = "deliverypersonid", referencedColumnName = "employeeid")
    @ManyToOne(optional = false)
    private Employee deliverypersonid;

    public Delivery() {
    }

    public Delivery(Integer deliveryid) {
        this.deliveryid = deliveryid;
    }

    public Delivery(Integer deliveryid, int orderid) {
        this.deliveryid = deliveryid;
        this.orderid = orderid;
    }

    public Integer getDeliveryid() {
        return deliveryid;
    }

    public void setDeliveryid(Integer deliveryid) {
        this.deliveryid = deliveryid;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getDeliverystatus() {
        return deliverystatus;
    }

    public void setDeliverystatus(String deliverystatus) {
        this.deliverystatus = deliverystatus;
    }

    public Date getDeliverytime() {
        return deliverytime;
    }

    public void setDeliverytime(Date deliverytime) {
        this.deliverytime = deliverytime;
    }

    public Employee getDeliverypersonid() {
        return deliverypersonid;
    }

    public void setDeliverypersonid(Employee deliverypersonid) {
        this.deliverypersonid = deliverypersonid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deliveryid != null ? deliveryid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Delivery)) {
            return false;
        }
        Delivery other = (Delivery) object;
        if ((this.deliveryid == null && other.deliveryid != null) || (this.deliveryid != null && !this.deliveryid.equals(other.deliveryid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pro.pizzarest.Delivery[ deliveryid=" + deliveryid + " ]";
    }
    
}

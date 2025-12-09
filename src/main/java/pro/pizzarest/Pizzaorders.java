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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Hala Shakaa4
 */
@Entity
@Table(name = "pizzaorders")
@NamedQueries({
    @NamedQuery(name = "Pizzaorders.findAll", query = "SELECT p FROM Pizzaorders p"),
    @NamedQuery(name = "Pizzaorders.findByOrderpizzaid", query = "SELECT p FROM Pizzaorders p WHERE p.orderpizzaid = :orderpizzaid"),
    @NamedQuery(name = "Pizzaorders.findBySize", query = "SELECT p FROM Pizzaorders p WHERE p.size = :size"),
    @NamedQuery(name = "Pizzaorders.findByQuantity", query = "SELECT p FROM Pizzaorders p WHERE p.quantity = :quantity"),
    @NamedQuery(name = "Pizzaorders.findByPrice", query = "SELECT p FROM Pizzaorders p WHERE p.price = :price")})
public class Pizzaorders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "orderpizzaid")
    private Integer orderpizzaid;
    @Basic(optional = false)
    @Column(name = "size")
    private String size;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "price")
    private BigDecimal price;
    @JoinColumn(name = "orderid", referencedColumnName = "orderid")
    @ManyToOne(optional = false)
    private Order1 orderid;
    @JoinColumn(name = "pizzaid", referencedColumnName = "pizzaid")
    @ManyToOne(optional = false)
    private Pizza pizzaid;

    public Pizzaorders() {
    }

    public Pizzaorders(Integer orderpizzaid) {
        this.orderpizzaid = orderpizzaid;
    }

    public Pizzaorders(Integer orderpizzaid, String size, int quantity, BigDecimal price) {
        this.orderpizzaid = orderpizzaid;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getOrderpizzaid() {
        return orderpizzaid;
    }

    public void setOrderpizzaid(Integer orderpizzaid) {
        this.orderpizzaid = orderpizzaid;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Order1 getOrderid() {
        return orderid;
    }

    public void setOrderid(Order1 orderid) {
        this.orderid = orderid;
    }

    public Pizza getPizzaid() {
        return pizzaid;
    }

    public void setPizzaid(Pizza pizzaid) {
        this.pizzaid = pizzaid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderpizzaid != null ? orderpizzaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pizzaorders)) {
            return false;
        }
        Pizzaorders other = (Pizzaorders) object;
        if ((this.orderpizzaid == null && other.orderpizzaid != null) || (this.orderpizzaid != null && !this.orderpizzaid.equals(other.orderpizzaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pro.pizzarest.Pizzaorders[ orderpizzaid=" + orderpizzaid + " ]";
    }
    
}

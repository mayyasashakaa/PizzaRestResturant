/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pro.pizzarest;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Hala Shakaa4
 */
@Entity
@Table(name = "pizza")
@NamedQueries({
    @NamedQuery(name = "Pizza.findAll", query = "SELECT p FROM Pizza p"),
    @NamedQuery(name = "Pizza.findByPizzaid", query = "SELECT p FROM Pizza p WHERE p.pizzaid = :pizzaid"),
    @NamedQuery(name = "Pizza.findByName", query = "SELECT p FROM Pizza p WHERE p.name = :name"),
    @NamedQuery(name = "Pizza.findBySize", query = "SELECT p FROM Pizza p WHERE p.size = :size"),
    @NamedQuery(name = "Pizza.findByDescription", query = "SELECT p FROM Pizza p WHERE p.description = :description"),
    @NamedQuery(name = "Pizza.findByBaseprice", query = "SELECT p FROM Pizza p WHERE p.baseprice = :baseprice")})
public class Pizza implements Serializable {

    @Column(name = "Description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pizzaid")
    private Collection<Pizzaorders> pizzaordersCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pizzaid")
    private Integer pizzaid;
    @Column(name = "Name")
    private String name;
    @Column(name = "Size")
    private String size;
    @Column(name = "description")
  //  private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
   // @Column(name = "baseprice")
    private BigDecimal baseprice;
    @ManyToMany(mappedBy = "pizzaCollection")
    private Collection<Order_> order1Collection;
    @ManyToMany(mappedBy = "pizzaCollection")
    private Collection<Menu> menuCollection;

    public Pizza() {
    }

    public Pizza(Integer pizzaid) {
        this.pizzaid = pizzaid;
    }

    public Integer getPizzaid() {
        return pizzaid;
    }

    public void setPizzaid(Integer pizzaid) {
        this.pizzaid = pizzaid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getBaseprice() {
        return baseprice;
    }

    public void setBaseprice(BigDecimal baseprice) {
        this.baseprice = baseprice;
    }

    public Collection<Order_> getOrder1Collection() {
        return order1Collection;
    }

    public void setOrder1Collection(Collection<Order_> order1Collection) {
        this.order1Collection = order1Collection;
    }

    public Collection<Menu> getMenuCollection() {
        return menuCollection;
    }

    public void setMenuCollection(Collection<Menu> menuCollection) {
        this.menuCollection = menuCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pizzaid != null ? pizzaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pizza)) {
            return false;
        }
        Pizza other = (Pizza) object;
        if ((this.pizzaid == null && other.pizzaid != null) || (this.pizzaid != null && !this.pizzaid.equals(other.pizzaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pro.pizzarest.Pizza[ pizzaid=" + pizzaid + " ]";
    }

   

    public Collection<Pizzaorders> getPizzaordersCollection() {
        return pizzaordersCollection;
    }

    public void setPizzaordersCollection(Collection<Pizzaorders> pizzaordersCollection) {
        this.pizzaordersCollection = pizzaordersCollection;
    }
    
}

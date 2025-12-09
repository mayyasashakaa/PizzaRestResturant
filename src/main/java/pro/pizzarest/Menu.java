/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pro.pizzarest;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Hala Shakaa4
 */
@Entity
@Table(name = "menu")
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m"),
    @NamedQuery(name = "Menu.findByMenuid", query = "SELECT m FROM Menu m WHERE m.menuid = :menuid"),
    @NamedQuery(name = "Menu.findByPizzaid", query = "SELECT m FROM Menu m WHERE m.pizzaid = :pizzaid"),
    @NamedQuery(name = "Menu.findByAvailability", query = "SELECT m FROM Menu m WHERE m.availability = :availability"),
    @NamedQuery(name = "Menu.findByEmpid", query = "SELECT m FROM Menu m WHERE m.empid = :empid")})
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "menuid")
    private Integer menuid;
    @Basic(optional = false)
    @Column(name = "pizzaid")
    private int pizzaid;
    @Column(name = "availability")
    private Boolean availability;
    @Basic(optional = false)
    @Column(name = "empid")
    private int empid;
    @JoinTable(name = "Include", joinColumns = {
        @JoinColumn(name = "mid", referencedColumnName = "menuid")}, inverseJoinColumns = {
        @JoinColumn(name = "pid", referencedColumnName = "pizzaid")})
    @ManyToMany
    private Collection<Pizza> pizzaCollection;

    public Menu() {
    }

    public Menu(Integer menuid) {
        this.menuid = menuid;
    }

    public Menu(Integer menuid, int pizzaid, int empid) {
        this.menuid = menuid;
        this.pizzaid = pizzaid;
        this.empid = empid;
    }

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    public int getPizzaid() {
        return pizzaid;
    }

    public void setPizzaid(int pizzaid) {
        this.pizzaid = pizzaid;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public Collection<Pizza> getPizzaCollection() {
        return pizzaCollection;
    }

    public void setPizzaCollection(Collection<Pizza> pizzaCollection) {
        this.pizzaCollection = pizzaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menuid != null ? menuid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.menuid == null && other.menuid != null) || (this.menuid != null && !this.menuid.equals(other.menuid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pro.pizzarest.Menu[ menuid=" + menuid + " ]";
    }
    
}

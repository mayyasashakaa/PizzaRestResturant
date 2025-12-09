package pro.pizzarest;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Customer entity class
 * 
 * @author Hala Shakaa4
 */
@Entity
@Table(name = "customer")
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByCustomerid", query = "SELECT c FROM Customer c WHERE c.customerid = :customerid"),
    @NamedQuery(name = "Customer.findByFname", query = "SELECT c FROM Customer c WHERE c.fname = :fname"),
    @NamedQuery(name = "Customer.findByMname", query = "SELECT c FROM Customer c WHERE c.mname = :mname"),
    @NamedQuery(name = "Customer.findByLname", query = "SELECT c FROM Customer c WHERE c.lname = :lname"),
    @NamedQuery(name = "Customer.findByPhonenumber", query = "SELECT c FROM Customer c WHERE c.phonenumber = :phonenumber"),
    @NamedQuery(name = "Customer.findByEmailaddress", query = "SELECT c FROM Customer c WHERE c.emailaddress = :emailaddress"),
    @NamedQuery(name = "Customer.findByStreet", query = "SELECT c FROM Customer c WHERE c.street = :street"),
    @NamedQuery(name = "Customer.findByCity", query = "SELECT c FROM Customer c WHERE c.city = :city"),
    @NamedQuery(name = "Customer.findByState", query = "SELECT c FROM Customer c WHERE c.state = :state")
})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "customerid")
    private Integer customerid;
    
    @Column(name = "fname")
    private String fname;
    
    @Column(name = "mname")
    private String mname;
    
    @Column(name = "lname")
    private String lname;
    
    @Column(name = "phonenumber")
    private String phonenumber;
    
    @Column(name = "emailaddress")
    private String emailaddress;
    
    @Column(name = "street")
    private String street;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "state")
    private String state;
    
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    
    @Column(name = "Address")
    private String address;
    
    @OneToMany(mappedBy = "customerid")
    private Collection<Order_> orderCollection;

    @JoinTable(name = "places", joinColumns = {
        @JoinColumn(name = "custid", referencedColumnName = "customerid")}, inverseJoinColumns = {
        @JoinColumn(name = "oid", referencedColumnName = "orderid")})
    @ManyToMany
    private Collection<Order_> orderManyToManyCollection;

    public Customer() {}

    public Customer(Integer customerid) {
        this.customerid = customerid;
    }

    // Getters and Setters
    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Collection<Order_> getOrderCollection() {
        return orderCollection;
    }

    public void setOrderCollection(Collection<Order_> orderCollection) {
        this.orderCollection = orderCollection;
    }

    public Collection<Order_> getOrderManyToManyCollection() {
        return orderManyToManyCollection;
    }

    public void setOrderManyToManyCollection(Collection<Order_> orderManyToManyCollection) {
        this.orderManyToManyCollection = orderManyToManyCollection;
    }

    @Override
    public int hashCode() {
        return customerid != null ? customerid.hashCode() : 0;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        return (this.customerid != null || other.customerid == null) && 
               (this.customerid == null || this.customerid.equals(other.customerid));
    }

    @Override
    public String toString() {
        return "pro.pizzarest.Customer[ customerid=" + customerid + " ]";
    }
}

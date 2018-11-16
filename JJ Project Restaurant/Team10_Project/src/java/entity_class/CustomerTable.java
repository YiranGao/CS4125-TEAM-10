/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity_class;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "customer_table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerTable.findAll", query = "SELECT c FROM CustomerTable c")
    , @NamedQuery(name = "CustomerTable.findByCustomerId", query = "SELECT c FROM CustomerTable c WHERE c.customerId = :customerId")
    , @NamedQuery(name = "CustomerTable.findByCustomerName", query = "SELECT c FROM CustomerTable c WHERE c.customerName = :customerName")
    , @NamedQuery(name = "CustomerTable.findByCustomerPhoneNumber", query = "SELECT c FROM CustomerTable c WHERE c.customerPhoneNumber = :customerPhoneNumber")
    , @NamedQuery(name = "CustomerTable.findByCustomerPassword", query = "SELECT c FROM CustomerTable c WHERE c.customerPassword = :customerPassword")
    , @NamedQuery(name = "CustomerTable.findByCustomerBirth", query = "SELECT c FROM CustomerTable c WHERE c.customerBirth = :customerBirth")
    , @NamedQuery(name = "CustomerTable.findByCustomerGender", query = "SELECT c FROM CustomerTable c WHERE c.customerGender = :customerGender")
    , @NamedQuery(name = "CustomerTable.findByCustomerEmail", query = "SELECT c FROM CustomerTable c WHERE c.customerEmail = :customerEmail")})
public class CustomerTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "customer_id")
    private Integer customerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "customer_phone_number")
    private BigInteger customerPhoneNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "customer_password")
    private String customerPassword;
    @Size(max = 45)
    @Column(name = "customer_birth")
    private String customerBirth;
    @Column(name = "customer_gender")
    private Integer customerGender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "customer_email")
    private String customerEmail;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId")
    private Collection<ReservationTable> reservationTableCollection;
    @JoinColumn(name = "creditcard_id", referencedColumnName = "card_id")
    @ManyToOne
    private CreditcardTable creditcardId;

    public CustomerTable() {
    }

    public CustomerTable(Integer customerId) {
        this.customerId = customerId;
    }

    public CustomerTable(Integer customerId, String customerName, String customerPassword, String customerEmail) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPassword = customerPassword;
        this.customerEmail = customerEmail;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigInteger getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(BigInteger customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public String getCustomerBirth() {
        return customerBirth;
    }

    public void setCustomerBirth(String customerBirth) {
        this.customerBirth = customerBirth;
    }

    public Integer getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(Integer customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    @XmlTransient
    public Collection<ReservationTable> getReservationTableCollection() {
        return reservationTableCollection;
    }

    public void setReservationTableCollection(Collection<ReservationTable> reservationTableCollection) {
        this.reservationTableCollection = reservationTableCollection;
    }

    public CreditcardTable getCreditcardId() {
        return creditcardId;
    }

    public void setCreditcardId(CreditcardTable creditcardId) {
        this.creditcardId = creditcardId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerTable)) {
            return false;
        }
        CustomerTable other = (CustomerTable) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity_class.CustomerTable[ customerId=" + customerId + " ]";
    }
    
}

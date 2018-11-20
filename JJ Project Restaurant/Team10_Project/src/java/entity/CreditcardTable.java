/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "creditcard_table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CreditcardTable.findAll", query = "SELECT c FROM CreditcardTable c")
    , @NamedQuery(name = "CreditcardTable.findByCardId", query = "SELECT c FROM CreditcardTable c WHERE c.cardId = :cardId")
    , @NamedQuery(name = "CreditcardTable.findByCardHolderName", query = "SELECT c FROM CreditcardTable c WHERE c.cardHolderName = :cardHolderName")
    , @NamedQuery(name = "CreditcardTable.findByCardValiddateYear", query = "SELECT c FROM CreditcardTable c WHERE c.cardValiddateYear = :cardValiddateYear")
    , @NamedQuery(name = "CreditcardTable.findByCardValiddateMonth", query = "SELECT c FROM CreditcardTable c WHERE c.cardValiddateMonth = :cardValiddateMonth")
    , @NamedQuery(name = "CreditcardTable.findByCardNumber", query = "SELECT c FROM CreditcardTable c WHERE c.cardNumber = :cardNumber")})
public class CreditcardTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "card_id")
    private Integer cardId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "card_holder_name")
    private String cardHolderName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "card_validdate_year")
    private long cardValiddateYear;
    @Basic(optional = false)
    @NotNull
    @Column(name = "card_validdate_month")
    private long cardValiddateMonth;
    @Basic(optional = false)
    @NotNull
    @Column(name = "card_number")
    private long cardNumber;
    @OneToMany(mappedBy = "creditcardId")
    private Collection<CustomerTable> customerTableCollection;

    public CreditcardTable() {
    }

    public CreditcardTable(Integer cardId) {
        this.cardId = cardId;
    }

    public CreditcardTable(Integer cardId, String cardHolderName, long cardValiddateYear, long cardValiddateMonth, long cardNumber) {
        this.cardId = cardId;
        this.cardHolderName = cardHolderName;
        this.cardValiddateYear = cardValiddateYear;
        this.cardValiddateMonth = cardValiddateMonth;
        this.cardNumber = cardNumber;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public long getCardValiddateYear() {
        return cardValiddateYear;
    }

    public void setCardValiddateYear(long cardValiddateYear) {
        this.cardValiddateYear = cardValiddateYear;
    }

    public long getCardValiddateMonth() {
        return cardValiddateMonth;
    }

    public void setCardValiddateMonth(long cardValiddateMonth) {
        this.cardValiddateMonth = cardValiddateMonth;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    @XmlTransient
    public Collection<CustomerTable> getCustomerTableCollection() {
        return customerTableCollection;
    }

    public void setCustomerTableCollection(Collection<CustomerTable> customerTableCollection) {
        this.customerTableCollection = customerTableCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cardId != null ? cardId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CreditcardTable)) {
            return false;
        }
        CreditcardTable other = (CreditcardTable) object;
        if ((this.cardId == null && other.cardId != null) || (this.cardId != null && !this.cardId.equals(other.cardId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CreditcardTable[ cardId=" + cardId + " ]";
    }
    
}

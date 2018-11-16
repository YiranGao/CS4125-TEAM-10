/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity_class;

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
@Table(name = "waiter_table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WaiterTable.findAll", query = "SELECT w FROM WaiterTable w")
    , @NamedQuery(name = "WaiterTable.findByWaiterId", query = "SELECT w FROM WaiterTable w WHERE w.waiterId = :waiterId")
    , @NamedQuery(name = "WaiterTable.findByWaiterName", query = "SELECT w FROM WaiterTable w WHERE w.waiterName = :waiterName")
    , @NamedQuery(name = "WaiterTable.findByWaiterPassword", query = "SELECT w FROM WaiterTable w WHERE w.waiterPassword = :waiterPassword")
    , @NamedQuery(name = "WaiterTable.findByUsertype", query = "SELECT w FROM WaiterTable w WHERE w.usertype = :usertype")
    , @NamedQuery(name = "WaiterTable.findByFeedbackMark", query = "SELECT w FROM WaiterTable w WHERE w.feedbackMark = :feedbackMark")})
public class WaiterTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "waiter_id")
    private Integer waiterId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "waiter_name")
    private String waiterName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "waiter_password")
    private String waiterPassword;
    @Basic(optional = false)
    @NotNull
    private int usertype;
    @Column(name = "feedback_mark")
    private Integer feedbackMark;
    @JoinColumn(name = "restaurant_id", referencedColumnName = "restaurant_id")
    @ManyToOne(optional = false)
    private RestaurantTable restaurantId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "waiterId")
    private Collection<FeedbackTable> feedbackTableCollection;

    public WaiterTable() {
    }

    public WaiterTable(Integer waiterId) {
        this.waiterId = waiterId;
    }

    public WaiterTable(Integer waiterId, String waiterName, String waiterPassword, int usertype) {
        this.waiterId = waiterId;
        this.waiterName = waiterName;
        this.waiterPassword = waiterPassword;
        this.usertype = usertype;
    }

    public Integer getWaiterId() {
        return waiterId;
    }

    public void setWaiterId(Integer waiterId) {
        this.waiterId = waiterId;
    }

    public String getWaiterName() {
        return waiterName;
    }

    public void setWaiterName(String waiterName) {
        this.waiterName = waiterName;
    }

    public String getWaiterPassword() {
        return waiterPassword;
    }

    public void setWaiterPassword(String waiterPassword) {
        this.waiterPassword = waiterPassword;
    }

    public int getUsertype() {
        return usertype;
    }

    public void setUsertype(int usertype) {
        this.usertype = usertype;
    }

    public Integer getFeedbackMark() {
        return feedbackMark;
    }

    public void setFeedbackMark(Integer feedbackMark) {
        this.feedbackMark = feedbackMark;
    }

    public RestaurantTable getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(RestaurantTable restaurantId) {
        this.restaurantId = restaurantId;
    }

    @XmlTransient
    public Collection<FeedbackTable> getFeedbackTableCollection() {
        return feedbackTableCollection;
    }

    public void setFeedbackTableCollection(Collection<FeedbackTable> feedbackTableCollection) {
        this.feedbackTableCollection = feedbackTableCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (waiterId != null ? waiterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WaiterTable)) {
            return false;
        }
        WaiterTable other = (WaiterTable) object;
        if ((this.waiterId == null && other.waiterId != null) || (this.waiterId != null && !this.waiterId.equals(other.waiterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity_class.WaiterTable[ waiterId=" + waiterId + " ]";
    }
    
}

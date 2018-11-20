/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "feedback_table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FeedbackTable.findAll", query = "SELECT f FROM FeedbackTable f")
    , @NamedQuery(name = "FeedbackTable.findByFeedbackId", query = "SELECT f FROM FeedbackTable f WHERE f.feedbackId = :feedbackId")
    , @NamedQuery(name = "FeedbackTable.findByFeedbackMarkWaiter", query = "SELECT f FROM FeedbackTable f WHERE f.feedbackMarkWaiter = :feedbackMarkWaiter")
    , @NamedQuery(name = "FeedbackTable.findByFeedbackMarkFronthouse", query = "SELECT f FROM FeedbackTable f WHERE f.feedbackMarkFronthouse = :feedbackMarkFronthouse")})
public class FeedbackTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "feedback_id")
    private Integer feedbackId;
    @Column(name = "feedback_mark_waiter")
    private Integer feedbackMarkWaiter;
    @Column(name = "feedback_mark_fronthouse")
    private Integer feedbackMarkFronthouse;
    @JoinColumn(name = "fronthouse_id", referencedColumnName = "fronthouse_id")
    @ManyToOne(optional = false)
    private FronthouseTable fronthouseId;
    @JoinColumn(name = "reservation_id", referencedColumnName = "restaurant_id")
    @ManyToOne(optional = false)
    private RestaurantTable reservationId;
    @JoinColumn(name = "waiter_id", referencedColumnName = "waiter_id")
    @ManyToOne(optional = false)
    private WaiterTable waiterId;

    public FeedbackTable() {
    }

    public FeedbackTable(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    public Integer getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    public Integer getFeedbackMarkWaiter() {
        return feedbackMarkWaiter;
    }

    public void setFeedbackMarkWaiter(Integer feedbackMarkWaiter) {
        this.feedbackMarkWaiter = feedbackMarkWaiter;
    }

    public Integer getFeedbackMarkFronthouse() {
        return feedbackMarkFronthouse;
    }

    public void setFeedbackMarkFronthouse(Integer feedbackMarkFronthouse) {
        this.feedbackMarkFronthouse = feedbackMarkFronthouse;
    }

    public FronthouseTable getFronthouseId() {
        return fronthouseId;
    }

    public void setFronthouseId(FronthouseTable fronthouseId) {
        this.fronthouseId = fronthouseId;
    }

    public RestaurantTable getReservationId() {
        return reservationId;
    }

    public void setReservationId(RestaurantTable reservationId) {
        this.reservationId = reservationId;
    }

    public WaiterTable getWaiterId() {
        return waiterId;
    }

    public void setWaiterId(WaiterTable waiterId) {
        this.waiterId = waiterId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (feedbackId != null ? feedbackId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FeedbackTable)) {
            return false;
        }
        FeedbackTable other = (FeedbackTable) object;
        if ((this.feedbackId == null && other.feedbackId != null) || (this.feedbackId != null && !this.feedbackId.equals(other.feedbackId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.FeedbackTable[ feedbackId=" + feedbackId + " ]";
    }
    
}

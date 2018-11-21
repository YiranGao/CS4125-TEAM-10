/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityclass;

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
@Table(name = "restaurant_table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RestaurantTable.findAll", query = "SELECT r FROM RestaurantTable r")
    , @NamedQuery(name = "RestaurantTable.findByRestaurantId", query = "SELECT r FROM RestaurantTable r WHERE r.restaurantId = :restaurantId")
    , @NamedQuery(name = "RestaurantTable.findByRestaurantLocation", query = "SELECT r FROM RestaurantTable r WHERE r.restaurantLocation = :restaurantLocation")
    , @NamedQuery(name = "RestaurantTable.findByRestaurantTableamount", query = "SELECT r FROM RestaurantTable r WHERE r.restaurantTableamount = :restaurantTableamount")})
public class RestaurantTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "restaurant_id")
    private Integer restaurantId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "restaurant_location")
    private String restaurantLocation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "restaurant_tableamount")
    private int restaurantTableamount;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurantId")
    private Collection<ReservationTable> reservationTableCollection;
    @JoinColumn(name = "admin_id", referencedColumnName = "admin_id")
    @ManyToOne(optional = false)
    private AdministratorTable adminId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurantId")
    private Collection<TableTable> tableTableCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurantId")
    private Collection<WaiterTable> waiterTableCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reservationId")
    private Collection<FeedbackTable> feedbackTableCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurantId")
    private Collection<FronthouseTable> fronthouseTableCollection;

    public RestaurantTable() {
    }

    public RestaurantTable(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public RestaurantTable(Integer restaurantId, String restaurantLocation, int restaurantTableamount) {
        this.restaurantId = restaurantId;
        this.restaurantLocation = restaurantLocation;
        this.restaurantTableamount = restaurantTableamount;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantLocation() {
        return restaurantLocation;
    }

    public void setRestaurantLocation(String restaurantLocation) {
        this.restaurantLocation = restaurantLocation;
    }

    public int getRestaurantTableamount() {
        return restaurantTableamount;
    }

    public void setRestaurantTableamount(int restaurantTableamount) {
        this.restaurantTableamount = restaurantTableamount;
    }

    @XmlTransient
    public Collection<ReservationTable> getReservationTableCollection() {
        return reservationTableCollection;
    }

    public void setReservationTableCollection(Collection<ReservationTable> reservationTableCollection) {
        this.reservationTableCollection = reservationTableCollection;
    }

    public AdministratorTable getAdminId() {
        return adminId;
    }

    public void setAdminId(AdministratorTable adminId) {
        this.adminId = adminId;
    }

    @XmlTransient
    public Collection<TableTable> getTableTableCollection() {
        return tableTableCollection;
    }

    public void setTableTableCollection(Collection<TableTable> tableTableCollection) {
        this.tableTableCollection = tableTableCollection;
    }

    @XmlTransient
    public Collection<WaiterTable> getWaiterTableCollection() {
        return waiterTableCollection;
    }

    public void setWaiterTableCollection(Collection<WaiterTable> waiterTableCollection) {
        this.waiterTableCollection = waiterTableCollection;
    }

    @XmlTransient
    public Collection<FeedbackTable> getFeedbackTableCollection() {
        return feedbackTableCollection;
    }

    public void setFeedbackTableCollection(Collection<FeedbackTable> feedbackTableCollection) {
        this.feedbackTableCollection = feedbackTableCollection;
    }

    @XmlTransient
    public Collection<FronthouseTable> getFronthouseTableCollection() {
        return fronthouseTableCollection;
    }

    public void setFronthouseTableCollection(Collection<FronthouseTable> fronthouseTableCollection) {
        this.fronthouseTableCollection = fronthouseTableCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (restaurantId != null ? restaurantId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RestaurantTable)) {
            return false;
        }
        RestaurantTable other = (RestaurantTable) object;
        if ((this.restaurantId == null && other.restaurantId != null) || (this.restaurantId != null && !this.restaurantId.equals(other.restaurantId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityclass.RestaurantTable[ restaurantId=" + restaurantId + " ]";
    }
    
}

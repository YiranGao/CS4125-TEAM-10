/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityclass;

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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "reservation_table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReservationTable.findAll", query = "SELECT r FROM ReservationTable r")
    , @NamedQuery(name = "ReservationTable.findByReservationId", query = "SELECT r FROM ReservationTable r WHERE r.reservationId = :reservationId")
    , @NamedQuery(name = "ReservationTable.findByReservationNumofcover", query = "SELECT r FROM ReservationTable r WHERE r.reservationNumofcover = :reservationNumofcover")
    , @NamedQuery(name = "ReservationTable.findByReservationBookingdate", query = "SELECT r FROM ReservationTable r WHERE r.reservationBookingdate = :reservationBookingdate")
    , @NamedQuery(name = "ReservationTable.findByTableId", query = "SELECT r FROM ReservationTable r WHERE r.tableId = :tableId")})
public class ReservationTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "reservation_id")
    private Integer reservationId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reservation_numofcover")
    private int reservationNumofcover;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reservation_bookingdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reservationBookingdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "table_id")
    private int tableId;
    @JoinColumn(name = "customer_id", referencedColumnName = "creditcard_id")
    @ManyToOne(optional = false)
    private CustomerTable customerId;
    @JoinColumn(name = "restaurant_id", referencedColumnName = "restaurant_id")
    @ManyToOne(optional = false)
    private RestaurantTable restaurantId;

    public ReservationTable() {
    }

    public ReservationTable(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public ReservationTable(Integer reservationId, int reservationNumofcover, Date reservationBookingdate, int tableId) {
        this.reservationId = reservationId;
        this.reservationNumofcover = reservationNumofcover;
        this.reservationBookingdate = reservationBookingdate;
        this.tableId = tableId;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public int getReservationNumofcover() {
        return reservationNumofcover;
    }

    public void setReservationNumofcover(int reservationNumofcover) {
        this.reservationNumofcover = reservationNumofcover;
    }

    public Date getReservationBookingdate() {
        return reservationBookingdate;
    }

    public void setReservationBookingdate(Date reservationBookingdate) {
        this.reservationBookingdate = reservationBookingdate;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public CustomerTable getCustomerId() {
        return customerId;
    }

    public void setCustomerId(CustomerTable customerId) {
        this.customerId = customerId;
    }

    public RestaurantTable getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(RestaurantTable restaurantId) {
        this.restaurantId = restaurantId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reservationId != null ? reservationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservationTable)) {
            return false;
        }
        ReservationTable other = (ReservationTable) object;
        if ((this.reservationId == null && other.reservationId != null) || (this.reservationId != null && !this.reservationId.equals(other.reservationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityclass.ReservationTable[ reservationId=" + reservationId + " ]";
    }
    
}

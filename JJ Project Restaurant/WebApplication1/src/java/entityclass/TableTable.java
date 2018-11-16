/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityclass;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "table_table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableTable.findAll", query = "SELECT t FROM TableTable t")
    , @NamedQuery(name = "TableTable.findByTableId", query = "SELECT t FROM TableTable t WHERE t.tableId = :tableId")
    , @NamedQuery(name = "TableTable.findByTableStates", query = "SELECT t FROM TableTable t WHERE t.tableStates = :tableStates")
    , @NamedQuery(name = "TableTable.findBySeatAmount", query = "SELECT t FROM TableTable t WHERE t.seatAmount = :seatAmount")})
public class TableTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "table_id")
    private Integer tableId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "table_states")
    private int tableStates;
    @Basic(optional = false)
    @NotNull
    @Column(name = "seat_amount")
    private int seatAmount;
    @JoinColumn(name = "restaurant_id", referencedColumnName = "restaurant_id")
    @ManyToOne(optional = false)
    private RestaurantTable restaurantId;

    public TableTable() {
    }

    public TableTable(Integer tableId) {
        this.tableId = tableId;
    }

    public TableTable(Integer tableId, int tableStates, int seatAmount) {
        this.tableId = tableId;
        this.tableStates = tableStates;
        this.seatAmount = seatAmount;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public int getTableStates() {
        return tableStates;
    }

    public void setTableStates(int tableStates) {
        this.tableStates = tableStates;
    }

    public int getSeatAmount() {
        return seatAmount;
    }

    public void setSeatAmount(int seatAmount) {
        this.seatAmount = seatAmount;
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
        hash += (tableId != null ? tableId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableTable)) {
            return false;
        }
        TableTable other = (TableTable) object;
        if ((this.tableId == null && other.tableId != null) || (this.tableId != null && !this.tableId.equals(other.tableId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityclass.TableTable[ tableId=" + tableId + " ]";
    }
    
}

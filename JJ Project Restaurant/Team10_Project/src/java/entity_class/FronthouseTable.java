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
@Table(name = "fronthouse_table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FronthouseTable.findAll", query = "SELECT f FROM FronthouseTable f")
    , @NamedQuery(name = "FronthouseTable.findByFronthouseId", query = "SELECT f FROM FronthouseTable f WHERE f.fronthouseId = :fronthouseId")
    , @NamedQuery(name = "FronthouseTable.findByFronthouseName", query = "SELECT f FROM FronthouseTable f WHERE f.fronthouseName = :fronthouseName")
    , @NamedQuery(name = "FronthouseTable.findByFronthousePassword", query = "SELECT f FROM FronthouseTable f WHERE f.fronthousePassword = :fronthousePassword")
    , @NamedQuery(name = "FronthouseTable.findByUsertype", query = "SELECT f FROM FronthouseTable f WHERE f.usertype = :usertype")
    , @NamedQuery(name = "FronthouseTable.findByFeedbackMark", query = "SELECT f FROM FronthouseTable f WHERE f.feedbackMark = :feedbackMark")})
public class FronthouseTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fronthouse_id")
    private Integer fronthouseId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "fronthouse_name")
    private String fronthouseName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "fronthouse_password")
    private String fronthousePassword;
    @Basic(optional = false)
    @NotNull
    private int usertype;
    @Column(name = "feedback_mark")
    private Integer feedbackMark;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fronthouseId")
    private Collection<FeedbackTable> feedbackTableCollection;
    @JoinColumn(name = "restaurant_id", referencedColumnName = "restaurant_id")
    @ManyToOne(optional = false)
    private RestaurantTable restaurantId;

    public FronthouseTable() {
    }

    public FronthouseTable(Integer fronthouseId) {
        this.fronthouseId = fronthouseId;
    }

    public FronthouseTable(Integer fronthouseId, String fronthouseName, String fronthousePassword, int usertype) {
        this.fronthouseId = fronthouseId;
        this.fronthouseName = fronthouseName;
        this.fronthousePassword = fronthousePassword;
        this.usertype = usertype;
    }

    public Integer getFronthouseId() {
        return fronthouseId;
    }

    public void setFronthouseId(Integer fronthouseId) {
        this.fronthouseId = fronthouseId;
    }

    public String getFronthouseName() {
        return fronthouseName;
    }

    public void setFronthouseName(String fronthouseName) {
        this.fronthouseName = fronthouseName;
    }

    public String getFronthousePassword() {
        return fronthousePassword;
    }

    public void setFronthousePassword(String fronthousePassword) {
        this.fronthousePassword = fronthousePassword;
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

    @XmlTransient
    public Collection<FeedbackTable> getFeedbackTableCollection() {
        return feedbackTableCollection;
    }

    public void setFeedbackTableCollection(Collection<FeedbackTable> feedbackTableCollection) {
        this.feedbackTableCollection = feedbackTableCollection;
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
        hash += (fronthouseId != null ? fronthouseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FronthouseTable)) {
            return false;
        }
        FronthouseTable other = (FronthouseTable) object;
        if ((this.fronthouseId == null && other.fronthouseId != null) || (this.fronthouseId != null && !this.fronthouseId.equals(other.fronthouseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity_class.FronthouseTable[ fronthouseId=" + fronthouseId + " ]";
    }
    
}

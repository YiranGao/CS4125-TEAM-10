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
@Table(name = "administrator_table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdministratorTable.findAll", query = "SELECT a FROM AdministratorTable a")
    , @NamedQuery(name = "AdministratorTable.findByAdminId", query = "SELECT a FROM AdministratorTable a WHERE a.adminId = :adminId")
    , @NamedQuery(name = "AdministratorTable.findByAdminName", query = "SELECT a FROM AdministratorTable a WHERE a.adminName = :adminName")
    , @NamedQuery(name = "AdministratorTable.findByUsertype", query = "SELECT a FROM AdministratorTable a WHERE a.usertype = :usertype")
    , @NamedQuery(name = "AdministratorTable.findByAdministratorcol", query = "SELECT a FROM AdministratorTable a WHERE a.administratorcol = :administratorcol")
    , @NamedQuery(name = "AdministratorTable.findByAdminPassword", query = "SELECT a FROM AdministratorTable a WHERE a.adminPassword = :adminPassword")})
public class AdministratorTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "admin_id")
    private Integer adminId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "admin_name")
    private String adminName;
    @Basic(optional = false)
    @NotNull
    private int usertype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String administratorcol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "admin_password")
    private String adminPassword;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adminId")
    private Collection<RestaurantTable> restaurantTableCollection;

    public AdministratorTable() {
    }

    public AdministratorTable(Integer adminId) {
        this.adminId = adminId;
    }

    public AdministratorTable(Integer adminId, String adminName, int usertype, String administratorcol, String adminPassword) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.usertype = usertype;
        this.administratorcol = administratorcol;
        this.adminPassword = adminPassword;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public int getUsertype() {
        return usertype;
    }

    public void setUsertype(int usertype) {
        this.usertype = usertype;
    }

    public String getAdministratorcol() {
        return administratorcol;
    }

    public void setAdministratorcol(String administratorcol) {
        this.administratorcol = administratorcol;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    @XmlTransient
    public Collection<RestaurantTable> getRestaurantTableCollection() {
        return restaurantTableCollection;
    }

    public void setRestaurantTableCollection(Collection<RestaurantTable> restaurantTableCollection) {
        this.restaurantTableCollection = restaurantTableCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adminId != null ? adminId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdministratorTable)) {
            return false;
        }
        AdministratorTable other = (AdministratorTable) object;
        if ((this.adminId == null && other.adminId != null) || (this.adminId != null && !this.adminId.equals(other.adminId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity_class.AdministratorTable[ adminId=" + adminId + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.paypal_project.db;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author kpfho
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserID", query = "SELECT u FROM User u WHERE u.userID = :userID"),
    @NamedQuery(name = "User.findByIsSeller", query = "SELECT u FROM User u WHERE u.isSeller = :isSeller"),
    @NamedQuery(name = "User.findByName", query = "SELECT u FROM User u WHERE u.name = :name")})
public class User implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "Is_Seller")
    private boolean isSeller;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Name")
    private String name;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "User_ID")
    private String userID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Collection<Downloads> downloadsCollection;
    @OneToMany(mappedBy = "createdByID")
    private Collection<Regime> regimeCollection;
    @OneToMany(mappedBy = "createdByID")
    private Collection<Categories> categoriesCollection;

    public User() {
    }

    public User(String userID) {
        this.userID = userID;
    }

    public User(String userID, boolean isSeller, String name) {
        this.userID = userID;
        this.isSeller = isSeller;
        this.name = name;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public boolean getIsSeller() {
        return isSeller;
    }

    public void setIsSeller(boolean isSeller) {
        this.isSeller = isSeller;
    }


    @XmlTransient
    public Collection<Downloads> getDownloadsCollection() {
        return downloadsCollection;
    }

    public void setDownloadsCollection(Collection<Downloads> downloadsCollection) {
        this.downloadsCollection = downloadsCollection;
    }

    @XmlTransient
    public Collection<Regime> getRegimeCollection() {
        return regimeCollection;
    }

    public void setRegimeCollection(Collection<Regime> regimeCollection) {
        this.regimeCollection = regimeCollection;
    }

    @XmlTransient
    public Collection<Categories> getCategoriesCollection() {
        return categoriesCollection;
    }

    public void setCategoriesCollection(Collection<Categories> categoriesCollection) {
        this.categoriesCollection = categoriesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userID != null ? userID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userID == null && other.userID != null) || (this.userID != null && !this.userID.equals(other.userID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.paypal_project.db.User[ userID=" + userID + " ]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}

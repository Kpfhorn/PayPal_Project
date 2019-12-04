/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.paypal_project.db;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
 * @author kpfho
 */
@Entity
@Table(name = "profiles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profiles.findAll", query = "SELECT p FROM Profiles p"),
    @NamedQuery(name = "Profiles.findByProfileID", query = "SELECT p FROM Profiles p WHERE p.profileID = :profileID"),
    @NamedQuery(name = "Profiles.findByRegimeID", query = "SELECT p FROM Profiles p WHERE p.regimeID = :regimeID")})
public class Profiles implements Serializable {

    @Lob
    @Size(max = 65535)
    @Column(name = "Profile_Name")
    private String profileName;
    @Lob
    @Size(max = 65535)
    @Column(name = "Profile_Photo")
    private String profilePhoto;
    @Lob
    @Size(max = 65535)
    @Column(name = "Description")
    private String description;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Profile_ID")
    private Integer profileID;
    @JoinColumn(name = "Regime_ID", referencedColumnName = "Regime_ID")
    @ManyToOne
    private Regime regimeID;
    @OneToMany(mappedBy = "profileID")
    private Collection<Profilecategories> profilecategoriesCollection;

    public Profiles() {
    }

    public Profiles(Integer profileID) {
        this.profileID = profileID;
    }

    public Integer getProfileID() {
        return profileID;
    }

    public void setProfileID(Integer profileID) {
        this.profileID = profileID;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    @JsonbTransient
    public Regime getRegimeID() {
        return regimeID;
    }

    public void setRegimeID(Regime regimeID) {
        this.regimeID = regimeID;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Profilecategories> getProfilecategoriesCollection() {
        return profilecategoriesCollection;
    }

    public void setProfilecategoriesCollection(Collection<Profilecategories> profilecategoriesCollection) {
        this.profilecategoriesCollection = profilecategoriesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (profileID != null ? profileID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profiles)) {
            return false;
        }
        Profiles other = (Profiles) object;
        if ((this.profileID == null && other.profileID != null) || (this.profileID != null && !this.profileID.equals(other.profileID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.paypal_project.db.Profiles[ profileID=" + profileID + " ]";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}

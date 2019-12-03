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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kpfho
 */
@Entity
@Table(name = "profilecategories")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profilecategories.findAll", query = "SELECT p FROM Profilecategories p"),
    @NamedQuery(name = "Profilecategories.findByProfileCategoryID", query = "SELECT p FROM Profilecategories p WHERE p.profileCategoryID = :profileCategoryID"),
    @NamedQuery(name = "Profilecategories.findByWeightImportance", query = "SELECT p FROM Profilecategories p WHERE p.weightImportance = :weightImportance"),
    @NamedQuery(name = "Profilecategories.findByRankUrgency", query = "SELECT p FROM Profilecategories p WHERE p.rankUrgency = :rankUrgency"),
    @NamedQuery(name = "Profilecategories.findByProfileID", query = "SELECT p FROM Profilecategories p WHERE p.profileID = :profileID")})
public class Profilecategories implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ProfileCategory_ID")
    private Integer profileCategoryID;
    @Column(name = "Weight_Importance")
    private Integer weightImportance;
    @Column(name = "Rank_Urgency")
    private Integer rankUrgency;
    @OneToMany(mappedBy = "profileCategoryID")
    private Collection<Profilecategorygoals> profilecategorygoalsCollection;
    @JoinColumn(name = "Category_ID", referencedColumnName = "Category_ID")
    @ManyToOne
    private Categories categoryID;
    @JoinColumn(name = "Profile_ID", referencedColumnName = "Profile_ID")
    @ManyToOne
    private Profiles profileID;

    public Profilecategories() {
    }

    public Profilecategories(Integer profileCategoryID) {
        this.profileCategoryID = profileCategoryID;
    }

    public Integer getProfileCategoryID() {
        return profileCategoryID;
    }

    public void setProfileCategoryID(Integer profileCategoryID) {
        this.profileCategoryID = profileCategoryID;
    }

    public Integer getWeightImportance() {
        return weightImportance;
    }

    public void setWeightImportance(Integer weightImportance) {
        this.weightImportance = weightImportance;
    }

    public Integer getRankUrgency() {
        return rankUrgency;
    }

    public void setRankUrgency(Integer rankUrgency) {
        this.rankUrgency = rankUrgency;
    }

    @XmlTransient
    public Collection<Profilecategorygoals> getProfilecategorygoalsCollection() {
        return profilecategorygoalsCollection;
    }

    public void setProfilecategorygoalsCollection(Collection<Profilecategorygoals> profilecategorygoalsCollection) {
        this.profilecategorygoalsCollection = profilecategorygoalsCollection;
    }
    

    public Categories getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Categories categoryID) {
        this.categoryID = categoryID;
    }
    
    @JsonbTransient
    public Profiles getProfileID() {
        return profileID;
    }

    public void setProfileID(Profiles profileID) {
        this.profileID = profileID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (profileCategoryID != null ? profileCategoryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profilecategories)) {
            return false;
        }
        Profilecategories other = (Profilecategories) object;
        if ((this.profileCategoryID == null && other.profileCategoryID != null) || (this.profileCategoryID != null && !this.profileCategoryID.equals(other.profileCategoryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.paypal_project.db.Profilecategories[ profileCategoryID=" + profileCategoryID + " ]";
    }
    
}

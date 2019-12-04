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
import javax.persistence.CascadeType;
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
@Table(name = "profilecategorygoals")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profilecategorygoals.findAll", query = "SELECT p FROM Profilecategorygoals p"),
    @NamedQuery(name = "Profilecategorygoals.findByProfileCategoryGoalID", query = "SELECT p FROM Profilecategorygoals p WHERE p.profileCategoryGoalID = :profileCategoryGoalID"),
    @NamedQuery(name = "Profilecategorygoals.findByProfileCategoryID", query = "SELECT p FROM Profilecategorygoals p WHERE p.profileCategoryID = :profileCategoryID")})
public class Profilecategorygoals implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ProfileCategoryGoal_ID")
    private Integer profileCategoryGoalID;
    @OneToMany(mappedBy = "profileCategoryGoalID")
    private Collection<Roadmaps> roadmapsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profilecategorygoals")
    private Collection<Profilecategorygoaloutcomes> profilecategorygoaloutcomesCollection;
    @JoinColumn(name = "Goal_ID", referencedColumnName = "Goal_ID")
    @ManyToOne
    private Goals goalID;
    @JoinColumn(name = "ProfileCategory_ID", referencedColumnName = "ProfileCategory_ID")
    @ManyToOne
    private Profilecategories profileCategoryID;

    public Profilecategorygoals() {
    }

    public Profilecategorygoals(Integer profileCategoryGoalID) {
        this.profileCategoryGoalID = profileCategoryGoalID;
    }

    public Integer getProfileCategoryGoalID() {
        return profileCategoryGoalID;
    }

    public void setProfileCategoryGoalID(Integer profileCategoryGoalID) {
        this.profileCategoryGoalID = profileCategoryGoalID;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Roadmaps> getRoadmapsCollection() {
        return roadmapsCollection;
    }

    public void setRoadmapsCollection(Collection<Roadmaps> roadmapsCollection) {
        this.roadmapsCollection = roadmapsCollection;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Profilecategorygoaloutcomes> getProfilecategorygoaloutcomesCollection() {
        return profilecategorygoaloutcomesCollection;
    }

    public void setProfilecategorygoaloutcomesCollection(Collection<Profilecategorygoaloutcomes> profilecategorygoaloutcomesCollection) {
        this.profilecategorygoaloutcomesCollection = profilecategorygoaloutcomesCollection;
    }

    public Goals getGoalID() {
        return goalID;
    }

    public void setGoalID(Goals goalID) {
        this.goalID = goalID;
    }

    public Profilecategories getProfileCategoryID() {
        return profileCategoryID;
    }

    public void setProfileCategoryID(Profilecategories profileCategoryID) {
        this.profileCategoryID = profileCategoryID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (profileCategoryGoalID != null ? profileCategoryGoalID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profilecategorygoals)) {
            return false;
        }
        Profilecategorygoals other = (Profilecategorygoals) object;
        if ((this.profileCategoryGoalID == null && other.profileCategoryGoalID != null) || (this.profileCategoryGoalID != null && !this.profileCategoryGoalID.equals(other.profileCategoryGoalID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.paypal_project.db.Profilecategorygoals[ profileCategoryGoalID=" + profileCategoryGoalID + " ]";
    }
    
}

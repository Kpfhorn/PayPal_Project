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
@Table(name = "roadmaps")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roadmaps.findAll", query = "SELECT r FROM Roadmaps r"),
    @NamedQuery(name = "Roadmaps.findByRoadMapID", query = "SELECT r FROM Roadmaps r WHERE r.roadMapID = :roadMapID")})
public class Roadmaps implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RoadMap_ID")
    private Integer roadMapID;
    @JoinColumn(name = "ProfileCategoryGoal_ID", referencedColumnName = "ProfileCategoryGoal_ID")
    @ManyToOne
    private Profilecategorygoals profileCategoryGoalID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roadmaps")
    private Collection<Roadmapactivities> roadmapactivitiesCollection;

    public Roadmaps() {
    }

    public Roadmaps(Integer roadMapID) {
        this.roadMapID = roadMapID;
    }

    public Integer getRoadMapID() {
        return roadMapID;
    }

    public void setRoadMapID(Integer roadMapID) {
        this.roadMapID = roadMapID;
    }

    public Profilecategorygoals getProfileCategoryGoalID() {
        return profileCategoryGoalID;
    }

    public void setProfileCategoryGoalID(Profilecategorygoals profileCategoryGoalID) {
        this.profileCategoryGoalID = profileCategoryGoalID;
    }

    @XmlTransient
    public Collection<Roadmapactivities> getRoadmapactivitiesCollection() {
        return roadmapactivitiesCollection;
    }

    public void setRoadmapactivitiesCollection(Collection<Roadmapactivities> roadmapactivitiesCollection) {
        this.roadmapactivitiesCollection = roadmapactivitiesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roadMapID != null ? roadMapID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roadmaps)) {
            return false;
        }
        Roadmaps other = (Roadmaps) object;
        if ((this.roadMapID == null && other.roadMapID != null) || (this.roadMapID != null && !this.roadMapID.equals(other.roadMapID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.paypal_project.db.Roadmaps[ roadMapID=" + roadMapID + " ]";
    }
    
}

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
import javax.persistence.Lob;
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
@Table(name = "activities")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Activities.findAll", query = "SELECT a FROM Activities a"),
    @NamedQuery(name = "Activities.findByActivityID", query = "SELECT a FROM Activities a WHERE a.activityID = :activityID")})
public class Activities implements Serializable {

    @Lob
    @Size(max = 65535)
    @Column(name = "Activity_Name")
    private String activityName;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Activity_ID")
    private Integer activityID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activities")
    private Collection<Roadmapactivities> roadmapactivitiesCollection;

    public Activities() {
    }

    public Activities(Integer activityID) {
        this.activityID = activityID;
    }

    public Integer getActivityID() {
        return activityID;
    }

    public void setActivityID(Integer activityID) {
        this.activityID = activityID;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
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
        hash += (activityID != null ? activityID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Activities)) {
            return false;
        }
        Activities other = (Activities) object;
        if ((this.activityID == null && other.activityID != null) || (this.activityID != null && !this.activityID.equals(other.activityID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.paypal_project.db.Activities[ activityID=" + activityID + " ]";
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.paypal_project.db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author kpfho
 */
@Embeddable
public class RoadmapactivitiesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "RoadMap_ID")
    private int roadMapID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Activity_ID")
    private int activityID;

    public RoadmapactivitiesPK() {
    }

    public RoadmapactivitiesPK(int roadMapID, int activityID) {
        this.roadMapID = roadMapID;
        this.activityID = activityID;
    }

    public int getRoadMapID() {
        return roadMapID;
    }

    public void setRoadMapID(int roadMapID) {
        this.roadMapID = roadMapID;
    }

    public int getActivityID() {
        return activityID;
    }

    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) roadMapID;
        hash += (int) activityID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoadmapactivitiesPK)) {
            return false;
        }
        RoadmapactivitiesPK other = (RoadmapactivitiesPK) object;
        if (this.roadMapID != other.roadMapID) {
            return false;
        }
        if (this.activityID != other.activityID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.paypal_project.db.RoadmapactivitiesPK[ roadMapID=" + roadMapID + ", activityID=" + activityID + " ]";
    }
    
}

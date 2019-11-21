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
public class ProfilecategorygoaloutcomesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ProfileCategoryGoal_ID")
    private int profileCategoryGoalID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Measure_ID")
    private int measureID;

    public ProfilecategorygoaloutcomesPK() {
    }

    public ProfilecategorygoaloutcomesPK(int profileCategoryGoalID, int measureID) {
        this.profileCategoryGoalID = profileCategoryGoalID;
        this.measureID = measureID;
    }

    public int getProfileCategoryGoalID() {
        return profileCategoryGoalID;
    }

    public void setProfileCategoryGoalID(int profileCategoryGoalID) {
        this.profileCategoryGoalID = profileCategoryGoalID;
    }

    public int getMeasureID() {
        return measureID;
    }

    public void setMeasureID(int measureID) {
        this.measureID = measureID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) profileCategoryGoalID;
        hash += (int) measureID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProfilecategorygoaloutcomesPK)) {
            return false;
        }
        ProfilecategorygoaloutcomesPK other = (ProfilecategorygoaloutcomesPK) object;
        if (this.profileCategoryGoalID != other.profileCategoryGoalID) {
            return false;
        }
        if (this.measureID != other.measureID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.paypal_project.db.ProfilecategorygoaloutcomesPK[ profileCategoryGoalID=" + profileCategoryGoalID + ", measureID=" + measureID + " ]";
    }
    
}

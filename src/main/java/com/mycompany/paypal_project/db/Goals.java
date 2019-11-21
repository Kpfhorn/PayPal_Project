/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.paypal_project.db;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "goals")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Goals.findAll", query = "SELECT g FROM Goals g"),
    @NamedQuery(name = "Goals.findByGoalID", query = "SELECT g FROM Goals g WHERE g.goalID = :goalID")})
public class Goals implements Serializable {

    @Lob
    @Size(max = 65535)
    @Column(name = "Goal_Name")
    private String goalName;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Goal_ID")
    private Integer goalID;
    @OneToMany(mappedBy = "goalID")
    private Collection<Profilecategorygoals> profilecategorygoalsCollection;

    public Goals() {
    }

    public Goals(Integer goalID) {
        this.goalID = goalID;
    }

    public Integer getGoalID() {
        return goalID;
    }

    public void setGoalID(Integer goalID) {
        this.goalID = goalID;
    }

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    @XmlTransient
    public Collection<Profilecategorygoals> getProfilecategorygoalsCollection() {
        return profilecategorygoalsCollection;
    }

    public void setProfilecategorygoalsCollection(Collection<Profilecategorygoals> profilecategorygoalsCollection) {
        this.profilecategorygoalsCollection = profilecategorygoalsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (goalID != null ? goalID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Goals)) {
            return false;
        }
        Goals other = (Goals) object;
        if ((this.goalID == null && other.goalID != null) || (this.goalID != null && !this.goalID.equals(other.goalID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.paypal_project.db.Goals[ goalID=" + goalID + " ]";
    }

}

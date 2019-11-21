/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.paypal_project.db;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kpfho
 */
@Entity
@Table(name = "profilecategorygoaloutcomes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profilecategorygoaloutcomes.findAll", query = "SELECT p FROM Profilecategorygoaloutcomes p"),
    @NamedQuery(name = "Profilecategorygoaloutcomes.findByProfileCategoryGoalID", query = "SELECT p FROM Profilecategorygoaloutcomes p WHERE p.profilecategorygoaloutcomesPK.profileCategoryGoalID = :profileCategoryGoalID"),
    @NamedQuery(name = "Profilecategorygoaloutcomes.findByMeasureID", query = "SELECT p FROM Profilecategorygoaloutcomes p WHERE p.profilecategorygoaloutcomesPK.measureID = :measureID"),
    @NamedQuery(name = "Profilecategorygoaloutcomes.findByNumericValue", query = "SELECT p FROM Profilecategorygoaloutcomes p WHERE p.numericValue = :numericValue"),
    @NamedQuery(name = "Profilecategorygoaloutcomes.findByExpectedDaysToComplete", query = "SELECT p FROM Profilecategorygoaloutcomes p WHERE p.expectedDaysToComplete = :expectedDaysToComplete"),
    @NamedQuery(name = "Profilecategorygoaloutcomes.findByGoalAchievementPercentage", query = "SELECT p FROM Profilecategorygoaloutcomes p WHERE p.goalAchievementPercentage = :goalAchievementPercentage")})
public class Profilecategorygoaloutcomes implements Serializable {

    @Lob
    @Size(max = 65535)
    @Column(name = "Operator")
    private String operator;
    @Lob
    @Size(max = 65535)
    @Column(name = "UnitOfMeasurement")
    private String unitOfMeasurement;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProfilecategorygoaloutcomesPK profilecategorygoaloutcomesPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "NumericValue")
    private Float numericValue;
    @Column(name = "ExpectedDaysToComplete")
    private Integer expectedDaysToComplete;
    @Column(name = "GoalAchievementPercentage")
    private Integer goalAchievementPercentage;
    @JoinColumn(name = "Measure_ID", referencedColumnName = "Measure_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Measures measures;
    @JoinColumn(name = "ProfileCategoryGoal_ID", referencedColumnName = "ProfileCategoryGoal_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Profilecategorygoals profilecategorygoals;

    public Profilecategorygoaloutcomes() {
    }

    public Profilecategorygoaloutcomes(ProfilecategorygoaloutcomesPK profilecategorygoaloutcomesPK) {
        this.profilecategorygoaloutcomesPK = profilecategorygoaloutcomesPK;
    }

    public Profilecategorygoaloutcomes(int profileCategoryGoalID, int measureID) {
        this.profilecategorygoaloutcomesPK = new ProfilecategorygoaloutcomesPK(profileCategoryGoalID, measureID);
    }

    public ProfilecategorygoaloutcomesPK getProfilecategorygoaloutcomesPK() {
        return profilecategorygoaloutcomesPK;
    }

    public void setProfilecategorygoaloutcomesPK(ProfilecategorygoaloutcomesPK profilecategorygoaloutcomesPK) {
        this.profilecategorygoaloutcomesPK = profilecategorygoaloutcomesPK;
    }


    public Float getNumericValue() {
        return numericValue;
    }

    public void setNumericValue(Float numericValue) {
        this.numericValue = numericValue;
    }


    public Integer getExpectedDaysToComplete() {
        return expectedDaysToComplete;
    }

    public void setExpectedDaysToComplete(Integer expectedDaysToComplete) {
        this.expectedDaysToComplete = expectedDaysToComplete;
    }

    public Integer getGoalAchievementPercentage() {
        return goalAchievementPercentage;
    }

    public void setGoalAchievementPercentage(Integer goalAchievementPercentage) {
        this.goalAchievementPercentage = goalAchievementPercentage;
    }

    public Measures getMeasures() {
        return measures;
    }

    public void setMeasures(Measures measures) {
        this.measures = measures;
    }

    public Profilecategorygoals getProfilecategorygoals() {
        return profilecategorygoals;
    }

    public void setProfilecategorygoals(Profilecategorygoals profilecategorygoals) {
        this.profilecategorygoals = profilecategorygoals;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (profilecategorygoaloutcomesPK != null ? profilecategorygoaloutcomesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profilecategorygoaloutcomes)) {
            return false;
        }
        Profilecategorygoaloutcomes other = (Profilecategorygoaloutcomes) object;
        if ((this.profilecategorygoaloutcomesPK == null && other.profilecategorygoaloutcomesPK != null) || (this.profilecategorygoaloutcomesPK != null && !this.profilecategorygoaloutcomesPK.equals(other.profilecategorygoaloutcomesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.paypal_project.db.Profilecategorygoaloutcomes[ profilecategorygoaloutcomesPK=" + profilecategorygoaloutcomesPK + " ]";
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }
    
}

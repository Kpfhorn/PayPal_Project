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
@Table(name = "roadmapactivities")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roadmapactivities.findAll", query = "SELECT r FROM Roadmapactivities r"),
    @NamedQuery(name = "Roadmapactivities.findByRoadMapID", query = "SELECT r FROM Roadmapactivities r WHERE r.roadmapactivitiesPK.roadMapID = :roadMapID"),
    @NamedQuery(name = "Roadmapactivities.findByActivityID", query = "SELECT r FROM Roadmapactivities r WHERE r.roadmapactivitiesPK.activityID = :activityID"),
    @NamedQuery(name = "Roadmapactivities.findByStartAfterDays", query = "SELECT r FROM Roadmapactivities r WHERE r.startAfterDays = :startAfterDays"),
    @NamedQuery(name = "Roadmapactivities.findByActivityDuration", query = "SELECT r FROM Roadmapactivities r WHERE r.activityDuration = :activityDuration"),
    @NamedQuery(name = "Roadmapactivities.findByRecurrenceFrequency", query = "SELECT r FROM Roadmapactivities r WHERE r.recurrenceFrequency = :recurrenceFrequency"),
    @NamedQuery(name = "Roadmapactivities.findByEndAfterDays", query = "SELECT r FROM Roadmapactivities r WHERE r.endAfterDays = :endAfterDays"),
    @NamedQuery(name = "Roadmapactivities.findByDateOfMonth", query = "SELECT r FROM Roadmapactivities r WHERE r.dateOfMonth = :dateOfMonth")})
public class Roadmapactivities implements Serializable {

    @Lob
    @Size(max = 65535)
    @Column(name = "DayOfWeek")
    private String dayOfWeek;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RoadmapactivitiesPK roadmapactivitiesPK;
    @Column(name = "StartAfter_Days")
    private Integer startAfterDays;
    @Column(name = "ActivityDuration")
    private Integer activityDuration;
    @Column(name = "RecurrenceFrequency")
    private Integer recurrenceFrequency;
    @Column(name = "EndAfter_Days")
    private Integer endAfterDays;
    @Column(name = "DateOfMonth")
    private Integer dateOfMonth;
    @JoinColumn(name = "Activity_ID", referencedColumnName = "Activity_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Activities activities;
    @JoinColumn(name = "RoadMap_ID", referencedColumnName = "RoadMap_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Roadmaps roadmaps;

    public Roadmapactivities() {
    }

    public Roadmapactivities(RoadmapactivitiesPK roadmapactivitiesPK) {
        this.roadmapactivitiesPK = roadmapactivitiesPK;
    }

    public Roadmapactivities(int roadMapID, int activityID) {
        this.roadmapactivitiesPK = new RoadmapactivitiesPK(roadMapID, activityID);
    }

    public RoadmapactivitiesPK getRoadmapactivitiesPK() {
        return roadmapactivitiesPK;
    }

    public void setRoadmapactivitiesPK(RoadmapactivitiesPK roadmapactivitiesPK) {
        this.roadmapactivitiesPK = roadmapactivitiesPK;
    }

    public Integer getStartAfterDays() {
        return startAfterDays;
    }

    public void setStartAfterDays(Integer startAfterDays) {
        this.startAfterDays = startAfterDays;
    }

    public Integer getActivityDuration() {
        return activityDuration;
    }

    public void setActivityDuration(Integer activityDuration) {
        this.activityDuration = activityDuration;
    }

    public Integer getRecurrenceFrequency() {
        return recurrenceFrequency;
    }

    public void setRecurrenceFrequency(Integer recurrenceFrequency) {
        this.recurrenceFrequency = recurrenceFrequency;
    }

    public Integer getEndAfterDays() {
        return endAfterDays;
    }

    public void setEndAfterDays(Integer endAfterDays) {
        this.endAfterDays = endAfterDays;
    }


    public Integer getDateOfMonth() {
        return dateOfMonth;
    }

    public void setDateOfMonth(Integer dateOfMonth) {
        this.dateOfMonth = dateOfMonth;
    }

    public Activities getActivities() {
        return activities;
    }

    public void setActivities(Activities activities) {
        this.activities = activities;
    }

    public Roadmaps getRoadmaps() {
        return roadmaps;
    }

    public void setRoadmaps(Roadmaps roadmaps) {
        this.roadmaps = roadmaps;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roadmapactivitiesPK != null ? roadmapactivitiesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roadmapactivities)) {
            return false;
        }
        Roadmapactivities other = (Roadmapactivities) object;
        if ((this.roadmapactivitiesPK == null && other.roadmapactivitiesPK != null) || (this.roadmapactivitiesPK != null && !this.roadmapactivitiesPK.equals(other.roadmapactivitiesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.paypal_project.db.Roadmapactivities[ roadmapactivitiesPK=" + roadmapactivitiesPK + " ]";
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
    
}

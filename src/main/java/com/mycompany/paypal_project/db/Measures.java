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
@Table(name = "measures")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Measures.findAll", query = "SELECT m FROM Measures m"),
    @NamedQuery(name = "Measures.findByMeasureID", query = "SELECT m FROM Measures m WHERE m.measureID = :measureID")})
public class Measures implements Serializable {

    @Lob
    @Size(max = 65535)
    @Column(name = "Measure_Name")
    private String measureName;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Measure_ID")
    private Integer measureID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "measures")
    private Collection<Profilecategorygoaloutcomes> profilecategorygoaloutcomesCollection;

    public Measures() {
    }

    public Measures(Integer measureID) {
        this.measureID = measureID;
    }

    public Integer getMeasureID() {
        return measureID;
    }

    public void setMeasureID(Integer measureID) {
        this.measureID = measureID;
    }

    public String getMeasureName() {
        return measureName;
    }

    public void setMeasureName(String measureName) {
        this.measureName = measureName;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Profilecategorygoaloutcomes> getProfilecategorygoaloutcomesCollection() {
        return profilecategorygoaloutcomesCollection;
    }

    public void setProfilecategorygoaloutcomesCollection(Collection<Profilecategorygoaloutcomes> profilecategorygoaloutcomesCollection) {
        this.profilecategorygoaloutcomesCollection = profilecategorygoaloutcomesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (measureID != null ? measureID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Measures)) {
            return false;
        }
        Measures other = (Measures) object;
        if ((this.measureID == null && other.measureID != null) || (this.measureID != null && !this.measureID.equals(other.measureID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.paypal_project.db.Measures[ measureID=" + measureID + " ]";
    }

}

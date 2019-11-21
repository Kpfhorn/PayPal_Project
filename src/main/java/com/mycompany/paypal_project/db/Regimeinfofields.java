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
@Table(name = "regimeinfofields")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Regimeinfofields.findAll", query = "SELECT r FROM Regimeinfofields r"),
    @NamedQuery(name = "Regimeinfofields.findByRegimeInfoFieldID", query = "SELECT r FROM Regimeinfofields r WHERE r.regimeInfoFieldID = :regimeInfoFieldID"),
    @NamedQuery(name = "Regimeinfofields.findByInfoField", query = "SELECT r FROM Regimeinfofields r WHERE r.infoField = :infoField")})
public class Regimeinfofields implements Serializable {

    @Size(max = 7)
    @Column(name = "InfoField")
    private String infoField;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RegimeInfoField_ID")
    private Integer regimeInfoFieldID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "regimeinfofields")
    private Collection<Regimedetails> regimedetailsCollection;

    public Regimeinfofields() {
    }

    public Regimeinfofields(Integer regimeInfoFieldID) {
        this.regimeInfoFieldID = regimeInfoFieldID;
    }

    public Integer getRegimeInfoFieldID() {
        return regimeInfoFieldID;
    }

    public void setRegimeInfoFieldID(Integer regimeInfoFieldID) {
        this.regimeInfoFieldID = regimeInfoFieldID;
    }


    @XmlTransient
    public Collection<Regimedetails> getRegimedetailsCollection() {
        return regimedetailsCollection;
    }

    public void setRegimedetailsCollection(Collection<Regimedetails> regimedetailsCollection) {
        this.regimedetailsCollection = regimedetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (regimeInfoFieldID != null ? regimeInfoFieldID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Regimeinfofields)) {
            return false;
        }
        Regimeinfofields other = (Regimeinfofields) object;
        if ((this.regimeInfoFieldID == null && other.regimeInfoFieldID != null) || (this.regimeInfoFieldID != null && !this.regimeInfoFieldID.equals(other.regimeInfoFieldID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.paypal_project.db.Regimeinfofields[ regimeInfoFieldID=" + regimeInfoFieldID + " ]";
    }

    public String getInfoField() {
        return infoField;
    }

    public void setInfoField(String infoField) {
        this.infoField = infoField;
    }
    
}

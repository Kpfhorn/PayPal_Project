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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kpfho
 */
@Entity
@Table(name = "regime")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Regime.findAll", query = "SELECT r FROM Regime r"),
    @NamedQuery(name = "Regime.findByRegimeID", query = "SELECT r FROM Regime r WHERE r.regimeID = :regimeID"),
    @NamedQuery(name = "Regime.findByRegimeName", query = "SELECT r FROM Regime r WHERE r.regimeName = :regimeName"),
    @NamedQuery(name = "Regime.findByRegimeTYPE", query = "SELECT r FROM Regime r WHERE r.regimeTYPE = :regimeTYPE"),
    @NamedQuery(name = "Regime.findByPublishStatus", query = "SELECT r FROM Regime r WHERE r.publishStatus = :publishStatus"),
    @NamedQuery(name = "Regime.findByDownloadCount", query = "SELECT r FROM Regime r WHERE r.downloadCount = :downloadCount")})
public class Regime implements Serializable {

    @Size(max = 100)
    @Column(name = "Regime_Name")
    private String regimeName;
    @Size(max = 30)
    @Column(name = "Regime_TYPE")
    private String regimeTYPE;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Regime_ID")
    private Integer regimeID;
    @Column(name = "PublishStatus")
    private Boolean publishStatus;
    @Column(name = "DownloadCount")
    private Integer downloadCount;
    @JoinColumn(name = "CreatedBy_ID", referencedColumnName = "User_ID")
    @ManyToOne
    private User createdByID;
    @OneToMany(mappedBy = "regimeID")
    private Collection<Profiles> profilesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "regime")
    private Collection<Regimedetails> regimedetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "regime")
    private Collection<Downloads> downloadsCollection;

    public Regime() {
    }

    public Regime(Integer regimeID) {
        this.regimeID = regimeID;
    }

    public Integer getRegimeID() {
        return regimeID;
    }

    public void setRegimeID(Integer regimeID) {
        this.regimeID = regimeID;
    }

    public String getRegimeName() {
        return regimeName;
    }

    public void setRegimeName(String regimeName) {
        this.regimeName = regimeName;
    }

    public String getRegimeTYPE() {
        return regimeTYPE;
    }

    public void setRegimeTYPE(String regimeTYPE) {
        this.regimeTYPE = regimeTYPE;
    }

    public Boolean getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(Boolean publishStatus) {
        this.publishStatus = publishStatus;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    public User getCreatedByID() {
        return createdByID;
    }

    public void setCreatedByID(User createdByID) {
        this.createdByID = createdByID;
    }

    @XmlTransient
    public Collection<Profiles> getProfilesCollection() {
        return profilesCollection;
    }

    public void setProfilesCollection(Collection<Profiles> profilesCollection) {
        this.profilesCollection = profilesCollection;
    }

    @XmlTransient
    public Collection<Regimedetails> getRegimedetailsCollection() {
        return regimedetailsCollection;
    }

    public void setRegimedetailsCollection(Collection<Regimedetails> regimedetailsCollection) {
        this.regimedetailsCollection = regimedetailsCollection;
    }

    @XmlTransient
    public Collection<Downloads> getDownloadsCollection() {
        return downloadsCollection;
    }

    public void setDownloadsCollection(Collection<Downloads> downloadsCollection) {
        this.downloadsCollection = downloadsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (regimeID != null ? regimeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Regime)) {
            return false;
        }
        Regime other = (Regime) object;
        if ((this.regimeID == null && other.regimeID != null) || (this.regimeID != null && !this.regimeID.equals(other.regimeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.paypal_project.db.Regime[ regimeID=" + regimeID + " ]";
    }

}

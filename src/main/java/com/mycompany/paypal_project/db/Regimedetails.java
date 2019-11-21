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
@Table(name = "regimedetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Regimedetails.findAll", query = "SELECT r FROM Regimedetails r"),
    @NamedQuery(name = "Regimedetails.findByRegimeID", query = "SELECT r FROM Regimedetails r WHERE r.regimedetailsPK.regimeID = :regimeID"),
    @NamedQuery(name = "Regimedetails.findByRegimeInfoFieldID", query = "SELECT r FROM Regimedetails r WHERE r.regimedetailsPK.regimeInfoFieldID = :regimeInfoFieldID")})
public class Regimedetails implements Serializable {

    @Lob
    @Size(max = 65535)
    @Column(name = "FieldValue")
    private String fieldValue;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RegimedetailsPK regimedetailsPK;
    @JoinColumn(name = "Regime_ID", referencedColumnName = "Regime_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Regime regime;
    @JoinColumn(name = "RegimeInfoField_ID", referencedColumnName = "RegimeInfoField_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Regimeinfofields regimeinfofields;

    public Regimedetails() {
    }

    public Regimedetails(RegimedetailsPK regimedetailsPK) {
        this.regimedetailsPK = regimedetailsPK;
    }

    public Regimedetails(int regimeID, int regimeInfoFieldID) {
        this.regimedetailsPK = new RegimedetailsPK(regimeID, regimeInfoFieldID);
    }

    public RegimedetailsPK getRegimedetailsPK() {
        return regimedetailsPK;
    }

    public void setRegimedetailsPK(RegimedetailsPK regimedetailsPK) {
        this.regimedetailsPK = regimedetailsPK;
    }


    public Regime getRegime() {
        return regime;
    }

    public void setRegime(Regime regime) {
        this.regime = regime;
    }

    public Regimeinfofields getRegimeinfofields() {
        return regimeinfofields;
    }

    public void setRegimeinfofields(Regimeinfofields regimeinfofields) {
        this.regimeinfofields = regimeinfofields;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (regimedetailsPK != null ? regimedetailsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Regimedetails)) {
            return false;
        }
        Regimedetails other = (Regimedetails) object;
        if ((this.regimedetailsPK == null && other.regimedetailsPK != null) || (this.regimedetailsPK != null && !this.regimedetailsPK.equals(other.regimedetailsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.paypal_project.db.Regimedetails[ regimedetailsPK=" + regimedetailsPK + " ]";
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }
    
}

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
public class RegimedetailsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "Regime_ID")
    private int regimeID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RegimeInfoField_ID")
    private int regimeInfoFieldID;

    public RegimedetailsPK() {
    }

    public RegimedetailsPK(int regimeID, int regimeInfoFieldID) {
        this.regimeID = regimeID;
        this.regimeInfoFieldID = regimeInfoFieldID;
    }

    public int getRegimeID() {
        return regimeID;
    }

    public void setRegimeID(int regimeID) {
        this.regimeID = regimeID;
    }

    public int getRegimeInfoFieldID() {
        return regimeInfoFieldID;
    }

    public void setRegimeInfoFieldID(int regimeInfoFieldID) {
        this.regimeInfoFieldID = regimeInfoFieldID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) regimeID;
        hash += (int) regimeInfoFieldID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegimedetailsPK)) {
            return false;
        }
        RegimedetailsPK other = (RegimedetailsPK) object;
        if (this.regimeID != other.regimeID) {
            return false;
        }
        if (this.regimeInfoFieldID != other.regimeInfoFieldID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.paypal_project.db.RegimedetailsPK[ regimeID=" + regimeID + ", regimeInfoFieldID=" + regimeInfoFieldID + " ]";
    }
    
}

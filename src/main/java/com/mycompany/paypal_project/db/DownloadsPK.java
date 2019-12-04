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
import javax.validation.constraints.Size;

/**
 *
 * @author kpfho
 */
@Embeddable
public class DownloadsPK implements Serializable{

    @Basic(optional = false)
    @NotNull
    @Column(name = "Regime_ID")
    private int regimeID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "BuyerUser_ID")
    private String buyerUserID;

    public DownloadsPK() {
    }

    public DownloadsPK(int regimeID, String buyerUserID) {
        this.regimeID = regimeID;
        this.buyerUserID = buyerUserID;
    }

    public int getRegimeID() {
        return regimeID;
    }

    public void setRegimeID(int regimeID) {
        this.regimeID = regimeID;
    }

    public String getBuyerUserID() {
        return buyerUserID;
    }

    public void setBuyerUserID(String buyerUserID) {
        this.buyerUserID = buyerUserID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) regimeID;
        hash += (buyerUserID != null ? buyerUserID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DownloadsPK)) {
            return false;
        }
        DownloadsPK other = (DownloadsPK) object;
        if (this.regimeID != other.regimeID) {
            return false;
        }
        if ((this.buyerUserID == null && other.buyerUserID != null) || (this.buyerUserID != null && !this.buyerUserID.equals(other.buyerUserID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.paypal_project.db.DownloadsPK[ regimeID=" + regimeID + ", buyerUserID=" + buyerUserID + " ]";
    }

}

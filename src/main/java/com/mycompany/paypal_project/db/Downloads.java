/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.paypal_project.db;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kpfho
 */
@Entity
@Table(name = "downloads")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Downloads.findAll", query = "SELECT d FROM Downloads d"),
    @NamedQuery(name = "Downloads.findByRegimeID", query = "SELECT d FROM Downloads d WHERE d.downloadsPK.regimeID = :regimeID"),
    @NamedQuery(name = "Downloads.findByBuyerUserID", query = "SELECT d FROM Downloads d WHERE d.downloadsPK.buyerUserID = :buyerUserID"),
    @NamedQuery(name = "Downloads.findByBoughtOnDate", query = "SELECT d FROM Downloads d WHERE d.boughtOnDate = :boughtOnDate"),
    @NamedQuery(name = "Downloads.findByUserRating", query = "SELECT d FROM Downloads d WHERE d.userRating = :userRating")})
public class Downloads implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DownloadsPK downloadsPK;
    @Column(name = "BoughtOnDate")
    @Temporal(TemporalType.DATE)
    private Date boughtOnDate;
    @Column(name = "UserRating")
    private Integer userRating;
    @Lob
    @Size(max = 65535)
    @Column(name = "UserComment")
    private String userComment;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "Order_ID")
    private String orderID;
    @JoinColumn(name = "Regime_ID", referencedColumnName = "Regime_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Regime regime;
    @JoinColumn(name = "BuyerUser_ID", referencedColumnName = "User_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public Downloads() {
    }

    public Downloads(DownloadsPK downloadsPK) {
        this.downloadsPK = downloadsPK;
    }

    public Downloads(DownloadsPK downloadsPK, String orderID) {
        this.downloadsPK = downloadsPK;
        this.orderID = orderID;
    }

    public Downloads(int regimeID, String buyerUserID) {
        this.downloadsPK = new DownloadsPK(regimeID, buyerUserID);
    }

    public DownloadsPK getDownloadsPK() {
        return downloadsPK;
    }

    public void setDownloadsPK(DownloadsPK downloadsPK) {
        this.downloadsPK = downloadsPK;
    }

    public Date getBoughtOnDate() {
        return boughtOnDate;
    }

    public void setBoughtOnDate(Date boughtOnDate) {
        this.boughtOnDate = boughtOnDate;
    }

    public Integer getUserRating() {
        return userRating;
    }

    public void setUserRating(Integer userRating) {
        this.userRating = userRating;
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Regime getRegime() {
        return regime;
    }

    public void setRegime(Regime regime) {
        this.regime = regime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (downloadsPK != null ? downloadsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Downloads)) {
            return false;
        }
        Downloads other = (Downloads) object;
        if ((this.downloadsPK == null && other.downloadsPK != null) || (this.downloadsPK != null && !this.downloadsPK.equals(other.downloadsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.paypal_project.db.Downloads[ downloadsPK=" + downloadsPK + " ]";
    }
    
}

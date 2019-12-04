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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "categories")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categories.findAll", query = "SELECT c FROM Categories c"),
    @NamedQuery(name = "Categories.findByCategoryID", query = "SELECT c FROM Categories c WHERE c.categoryID = :categoryID")})
public class Categories implements Serializable {

    @Lob
    @Size(max = 65535)
    @Column(name = "Category_Name")
    private String categoryName;
    @Lob
    @Size(max = 65535)
    @Column(name = "Category_Photo")
    private String categoryPhoto;
    @Lob
    @Size(max = 65535)
    @Column(name = "Description")
    private String description;
    @OneToMany(mappedBy = "categoryID")
    private Collection<Profilecategories> profilecategoriesCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Category_ID")
    private Integer categoryID;
    @JoinColumn(name = "CreatedBy_ID", referencedColumnName = "User_ID")
    @ManyToOne
    private User createdByID;

    public Categories() {
    }

    public Categories(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryPhoto() {
        return categoryPhoto;
    }

    public void setCategoryPhoto(String categoryPhoto) {
        this.categoryPhoto = categoryPhoto;
    }

    
    @JsonbTransient
    public User getCreatedByID() {
        return createdByID;
    }

    public void setCreatedByID(User createdByID) {
        this.createdByID = createdByID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryID != null ? categoryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categories)) {
            return false;
        }
        Categories other = (Categories) object;
        if ((this.categoryID == null && other.categoryID != null) || (this.categoryID != null && !this.categoryID.equals(other.categoryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.paypal_project.db.Categories[ categoryID=" + categoryID + " ]";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Profilecategories> getProfilecategoriesCollection() {
        return profilecategoriesCollection;
    }

    public void setProfilecategoriesCollection(Collection<Profilecategories> profilecategoriesCollection) {
        this.profilecategoriesCollection = profilecategoriesCollection;
    }
    
}

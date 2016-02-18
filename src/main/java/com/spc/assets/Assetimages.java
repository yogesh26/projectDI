/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spc.assets;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author YogeshK
 */
@Entity
@Table(name = "assetimages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Assetimages.findAll", query = "SELECT a FROM Assetimages a"),
    @NamedQuery(name = "Assetimages.findByIdassetImages", query = "SELECT a FROM Assetimages a WHERE a.idassetImages = :idassetImages")})
public class Assetimages implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idassetImages")
    private Integer idassetImages;
    @Lob
    @Column(name = "assetImages")
    private byte[] assetImages;
    @OneToMany(mappedBy = "idassetImages")
    private List<Assets> assetsList;

    public Assetimages() {
    }

    public Assetimages(Integer idassetImages) {
        this.idassetImages = idassetImages;
    }

    public Integer getIdassetImages() {
        return idassetImages;
    }

    public void setIdassetImages(Integer idassetImages) {
        this.idassetImages = idassetImages;
    }

    public byte[] getAssetImages() {
        return assetImages;
    }

    public void setAssetImages(byte[] assetImages) {
        this.assetImages = assetImages;
    }

    @XmlTransient
    public List<Assets> getAssetsList() {
        return assetsList;
    }

    public void setAssetsList(List<Assets> assetsList) {
        this.assetsList = assetsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idassetImages != null ? idassetImages.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Assetimages)) {
            return false;
        }
        Assetimages other = (Assetimages) object;
        if ((this.idassetImages == null && other.idassetImages != null) || (this.idassetImages != null && !this.idassetImages.equals(other.idassetImages))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.model.entities.Assetimages[ idassetImages=" + idassetImages + " ]";
    }
    
}

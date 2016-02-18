/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spc.access.images;

import com.spc.access.details.Userdetails;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author YogeshK
 */
@Entity
@Table(name = "userimages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userimages.findAll", query = "SELECT u FROM Userimages u"),
    @NamedQuery(name = "Userimages.findByIduserimage", query = "SELECT u FROM Userimages u WHERE u.iduserimage = :iduserimage"),
    @NamedQuery(name = "Userimages.findByType", query = "SELECT u FROM Userimages u WHERE u.type = :type"),
    @NamedQuery(name = "Userimages.findBySizeWidth", query = "SELECT u FROM Userimages u WHERE u.sizeWidth = :sizeWidth"),
    @NamedQuery(name = "Userimages.findBySizeHeight", query = "SELECT u FROM Userimages u WHERE u.sizeHeight = :sizeHeight"),
    @NamedQuery(name = "Userimages.findByImagename", query = "SELECT u FROM Userimages u WHERE u.imagename = :imagename")})
public class Userimages implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iduserimage")
    private Integer iduserimage;
    @Lob
    @Column(name = "userimage")
    private byte[] userimage;
    @Size(max = 5)
    @Column(name = "type")
    private String type;
    @Column(name = "sizeWidth")
    private Integer sizeWidth;
    @Column(name = "sizeHeight")
    private Integer sizeHeight;
    @Size(max = 45)
    @Column(name = "imagename")
    private String imagename;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iduserimages")
    private List<Userdetails> userdetailsList;

    public Userimages() {
    }

    public Userimages(Integer iduserimage) {
        this.iduserimage = iduserimage;
    }

    public Integer getIduserimage() {
        return iduserimage;
    }

    public void setIduserimage(Integer iduserimage) {
        this.iduserimage = iduserimage;
    }

    public byte[] getUserimage() {
        return userimage;
    }

    public void setUserimage(byte[] userimage) {
        this.userimage = userimage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSizeWidth() {
        return sizeWidth;
    }

    public void setSizeWidth(Integer sizeWidth) {
        this.sizeWidth = sizeWidth;
    }

    public Integer getSizeHeight() {
        return sizeHeight;
    }

    public void setSizeHeight(Integer sizeHeight) {
        this.sizeHeight = sizeHeight;
    }

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }

    @XmlTransient
    public List<Userdetails> getUserdetailsList() {
        return userdetailsList;
    }

    public void setUserdetailsList(List<Userdetails> userdetailsList) {
        this.userdetailsList = userdetailsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iduserimage != null ? iduserimage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userimages)) {
            return false;
        }
        Userimages other = (Userimages) object;
        if ((this.iduserimage == null && other.iduserimage != null) || (this.iduserimage != null && !this.iduserimage.equals(other.iduserimage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.model.entities.Userimages[ iduserimage=" + iduserimage + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spc.assets;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
@Table(name = "assettypes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Assettypes.findAll", query = "SELECT a FROM Assettypes a"),
    @NamedQuery(name = "Assettypes.findByIdassettypes", query = "SELECT a FROM Assettypes a WHERE a.idassettypes = :idassettypes"),
    @NamedQuery(name = "Assettypes.findByAssetTypes", query = "SELECT a FROM Assettypes a WHERE a.assetTypes = :assetTypes")})
public class Assettypes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idassettypes")
    private Integer idassettypes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "assetTypes")
    private String assetTypes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idassettypes")
    private List<Assets> assetsList;

    public Assettypes() {
    }

    public Assettypes(Integer idassettypes) {
        this.idassettypes = idassettypes;
    }

    public Assettypes(Integer idassettypes, String assetTypes) {
        this.idassettypes = idassettypes;
        this.assetTypes = assetTypes;
    }

    public Integer getIdassettypes() {
        return idassettypes;
    }

    public void setIdassettypes(Integer idassettypes) {
        this.idassettypes = idassettypes;
    }

    public String getAssetTypes() {
        return assetTypes;
    }

    public void setAssetTypes(String assetTypes) {
        this.assetTypes = assetTypes;
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
        hash += (idassettypes != null ? idassettypes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Assettypes)) {
            return false;
        }
        Assettypes other = (Assettypes) object;
        if ((this.idassettypes == null && other.idassettypes != null) || (this.idassettypes != null && !this.idassettypes.equals(other.idassettypes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.model.entities.Assettypes[ idassettypes=" + idassettypes + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spc.assets;

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
@Table(name = "assets")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Assets.findAll", query = "SELECT a FROM Assets a"),
    @NamedQuery(name = "Assets.findByIdAssets", query = "SELECT a FROM Assets a WHERE a.idAssets = :idAssets"),
    @NamedQuery(name = "Assets.findByAssetTitle", query = "SELECT a FROM Assets a WHERE a.assetTitle = :assetTitle"),
    @NamedQuery(name = "Assets.findByAssetDescription", query = "SELECT a FROM Assets a WHERE a.assetDescription = :assetDescription"),
    @NamedQuery(name = "Assets.findByPhysicalProperties", query = "SELECT a FROM Assets a WHERE a.physicalProperties = :physicalProperties")})
public class Assets implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAssets")
    private Integer idAssets;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "assetTitle")
    private String assetTitle;
    @Size(max = 100)
    @Column(name = "assetDescription")
    private String assetDescription;
    @Size(max = 255)
    @Column(name = "physicalProperties")
    private String physicalProperties;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAssets")
    private List<Assetmapping> assetmappingList;
    @JoinColumn(name = "idassettypes", referencedColumnName = "idassettypes")
    @ManyToOne(optional = false)
    private Assettypes idassettypes;
    @JoinColumn(name = "idassetImages", referencedColumnName = "idassetImages")
    @ManyToOne
    private Assetimages idassetImages;

    public Assets() {
    }

    public Assets(Integer idAssets) {
        this.idAssets = idAssets;
    }

    public Assets(Integer idAssets, String assetTitle) {
        this.idAssets = idAssets;
        this.assetTitle = assetTitle;
    }

    public Integer getIdAssets() {
        return idAssets;
    }

    public void setIdAssets(Integer idAssets) {
        this.idAssets = idAssets;
    }

    public String getAssetTitle() {
        return assetTitle;
    }

    public void setAssetTitle(String assetTitle) {
        this.assetTitle = assetTitle;
    }

    public String getAssetDescription() {
        return assetDescription;
    }

    public void setAssetDescription(String assetDescription) {
        this.assetDescription = assetDescription;
    }

    public String getPhysicalProperties() {
        return physicalProperties;
    }

    public void setPhysicalProperties(String physicalProperties) {
        this.physicalProperties = physicalProperties;
    }

    @XmlTransient
    public List<Assetmapping> getAssetmappingList() {
        return assetmappingList;
    }

    public void setAssetmappingList(List<Assetmapping> assetmappingList) {
        this.assetmappingList = assetmappingList;
    }

    public Assettypes getIdassettypes() {
        return idassettypes;
    }

    public void setIdassettypes(Assettypes idassettypes) {
        this.idassettypes = idassettypes;
    }

    public Assetimages getIdassetImages() {
        return idassetImages;
    }

    public void setIdassetImages(Assetimages idassetImages) {
        this.idassetImages = idassetImages;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAssets != null ? idAssets.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Assets)) {
            return false;
        }
        Assets other = (Assets) object;
        if ((this.idAssets == null && other.idAssets != null) || (this.idAssets != null && !this.idAssets.equals(other.idAssets))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.model.entities.Assets[ idAssets=" + idAssets + " ]";
    }
    
}

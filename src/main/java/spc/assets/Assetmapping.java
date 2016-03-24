/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spc.assets;

import spc.projects.Project;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author YogeshK
 */
@Entity
@Table(name = "assetmapping")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Assetmapping.findAll", query = "SELECT a FROM Assetmapping a"),
    @NamedQuery(name = "Assetmapping.findByIdassetmapping", query = "SELECT a FROM Assetmapping a WHERE a.idassetmapping = :idassetmapping"),
    @NamedQuery(name = "Assetmapping.findByDateadded", query = "SELECT a FROM Assetmapping a WHERE a.dateadded = :dateadded"),
    @NamedQuery(name = "Assetmapping.findByBarcode", query = "SELECT a FROM Assetmapping a WHERE a.barcode = :barcode"),
    @NamedQuery(name = "Assetmapping.findByCoordx", query = "SELECT a FROM Assetmapping a WHERE a.coordx = :coordx"),
    @NamedQuery(name = "Assetmapping.findByCoordy", query = "SELECT a FROM Assetmapping a WHERE a.coordy = :coordy"),
    @NamedQuery(name = "Assetmapping.findByAssettitle", query = "SELECT a FROM Assetmapping a WHERE a.assettitle = :assettitle")})
public class Assetmapping implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idassetmapping")
    private Integer idassetmapping;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateadded")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateadded;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "barcode")
    private String barcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "coordx")
    private String coordx;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "coordy")
    private String coordy;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "assettitle")
    private String assettitle;
    @JoinColumn(name = "idAssets", referencedColumnName = "idAssets")
    @ManyToOne(optional = false)
    private Assets idAssets;
    @JoinColumn(name = "idProject", referencedColumnName = "idproject")
    @ManyToOne(optional = false)
    private Project idProject;

    public Assetmapping() {
    }

    public Assetmapping(Integer idassetmapping) {
        this.idassetmapping = idassetmapping;
    }

    public Assetmapping(Integer idassetmapping, Date dateadded, String barcode, String coordx, String coordy, String assettitle) {
        this.idassetmapping = idassetmapping;
        this.dateadded = dateadded;
        this.barcode = barcode;
        this.coordx = coordx;
        this.coordy = coordy;
        this.assettitle = assettitle;
    }

    public Integer getIdassetmapping() {
        return idassetmapping;
    }

    public void setIdassetmapping(Integer idassetmapping) {
        this.idassetmapping = idassetmapping;
    }

    public Date getDateadded() {
        return dateadded;
    }

    public void setDateadded(Date dateadded) {
        this.dateadded = dateadded;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getCoordx() {
        return coordx;
    }

    public void setCoordx(String coordx) {
        this.coordx = coordx;
    }

    public String getCoordy() {
        return coordy;
    }

    public void setCoordy(String coordy) {
        this.coordy = coordy;
    }

    public String getAssettitle() {
        return assettitle;
    }

    public void setAssettitle(String assettitle) {
        this.assettitle = assettitle;
    }

    public Assets getIdAssets() {
        return idAssets;
    }

    public void setIdAssets(Assets idAssets) {
        this.idAssets = idAssets;
    }

    public Project getIdProject() {
        return idProject;
    }

    public void setIdProject(Project idProject) {
        this.idProject = idProject;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idassetmapping != null ? idassetmapping.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Assetmapping)) {
            return false;
        }
        Assetmapping other = (Assetmapping) object;
        if ((this.idassetmapping == null && other.idassetmapping != null) || (this.idassetmapping != null && !this.idassetmapping.equals(other.idassetmapping))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.model.entities.Assetmapping[ idassetmapping=" + idassetmapping + " ]";
    }
    
}

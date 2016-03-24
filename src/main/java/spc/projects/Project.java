/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spc.projects;

import spc.access.User;
import spc.assets.Assetmapping;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author YogeshK
 */
@Entity
@Table(name = "project")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p"),
    @NamedQuery(name = "Project.findByIdproject", query = "SELECT p FROM Project p WHERE p.idproject = :idproject"),
    @NamedQuery(name = "Project.findByProjecttitle", query = "SELECT p FROM Project p WHERE p.projecttitle = :projecttitle"),
    @NamedQuery(name = "Project.findByProjectdescription", query = "SELECT p FROM Project p WHERE p.projectdescription = :projectdescription"),
    @NamedQuery(name = "Project.findByDateAdded", query = "SELECT p FROM Project p WHERE p.dateAdded = :dateAdded")})
public class Project implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproject")
    private Integer idproject;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "projecttitle")
    private String projecttitle;
    @Size(max = 45)
    @Column(name = "projectdescription")
    private String projectdescription;
    @Column(name = "dateAdded")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProject")
    private List<Assetmapping> assetmappingList;
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    @ManyToOne(optional = false)
    private User idUser;

    public Project() {
    }

    public Project(Integer idproject) {
        this.idproject = idproject;
    }

    public Project(Integer idproject, String projecttitle) {
        this.idproject = idproject;
        this.projecttitle = projecttitle;
    }

    public Integer getIdproject() {
        return idproject;
    }

    public void setIdproject(Integer idproject) {
        this.idproject = idproject;
    }

    public String getProjecttitle() {
        return projecttitle;
    }

    public void setProjecttitle(String projecttitle) {
        this.projecttitle = projecttitle;
    }

    public String getProjectdescription() {
        return projectdescription;
    }

    public void setProjectdescription(String projectdescription) {
        this.projectdescription = projectdescription;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    @XmlTransient
    public List<Assetmapping> getAssetmappingList() {
        return assetmappingList;
    }

    public void setAssetmappingList(List<Assetmapping> assetmappingList) {
        this.assetmappingList = assetmappingList;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproject != null ? idproject.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.idproject == null && other.idproject != null) || (this.idproject != null && !this.idproject.equals(other.idproject))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.model.entities.Project[ idproject=" + idproject + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spc.access;

import com.spc.access.details.Userdetails;
import com.spc.access.role.UserRoles;
import com.spc.projects.Project;

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
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByIdUser", query = "SELECT u FROM User u WHERE u.idUser = :idUser"),
    @NamedQuery(name = "User.findByUserName", query = "SELECT u FROM User u WHERE u.userName = :userName"),
    @NamedQuery(name = "User.findByUserPassword", query = "SELECT u FROM User u WHERE u.userPassword = :userPassword")})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUser")
    private Integer idUser;
    @Size(max = 45)
    @Column(name = "UserName")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "UserPassword")
    private String userPassword;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private List<Project> projectList;
    @JoinColumn(name = "UserDetails_idUserDetails", referencedColumnName = "idUserDetails")
    @ManyToOne(optional = false)
    private Userdetails userDetailsidUserDetails;
    @JoinColumn(name = "UserRoles_idUserRoles", referencedColumnName = "idUserRoles")
    @ManyToOne(optional = false)
    private UserRoles userRolesidUserRoles;

    public User() {
    }

    public User(Integer idUser) {
        this.idUser = idUser;
    }

    public User(Integer idUser, String userPassword) {
        this.idUser = idUser;
        this.userPassword = userPassword;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @XmlTransient
    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public Userdetails getUserDetailsidUserDetails() {
        return userDetailsidUserDetails;
    }

    public void setUserDetailsidUserDetails(Userdetails userDetailsidUserDetails) {
        this.userDetailsidUserDetails = userDetailsidUserDetails;
    }

    public UserRoles getUserRolesidUserRoles() {
        return userRolesidUserRoles;
    }

    public void setUserRolesidUserRoles(UserRoles userRolesidUserRoles) {
        this.userRolesidUserRoles = userRolesidUserRoles;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.model.entities.User[ idUser=" + idUser + " ]";
    }
    
}

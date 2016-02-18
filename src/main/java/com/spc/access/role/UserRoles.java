/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spc.access.role;

import com.spc.access.User;

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
@Table(name = "userroles")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "UserRoles.findAll", query = "SELECT u FROM UserRoles u"),
//    @NamedQuery(name = "UserRoles.findByIdUserRoles", query = "SELECT u FROM UserRoles u WHERE u.id_user_roles = :id_user_roles"),
//    @NamedQuery(name = "UserRoles.findByUserType", query = "SELECT u FROM UserRoles u WHERE u.user_type = :user_type")})
public class UserRoles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_user_roles")
    private Integer idUserRoles;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "user_type")
    private String userType;
    @OneToMany(mappedBy = "idUser" , fetch = FetchType.LAZY)
    private List<User> userList;

    public UserRoles() {
    }

    public UserRoles(String userType) {
        this.idUserRoles=0;
        this.userType = userType;
    }

    public Integer getIdUserRoles() {
        return idUserRoles;
    }

    public void setIdUserRoles(Integer idUserRoles) {
        this.idUserRoles = idUserRoles;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @XmlTransient
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUserRoles != null ? idUserRoles.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserRoles)) {
            return false;
        }
        UserRoles other = (UserRoles) object;
        if ((this.idUserRoles == null && other.idUserRoles != null) || (this.idUserRoles != null && !this.idUserRoles.equals(other.idUserRoles))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.model.entities.Userroles[ idUserRoles=" + idUserRoles + " ]";
    }
    
}

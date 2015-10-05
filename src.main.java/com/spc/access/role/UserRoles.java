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
@NamedQueries({
    @NamedQuery(name = "UserRoles.findAll", query = "SELECT u FROM UserRoles u"),
    @NamedQuery(name = "UserRoles.findByIdUserRoles", query = "SELECT u FROM UserRoles u WHERE u.id_user_roles = :id_user_roles"),
    @NamedQuery(name = "UserRoles.findByUserType", query = "SELECT u FROM UserRoles u WHERE u.user_type = :user_type")})
public class UserRoles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_user_roles")
    private Integer id_user_roles;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "user_type")
    private String user_type;
    @OneToMany(mappedBy = "idUser" , fetch = FetchType.LAZY)
    private List<User> userList;

    public UserRoles() {
    }

    public UserRoles(Integer idUserRoles) {
        this.id_user_roles = idUserRoles;
    }

    public UserRoles(Integer idUserRoles, String userType) {
        this.id_user_roles = idUserRoles;
        this.user_type = userType;
    }

    public Integer getIdUserRoles() {
        return id_user_roles;
    }

    public void setIdUserRoles(Integer idUserRoles) {
        this.id_user_roles = idUserRoles;
    }

    public String getUserType() {
        return user_type;
    }

    public void setUserType(String userType) {
        this.user_type = userType;
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
        hash += (id_user_roles != null ? id_user_roles.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserRoles)) {
            return false;
        }
        UserRoles other = (UserRoles) object;
        if ((this.id_user_roles == null && other.id_user_roles != null) || (this.id_user_roles != null && !this.id_user_roles.equals(other.id_user_roles))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.model.entities.Userroles[ idUserRoles=" + id_user_roles + " ]";
    }
    
}

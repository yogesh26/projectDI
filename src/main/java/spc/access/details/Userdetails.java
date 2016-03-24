/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spc.access.details;

import spc.access.images.Userimages;
import spc.access.User;

import javax.persistence.*;
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
@Table(name = "userdetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userdetails.findAll", query = "SELECT u FROM Userdetails u"),
    @NamedQuery(name = "Userdetails.findByIdUserDetails", query = "SELECT u FROM Userdetails u WHERE u.idUserDetails = :idUserDetails"),
    @NamedQuery(name = "Userdetails.findByIdUser", query = "SELECT u FROM Userdetails u WHERE u.idUser = :idUser"),
    @NamedQuery(name = "Userdetails.findByUserName", query = "SELECT u FROM Userdetails u WHERE u.userName = :userName"),
    @NamedQuery(name = "Userdetails.findByUserSurname", query = "SELECT u FROM Userdetails u WHERE u.userSurname = :userSurname"),
    @NamedQuery(name = "Userdetails.findByGender", query = "SELECT u FROM Userdetails u WHERE u.gender = :gender"),
    @NamedQuery(name = "Userdetails.findByDob", query = "SELECT u FROM Userdetails u WHERE u.dob = :dob"),
    @NamedQuery(name = "Userdetails.findByDoj", query = "SELECT u FROM Userdetails u WHERE u.doj = :doj"),
    @NamedQuery(name = "Userdetails.findByVerified", query = "SELECT u FROM Userdetails u WHERE u.verified = :verified"),
    @NamedQuery(name = "Userdetails.findByActivated", query = "SELECT u FROM Userdetails u WHERE u.activated = :activated")})
public class Userdetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUserDetails")
    private Integer idUserDetails;
    @Column(name = "idUser")
    private Integer idUser;
    @Size(max = 45)
    @Column(name = "UserName")
    private String userName;
    @Size(max = 45)
    @Column(name = "UserSurname")
    private String userSurname;
    @Size(max = 2)
    @Column(name = "Gender")
    private String gender;
    @Column(name = "Dob")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Column(name = "Doj")
    @Temporal(TemporalType.DATE)
    private Date doj;
    @Column(name = "Verified")
    private Boolean verified;
    @Column(name = "Activated")
    private Boolean activated;
    @JoinColumn(name = "iduserimages", referencedColumnName = "iduserimage")
    @ManyToOne(optional = false)
    private Userimages iduserimages;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userDetailsidUserDetails")
    private List<User> userList;

    public Userdetails() {
    }

    public Userdetails(Integer idUserDetails) {
        this.idUserDetails = idUserDetails;
    }

    public Integer getIdUserDetails() {
        return idUserDetails;
    }

    public void setIdUserDetails(Integer idUserDetails) {
        this.idUserDetails = idUserDetails;
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

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public Userimages getIduserimages() {
        return iduserimages;
    }

    public void setIduserimages(Userimages iduserimages) {
        this.iduserimages = iduserimages;
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
        hash += (idUserDetails != null ? idUserDetails.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userdetails)) {
            return false;
        }
        Userdetails other = (Userdetails) object;
        if ((this.idUserDetails == null && other.idUserDetails != null) || (this.idUserDetails != null && !this.idUserDetails.equals(other.idUserDetails))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.model.entities.Userdetails[ idUserDetails=" + idUserDetails + " ]";
    }
    
}

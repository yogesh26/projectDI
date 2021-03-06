/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spc.access;

import spc.access.details.Userdetails;
import spc.access.role.UserRoles;
import spc.projects.Project;

import lombok.Getter;
import lombok.Setter;


import java.util.List;

/**
 *
 * @author YogeshK
 */
@Getter
@Setter
public class UserDTO {
    private static final long serialVersionUID = 1L;

    private Integer idUser;

    private String userName;

    private String userPassword;

    private List<Project> projectList;

    private Userdetails userDetailsidUserDetails;

    private UserRoles userRolesidUserRoles;
}

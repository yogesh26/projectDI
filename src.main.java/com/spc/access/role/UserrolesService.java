package com.spc.access.role;

import src.exception.UserroleNotFoundException;
import src.model.dtos.UserrolesDTO;
import src.model.entities.Userroles;
import src.repository.UserrolesRepository;

import java.util.List;

/**
 * Created by yogeshkumar on 15/08/21.
 */
public interface UserRolesService {
    public void setUserRolesRepository(UserRolesRepository userolesRepository);

    public UserRolesDTO create(UserRolesDTO newUserroleEntity);

    public List<UserRolesDTO> findAll();

    public UserRolesDTO findById(Integer id) throws UserRoleNotFoundException;


    public UserRoles update(UserRoles updatedUserEntity);

    public UserRolesDTO transformIntoDTO(UserRoles entity);
}
package com.spc.access.role;


import java.util.List;
import com.spc.access.role.UserRolesReposiotry;
import com.spc.exception.UserRolesNotFoundException;

/**
 * Created by yogeshkumar on 15/08/21.
 */
public interface UserRolesService {
    public void setUserRolesRepository(UserRolesReposiotry userolesRepository);

    public UserRoleResponseDTO create(UserRolesDTO newUserroleEntity)throws Exception;

    public UserRolesDTO findById(Integer id) throws UserRolesNotFoundException;


    public UserRoles update(UserRoles updatedUserEntity);

    public UserRolesDTO transformIntoDTO(UserRoles entity);

}
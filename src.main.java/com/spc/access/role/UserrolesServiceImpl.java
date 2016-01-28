package com.spc.access.role;

import com.google.gson.Gson;
import com.spc.exception.UserRolesNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yogeshkumar on 15/08/21.
 */

@Service
@Slf4j
public class UserRolesServiceImpl implements UserRolesService {

    @Resource
    UserRolesReposiotry userrolesRepository;

    @Qualifier("userroles")
    @PersistenceContext
    private EntityManager em;


    /**
     * Transfer into a DTO
     *
     * @param entity
     * @return
     */
    public UserRolesDTO convertToDTO(UserRoles entity) {
        UserRolesDTO userrolesDTO = new UserRolesDTO();
        userrolesDTO.setUserType(entity.getUserType());
        return userrolesDTO;
    }

    /**
     * Create and persist an entity from a DTO
     *
     * @param newUserDTO
     * @return
     */
    @Override
    public UserRoleResponseDTO create(UserRolesDTO newUserDTO) throws Exception{
        System.out.println("creating the user role now");
        UserRoleResponseDTO respDto = new UserRoleResponseDTO();
        try {
            System.out.println("newuserDTO =>" + newUserDTO.getIdUserRoles());
            System.out.println("newuserDTO =>" + newUserDTO.getUserType());

            Gson gson = new Gson();
            System.out.println("create entity now");
            UserRoles createdUser=new UserRoles();
            createdUser.setIdUserRoles(newUserDTO.getIdUserRoles());
            createdUser.setUserType(newUserDTO.getUserType());
            System.out.println("created entity now");
            createdUser = userrolesRepository.save(createdUser);

            UserRolesDTO dto = convertToDTO(createdUser);


            if (createdUser == null) {
                respDto.setUserDto(dto);
                respDto.setResponseCode("401");
                respDto.setResponseMessage("Role couldnot be created");
            } else {
                respDto.setUserDto(dto);
                respDto.setResponseCode("201");
                respDto.setResponseMessage("Role created");
            }
        }catch (Exception e){
            respDto.setUserDto(null);
            respDto.setResponseCode("500");
            respDto.setResponseMessage("Internal Server error");
            throw e;
        }
        return respDto;
    }

    @Override
    public void setUserRolesRepository(UserRolesReposiotry useRepository) {
        this.userrolesRepository = useRepository;
    }



    /**
     * Find a specific entity using pk value
     *
     * @param id
     * @return
     * @throws com.spc.exception.UserRolesNotFoundException
     */
    public UserRolesDTO findById(Integer id) throws UserRolesNotFoundException {
        UserRoles entity = userrolesRepository.findOne(id);
        if (entity == null) {
            throw new UserRolesNotFoundException("User role not found");
        }
        return convertToDTO(entity);
    }


    @Override
    public UserRolesDTO transformIntoDTO(UserRoles entity) {
        return null;
    }



    /**
     * Save the updated entity
     *
     * @param updatedIncidentFlowStateNotificationMessageEntity
     * @return
     */
    public UserRoles update(UserRoles updatedIncidentFlowStateNotificationMessageEntity) {
        updatedIncidentFlowStateNotificationMessageEntity = userrolesRepository.save(updatedIncidentFlowStateNotificationMessageEntity);
        return updatedIncidentFlowStateNotificationMessageEntity;
    }

}
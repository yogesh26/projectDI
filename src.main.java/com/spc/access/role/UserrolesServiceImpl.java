package com.spc.access.role;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import src.exception.UserNotFoundException;
import src.exception.UserroleNotFoundException;
import src.model.dtos.UserrolesDTO;
import src.model.entities.UserRoles;
import src.repository.UserRolesRepository;

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
    UserRolesRepository userrolesRepository;

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
    public UserRolesDTO create(UserRolesDTO newUserDTO) {

        log.debug("newuserDTO =>"+newUserDTO.toString());



        Gson gson = new Gson();
        UserRoles createdUser = gson.fromJson(newUserDTO.toString(), UserRoles.class);

        createdUser = userrolesRepository.save(createdUser);
        return convertToDTO(createdUser);
    }

    @Override
    public void setUserRolesRepository(UserRolesRepository useRepository) {
        this.userrolesRepository = useRepository;
    }


    /**
     * Retrieve a list of all the messages in DTO format
     *
     * @return
     */
    public List<UserRolesDTO> findAll() {
        List<UserRoles> entityList = userrolesRepository.findAll();
        List<UserRolesDTO> dtoList = new ArrayList<>();

        for (UserRoles entity : entityList) {
            UserRolesDTO dto = convertToDTO(entity);
            dtoList.add(dto);
        }

        return dtoList;
    }


    /**
     * Find a specific entity using pk value
     *
     * @param id
     * @return
     * @throws src.exception.UserNotFoundException
     */
    public UserRolesDTO findById(Integer id) throws UserroleNotFoundException {
        UserRoles entity = userrolesRepository.findOne(id);
        if (entity == null) {
            throw new UserroleNotFoundException("User role not found");
        }
        return convertToDTO(entity);
    }


    @Override
    public UserRolesDTO transformIntoDTO(UserRoles entity) {
        return null;
    }

    /**
     * Find a specific entry using the pk value
     *
     * @param id
     * @return
     * @throws UserNotFoundException
     */
    public UserRoles findOutgoingMessageById(Integer id) throws UserroleNotFoundException {
        UserRoles entity = userrolesRepository.findOne(id);
        if (entity == null) {
            throw new UserroleNotFoundException("User not found");
        }
        return entity;
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
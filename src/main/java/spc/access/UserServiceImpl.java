package spc.access;

import com.google.gson.Gson;
import spc.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YogeshK on 2015-07-22.
 */

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserRepository userRepository;

    @Qualifier("users")
    @PersistenceContext
    private EntityManager em;


    /**
     * Transfer into a DTO
     *
     * @param entity
     * @return
     */
    public UserDTO convertToDTO(User entity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setIdUser(entity.getIdUser());
        userDTO.setProjectList(entity.getProjectList());
        userDTO.setUserDetailsidUserDetails(entity.getUserDetailsidUserDetails());
        userDTO.setUserName(entity.getUserName());
        userDTO.setUserPassword(entity.getUserPassword());
        userDTO.setUserRolesidUserRoles(entity.getUserRolesidUserRoles());
        return userDTO;
    }

    /**
     * Create and persist an entity from a DTO
     *
     * @param newUserDTO
     * @return
     */
    @Override
    public UserDTO create(UserDTO newUserDTO) {

        log.debug("newuserDTO =>"+newUserDTO.toString());



        Gson gson = new Gson();
        User createdUser = gson.fromJson(newUserDTO.toString(), User.class);

        createdUser = userRepository.save(createdUser);
        return convertToDTO(createdUser);
    }

    @Override
    public void setUserRepository(UserRepository useRepository) {
        this.userRepository = useRepository;
    }


    /**
     * Retrieve a list of all the messages in DTO format
     *
     * @return
     */
    public List<UserDTO> findAll() {
        List<User> entityList = userRepository.findAll();
        List<UserDTO> dtoList = new ArrayList<>();

        for (User entity : entityList) {
            UserDTO dto = convertToDTO(entity);
            dtoList.add(dto);
        }

        return dtoList;
    }


    /**
     * Find a specific entity using pk value
     *
     * @param id
     * @return
     * @throws UserNotFoundException
     */
    public UserDTO findById(Long id) throws UserNotFoundException {
        User entity = userRepository.findOne(id);
        if (entity == null) {
            throw new UserNotFoundException("User not found");
        }
        return convertToDTO(entity);
    }


    @Override
    public UserDTO transformIntoDTO(User entity) {
        return null;
    }

    /**
     * Find a specific entry using the pk value
     *
     * @param id
     * @return
     * @throws UserNotFoundException
     */
    public User findOutgoingMessageById(Long id) throws UserNotFoundException {
        User entity = userRepository.findOne(id);
        if (entity == null) {
            throw new UserNotFoundException("User not found");
        }
        return entity;
    }

    /**
     * Save the updated entity
     *
     * @param updatedIncidentFlowStateNotificationMessageEntity
     * @return
     */
    public User update(User updatedIncidentFlowStateNotificationMessageEntity) {
        updatedIncidentFlowStateNotificationMessageEntity = userRepository.save(updatedIncidentFlowStateNotificationMessageEntity);
        return updatedIncidentFlowStateNotificationMessageEntity;
    }

}
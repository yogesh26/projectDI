package com.spc.access;

import com.spc.exception.UserNotFoundException;


import java.util.List;

/**
 * Created by YogeshK on 2015-07-22.
 */
public interface UserService {
    public void setUserRepository(UserRepository useRepository);

    public UserDTO create(UserDTO newUserEntity);

    public List<UserDTO> findAll();

    public UserDTO findById(Long id) throws UserNotFoundException;


    public User update(User updatedUserEntity);

    public UserDTO transformIntoDTO(User entity);


}

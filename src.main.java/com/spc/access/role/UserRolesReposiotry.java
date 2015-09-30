package com.spc.access.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import src.model.entities.UserRoles;


/**
 * Created by YogeshK on 2015-09-17.
 */
@Repository
public interface UserRolesReposiotry extends JpaRepository<UserRoles, Long> {
}

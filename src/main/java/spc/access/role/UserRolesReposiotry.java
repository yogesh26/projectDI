package spc.access.role;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by YogeshK on 2015-09-17.
 */
@Repository
public interface UserRolesReposiotry extends CrudRepository<UserRoles, Integer> {
    List<UserRoles> findByUserType(String userType);
}

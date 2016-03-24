package spc.access.role;

import spc.access.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by YogeshK on 2015-10-05.
 */
@Getter
@Setter
public class UserRolesDTO {
    private Integer idUserRoles;
    private String userType;
    private List<User> userList;


}

package com.spc.access.role;

import com.spc.utils.CommonResponseDTO;
import com.spc.utils.CommonResponseHeader;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by YogeshK on 2015-10-05.
 */
@Getter
@Setter
public class UserRoleResponseDTO extends CommonResponseDTO {

    private UserRolesDTO userDto;
}

package com.spc.access.details;

import com.spc.access.images.Userimages;
import com.spc.access.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * Created by YogeshK on 2015-07-22.
 */
@Getter
@Setter
public class UserdetailsDTO {

    private Integer idUserDetails;

    private Integer idUser;

    private String userName;

    private String userSurname;

    private String gender;

    private Date dob;

    private Date doj;

    private Boolean verified;

    private Boolean activated;

    private Userimages iduserimages;

    private List<User> userList;

}

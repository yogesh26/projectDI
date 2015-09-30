package com.spc.access.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import src.model.dtos.UserRolesDTO;
import src.services.UserRolesService;
import src.utils.CommonResponseHeader;

import javax.transaction.Transactional;

/**
 * Created by YogeshK on 2015-09-17.
 */

@RestController
public class UserRolesController {

    @Autowired
    private UserRolesService userRolesService;

    @RequestMapping("/userAuth/getRoles")
    @ResponseBody
    String getRoles() {

        return "Success";

    }

    /**
     * Rest API to create a new FormDesign. This controller consumes a DTO containing all the relevant fields and list of key values.
     */
    @RequestMapping(method = RequestMethod.POST,
            value = "/createUserRole",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    @Transactional
    public ResponseEntity<UserRolesDTO> createFormDesign(@RequestParam(value = "roleType") String recId) {

        System.out.println("here1");
        HttpHeaders headers = CommonResponseHeader.getNoCacheHeader();
        UserRolesDTO createdUserRolesResult = new UserRolesDTO();
        try {
            createdUserRolesResult.setUserType(recId);
            UserRolesDTO newEntity = userRolesService.create(createdUserRolesResult);
            return new ResponseEntity<>(newEntity, headers, HttpStatus.CREATED);
        } catch (Exception ex) {
            System.out.println("Exception" + ex.toString());
            return new ResponseEntity<>(createdUserRolesResult, headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}

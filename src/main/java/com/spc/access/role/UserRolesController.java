package com.spc.access.role;

import com.spc.utils.CommonResponseHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

/**
 * Created by YogeshK on 2015-09-17.
 */

@RestController
public class UserRolesController {

    @Autowired
    UserRolesService userRoleService;


    @RequestMapping("/userAuth/getRoles")
    @ResponseBody
    String getRoles() {

        return "Success";

    }

    /**
     * Rest API to create a new Incident. This controller consumes a DTO containing all the relevant fields and list of key values.
     * Lookup values like incident status , flow status, priority and others will be validated before the event will be created.
     */
    @RequestMapping(method = RequestMethod.POST,
            value = "/createUserRole",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<UserRolesDTO> createUserRoleHelper(@RequestBody UserRolesDTO roleEntity) throws Exception {
        System.out.println("received the request for role create");
        UserRoleResponseDTO obj = userRoleService.create(roleEntity);
        HttpHeaders headers = CommonResponseHeader.getNoCacheHeader();

        if ("201".equals(obj.getResponseCode())||"200".equals(obj.getResponseCode())) {
            return new ResponseEntity<>(obj.getUserDto(), headers, HttpStatus.CREATED);
        } else if ("204".equals(obj.getResponseCode())) {
            return new ResponseEntity<>(obj.getUserDto(), headers, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(obj.getUserDto(), headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}

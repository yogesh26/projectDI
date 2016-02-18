package com.spc.access; /**
 * Created by YogeshK on 2015-07-15.
 */

import com.spc.access.role.UserRoleResponseDTO;
import com.spc.access.role.UserRoles;
import com.spc.access.role.UserRolesDTO;
import com.spc.access.role.UserRolesService;
import com.spc.exception.UserRolesNotFoundException;
import com.spc.utils.CommonResponseHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by YogeshK on 2015-07-15.
 */

@RestController
@RequestMapping("/userAuth")
//@EnableAutoConfiguration(exclude=org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration.class)
public class UserAuthController {

    @RequestMapping("/Ver")
    @ResponseBody
    String version() {
        System.out.println("Ver1.2");
        return "1.2" + getImage("dto", "eedsdsdsds.PNG");

    }


    public String getImage(String path, String name) {
        try {

            ClassLoader loader = UserAuthController.class.getClassLoader();

            URL str = loader.getResource("image/emailSignature.PNG");
            if(str == null){
                return ("doesnt exist at:" +"resources/image/emailSignature.PNG");
            }
            File file = ResourceUtils.getFile(loader.getResource("image/emailSignature.PNG"));
            if(file.exists())
                return ("exists at:" + file.getAbsolutePath());
            else
                return ("doesnt exist at:" + file.getAbsolutePath());

        }
        catch (IOException e) {
            return ("Image file "+name+" not found in path: " +path);
        }
    }




}

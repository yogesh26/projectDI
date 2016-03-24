package spc.access; /**
 * Created by YogeshK on 2015-07-15.
 */

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by YogeshK on 2015-07-15.
 */
@Api(description = "User management",
        value = "User CRUD")
@RestController
@RequestMapping(value = "/appauth", produces = MediaType.APPLICATION_JSON_VALUE)
//@EnableAutoConfiguration(exclude=org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration.class)
public class UserAuthController {
    @ApiOperation(response = ApiResponse.class,
            value = "version of the api",
            notes = "current version of the api")
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

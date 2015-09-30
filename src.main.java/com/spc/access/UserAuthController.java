package com.spc.access; /**
 * Created by YogeshK on 2015-07-15.
 */

import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by YogeshK on 2015-07-15.
 */

@RestController
//@EnableAutoConfiguration(exclude=org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration.class)
public class UserAuthController {
    @RequestMapping("/userAuth/Ver")
    @ResponseBody
    String version() {

        return "1.2" + getImage("dto", "eedsdsdsds.PNG");

    }
//    @RequestMapping(value = "/downloadImage",
//            method = RequestMethod.GET,
//            params = {"imageId"},
//            produces = MediaType.IMAGE_PNG_VALUE
//    )
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
//    public void downLoadImage(@RequestParam(value = "imageId") String id, HttpServletResponse respcontext) throws IOException {
//        System.out.println(respcontext.getStatus());
//        HttpHeaders headers = ResponseHeader.responseWithNoCacheHeader();
//        ClassLoader loader = UserAuthController.class.getClassLoader();
//        System.out.println("looking for image:" + id);
//
//        URL str = loader.getResource("image/" + id);
//        if(str == null){
//
//            //return new ResponseEntity<>(null, headers, HttpStatus.NOT_FOUND) ;
//        }
//        System.out.println("image found at:" + str);
//        InputStream inps = UserAuthController.class.getClass().getResourceAsStream("/image/" + id);
//        if(inps== null){
//            System.out.println("input stream found null");
//        }
//        headers.setContentType(MediaType.IMAGE_PNG);
//        try {
//            FileCopyUtils.copy(inps, respcontext.getOutputStream());
//            respcontext.flushBuffer();
//        } catch (final IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        //return new ResponseEntity<byte[]>(IOUtils.toByteArray(inps), headers, HttpStatus.CREATED);
//    }
//    public ResponseEntity<InputStreamResource> downLoadImage(@RequestParam(value = "imageId") String id){
//        HttpHeaders headers = ResponseHeader.responseWithNoCacheHeader();
//        ClassLoader loader = UserAuthController.class.getClassLoader();
//        System.out.println("looking for image:" + id);
//
//        URL str = loader.getResource("image/" + id);
//        if(str == null){
//
//            return new ResponseEntity<>(null, headers, HttpStatus.NOT_FOUND) ;
//        }
//        System.out.println("image found at:" + str);
//        InputStream inps = UserAuthController.class.getClass().getResourceAsStream("/image/" + id);
//        if(inps== null){
//            System.out.println("input stream found null");
//        }
//        InputStreamResource res = new InputStreamResource(inps);
//
//        return new ResponseEntity<InputStreamResource>(res, headers, HttpStatus.OK) ;
//    }

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

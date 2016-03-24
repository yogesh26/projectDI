package spc.access;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by YogeshK on 2016-02-17.
 */
@Controller
@RestController
public class FloorWiseController {
//    @RequestMapping(value = "/floorWiseHome", method = RequestMethod.GET)
//    public ModelAndView floorWiseHome() {
//        System.out.println("hello");
//        return new ModelAndView("floorWiseHome");
//    }
@Value("${application.message:Hello World}")
private String message = "Hello World";

    @RequestMapping("/floorwise")
    public @ResponseBody
    Map<String, String> callSomething () {

        Map<String, String> map = new HashMap<String, String>();
        map.put("url", "http://www.leveluplunch.com");

        return map;
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView hello() {
        System.out.println("jsp test");
        return new ModelAndView("index");
    }

    @RequestMapping("/api-desc")
    public ModelAndView foo(Map<String, Object> model) {
        return new ModelAndView("index");
    }
}

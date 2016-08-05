package spc.appgeom;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Map;

/**
 * Created by YogeshK on 2016-06-22.
 */
@Controller

public class JSPController {
    @Value("${application.message:Hello World}")
    private String message = "Hello World";
    @RequestMapping("/jsptest")
    public String test(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", this.message);
        return "index";
    }
}

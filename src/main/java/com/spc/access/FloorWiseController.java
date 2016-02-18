package com.spc.access;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by YogeshK on 2016-02-17.
 */
@Controller

public class FloorWiseController {
    @RequestMapping(value = "/floorWiseHome", method = RequestMethod.GET)
    public ModelAndView floorWiseHome() {
        System.out.println("hello");
        return new ModelAndView("floorWiseHome");
    }
}

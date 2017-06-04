package piatr.asylum.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by piatr on 23.05.17.
 */
@Controller
public class StartController {
    @RequestMapping("/")
    public String hello(){
        return "startPage";
    }
}

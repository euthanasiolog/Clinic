package java.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by piatr on 23.05.17.
 */
@Controller
public class SignInController {
    @RequestMapping("/signIn")
    public String signIn(ModelMap modelMap){
        return "";
    }
}

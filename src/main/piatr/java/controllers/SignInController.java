package java.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by piatr on 23.05.17.
 */
@Controller
public class SignInController {
    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public String signIn(ModelMap modelMap){
        SignIn signIn = new SignIn();
        modelMap.put("signIn", signIn);
        return "signInPage";
    }
    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String signIn(ModelMap modelMap, SignIn signIn){
        if(signIn.getType().equals("doctor")){

            return "";
        }else if (signIn.getType().equals("nurse")){
            return "";
        } return "signInPage";
    }
}

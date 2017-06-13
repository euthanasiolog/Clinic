package piatr.asylum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import piatr.asylum.forms.SignIn;
import piatr.asylum.service.peopleService.UserService;
import piatr.asylum.service.peopleService.UserServiceImpl;

/**
 * Created by piatr on 23.05.17.
 */
@Controller
public class SignInController {
    @Autowired
    private
    UserService userService;

    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public String signInStart(ModelMap modelMap){
        SignIn signIn = new SignIn();
        modelMap.put("signIn", signIn);
        return "signInPage";
    }
    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String signIn(ModelMap modelMap, SignIn signIn){
        if(userService.isLoginExist(signIn.getLogin(), signIn.getType())&&userService.isPasswordCorrect(signIn.getLogin(), signIn.getPassword(),signIn.getType()))
        return "mainPage";
        else return "signInPage";
    }
}

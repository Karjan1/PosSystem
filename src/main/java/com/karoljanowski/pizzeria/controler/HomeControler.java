package com.karoljanowski.pizzeria.controler;

import com.karoljanowski.pizzeria.dao.RoleDao;
import com.karoljanowski.pizzeria.domain.User;
import com.karoljanowski.pizzeria.domain.security.UserRole;
import com.karoljanowski.pizzeria.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Karol Janowski on 2017-06-06.
 */
@Controller
public class HomeControler {

    @Autowired
    UserService userService;

    @Autowired  // BAD PRACTICE. SHOULD CRRATE ROLESERVICE
    private RoleDao roleDao;

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "pages/login";}

    @RequestMapping("/admin")
    public String admin(){
        return "pages/index";}

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "pages/signup";
    }
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signupPost(@ModelAttribute("owner") User user, Model model){
        if (userService.checkUserExists(user.getPhone(), user.getEmail(), user.getUsername())){
            if (userService.checkPhoneExists(user.getPhone())){
                model.addAttribute("phoneExists", true);
            }
            if (userService.checkEmailExists(user.getEmail())){
                model.addAttribute("emailExists", true);
            }
            return "pages/signup";
        } else {
            Set<UserRole> userRoles = new HashSet<>();
            userRoles.add(new UserRole(user, roleDao.findByName("ROLE_USER")));
            userService.createUser(user, userRoles);
            return "redirect:/";
        }
    }
}















package com.softekh.capp.controller;

import com.softekh.capp.command.LoginCommand;
import com.softekh.capp.command.UserCommand;
import com.softekh.capp.domain.User;
import com.softekh.capp.exception.UserBlockedException;
import com.softekh.capp.service.UserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ISAAC BLACK
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = {"/","/index"})
    public String index(Model m){
        m.addAttribute("command", new LoginCommand());
        return "index"; //JSP - /WEB-INF/view/index.jsp
    }
    
    @RequestMapping(value = "/login", method=RequestMethod.POST)
    public String handleLogin(@ModelAttribute("command") LoginCommand cmd, Model m, HttpSession session){
        try {
            User loggedInUser = userService.login(cmd.getLoginName(), cmd.getPassword());
            if(loggedInUser == null){
              //Failed  
             //Add error message and go back to Login-FORM
            m.addAttribute("err", "Login Failed! Enter Valid Credentials.");
            return "index"; //JSP - Login FORM
            }else{
            //SUCCESS
            //Chech role and redirect to the appropriate Dashboard
            if(loggedInUser.getRole().equals(UserService.ROLE_ADMIN) ){
                //Add user details in session(Assign session to logged in user)
                addUserInSession(loggedInUser,session);
                return "redirect:admin/dashboard";
            }else if(loggedInUser.getRole().equals(UserService.ROLE_USER)){
                //Add user details in session(Assign session to logged in user)
                addUserInSession(loggedInUser,session);
                return "redirect:user/dashboard";
            }else{
                //Add error message and go back to Login-FORM
                m.addAttribute("err", "Invalid User ROLE");
                return "index"; //JSP - Login FORM
                }
            }
        } catch (UserBlockedException ex) {
            //Add error message and go back to Login-FORM
            m.addAttribute("err", ex.getMessage());
            return "index"; //JSP - Login FORM
        }

    }
    
   @RequestMapping(value = "/user/dashboard")
    public String userDashboard(){
        return "dashboard_user"; //JSP
    }
    
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:index?act=lo";
    }
    
    @RequestMapping(value = "/admin/dashboard")
    public String adminDashboard(){
        return "dashboard_admin"; //JSP
    }
    
    @RequestMapping(value = "/admin/users")
    public String getUserList(Model m){
        m.addAttribute("userList", userService.getUserList());
        return "users"; //JSP
    }
    
    @RequestMapping(value = "/reg_form")
    public String registrationForm(Model m){
        UserCommand cmd = new UserCommand();
        m.addAttribute("command",cmd);
        return "reg_form"; //JSP
    }
    @RequestMapping(value = "/register")
    public String registerUser(@ModelAttribute("command") UserCommand cmd, Model m){
        try {
            User user = cmd.getUser();
            user.setRole(UserService.ROLE_USER);
            user.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
            userService.register(user);
            return "redirect:index?act=reg"; // Login Page
        } catch (DuplicateKeyException e) {
            e.printStackTrace();
            m.addAttribute("err", "Username is already registered. Please select another Username");
            return "reg_form"; //JSP
        }
    }
    
    private void addUserInSession(User u, HttpSession session){
        session.setAttribute("user", u);
        session.setAttribute("userId", u.getUserId());
        session.setAttribute("role", u.getRole());
    }
    
     @RequestMapping(value = "/admin/change_status")
     @ResponseBody
    public String changeLoginStatus(@RequestParam Integer userId, @RequestParam Integer loginStatus){
         try {
             userService.ChangeLoginStatus(userId, loginStatus);
             return "SUCCESS: Status Changed";
         } catch (Exception e) {
             e.printStackTrace();
             return "ERROR: Unable to Change Status";
         }
    }
    
    @RequestMapping(value = "/check_avail")
    @ResponseBody
    public String checkAvailability(@RequestParam String username){
        if(userService.isUserNameExist(username)){
            return "This username is already taken : Choose another name!";
        }else{
            return "Yes! You can take this";
        }
    }
    
}

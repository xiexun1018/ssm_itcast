package cn.itcast.ssm.controller;

import cn.itcast.ssm.dao.UserDao;
import cn.itcast.ssm.domain.Role;
import cn.itcast.ssm.domain.Users;
import cn.itcast.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author:xiexun
 * @date:2018/11/15
 * @time:10:42
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("/findAll")
    public ModelAndView findAllTest(){
        ModelAndView modelAndView = new ModelAndView();
        List<Users> userList = userService.findAll();
        modelAndView.setViewName("user-list");
        modelAndView.addObject("userList",userList);
        return modelAndView;
    }
    @RequestMapping("/toAdd")
    public String toAddTest(){
        return "user-add";
    }
    @RequestMapping("/saveUser")
    public String saveUserTest(Users users){
        userService.save(users);
        return "redirect:findAll";
    }
    @RequestMapping("/findById")
    public ModelAndView findByIdTest(String id){
        ModelAndView modelAndView = new ModelAndView();
        Users user = userService.findById(id);
        modelAndView.setViewName("user-show");
        modelAndView.addObject("user",user);
        return modelAndView;
    }
    @RequestMapping("/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRoleTest(String id){
        ModelAndView modelAndView = new ModelAndView();
        Users user = userService.findById(id);
        List<Role> roleList=userService.findOtherRoles(id);
        modelAndView.setViewName("user-role-add");
        modelAndView.addObject("user",user);
        modelAndView.addObject("roleList",roleList);
        return modelAndView;
    }
    @RequestMapping("/addRoleToUser")
    public String addRoleToUserTest(@RequestParam(name = "userId",required = true) String userId,@RequestParam(name="ids",required = true) String[] roleId){
        userService.addRoleToUser(userId,roleId);
        return "redirect:findAll";
    }
}


package cn.itcast.ssm.controller;

import cn.itcast.ssm.domain.Permission;
import cn.itcast.ssm.domain.Role;
import cn.itcast.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author:xiexun
 * @date:2018/11/15
 * @time:15:08
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;
    @RequestMapping("/findAll")
    @PreAuthorize(" authentication.principal.username=='tom' ")
    public ModelAndView findAllTest(){
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.findAll();
        modelAndView.setViewName("role-list");
        modelAndView.addObject("roleList",roleList);
        return modelAndView;
    }
    @RequestMapping("/toAdd")
    public String toAddTest(){
        return "role-add";
    }
    @RequestMapping("/saveRole")
    public String saveRoleTest(Role role){
        roleService.save(role);
        return "redirect:findAll";
    }
    @RequestMapping("/findRoleByIdAndAllPermission")
    public ModelAndView findRoleByIdAndAllPermissionTest(String id){
        ModelAndView modelAndView = new ModelAndView();
        Role role = roleService.findById(id);
        List<Permission> permissionList =roleService.findOtherPermissions(id);
        modelAndView.setViewName("role-permission-add");
        modelAndView.addObject("role",role);
        modelAndView.addObject("permissionList",permissionList);
        return modelAndView;
    }
    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRoleTest(@RequestParam(name = "roleId",required = true) String roleId,@RequestParam(name="ids",required = true) String[] permissionIds){
        roleService.addPermissionToRole(permissionIds,roleId);
        return "redirect:findAll";
    }
}

package cn.itcast.ssm.controller;

import cn.itcast.ssm.domain.Permission;
import cn.itcast.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author:xiexun
 * @date:2018/11/15
 * @time:15:38
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;
    @RequestMapping("/findAll")
    @PreAuthorize(" authentication.principal.username=='tom' ")
    public ModelAndView findAllTest(){
        ModelAndView modelAndView = new ModelAndView();
        List<Permission> permissionList = permissionService.findAll();
        modelAndView.setViewName("permission-list");
        modelAndView.addObject("permissionList",permissionList);
        return modelAndView;
    }
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "permission-add";
    }
@RequestMapping("/savePermission")
    public String savePermission(Permission permission){
        permissionService.save(permission);
        return "redirect:findAll";
    }
}

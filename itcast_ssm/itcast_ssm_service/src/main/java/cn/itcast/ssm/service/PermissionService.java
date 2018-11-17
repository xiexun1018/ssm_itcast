package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.Permission;
import cn.itcast.ssm.domain.Role;

import java.util.List;

public interface PermissionService {

    List<Permission> findAll();
    void save(Permission permission);
    List<Role> findByRoleId(String roleId);
}

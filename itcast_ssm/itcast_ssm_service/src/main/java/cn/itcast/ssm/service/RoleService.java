package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.Permission;
import cn.itcast.ssm.domain.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();
    void save(Role role);

    Role findById(String roleId);

    List<Permission> findOtherPermissions(String roleId);

    void addPermissionToRole( String[] permissionIds,String roleId);
}

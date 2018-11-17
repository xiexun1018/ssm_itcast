package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Permission;
import cn.itcast.ssm.domain.Role;

import java.util.List;

public interface PermissionDao {
    List<Role> findByRoleId(String roleId);

    List<Permission> findAll();

    void save(Permission permission);
}

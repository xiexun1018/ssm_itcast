package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Permission;
import cn.itcast.ssm.domain.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDao {
    List<Role> findByUserId(String userId);

    List<Role> findAll();

    void save(Role role);

    Role findByRoleId(String roleId);

    List<Permission> findOtherPermissions(String roleId);

    void addPermissionToRole( @Param("permissionId") String permissionId, @Param("roleId")String roleId);
}

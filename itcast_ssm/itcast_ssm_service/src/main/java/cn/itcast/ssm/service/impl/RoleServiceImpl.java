package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.dao.RoleDao;
import cn.itcast.ssm.domain.Permission;
import cn.itcast.ssm.domain.Role;
import cn.itcast.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:xiexun
 * @date:2018/11/15
 * @time:15:09
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    public List<Role> findAll() {
        return roleDao.findAll();
    }

    public void save(Role role) {
        roleDao.save(role);
    }

    public Role findById(String roleId) {
        return roleDao.findByRoleId(roleId);
    }

    public List<Permission> findOtherPermissions(String roleId) {
        return roleDao.findOtherPermissions(roleId);
    }

    public void addPermissionToRole(String[] permissionIds,String roleId) {
        for (String permissionId : permissionIds) {
            roleDao.addPermissionToRole(permissionId,roleId);
        }
    }
}

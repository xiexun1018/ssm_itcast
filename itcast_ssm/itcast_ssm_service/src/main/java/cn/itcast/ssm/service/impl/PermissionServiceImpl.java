package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.dao.PermissionDao;
import cn.itcast.ssm.domain.Permission;
import cn.itcast.ssm.domain.Role;
import cn.itcast.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:xiexun
 * @date:2018/11/15
 * @time:15:40
 */
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;
    public List<Permission> findAll() {
        return permissionDao.findAll();
    }

    public void save(Permission permission) {
        permissionDao.save(permission);
    }

    public List<Role> findByRoleId(String roleId) {
        return permissionDao.findByRoleId(roleId);
    }
}

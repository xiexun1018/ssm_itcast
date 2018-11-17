package cn.itcast.ssm.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author:xiexun
 * @date:2018/11/14
 * @time:10:44
 */
public class Role implements Serializable {
    private String id;
    private String roleName;
    private String roleDesc;
    private List<Permission> permissions;
    private List<Users> users;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }
}

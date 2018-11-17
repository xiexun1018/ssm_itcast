package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Role;
import cn.itcast.ssm.domain.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author:xiexun
 * @date:2018/11/14
 * @time:11:37
 */
public interface UserDao {
    Users findByUsername(String username);
    List<Users> findAll();
    void save(Users users);

    Users findById(String id);

    List<Role> findOtherRoles(String userId);

    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);
}

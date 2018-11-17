package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.Role;
import cn.itcast.ssm.domain.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    public List<Users> findAll();
    void save(Users users);
    Users findById(String id);

    List<Role> findOtherRoles(String userId);

    void addRoleToUser(String userId, String[] roleId);
}

package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.dao.UserDao;
import cn.itcast.ssm.domain.Role;
import cn.itcast.ssm.domain.Users;
import cn.itcast.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:xiexun
 * @date:2018/11/14
 * @time:11:26
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userDao.findByUsername(username);
        //"{noop}" +
        User user = new User(users.getUsername(), /*"{noop}" +*/ users.getPassword(), users.getStatus() == 0 ? false : true, true, true, true, getAuthority(users.getRoles()));
        //User user = new User(users.getUsername(), users.getPassword(), users.getStatus() == 0 ? false : true, true, true, true, getAuthority(users.getRoles()));
        return user;
    }

    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }

    public List<Users> findAll() {
        return userDao.findAll();
    }

    public void save(Users users) {
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        userDao.save(users);
    }

    public Users findById(String id){
        return userDao.findById(id);
    }

    public List<Role> findOtherRoles(String userId) {
        return userDao.findOtherRoles(userId);
    }

    public void addRoleToUser(String userId, String[] roleId) {
        for (String s : roleId) {
            userDao.addRoleToUser(userId,s);
        }
    }


}

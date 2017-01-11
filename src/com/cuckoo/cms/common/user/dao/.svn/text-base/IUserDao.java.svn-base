package com.cuckoo.cms.common.user.dao;

import java.util.List;

import com.cuckoo.cms.common.user.pojo.Authority;
import com.cuckoo.cms.common.user.pojo.Role;
import com.cuckoo.cms.common.user.pojo.User;
import com.cuckoo.cms.common.user.pojo.req.UserAddReq;
import com.cuckoo.cms.common.user.pojo.req.UserReq;
/**
 * 
 * @author tsx270129
 *
 */
public interface IUserDao {
User login(UserReq userReq);
List<Authority> getAllResource(User user);

List<Role> getRoles(User user);

List<Authority> getResourceByRole(Role role);

int editUser(UserAddReq addReq);

}

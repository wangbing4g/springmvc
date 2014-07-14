/**
 * 
 */
package com.ceair.springmvc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import c.c.p.web.search.SimpleSpecifications;

import com.ceair.springmvc.dao.UserDao;
import com.ceair.springmvc.dto.UserSearchDto;
import com.ceair.springmvc.entity.User;

/**
 * @author Administrator
 *
 */
@Component
@Transactional
public class UserService {
	
	private static Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserDao userDao;
	
	public void doAddUser(User user) {
		userDao.save(user);
	}
	
	public User getUser(Long id) {
		return userDao.findOne(id);
	}
	
	public void doUpdateUser(User user) {
		
		User oldUser = getUser(user.getId());
		BeanUtils.copyProperties(user, oldUser);
		userDao.save(oldUser);
		
	}
	
	public void doDeleteUser(Long id) {
	    userDao.delete(id);
	}
	
	public Page<User> queryUser(final UserSearchDto userSearchDto,Pageable pageRequest) {
		LOG.debug("Search page users");
		return userDao.findAll(SimpleSpecifications.bySearchDto(userSearchDto, User.class), pageRequest);
	}

}

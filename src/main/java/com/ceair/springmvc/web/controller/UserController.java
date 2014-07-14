/**
 * 
 */
package com.ceair.springmvc.web.controller;

import javax.servlet.ServletRequest;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import c.c.p.web.paging.SpringPagingUtils;
import c.c.p.web.paging.PagingExecute;

import com.ceair.springmvc.dto.UserSearchDto;
import com.ceair.springmvc.entity.User;
import com.ceair.springmvc.service.UserService;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/*@RequestMapping(value="/list",method = RequestMethod.GET)
	@ResponseBody
	public Page<User> queryPageUserJson(final UserSearchDto userSearchDto,ServletRequest request) {
		
		return SpringPagingUtils.pagingData(request,new PagingExecute<User>() {
			
			@Override
			public Page<User> execute(PageRequest pageRequest) {
				return userService.queryUser(userSearchDto, pageRequest);
			}
		});
	}*/
	
	@RequestMapping(method = RequestMethod.GET)
	public String queryPageUser(final UserSearchDto userSearchDto, ServletRequest request) {
		
		
		SpringPagingUtils.paging(request,new PagingExecute<User>() {
			
			@Override
			public Page<User> execute(PageRequest pageRequest) {
				return userService.queryUser(userSearchDto, pageRequest);
			}
		});
		
		return "user/userList";
		
	}
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String createForm(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("action", "create");
		return "user/userForm";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(@Valid User newUser, RedirectAttributes redirectAttributes) {
	    userService.doAddUser(newUser);
		redirectAttributes.addFlashAttribute("message", "创建用户成功");
		return "redirect:/user/";
	}

	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") Long id, Model model) {
		
		model.addAttribute("user", userService.getUser(id));
		model.addAttribute("action", "update");
		return "user/userForm";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@Valid User user, RedirectAttributes redirectAttributes) {
	    
	    userService.doUpdateUser(user);
		redirectAttributes.addFlashAttribute("message", "更新用户成功");
		return "redirect:/user/";
	}

	@RequestMapping(value = "delete/{id}" ,method=RequestMethod.GET)
	public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		userService.doDeleteUser(id);
		redirectAttributes.addFlashAttribute("message", "删除用户成功");
		return "redirect:/user/";
	}

}

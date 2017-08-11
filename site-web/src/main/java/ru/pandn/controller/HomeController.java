package ru.pandn.controller;

import org.apache.tiles.request.servlet.ServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.pandn.model.User;
import ru.pandn.model.UserList;
import ru.pandn.service.impl.UserServiceImpl;

import static ru.pandn.view.ViewNames.ADD_USER;
import static ru.pandn.view.ViewNames.DELETE_USER;
import static ru.pandn.view.ViewNames.MAIN_ACTION;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	UserServiceImpl userService;

	@RequestMapping(value = MAIN_ACTION, method = RequestMethod.GET)
	public String getIndexPage(Model model) {
		logger.info("getIndexPage()");
		UserList users = userService.getUsers();
		model.addAttribute("users",users);
		model.addAttribute("user_create",new User());

		return MAIN_ACTION;
	}

	@RequestMapping(value = MAIN_ACTION + "/{userId}", method = RequestMethod.GET)
	public String getUserPage(@PathVariable("userId") final Integer userId,
							   Model model) {
		logger.info("getUserPage(); userId:{}",userId);
		User user = userService.getUserById(userId);
		model.addAttribute("user",user);
		return MAIN_ACTION;

	}

	@RequestMapping(value = ADD_USER, method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") final User user,
						  Model model){
		logger.info("addUser(); user:{}",user);
		userService.addNewUser(user);
		return "redirect:"+MAIN_ACTION;
	}

	@RequestMapping(value = DELETE_USER + "/{userId}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("userId") final Integer userId,
							 Model model){
		logger.info("deleteUser(); userId:{}",userId);
		userService.deleteUser(userId);
		return "redirect:"+MAIN_ACTION;
	}


	
}

package mx.ipn.cic.SpringExample.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mx.ipn.cic.SpringExample.model.UserModel;
import mx.ipn.cic.SpringExample.services.IUserService;

@Controller
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	private IUserService userService;

	private Log logger = LogFactory.getLog(UserController.class);

	@PostMapping("/register")
	public String userSubmit(@Validated @ModelAttribute(name = "user") UserModel user) {

		logger.info(user);

		this.userService.create(user);

		return "redirect:/user/all";
	}

	@GetMapping(path = "/userForm")
	public ModelAndView getForm() {

		ModelAndView mav = new ModelAndView("user_form", "user", new UserModel());

		return mav;

	}

	@GetMapping(path = "/all")
	public ModelAndView getAll() {

		List<UserModel> userList = this.userService.findAll();

		ModelAndView mav = new ModelAndView("user_list");
		mav.addObject("users", userList);

		return mav;

	}
	
	@GetMapping(path="/{id}/delete")
	public String delete(
			@PathVariable(name="id") int id
			) {
		
		this.userService.deleteById(id);
		
		return "redirect:/user/all";
		
	}

}















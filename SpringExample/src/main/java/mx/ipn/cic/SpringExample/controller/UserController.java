package mx.ipn.cic.SpringExample.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mx.ipn.cic.SpringExample.model.UserModel;

@Controller
@RequestMapping(path = "/user")
public class UserController {

	private Log logger = LogFactory.getLog(UserController.class);

	@GetMapping(path = "/userForm")
	public ModelAndView getForm() {

		ModelAndView mav = new ModelAndView("user_form", "user", new UserModel());

		return mav;

	}

	@PostMapping("/register")
	public String userSubmit(
			@Validated @ModelAttribute(name = "user") UserModel user
			) {

		logger.info(user);

		return "success";
	}

}







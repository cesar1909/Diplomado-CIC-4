package mx.ipn.cic.biblioteca.AdminControl.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String welcome() {

		return "welcome";

	}

	@RequestMapping("/mav")
	public ModelAndView indexMAV() {

		ModelAndView mav = new ModelAndView("index");
		mav.addObject("saludo", "Este es un parámetro");

		return mav;

	}

}

package mx.ipn.cic.SpringExample.controller;

import javax.servlet.ServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/user")
public class DemoController {

	private Log logger = LogFactory.getLog(DemoController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String index(@RequestParam(name = "name") String nombre) {

		// System.out.println("Hola Mundo desde Spring");
		logger.info("Hola Mundo desde Spring!!");

		return "demo/hello";

	}

	@RequestMapping(method = RequestMethod.POST)
	public String index(ServletRequest request) {

		// System.out.println("Hola Mundo desde Spring");
		logger.info("Hola Mundo desde Spring!!");

		logger.info("Parametro Name: " + request.getParameter("name"));

		return "demo/hello";

	}

	@RequestMapping(path = "/hello", method = RequestMethod.GET)
	public String handleGet() {

		// System.out.println("Hola Mundo desde Spring");
		logger.info("Hola Mundo desde Spring!!");

		return "hello";

	}

	@RequestMapping(path = "/hello", method = RequestMethod.POST)
	public String manejarPost() {

		logger.info("Hola Mundo desde Spring!!");

		return "hello";

	}

	@RequestMapping(path = "/hello", method = RequestMethod.PUT)
	public String receivePut() {

		logger.info("Hola Mundo desde Spring!!");

		return "hello";

	}

	@RequestMapping(path = "/hello", method = RequestMethod.DELETE)
	public String borra() {

		logger.info("Hola Mundo desde Spring!!");

		return "hello";

	}

	@PostMapping(path = "/test")
	public ModelAndView test() {

		ModelAndView mav = new ModelAndView("demo/hello");

		mav.addObject("message", "Bienvenido Manuel");

		return mav;
	}

}









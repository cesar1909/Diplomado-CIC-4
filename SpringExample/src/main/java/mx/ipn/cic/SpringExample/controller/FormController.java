package mx.ipn.cic.SpringExample.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/form")
public class FormController {

	private Log logger = LogFactory.getLog(FormController.class);

	@GetMapping(path = "/getForm")
	public String getForm(
			@RequestParam(name = "param1",required=false) String param,
			@RequestParam(name = "param2") String param2
			) {

		logger.info("Parámetro: " + param);

		return "form_example";
	}
	
	
	@PostMapping(path="/{path}")
	public String postForm(
			@PathVariable(name="path") String path
			) {
		
		logger.info("Path:" + path);
		
		return "form_example";
	}
	
	@PostMapping(path="/{path}/dinamico")
	public String postFormDinamico(
			@PathVariable String path,
			@RequestParam(name="param2") String param2
			) {
		
		logger.info("Path:" + path);
		logger.info("Param2:" + param2);
		
		return "form_example";
		
	}
	

}

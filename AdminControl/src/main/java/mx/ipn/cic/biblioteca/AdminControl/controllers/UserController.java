package mx.ipn.cic.biblioteca.AdminControl.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mx.ipn.cic.biblioteca.AdminControl.model.UserModel;
import mx.ipn.cic.biblioteca.AdminControl.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(path = "")
	public String redirectToAll() {
		return "redirect:/user/all";
	}

	// @RequestMapping(path = "/newUserForm",
	// method = RequestMethod.GET)
	@GetMapping(path = "/newForm")
	public ModelAndView newUserForm() {

		ModelAndView mav = new ModelAndView("users/newForm", "userModel", new UserModel());

		return mav;

	}

	@GetMapping(path = "/all")
	public ModelAndView allUsers() {

		List<UserModel> findAll = this.userService.findAll();

		ModelAndView mav = new ModelAndView("users/all");
		mav.addObject("users", findAll);

		return mav;

	}

	@PostMapping(path = "/register")
	public String register(@RequestParam(name = "name") String name, @RequestParam(name = "lastnameP") String lastnameP,
			@RequestParam(name = "lastnameM") String lastnameM, @RequestParam(name = "age") int age,
			@RequestParam(name = "address") String address, @RequestParam(name = "id", required = false) Integer id) {

		// Proceso de registro

		UserModel user = new UserModel(id, name, lastnameP, lastnameM, age, address);

		if (id == null) {
			this.userService.register(user);
		} else {
			this.userService.edit(user);
		}

		return "redirect:/user/all";

	}

	@GetMapping(path = "/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Integer identificador) {

		UserModel userFound = this.userService.findById(identificador);
		ModelAndView mav = new ModelAndView("users/newForm", "userModel", userFound);
		return mav;

	}

	@GetMapping(path = "/delete/{id}")
	public String delete(@PathVariable("id") Integer idToDelete) {

		this.userService.delete(idToDelete);

		return "redirect:/user/all";

	}

	@GetMapping(path="/search")
	public ModelAndView search(
			@RequestParam(name="name", required=false) String name,
			@RequestParam(name="lastnameP", required=false) String lastnameP,
			@RequestParam(name="lastnameM", required=false) String lastnameM
			) {
				
		List<UserModel> searchResult = 
				this.userService.search(name, lastnameP, lastnameM);

		ModelAndView mav = new ModelAndView("users/all");
		mav.addObject("users", searchResult);

		return mav;
		
	}

}

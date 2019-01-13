package mx.ipn.cic.SpringExample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.ipn.cic.SpringExample.model.UserModel;
import mx.ipn.cic.SpringExample.services.IUserService;

@RestController
@RequestMapping(path = "/rest/user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserRestController {

	@Autowired
	@Qualifier(value = "PRODUCCION")
	private IUserService userService;

	@GetMapping(path = "/all")
	public ResponseEntity<List<UserModel>> getAll() {

		List<UserModel> list = this.userService.findAll();

		ResponseEntity<List<UserModel>> response;

		if (list != null) {
			response = new ResponseEntity<>(list, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;

	}

	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<UserModel> findById(@PathVariable(name = "id") Integer id) {

		ResponseEntity<UserModel> response;

		try {

			UserModel user = this.userService.findById(id);

			if (user != null) {
				response = new ResponseEntity<UserModel>(user, HttpStatus.OK);
			} else {
				response = new ResponseEntity<UserModel>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			response = new ResponseEntity<UserModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;

	}

	@PostMapping(path = "/create")
	public ResponseEntity<UserModel> create(@RequestBody UserModel user) {

		ResponseEntity<UserModel> response;

		try {

			user = this.userService.create(user);

			if (user != null) {
				response = new ResponseEntity<UserModel>(user, HttpStatus.CREATED);
			} else {
				response = new ResponseEntity<UserModel>(HttpStatus.NOT_ACCEPTABLE);
			}

		} catch (Exception e) {
			response = new ResponseEntity<UserModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;

	}

	@PutMapping(path = "/update/{id}")
	public ResponseEntity<UserModel> update(@RequestBody UserModel user, @PathVariable(name = "id") Integer id) {

		ResponseEntity<UserModel> response;

		try {

			user.setId(id);

			user = this.userService.update(user);

			if (user != null) {
				response = new ResponseEntity<UserModel>(user, HttpStatus.ACCEPTED);
			} else {
				response = new ResponseEntity<UserModel>(HttpStatus.NOT_ACCEPTABLE);
			}

		} catch (Exception e) {
			response = new ResponseEntity<UserModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;

	}

	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable(name = "id") Integer id) {

		ResponseEntity<Boolean> response;

		try {

			Boolean result = this.userService.deleteById(id);

			if (result) {
				response = new ResponseEntity<>(HttpStatus.ACCEPTED);
			} else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			response = new ResponseEntity<Boolean>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;

	}

}

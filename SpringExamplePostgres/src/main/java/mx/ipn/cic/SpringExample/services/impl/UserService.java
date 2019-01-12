package mx.ipn.cic.SpringExample.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import mx.ipn.cic.SpringExample.model.UserModel;
import mx.ipn.cic.SpringExample.services.IUserService;

@Service//Ignorar este servicio
@Qualifier(value="Testing")
public class UserService implements IUserService {

	private List<UserModel> userList;
	
	private int counter = 1;

	public UserService() {

		this.userList = new ArrayList<UserModel>();

	}

	@Override
	public UserModel findById(Integer id) {

		Optional<UserModel> user = this.userList.stream().filter(u -> u.getId() == id).findFirst();

		if (user.isPresent()) {
			return user.get();
		}

		return null;
		/*
		 * for (UserModel user : this.userList) {
		 * 
		 * if (user.getId() == id) { return user; }
		 * 
		 * }
		 */

	}

	@Override
	public List<UserModel> findAll() {

		return this.userList;
	}

	@Override
	public UserModel create(UserModel user) {

		user.setId(counter++);
		
		this.userList.add(user);

		return user;

	}

	@Override
	public UserModel update(UserModel user) {

		UserModel aux = findById(user.getId());

		aux.setName(user.getName());
		aux.setLastname(user.getLastname());
		aux.setAge(user.getAge());

		return aux;
	}

	@Override
	public boolean deleteById(Integer id) {

		UserModel user = findById(id);

		if (user != null) {

			return this.userList.remove(user);

		}

		return false;
	}

	@Override
	public boolean delete(UserModel user) {

		if (this.userList.contains(user)) {

			return this.userList.remove(user);

		}

		return false;
	}

}

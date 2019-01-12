package mx.ipn.cic.SpringExample.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import mx.ipn.cic.SpringExample.model.UserModel;
import mx.ipn.cic.SpringExample.repository.UserJPARepository;
import mx.ipn.cic.SpringExample.services.IUserService;

@Service
@Qualifier(value = "PRODUCCION")
public class UserServiceDB implements IUserService {

	@Autowired
	private UserJPARepository repository;

	@Override
	public UserModel findById(Integer id) {

		Optional<UserModel> user = this.repository.findById(id);

		if (user.isPresent()) {
			return user.get();
		}

		return null;

	}

	@Override
	public List<UserModel> findAll() {

		return this.repository.findAll();

	}

	@Override
	public UserModel create(UserModel user) {

		return this.repository.save(user);

	}

	@Override
	public UserModel update(UserModel user) {

		return this.repository.save(user);

	}

	@Override
	public boolean deleteById(Integer id) {

		try {
			this.repository.deleteById(id);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	@Override
	public boolean delete(UserModel user) {

		this.repository.delete(user);

		return true;
	}

}

package mx.ipn.cic.SpringExample.services;

import java.util.List;

import mx.ipn.cic.SpringExample.model.UserModel;

public interface IUserService {
	
	UserModel findById(Integer id);
	
	List<UserModel> findAll();
	
	UserModel create(UserModel user);
	
	UserModel update(UserModel user);
	
	boolean deleteById(Integer id);
	
	boolean delete(UserModel user);

}

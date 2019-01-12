package mx.ipn.cic.SpringExample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.ipn.cic.SpringExample.model.UserModel;

@Repository
public interface UserJPARepository 
		extends JpaRepository<UserModel, Integer> {

}

package mx.ipn.cic.biblioteca.AdminControl.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.ipn.cic.biblioteca.AdminControl.model.UserModel;
import java.lang.String;

@Repository
public interface IUserRepository extends JpaRepository<UserModel, Integer> {

	List<UserModel> findByNameContainingOrLastnamePContainingOrLastnameMContaining(
			String name,
			String lastnameP,
			String lastnameM
			);

}

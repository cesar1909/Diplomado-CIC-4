package mx.ipn.cic.biblioteca.AdminControl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.ipn.cic.biblioteca.AdminControl.model.LoanModel;

@Repository
public interface ILoanRepository extends JpaRepository<LoanModel, Integer> {

}

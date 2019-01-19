package mx.ipn.cic.biblioteca.AdminControl.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.ipn.cic.biblioteca.AdminControl.model.BookModel;

@Repository
public interface IBookRepository extends JpaRepository<BookModel, Integer> {

	List<BookModel> findByStockGreaterThan(int stock);
	
	List<BookModel> findByAuthorContaining(String author);
	
	List<BookModel> findByTitleContaining(String title);
	
}

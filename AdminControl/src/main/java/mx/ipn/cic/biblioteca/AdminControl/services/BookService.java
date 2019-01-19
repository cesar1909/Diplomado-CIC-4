package mx.ipn.cic.biblioteca.AdminControl.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.ipn.cic.biblioteca.AdminControl.model.BookModel;
import mx.ipn.cic.biblioteca.AdminControl.repositories.IBookRepository;

@Service
public class BookService {

	@Autowired
	private IBookRepository repository;

	public BookModel register(BookModel newBook) {

		return this.repository.save(newBook);

	}

	public BookModel findById(Integer id) {

		Optional<BookModel> found = this.repository.findById(id);
		
		try {
			return found.get();
		} catch (NoSuchElementException e) {
			System.out.println("No se encontró el elemento");
		}

		return null;
		
	}

	public List<BookModel> findAll() {
		
		return this.repository.findAll();
		
	}
	
	public List<BookModel> findAllAvailable(){
		
		return this.repository.findByStockGreaterThan(0);
		
	}

	public boolean delete(Integer idToDelete) {

		this.repository.deleteById(idToDelete);
		
		return true;

	}

	public BookModel edit(BookModel bookModel) {

		return this.repository.save(bookModel);
		
	}

}

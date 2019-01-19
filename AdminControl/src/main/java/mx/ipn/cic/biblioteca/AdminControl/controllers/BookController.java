package mx.ipn.cic.biblioteca.AdminControl.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mx.ipn.cic.biblioteca.AdminControl.model.BookModel;
import mx.ipn.cic.biblioteca.AdminControl.services.BookService;

@Controller
@RequestMapping(path = "/book")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping(path="")
	public String redirectToAll() {
		return "redirect:/book/all";
	}
	
	@GetMapping(path = "/all")
	public ModelAndView allBooks() {

		List<BookModel> books = this.bookService.findAll();

		ModelAndView mav = new ModelAndView("books/allBooks");
		mav.addObject("books", books);

		return mav;

	}

	@GetMapping(path = "/newForm")
	public ModelAndView newBookForm() {

		ModelAndView mav = new ModelAndView(
				"books/newBookForm",
				"bookModel",
				new BookModel());

		return mav;

	}

	// @PostMapping(path = "/register")
	// public String register(BookModel newBook) {
	//
	// System.out.println(newBook);
	//
	// return "redirect:/book/all";
	//
	// }

	@PostMapping(path = "/register")
	public String register(@ModelAttribute(name = "bookModel") 
										BookModel bookModel) {

		if (bookModel.getId() == null || bookModel.getId() == 0) {
			
			this.bookService.register(bookModel);
			
		} else {
			
			this.bookService.edit(bookModel);
			
		}

		System.out.println(bookModel);

		return "redirect:/book/all";

	}

	@GetMapping(path = "/edit/{id}")
	public ModelAndView edit(@PathVariable("id") 
									Integer identificador) {

		BookModel bookFound = 
				this.bookService.findById(identificador);
		ModelAndView mav = 
				new ModelAndView("books/newBookForm", 
						"bookModel", 
						bookFound);
		return mav;

	}

	@GetMapping(path = "/delete/{id}")
	public String delete(@PathVariable("id") 
								Integer idToDelete) {

		this.bookService.delete(idToDelete);
		
		return "redirect:/book/all";

	}

}

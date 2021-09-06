package fi.server2021.Bookstore.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.server2021.Bookstore.domain.Book;

@Controller
public class BookController {
	
	ArrayList<Book> books = new ArrayList<>();
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String bookstore(Model model) {
		return null;
	}

}

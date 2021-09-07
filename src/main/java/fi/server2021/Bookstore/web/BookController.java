package fi.server2021.Bookstore.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fi.server2021.Bookstore.domain.Book;

@Controller
public class BookController {
	
	ArrayList<Book> books = new ArrayList<>();
	
	@GetMapping("/index")
	public String bookstore(Model model) {
		return null;
	}

}

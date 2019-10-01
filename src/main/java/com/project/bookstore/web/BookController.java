package com.project.bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.bookstore.domain.Book;
import com.project.bookstore.domain.BookRepository;
import com.project.bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository catRepository;
	
	@RequestMapping(value= {"/", "/booklist"})
	public String studentList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	@RequestMapping(value = "/add")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
    	model.addAttribute("categories", catRepository.findAll());
        return "addbook";
    }     
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        repository.save(book);
        return "redirect:booklist";
    } 
	
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	repository.deleteById(bookId);
        return "redirect:../booklist";
    }
    
    @RequestMapping(value = "/edit/{id}")
    public String editBook(@PathVariable("id") Long bookId,Model model){
    	model.addAttribute("book", repository.findById(bookId));
    	model.addAttribute("categories", catRepository.findAll());
        return "editbook";
    }
    
    @RequestMapping(value = "/edit/update", method = RequestMethod.POST)
    public String edit(Book book){
        repository.save(book);
        return "redirect:../booklist";
    } 
    
    @RequestMapping(value = "/api", method = RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest() {
    	return (List<Book>)repository.findAll();
    }
    
    @RequestMapping(value = "/api/{id}", method = RequestMethod.GET)
    public @ResponseBody Book findBookRest(@PathVariable("id") Long bookId) {
    	return repository.findById(bookId).get();
    }
	
}

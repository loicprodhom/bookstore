package com.project.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.bookstore.domain.Book;
import com.project.bookstore.domain.BookRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@RequestMapping(value= {"/", "/booklist"})
	public String studentList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	@RequestMapping(value = "/add")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
        return "addbook";
    }     
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        repository.save(book);
        return "redirect:booklist";
    } 
	
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable("id") Long bookId, Model model) {
    	repository.deleteById(bookId);
        return "redirect:../booklist";
    }
    
    @RequestMapping(value = "/edit/{id}")
    public String editBook(@PathVariable("id") Long bookId,Model model){
    	model.addAttribute("book", repository.findById(bookId));
        return "editbook";
    }
    
    @RequestMapping(value = "/edit/update", method = RequestMethod.POST)
    public String edit(Book book){
        repository.save(book);
        return "redirect:../booklist";
    } 
	
}

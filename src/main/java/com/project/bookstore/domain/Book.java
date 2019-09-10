package com.project.bookstore.domain;
import javax.persistence.*;

@Entity
public class Book {
	// title, author, year, isbn, price 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String title, author, isbn;
	private int year;
	private double price;
	
	public Book(String title, String author, String isbn, int year, double price) {
		this.title=title;
		this.author=author;
		this.isbn=isbn;
		this.year=year;
		this.price=price;
	}
	
	@Override
	public String toString() {
		return "Book id="+id+", title="+title+", author="+author+", isbn="+isbn+", year="+year+", price="+price;
	}
}

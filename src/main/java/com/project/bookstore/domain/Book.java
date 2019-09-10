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
	
	public Book() {}
	
	public Book(String title, String author, String isbn, int year, double price) {
		this.title=title;
		this.author=author;
		this.isbn=isbn;
		this.year=year;
		this.price=price;
	}
	
	public Book(String title, String author, String isbn, int year) {
		this.title=title;
		this.author=author;
		this.isbn=isbn;
		this.year=year;
	}
	
	public long getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public int getYear() {
		return year;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	@Override
	public String toString() {
		return "Book id="+id+", title="+title+", author="+author+", isbn="+isbn+", year="+year+", price="+price;
	}
}

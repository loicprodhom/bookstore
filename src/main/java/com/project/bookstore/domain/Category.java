package com.project.bookstore.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long categoryId;
	private String name;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Book> books;
	
	public Category() {	}
	
	public Category(String name, List<Book> books) {
		super();
		this.name=name;
		this.books=books;
	}
	
	public Category(String name) {
		super();
		this.name=name;
		this.books=new ArrayList<Book>();
	}
	
	public List<Book> getBooks() {
		return books;
	}
	
	public long getCategoryId() {
		return categoryId;
	}
	
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	public void setCategoryId(long category_id) {
		this.categoryId = category_id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}

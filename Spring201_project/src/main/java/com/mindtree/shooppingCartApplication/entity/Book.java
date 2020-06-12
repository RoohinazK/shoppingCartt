package com.mindtree.shooppingCartApplication.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@DiscriminatorValue("book")  
public class Book extends Product{
	
	@Column
	private String bookName;
	
	@Column
	private String bookGenre;
	
	@Column
	private String bookPublisher;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Book( String bookName, String bookGenre, String bookPublisher) {
		super();
		this.bookName = bookName;
		this.bookGenre = bookGenre;
		this.bookPublisher = bookPublisher;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookGenre() {
		return bookGenre;
	}

	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}

	public String getBookPublisher() {
		return bookPublisher;
	}

	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}
	
	
}

package com.test.data;

import java.util.ArrayList;
import java.util.List;

public class Livre {

	public static List<Livre> db = new ArrayList<>();
	
	private String title;
	
	private String Author;
	
	private int price;

	public Livre(String title, String author, int price) {
		super();
		this.title = title;
		Author = author;
		this.price = price;
	}

	public Livre() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}

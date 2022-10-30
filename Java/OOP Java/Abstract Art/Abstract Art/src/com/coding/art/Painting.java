package com.coding.art;

public class Painting extends Art {
	private String paintType;
	
	public Painting(String title, String author, String description, String paintType) {
		super(title, author, description);
		this.paintType = paintType;
	}
	
	public String getPainType() {
		return paintType;
	}
	
	public void setPaintType(String paintType) {
		this.paintType = paintType;
	}
	
	public void viewArt() {
		System.out.println("Paint Title is: "+ this.getTitle());
		System.out.println("Paint Author is: "+ this.getAuthor());
		System.out.println("Paint Description is: "+ this.getDescription());
		System.out.println("Paint Type is: "+this.getPainType());
	}
}

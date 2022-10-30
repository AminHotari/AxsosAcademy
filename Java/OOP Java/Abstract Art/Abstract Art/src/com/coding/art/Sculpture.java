package com.coding.art;

public class Sculpture extends Art {
	private String material;

	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	
	public Sculpture(String title, String author, String description, String material) {
		super(title, author, description);
		this.material = material;
	}
	
	public void viewArt() {
		System.out.println("Sculpture Title is: "+ this.getTitle());
		System.out.println("Sculpture Author is: "+ this.getAuthor());
		System.out.println("Sculpture Description is: "+ this.getDescription());
		System.out.println("Sculpture Material is: "+ this.getMaterial());
	}
}

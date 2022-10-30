package com.coding.art;
import java.util.ArrayList;
import java.util.Collections;

public class Museum {

	public static void main(String[] args) {
		Painting paint = new Painting("Palestine","Amin","The Real","Acrylic");
		Painting paint1 = new Painting("Jordan","Ahmad","The One","Watercolor");
		Painting paint2 = new Painting("Mist","Amr","Nice","Oil");
		
		Sculpture sculpture = new Sculpture("Jerusalem","Rami","Favorite","Bronze");
		Sculpture sculpture1 = new Sculpture("Cave","Sami","Good","Marble");
		
		System.out.println(paint.getAuthor());
		System.out.println(sculpture.getMaterial());
		
		ArrayList<Art> museum = new ArrayList<Art>();
		
		museum.add(paint);
		museum.add(paint1);
		museum.add(paint2);
		
		museum.add(sculpture);
		museum.add(sculpture1);
		
		Collections.shuffle(museum);
		
		for(Art art : museum) {
			art.viewArt();
		}
		
		

	}

}

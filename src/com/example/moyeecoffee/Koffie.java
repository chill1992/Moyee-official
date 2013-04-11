package com.example.moyeecoffee;

import android.graphics.Bitmap;

public class Koffie {
	private String naam;
	private String prijs;
	private String gewicht;
	private String beschrijving;
	private Bitmap afbeelding;
	private String id;
	//private ArrayList<PointOfSale> bijWelkePointOfSaleVerkocht;
	
	Koffie(String naam, String prijs, String gewicht, String beschrijving, Bitmap afbeelding, String id){
		this.naam = naam;
		this.prijs = prijs;
		this.gewicht = gewicht;
		this.beschrijving = beschrijving;
		this.afbeelding = afbeelding;
		this.id = id;
		//this.bijWelkePointOfSaleVerkocht = bijWelkePointOfSaleVerkocht;
	}
	
	public String getNaam(){
		return naam;
	}
	
	public String getPrijs(){
		return prijs;
	}
	
	public String getGewicht(){
		return gewicht;
	}
	
	public String getBeschrijving(){
		return beschrijving;
	}
	
	public Bitmap getAfbeelding(){
		return afbeelding;
	}
	
	public String getId(){
		return id;
	}
	
	//private ArrayList<PointOfSale> getBijWelkePointOfSalesVerkocht(){
	//	return bijWelkePointOfSaleVerkocht;
	//}
}

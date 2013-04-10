package com.example.moyeecoffee;

import java.util.ArrayList;

public class PointOfSale 
{
	private String naam;
	private String adress;
	// Latitude en longitude gegevens zijn nodig om de Point of Sale te kunnen weergeven op Google Maps.
	private double latitude;
	private double longitude;
	// In deze lijst komen de koffies te staan die dit Point of Sale verkoopt.
	private ArrayList<Koffie> koffieAssortiment;
	
	public PointOfSale(String naam, String adress, double latitude, double longitude, ArrayList<Koffie> koffieAssortiment)
	{
		this.naam = naam;
		this.adress = adress;
		this.latitude = latitude;
		this.longitude = longitude;
		this.koffieAssortiment = koffieAssortiment;
	}
	
	// Geef de naam van de Point of Sale.
	public String getNaam()
	{
		return this.naam;
	}
	
	// Geef het adress van de Point of Sale.
	public String getAdress()
	{
		return this.adress;
	}

	// Geef de latitude van de Point of Sale.
	public double getLatitude()
	{
		return this.latitude;
	}
	
	// Geef de longitude van de Point of Sale.
	public double getLongitude()
	{
		return this.longitude;
	}
	
	// Geef get koffieassortiment van de Point of Sale.
	public ArrayList<Koffie> getKoffieAssortiment()
	{
		return this.koffieAssortiment;
	}

}

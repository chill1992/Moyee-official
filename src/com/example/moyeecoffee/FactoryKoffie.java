package com.example.moyeecoffee;

import java.util.ArrayList;

public class FactoryKoffie {
	ArrayList<Koffie> koffieLijst;
	
	private static FactoryKoffie instance = null; //test jonathan
	
	private FactoryKoffie()
	{
		koffieLijst = new ArrayList<Koffie>();
		
		//voeg koffie toe, dit moet misschien in een andere klasse staan		
//		voegKoffieToe(new Koffie("afrikaanse koffie", "5,00", null, null, null, null));
//		voegKoffieToe(new Koffie("dark roasted koffie", "1,00", null, null, null, null));
	}
	
	public static FactoryKoffie get()
	{
		if(instance == null)
			instance = new FactoryKoffie();
		
		return instance;
	}
	
	public void voegKoffieToe(Koffie koffie){
		koffieLijst.add(koffie);
	}
	
	//krijg de koffie met het ingevoerde adres
	public Koffie getKoffie(String adres){
		Koffie koffie = null;
		
		for(int i = 0; i<koffieLijst.size(); i++){
			//if(koffieLijst.get(i))
		}
		
		return koffie;
	}
	
	public ArrayList<Koffie> getKoffieLijst(){
		return koffieLijst;
	}
}

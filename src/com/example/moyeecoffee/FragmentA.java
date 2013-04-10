package com.example.moyeecoffee;


import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class FragmentA extends Fragment 
{
	private ArrayList<PointOfSale> pointsOfSale;
	private WebView browser;
	private View mContentView;

@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup group, Bundle saved)
	{
		mContentView = inflater.inflate(R.layout.frag_a, group, false);
	    browser = (WebView)mContentView.findViewById(R.id.webview);
		pointsOfSale = new ArrayList<PointOfSale>();
		
		// Navigatie binnen de pagina dient plaats te vinden binnen dezelfde webview.
		// Dus we stellen een nieuwe webclient in.
		browser.setWebViewClient(new WebViewClient());
		
		// Stel via de websettings in dat javascript uitgevoerd kan worden.
		WebSettings settings = browser.getSettings();
		settings.setJavaScriptEnabled(true);
		
		// Maak de Points of Sale, deze kunnen eventueel in een database worden geplaatst.
		PointOfSale pos1 = new PointOfSale("Stach", "Van Woustraat 154", 52.352682, 4.902842, null);
		PointOfSale pos2 = new PointOfSale("Stach", "Nieuwe Spiegelstraat 52", 52.363467, 4.888659, null);

		// Voeg de Point of Sales ook toe aan de pointsOfSale arraylist om later dynamisch een url op te bouwen.
		pointsOfSale.add(pos1);
		pointsOfSale.add(pos2);
		
		// Maak de dynamische url om mee te geven aan de webview. 
				// Er wordt per Point of Sale een stuk een de dynamicURL toegevoegt.
				String dynamicURL = "http://www.gijs-de-jong.nl/googlemap.html?";
				boolean isEerstePointOfSale = true;
				for(int i = 0; i < pointsOfSale.size() ; i++)
				{
					String urlPerPointOfSale = "";
					// Laat bij de eerste Point of Sale het '&' teken weg.
					if(!isEerstePointOfSale)
					{
						urlPerPointOfSale += "&";
					}
					urlPerPointOfSale += "q=" + pointsOfSale.get(i).getNaam() + "<br>" + pointsOfSale.get(i).getAdress() + "@" + pointsOfSale.get(i).getLatitude() + "," + pointsOfSale.get(i).getLongitude();
					// Voeg de URL toe aan de dynamicURL.
					dynamicURL += urlPerPointOfSale;
					// Maak de variabele isEerstePointOfSale false zodat er in het vervolg wel het '&' teken bij komt.
					// Dit is nodig om meerdere Points of Sale te laten zien.
					// En dat willen we!
					isEerstePointOfSale = false;
				}
				// Laadt de dynamicURL in de browser. Deze geeft nu de Google Maps weer.
				browser.loadUrl(dynamicURL);
	    
		return mContentView;
	}

@Override
	public void onActivityCreated (Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		
	}
}

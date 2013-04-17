package com.example.moyeecoffee;

import com.example.moyeecoffee.R;

<<<<<<< HEAD
=======
import com.example.moyeecoffee.R;

import android.net.Uri;
>>>>>>> parent of ac51377... commit van jonathan
import android.os.Bundle;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v4.app.Fragment;
<<<<<<< HEAD
=======
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager.LayoutParams;
>>>>>>> parent of ac51377... commit van jonathan
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
<<<<<<< HEAD

public class FragmentB extends Fragment 
{
	Button button;
	
@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup group, Bundle saved)
	{	
		return inflater.inflate(R.layout.frag_b, group, false);
	}

@Override
	public void onActivityCreated (Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		
	}
=======
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.EditText;

public class FragmentB extends Fragment {
	private Preferences preferences;
	private EditText naamEditText = null;
	private EditText emailEditText = null;
	private String naam;
	private String email;
	private int scherm;
	private boolean koffiesToegevoegd;
	private ArrayList<Integer> aantallen;
	private View hoofdschermContentView, invoerSchermContentView, bevestigBestellingContentView;
	private final int hoofdScherm = 1, invoerScherm = 2, bevestigBestellingScherm = 3;
	private int currentLayout;
	
	public FragmentB(){
		currentLayout = 1;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle sacedInstanceState) {
		
		//hoofdschermContentView = inflater.inflate(R.layout.frag_b, container, false);
		//invoerSchermContentView = inflater.inflate(R.layout.invoer_scherm, container, false);
		//bevestigBestellingContentView = inflater.inflate(R.layout.bevestig_bestelling_scherm, container, false);
		
		
		//return mContentView;
		
//		if(currentLayout == 1){
//			return hoofdschermContentView;
//		}
//		else if(currentLayout == 2){
//			return invoerSchermContentView;
//		}
//		if(currentLayout == 3){
//			return bevestigBestellingContentView;
//		}
		
		return inflater.inflate(R.layout.invoer_scherm, container, false);
	}
	
	
	@Override
	public void onStart() {
		super.onStart();
		
		koffiesToegevoegd = false;
		aantallen = new ArrayList<Integer>();
		
		preferences = new Preferences(getActivity());
		this.naam  = preferences.getString("naam");
		this.email = preferences.getString("email");
		preferences.clearPreferences();
		
		this.scherm = 0;
		
//		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
	}
	
	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void naarHoofdScherm(View view) {
		slaPreferencesOp();
//		FragmentManager fm = getFragmentManager();
//		FragmentTransaction transaction = fm.beginTransaction();
//		transaction.replace(R.layout.activity_main, this);
//		transaction.commit();
//		setContentView(R.layout.activity_main);
		//setContentView(R.layout.activity_main);
		
		this.scherm = 0;
	}
	
	public void naarInvoerScherm(View view) {
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		ft.replace(R.layout.invoer_scherm, this);
		ft.addToBackStack(null);
		ft.commit();
		
//		FragmentManager fm = getFragmentManager();
//		FragmentTransaction transaction = fm.beginTransaction();
//		transaction.replace(R.layout.invoer_scherm, this);
//		transaction.commit();
		
		//getActivity().setContentView(R.layout.invoer_scherm);
		this.scherm = 1;
		
		this.naamEditText = (EditText)this.getView().findViewById(R.id.naamedittext);
		this.emailEditText = (EditText)this.getView().findViewById(R.id.emailedittext);
		
		//geef de tekstvelden de waardes uit naam en email
		this.naamEditText.setText(naam, TextView.BufferType.EDITABLE);
		this.emailEditText.setText(email, TextView.BufferType.EDITABLE);
		
		//vul rijen aan met producten
		TableLayout table = (TableLayout) getView().findViewById(R.id.table);
		ArrayList<Koffie> koffieLijst = FactoryKoffie.get().getKoffieLijst();
		
		for(int i = 0; i<koffieLijst.size(); i++){
			final int iFinal = i;
			TableRow.LayoutParams params = new TableRow.LayoutParams(android.view.ViewGroup.LayoutParams.MATCH_PARENT, android.view.ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f);
			params.topMargin = 2;
			params.bottomMargin = 2;
			
			TableRow row = new TableRow(getActivity());
			
			TextView aantal = new TextView(getActivity());
			aantal.setText("0");
			aantal.setId(i);
			params.rightMargin = 10;
			aantal.setLayoutParams(params);
			
			if(koffiesToegevoegd)
				aantal.setText(Integer.toString(aantallen.get(i)));
			
			else
				aantallen.add(0);
			
			Button knopMin = new Button(getActivity());
			knopMin.setText("-");
			knopMin.setFocusable(true);
			params.weight = 0.0f;
			params.leftMargin = 10;
			knopMin.setLayoutParams(params);
			knopMin.setOnClickListener(new OnClickListener() {
				   @Override
				   public void onClick(View v) {
					   TextView aantal = (TextView)getView().findViewById(iFinal);
					   int aantalInt = Integer.parseInt(aantal.getText().toString());
					   
					   if(aantalInt > 0){
						   --aantalInt;
						   aantal.setFocusable(true);
						   aantal.setText(Integer.toString(aantalInt));
						   aantal.setFocusable(false);
						   
						   aantallen.set(iFinal, aantalInt);
					   }
				   }
			});
			
			TextView knopKoffie = new TextView(getActivity());
			knopKoffie.setText(koffieLijst.get(i).getNaam() + "   prijs: €" + koffieLijst.get(i).getPrijs());
			knopKoffie.setFocusable(false);
			params.weight = 0.5f;
			params.leftMargin = 0;
			knopKoffie.setLayoutParams(params);
			
			Button knopPlus = new Button(getActivity());
			knopPlus.setText("+");
			knopPlus.setFocusable(true);
			params.weight = 0.0f;
			knopPlus.setLayoutParams(params);
			knopPlus.setOnClickListener(new OnClickListener() {
				   @Override
				   public void onClick(View v) {
					   TextView aantal = (TextView)getView().findViewById(iFinal);
					   int aantalInt = Integer.parseInt(aantal.getText().toString());
					   
					   if(aantalInt < 99){
						   ++aantalInt;
						   aantal.setFocusable(true);
						   aantal.setText(Integer.toString(aantalInt));
						   aantal.setFocusable(false);
						   
						   aantallen.set(iFinal, aantalInt);
					   }
				   }
			});
			
			row.addView(knopMin);
			row.addView(knopKoffie);
			row.addView(knopPlus);
			row.addView(aantal);
			
			table.addView(row, 2 + i);
		}
		
		koffiesToegevoegd = true;
	}
	
	public void naarBevestigBestellingScherm(View view){
		slaPreferencesOp();
		
//		setContentView(R.layout.bevestig_bestelling_scherm);
		this.scherm = 2;
	}
	
	public void naarWebShop(View view){
		Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse("http://moyeecoffee.nl/my-account/"));
	    startActivity(browse);
	}
	
	public void bestel(View view){
		boolean heeftIetsBesteld = false;
		
		//mail de bestelling
		String[] to = {"moyee.app@gmail.com"};
		String from = "moyee.app@gmail.com";
		String subject = "Bestelling van " + this.naam;
		String body = "Ik wil graag het volgende bestellen:\n\n";
		
		ArrayList<Koffie> koffieLijst = FactoryKoffie.get().getKoffieLijst();
		
		for(int i = 0; i<koffieLijst.size(); i++){
			if(aantallen.get(i) != 0){
				heeftIetsBesteld = true;
				body += "product: \"" + koffieLijst.get(i).getNaam() + "\" - aantal: \"" + aantallen.get(i) + "\"\n";
			}
		}
		
		if(!heeftIetsBesteld){
			toonFoutMelding("u heeft niks besteld");
			return;
		}
		else if(this.naam.equals("")){
			toonFoutMelding("u heeft geen naam ingevoerd");
			return;
		}
		else if(this.email.equals("")){
			toonFoutMelding("u heeft geen email-adres ingevoerd");
			return;
		}
		
		body += "\nMijn naam is: \"" + this.naam + "\"\nMijn emailadres is: \"" + this.email + "\"";
		
		MailAsyncTask task = new MailAsyncTask(to, from, subject, body);
		task.execute(null,null,null);
		
		//keer terug naar hoofdmenu
		//naarHoofdScherm(this.findViewById(android.R.id.content));
//		setContentView(R.layout.activity_main);
		this.scherm = 0;
	}
	
	private void toonFoutMelding(String foutmelding) {
		
	}

	public void slaPreferencesOp(){
		this.naam = naamEditText.getText().toString();
		preferences.setString("naam", naamEditText.getText().toString());
		this.email = emailEditText.getText().toString();
		preferences.setString("email", emailEditText.getText().toString());
	}
	
	public void onBackPressed() {
		if(scherm == 1)
			naarHoofdScherm(this.getView().findViewById(android.R.id.content));
		
		else if(scherm == 2){
			naarInvoerScherm(this.getView().findViewById(android.R.id.content));
		}
		
		return;
	}
>>>>>>> parent of ac51377... commit van jonathan
}

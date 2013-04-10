package com.example.moyeecoffee;

import com.example.moyeecoffee.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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
}

/*

package com.example.moyeecoffee;

import java.util.ArrayList;

import com.example.koopkoffie.R;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v4.view.ViewPager.LayoutParams;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.EditText;

public class FragmentB extends Activity {
	private Preferences preferences;
	private EditText naamEditText = null;
	private EditText emailEditText = null;
	private String naam;
	private String email;
	private int scherm;
	private boolean koffiesToegevoegd;
	private ArrayList<Integer> aantallen;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		koffiesToegevoegd = false;
		aantallen = new ArrayList<Integer>();
		
		preferences = new Preferences(this);
		this.naam  = preferences.getString("naam");
		this.email = preferences.getString("email");
		preferences.clearPreferences();
		
		setContentView(R.layout.activity_main);
		this.scherm = 0;
		
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void naarHoofdScherm(View view) {
		slaPreferencesOp();
		
		setContentView(R.layout.activity_main);
		this.scherm = 0;
	}
	
	public void naarInvoerScherm(View view) {
		setContentView(R.layout.invoer_scherm);
		this.scherm = 1;
		
		this.naamEditText = (EditText)this.findViewById(R.id.naamedittext);
		this.emailEditText = (EditText)this.findViewById(R.id.emailedittext);
		
		//geef de tekstvelden de waardes uit naam en email
		this.naamEditText.setText(naam, TextView.BufferType.EDITABLE);
		this.emailEditText.setText(email, TextView.BufferType.EDITABLE);
		
		//vul rijen aan met producten
		TableLayout table = (TableLayout) findViewById(R.id.table);
		ArrayList<Koffie> koffieLijst = FactoryKoffie.get().getKoffieLijst();
		
		for(int i = 0; i<koffieLijst.size(); i++){
			final int iFinal = i;
			TableRow.LayoutParams params = new TableRow.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, 1.0f);
			params.topMargin = 2;
			params.bottomMargin = 2;
			
			TableRow row = new TableRow(this);
			
			TextView aantal = new TextView(this);
			aantal.setText("0");
			aantal.setId(i);
			params.rightMargin = 10;
			aantal.setLayoutParams(params);
			
			if(koffiesToegevoegd)
				aantal.setText(Integer.toString(aantallen.get(i)));
			
			else
				aantallen.add(0);
			
			Button knopMin = new Button(this);
			knopMin.setText("-");
			knopMin.setFocusable(true);
			params.weight = 0.0f;
			params.leftMargin = 10;
			knopMin.setLayoutParams(params);
			knopMin.setOnClickListener(new OnClickListener() {
				   @Override
				   public void onClick(View v) {
					   TextView aantal = (TextView)findViewById(iFinal);
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
			
			TextView knopKoffie = new TextView(this);
			knopKoffie.setText(koffieLijst.get(i).getNaam() + "   prijs: €" + koffieLijst.get(i).getPrijs());
			knopKoffie.setFocusable(false);
			params.weight = 0.5f;
			params.leftMargin = 0;
			knopKoffie.setLayoutParams(params);
			
			Button knopPlus = new Button(this);
			knopPlus.setText("+");
			knopPlus.setFocusable(true);
			params.weight = 0.0f;
			knopPlus.setLayoutParams(params);
			knopPlus.setOnClickListener(new OnClickListener() {
				   @Override
				   public void onClick(View v) {
					   TextView aantal = (TextView)findViewById(iFinal);
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
		
		setContentView(R.layout.bevestig_bestelling_scherm);
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
		setContentView(R.layout.activity_main);
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
	
	@Override
	public void onBackPressed() {
		if(scherm == 1)
			naarHoofdScherm(this.findViewById(android.R.id.content));
		
		else if(scherm == 2){
			naarInvoerScherm(this.findViewById(android.R.id.content));
		}
		
		return;
	}
}

*/

package com.example.moyeecoffee;

import com.example.moyeecoffee.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FragmentC extends Fragment 
{
	Button button;
	Button btnViewProducts;
	
@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup group, Bundle saved){
	View view = inflater.inflate(R.layout.frag_c, group, false);
	
	
	Intent i = new Intent(getActivity().getApplicationContext(), AllProductsActivity.class);
	i.putExtra("id", 1);
	startActivity(i);	
	return view;
}

@Override
	public void onActivityCreated (Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		
	}

}



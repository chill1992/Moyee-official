package com.example.moyeecoffee;

import com.example.moyeecoffee.R;

import android.content.Intent;
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
	public View onCreateView(LayoutInflater inflater, ViewGroup group, Bundle saved){
	View view = inflater.inflate(R.layout.frag_b, group, false);
	
	
	Intent i = new Intent(getActivity().getApplicationContext(), KoopKoffieMainActivity.class);
	i.putExtra("id", 2);
	startActivity(i);	
	return view;
}

@Override
	public void onActivityCreated (Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		
	}

}

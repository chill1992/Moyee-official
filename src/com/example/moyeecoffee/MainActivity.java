package com.example.moyeecoffee;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragmentActivity;

public class MainActivity extends SherlockFragmentActivity {

/** Called when the activity is first created. */
@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		ActionBar bar = getSupportActionBar();
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		ActionBar.Tab tab1 = bar.newTab();
		ActionBar.Tab tab2 = bar.newTab();
		ActionBar.Tab tab3 = bar.newTab();
		tab1.setText("  Winkels");
		tab2.setText("  Bestellen");
		tab3.setText("  Koffies");
		tab1.setTabListener(new MyTabListener());
		tab2.setTabListener(new MyTabListener());
		tab3.setTabListener(new MyTabListener());
		tab1.setIcon(R.drawable.mug);
		tab2.setIcon(R.drawable.dollar);
		tab3.setIcon(R.drawable.bean);
		bar.addTab(tab1);
		bar.addTab(tab2);
		bar.addTab(tab3);
	}

	private class MyTabListener implements ActionBar.TabListener
	{
		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			if(tab.getPosition()==0)
			{
				FragmentA frag = new FragmentA();
				ft.replace(android.R.id.content, frag);
			}
			if(tab.getPosition()==1)
			{
				FragmentB frag = new FragmentB();
				ft.replace(android.R.id.content, frag);
			}
			if(tab.getPosition()==2)
			{
				FragmentC frag = new FragmentC();
				ft.replace(android.R.id.content, frag);
			}
	}
		
@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
	// TODO Auto-generated method stub
	}

@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
	// TODO Auto-generated method stub
	}
}
}
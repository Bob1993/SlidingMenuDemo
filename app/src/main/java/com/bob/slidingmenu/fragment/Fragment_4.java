package com.bob.slidingmenu.fragment;

import com.bob.slidingmenu.R;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**
 * 
 * @author bob
 * @description Wednesday
 */
public class Fragment_4 extends Fragment {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.frag_4, null);
		return view;
	}
	
	
	
	@Override
	public void onDestroyView() {
		super.onDestroyView();
	}
	
	
	@Override
	public void onDestroy() {
		super.onDestroy();
	}
}

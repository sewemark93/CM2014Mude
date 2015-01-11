package com.example.muuu;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

public class fragment_favorites extends Fragment  {
    
	TextView tx;
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState)
	{
		 View rootView = inflater.inflate(R.layout.fragment_fav, container, false);
		 GridView gridView = (GridView)rootView.findViewById(R.id.grid_view);
	     /*this part of code connects to database and searches for favourite items
	      * then binds favourite items with gridview
	      */
		 MyDBHandler handler =new MyDBHandler(getActivity(), null, null, 1);
		 gridView.setAdapter(new ImageAdapter(rootView.getContext(),getActivity(),handler.searchByFavourite(1)));
            
		 return rootView;
   
    }
    
  
	}
package com.example.muuu;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

public class fragment_searchresult extends Fragment  {
    
	TextView tx;
	Object what;
	String category;
	public fragment_searchresult(Object _what, String _category)
	{
		what =_what;
		category =_category;
		
		
	}
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
		 View rootView = inflater.inflate(R.layout.fragment_searchresult, container, false);
		 GridView gridView = (GridView)rootView.findViewById(R.id.grid_view_search);
		/*this part of code is responsible for connecting with database
		 * searching for particular objects
		 * and displaying results (if any) in gridView)
		 */
		 MyDBHandler handler =new MyDBHandler(getActivity(), null, null, 1);
		 
		 if(category=="Category")
		 {
		 gridView.setAdapter(new ImageAdapter(rootView.getContext(),getActivity(),handler.searchByCategory(what.toString())));
          
		 }
		 else if(category=="Date")
		 {
			 gridView.setAdapter(new ImageAdapter(rootView.getContext(),getActivity(),handler.searchByDate((Integer) what)));
			 
		 }
		 else if(category=="Designer")
		 {
			 gridView.setAdapter(new ImageAdapter(rootView.getContext(),getActivity(),handler.searchByAuthor(what.toString())));
	          
		 }
		 // Inflate the layout for this fragment
     return rootView;
   
    }
    
  
	}
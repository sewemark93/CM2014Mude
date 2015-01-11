package com.example.muuu;

import java.util.ArrayList;
import android.app.ActionBar.LayoutParams;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;


public class fragment_search extends Fragment  {
    

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) 
	{
		 View rootView = inflater.inflate(R.layout.fragment_search, container, false);
		 final ListView listView = (ListView)rootView.findViewById(R.id.listcategory);
		 String[] values = new String[] { "Decoração","Livro","Mobiliário","Joalharia","Utensilios" };

		 final ArrayList<String> list = new ArrayList<String>();
		    for (int i = 0; i < values.length; i++)
		    {
		      list.add(values[i]);
		    }
		    
		    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),R.layout.listviewtemplatelayout,R.id.tv, values);
	        listView.setAdapter(adapter);
	        listView.setVisibility(View.GONE);
	        setListViewHeightBasedOnChildren(listView);
		   
		    listView.setOnItemClickListener(new OnItemClickListener()
		    {
		        	 
	                  public void onItemClick(AdapterView<?> parent, View view,
	                     int position, long id)
	                  {
	                  
	                   int itemPosition     = position;
	                   String what="";
	                   
	                   if(itemPosition==0)
	                   {
	                       what="Decoração";
	                   }
	                   else if(itemPosition==1)
	                   {
	                	   what="Livro";
	                   }
	                   else if(itemPosition==2)
	                   {
	                	   what="Mobiliário";
	                   }
	                   else if(itemPosition==3)
	                   {
	                	   what="Joalharia";
	                   }
	                   else if(itemPosition==4)
	                   {
	                	   what="Utensilios";
	                   }
	                   
	                   FragmentManager fragmentManager = getFragmentManager();
                       fragment_searchresult fra2 = new fragment_searchresult(what,"Category");
                       fragmentManager.beginTransaction().replace(R.id.main_fragment_container, fra2).commit();
	                 
	                  }
	    
	             }); 
		        Button searcgcategorybutton = (Button)rootView.findViewById(R.id.search_categoriabutton);
		        searcgcategorybutton.setOnClickListener( new OnClickListener() 
		        {
		        		 @Override
       		             public void onClick(View v) {
       		            	 	
       		            	if(listView.getVisibility()==View.GONE)
       		            	{
       		            		listView.setVisibility(View.VISIBLE);
       		             	}
       		            	else
       		            	{
       		            		listView.setVisibility(View.GONE);
       		            	}
       		     
       		             }});
		        
		        

			    String[] valuesdata = new String[] {"1950","1960","1978","2005","2006","2012"};
			    String[] valuesdesigner = new String[] {"Fernando Brízio","João Machado","Sebastião Rodrigues","Filipe Alarcão","Gonçalo Rodrigues dos Santos","Marco Sousa Santos","Alvaro Siza Vieira","Liliana Guerreiro","Daciano da Costa","Joaquim Ribeiro","Carlos Aguiar","Carlos Aguiar"};
			    final ArrayList<String> list2 = new ArrayList<String>();
			    for (int i = 0; i < valuesdata.length; i++) {
			      list2.add(valuesdata[i]);
			    }
			    final ListView listView3 = (ListView)rootView.findViewById(R.id.listdesigner);
			    final ArrayList<String> list3 = new ArrayList<String>();
			    for (int  j = 0; j < valuesdesigner.length; j++) {
			      list3.add(valuesdesigner[j]);
			    }
			    final ListView listView2 = (ListView)rootView.findViewById(R.id.listdata);
			
			    ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(),R.layout.listviewtemplatelayout,R.id.tv, valuesdata);
		        listView2.setAdapter(adapter2);
		        listView2.setVisibility(View.GONE);
		        setListViewHeightBasedOnChildren(listView2);
			        
			    ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(getActivity(),
	            R.layout.listviewtemplatelayout,R.id.tv, valuesdesigner);
		        listView3.setAdapter(adapter3);
		        listView3.setVisibility(View.GONE);
		        setListViewHeightBasedOnChildren(listView3);
			    listView2.setOnItemClickListener(new OnItemClickListener() {
			        	 
			    	 
		                  public void onItemClick(AdapterView<?> parent, View view,
		                     int position, long id)
		                  {
		                	   int itemPosition     = position;
			 
			                   int whatint=0;
			                   if(itemPosition==0)
			                   {
			                	   whatint=1950;
			                   }
			                   else if(itemPosition==1)
			                   {
			                	   whatint=1960;
			                   }
			                   else if(itemPosition==2)
			                   {
			                	   whatint=1978;
			                   }
			                   else if(itemPosition==3)
			                   {
			                	   whatint=2005;
			                   }
			                   else if(itemPosition==4)
			                   {
			                	   whatint=2006;
			                   }
			                   else if(itemPosition==5)
			                   {
			                	   whatint=2012;
			                   }
			                   FragmentManager fragmentManager = getFragmentManager();
		                       fragment_searchresult fra2 = new fragment_searchresult(whatint,"Date");
		                       fragmentManager.beginTransaction().replace(R.id.main_fragment_container, fra2).commit();
		                 
		                  }
		    
		             }); 
			        listView3.setOnItemClickListener(new OnItemClickListener() {

						@Override
						public void onItemClick(AdapterView<?> arg0, View arg1,
							   int position, long arg3) {
							  
			                   // ListView Clicked item value
			                   String  itemValue    = (String) listView3.getItemAtPosition(position);
			                   FragmentManager fragmentManager = getFragmentManager();
		                       fragment_searchresult fra2 = new fragment_searchresult(itemValue,"Designer");
		                       fragmentManager.beginTransaction().replace(R.id.main_fragment_container, fra2).commit();
							// TODO Auto-generated method stub
							
						}
			        }); 
		        Button searcdatabutton = (Button)rootView.findViewById(R.id.search_databutton);
		        searcdatabutton.setOnClickListener( new OnClickListener() {

       		             @Override
       		             public void onClick(View v) {
       		            	 	
       		            	if(listView2.getVisibility()==View.GONE)
       		            	{
       		            		listView2.setVisibility(View.VISIBLE);
       		            		
       		            	}
       		            	else
       		            	{
       		            		
       		            		listView2.setVisibility(View.GONE);
       		            	}
       		     
       		             }});
                Button searcdegignerbutton = (Button)rootView.findViewById(R.id.search_desginerbutton);
		        searcdegignerbutton.setOnClickListener( new OnClickListener() {

       		             @Override
       		             public void onClick(View v) {
       		            	 	
       		            	if(listView3.getVisibility()==View.GONE)
       		            	{
       		            		listView3.setVisibility(View.VISIBLE);
       		            		
       		            	}
       		            	else
       		            	{
       		            		
       		            		listView3.setVisibility(View.GONE);
       		            	}
       		     
       		             }});
		   return rootView;
   
	}
	 public static void setListViewHeightBasedOnChildren(ListView listView1)
	 {
 	    ListAdapter listAdapter = listView1.getAdapter();
 	    if (listAdapter == null)
 	        return;
 	    
 	   int desiredWidth;
        if(listAdapter.getCount()>6)
        	desiredWidth= MeasureSpec.makeMeasureSpec(listView1.getWidth(), MeasureSpec.EXACTLY);
        else
        	desiredWidth= MeasureSpec.makeMeasureSpec(listView1.getWidth(), MeasureSpec.UNSPECIFIED);
 	    int totalHeight = 0;
 	    View view = null;
 	    for (int i = 0; i < listAdapter.getCount(); i++) 
 	    {
 	        view = listAdapter.getView(i, view, listView1);
 	        if (i == 0)
 	            view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, LayoutParams.WRAP_CONTENT));

 	        view.measure(desiredWidth, MeasureSpec.UNSPECIFIED);
 	        totalHeight += view.getMeasuredHeight();
 	    }
 	    ViewGroup.LayoutParams params = listView1.getLayoutParams();
 	    params.height = totalHeight + (listView1.getDividerHeight() * (listAdapter.getCount() - 1));
 	    listView1.setLayoutParams(params);
 	    listView1.requestLayout();
 	}
	
}
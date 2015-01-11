package com.example.muuu;



import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;

import android.view.View.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class fragment_mainmenu extends Fragment  {
    
	TextView tx;
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState)
	{

        View rootView = inflater.inflate(R.layout.fragment_menu, container, false);
		final Button favbutton = (Button)rootView.findViewById(R.id.favourite_button);
		favbutton.setOnClickListener( new OnClickListener() {

            @Override
            public void onClick(View v) {
           	 	
           	 FragmentManager fragmentManager = getFragmentManager();
           	 fragment_favorites fra2 = new fragment_favorites();
             fragmentManager.beginTransaction().replace(R.id.main_fragment_container, fra2).commit();        
    
            }});
		 final Button gallerybutton = (Button)rootView.findViewById(R.id.galeria_button);
		 gallerybutton.setOnClickListener( new OnClickListener() {

	            @Override
	            public void onClick(View v) {
	            
	            	 FragmentManager fragmentManager3 = getFragmentManager();
	             	 fragment_gallery fra3 = new fragment_gallery();
	                 fragmentManager3.beginTransaction().replace(R.id.main_fragment_container, fra3).commit();  
	            }});
		 
		 
		 
		 final  Button infobutton = (Button)rootView.findViewById(R.id.info_button);
		 final Button searchbutton = (Button)rootView.findViewById(R.id.search_button);
		 searchbutton.setOnClickListener( new OnClickListener() {

            @Override
            public void onClick(View v) {
            	 Animation animation2 = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.fade);
            	 gallerybutton.startAnimation(animation2);
            	 animation2.setAnimationListener(new Animation.AnimationListener(){
            		    @Override
            		    public void onAnimationStart(Animation arg0) {
            		    	
            		    }           
            		    @Override
            		    public void onAnimationRepeat(Animation arg0) {
            		    }           
            		    @Override
            		    public void onAnimationEnd(Animation arg0) {
            		    	gallerybutton.setVisibility(View.GONE);
            		    }
            		});
            	 gallerybutton.startAnimation(animation2);
            	 Animation animation3 = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.fade);
        
            	  animation3.setAnimationListener(new Animation.AnimationListener(){
            		    @Override
            		    public void onAnimationStart(Animation arg0) {
            		    	
            		    }           
            		    @Override
            		    public void onAnimationRepeat(Animation arg0) {
            		    }           
            		    @Override
            		    public void onAnimationEnd(Animation arg0) {
            		    	  infobutton.setVisibility(View.GONE);
            		    }
            		});
            	  infobutton.startAnimation(animation3);
            	  Animation animation4= AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.fade);
            
                  animation4.setAnimationListener(new Animation.AnimationListener(){
            		    @Override
            		    public void onAnimationStart(Animation arg0) {
            		    	
            		    }           
            		    @Override
            		    public void onAnimationRepeat(Animation arg0) {
            		    }           
            		    @Override
            		    public void onAnimationEnd(Animation arg0) {
            		        favbutton.setVisibility(View.GONE);
            		       
                        	 Animation animation5= AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.top);
                        	 FragmentManager fragmentManager3 = getFragmentManager();
                         	 fragment_search fra3 = new fragment_search();
                        	 fragmentManager3.beginTransaction().replace(R.id.search_fragment_container, fra3).commit();  
                         	 searchbutton.startAnimation(animation5); 
            		    }
            		   
                  });
                  favbutton.startAnimation(animation4);
                  Animation animation5= AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.top);
                  
                  animation5.setAnimationListener(new Animation.AnimationListener(){
            		    @Override
            		    public void onAnimationStart(Animation arg0) {
            		    	
            		    }           
            		    @Override
            		    public void onAnimationRepeat(Animation arg0) {
            		    }           
            		    @Override
            		    public void onAnimationEnd(Animation arg0) {
            		       
            		    	 FragmentManager fragmentManager3 = getFragmentManager();
                             fragment_search fra3 = new fragment_search();
                        	 fragmentManager3.beginTransaction().replace(R.id.search_fragment_container, fra3).commit();  
                         }
            		   
                  });
          
            }});
			
			infobutton.setOnClickListener( new OnClickListener() {

		            @Override
		            public void onClick(View v) {
		            
		            	 FragmentManager fragmentManager3 = getFragmentManager();
		            	 fragment_info fra3 = new fragment_info();
		                
		             	 fragmentManager3.beginTransaction().replace(R.id.main_fragment_container, fra3).commit();  
		            }});
			 
			 
          
            // Inflate the layout for this fragment
       return rootView;
   
    }
    
  
	}


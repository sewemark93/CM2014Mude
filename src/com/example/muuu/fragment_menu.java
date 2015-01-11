package com.example.muuu;
import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;


public class fragment_menu extends Fragment {
   
	View rootView;
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        	
			    fragment_mainmenu fra = new fragment_mainmenu();
	        	FragmentManager fragmentManager = getFragmentManager();
	            fragmentManager.beginTransaction().replace(R.id.menu_fragment_container, fra).commit();        
                 /* Inflate the layout for this fragment */
                 rootView = inflater.inflate(R.layout.labeled_text_edit, container, false);
            	 Button clickButton = (Button)rootView.findViewById(R.id.close);
        		 clickButton.setOnClickListener( new OnClickListener() {

        		             @Override
        		             public void onClick(View v) {
        		            	 	
        		            	 FragmentManager fragmentManager = getFragmentManager();
        			            	if (fragmentManager.findFragmentById(R.id.overlay_fragment_container) != null) 
        			            		{
        			            		     Fragment fragment = fragmentManager.findFragmentById(R.id.overlay_fragment_container);
        			         
        			            		     getFragmentManager().beginTransaction().remove(fragment).commit();
                                             
        			                         Button b =(Button)getActivity().findViewById(R.id.frag1hide);
        			                         b.setBackgroundResource(R.drawable.icon_menu);
        			                    	
        			            		}
        		     
        		             }});
        		 
        		 
        		 Button clickButton2 = (Button)rootView.findViewById(R.id.back);
        		 clickButton2.setOnClickListener( new OnClickListener() {

        		             @Override
        		             public void onClick(View v) 
        		             {
        		            	 
        		            	 
        		             	 FragmentManager fragmentManager = getFragmentManager();
        		                 final Button gallerybutton = (Button)rootView.findViewById(R.id.galeria_button);
        		            	 final  Button infobutton = (Button)rootView.findViewById(R.id.info_button);
        		           		 
        		         		 final Button favbutton = (Button)rootView.findViewById(R.id.favourite_button);
        		            	 
        		         		 /*checks if user is in search fragment. When user is in search fragment
        		         		  * return to normal menu (show option buttons)
        		         		  */
        		         		 if(fragmentManager.findFragmentById(R.id.search_fragment_container)!=  null)
        		            	 {
        		            		  gallerybutton.setVisibility(View.VISIBLE);
        		                      infobutton.setVisibility(View.VISIBLE);
        		                      favbutton.setVisibility(View.VISIBLE);
        		              	 	
        		                    	
        		                    	fragment_blank fra= new fragment_blank();
        		                        
        		                      fragmentManager.beginTransaction().replace(R.id.search_fragment_container, fra).commit();
        		            		 
        		            	 }
        		            	 else
        		            	 {
	        		            	 if (fragmentManager.findFragmentById(R.id.overlay_fragment_container) != null) 
	     			            		{
	     			            			Fragment fragment = fragmentManager.findFragmentById(R.id.overlay_fragment_container);
	     			         
	     			            		    getFragmentManager().beginTransaction().remove(fragment).commit();
	                                          
	     			                         Button b =(Button)getActivity().findViewById(R.id.frag1hide);
	     			                         b.setBackgroundResource(R.drawable.icon_menu);
	     			            		}

        			            }
        		             }
        		     
        		             });

        		 
        		 
            	return rootView;
}
}
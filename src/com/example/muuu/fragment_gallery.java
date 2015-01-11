package com.example.muuu;



import android.os.Bundle;
import android.app.Fragment;

import android.app.FragmentTransaction;
import android.view.View.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class fragment_gallery extends Fragment implements OnClickListener  {
    
	TextView tx;
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) 
	{
		 View rootView = inflater.inflate(R.layout.fragment_gallery, container, false);
	   	 ImageView image = (ImageView)rootView.findViewById(R.id.almanaque);
	     image.setOnClickListener(this);
	     ImageView image2 = (ImageView)rootView.findViewById(R.id.cadeiragoncalo);
	     image2.setOnClickListener(this);
	     ImageView image3 = (ImageView)rootView.findViewById(R.id.coleccaofiligrana);
	     image3.setOnClickListener(this);
	     ImageView image4 = (ImageView)rootView.findViewById(R.id.furo);
	     image4.setOnClickListener(this);
	     ImageView image5 = (ImageView)rootView.findViewById(R.id.portobarros);
	     image5.setOnClickListener(this);
	     ImageView image6 = (ImageView)rootView.findViewById(R.id.congressointpessoano);
	     image6.setOnClickListener(this);
	     ImageView image7 = (ImageView)rootView.findViewById(R.id.cadeiraosaka);
	     image7.setOnClickListener(this);
	     ImageView image8 = (ImageView)rootView.findViewById(R.id.cadeiraal);
	     image8.setOnClickListener(this);
	     ImageView image9 = (ImageView)rootView.findViewById(R.id.torneirapanda);
	     image9.setOnClickListener(this);
	     ImageView image10 = (ImageView)rootView.findViewById(R.id.puxadorbeta);
	     image10.setOnClickListener(this);
	     ImageView image12 = (ImageView)rootView.findViewById(R.id.espelhoalvaro);
	     image12.setOnClickListener(this);
	     ImageView image13 = (ImageView)rootView.findViewById(R.id.candeeiroterra);
	     image13.setOnClickListener(this);
	     ImageView image14 = (ImageView)rootView.findViewById(R.id.linhagoa);
	     image14.setOnClickListener(this);
	     ImageView image16 = (ImageView)rootView.findViewById(R.id.linhacortez);
	     image16.setOnClickListener(this);
            // Inflate the layout for this fragment
    return rootView;
   
    }
	  public void onClick(View v) {
	    	
		  /*this part of code replaces gallery fragmen with appropriate detail fragment */
	    	 int id = v.getId();
	    	 FragmentTransaction tx = getFragmentManager().beginTransaction();
	    	 Bundle bundle=new Bundle();
	    	 bundle.putInt("ImageId", id);
	    	 fragment_detail fra = new fragment_detail();
	    	 fra.setArguments(bundle);
	         tx.replace(R.id.main_fragment_container,fra);
	         tx.commit();
	    }
	
    
  
}
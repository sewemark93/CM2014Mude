package com.example.muuu;

import java.io.ByteArrayOutputStream;

import android.app.Fragment;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class fragment_aboutauthor extends Fragment {
    View rootView;


	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState)
	{
		 
		  View rootView = inflater.inflate(R.layout.fragment_author, container, false);
		
	     
		  ImageView authotimage = (ImageView)rootView.findViewById(R.id.authorimage);
		  /*This parts of code gets resource Id for designer image  */
		  String name =getArguments().getString("imagrres");
		  int  resourceId = getResources().getIdentifier(
	     	       name+"designer", "drawable",getActivity().getPackageName() );
		  authotimage.setBackgroundResource(resourceId);
		  TextView description= (TextView)rootView.findViewById(R.id.authordescription);
          /*This part of code read all information about designer from txt file */
		  /*If no file exist simply set text filed value eglas to nothing */
		  AssetManager am = rootView.getContext().getAssets();
		  FileReaderHelper filehelper = new FileReaderHelper();
		  ByteArrayOutputStream byteArrayOutputStream = filehelper.read(name+"designer"+".txt", am);
		
			if(byteArrayOutputStream==null)
			{
				   description.setText("");
	
			}
			else
			{
			   description.setText(byteArrayOutputStream.toString());
			}
       
         return rootView;
    }
		

}

package com.example.muuu;

import java.io.ByteArrayOutputStream;
import android.app.Fragment;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class fragment_info extends Fragment  {
    

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
		  
		  View rootView = inflater.inflate(R.layout.fragment_info, container, false);
		  
		  Typeface typeFace=Typeface.createFromAsset(getActivity().getAssets(),"fonts/helveticaneuecon.ttf");
		  final TextView textView1= (TextView)rootView.findViewById(R.id.header1);
	 	  textView1.setTypeface(typeFace);
	 	  final TextView textView2= (TextView)rootView.findViewById(R.id.header2);
	 	  textView2.setTypeface(typeFace);
	 	  final TextView textView3= (TextView)rootView.findViewById(R.id.text1);
	 	  textView3.setTypeface(typeFace);
	 	  final TextView textView4= (TextView)rootView.findViewById(R.id.text2);
	 	  textView4.setTypeface(typeFace);
          textView1.setText(R.string.sobre);
          textView2.setText(R.string.contactos);
          /* this part of code read infrmation about application from txt files */
          FileReaderHelper filereader = new FileReaderHelper();
		  AssetManager am = rootView.getContext().getAssets();
		  ByteArrayOutputStream byteArrayOutputStream = filereader.read("sobre"+".txt", am);
		 
			if(byteArrayOutputStream==null)
			{
				textView3.setText("");
	
			}
			else
			{
				textView3.setText(byteArrayOutputStream.toString());
			}
			ByteArrayOutputStream byteArrayOutputStream2 = filereader.read("contactos"+".txt", am);
			 
			if(byteArrayOutputStream2==null)
			{
				textView4.setText("");
	
			}
			else
			{
				textView4.setText(byteArrayOutputStream2.toString());
			}
		 return rootView;
	}
    
  
	}
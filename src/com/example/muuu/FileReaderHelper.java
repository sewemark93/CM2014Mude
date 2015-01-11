package com.example.muuu;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.res.AssetManager;

public class FileReaderHelper {

	public FileReaderHelper()
	{
		
	}
	public ByteArrayOutputStream read(String name, AssetManager am)
	{
		
		  ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		  InputStream is = null;
		   try
		   {
			   is = am.open(name);
			   int i;
			   try 
			   {
				   i = is.read();
				   while (i != -1)
			       {
					   byteArrayOutputStream.write(i);
					   i = is.read();
			       }
			      is.close();
			     
			  } catch (IOException e) {
			   
			   e.printStackTrace();
			  }
		} catch (IOException e) 
		{
		
			e.printStackTrace();
		}
		 return byteArrayOutputStream;
		
	}
	
	
	
}

package com.example.muuu;


import android.content.res.Resources;



/*class to get resource id for images */
public class MainImageAdapter {
	private String imgre;
	private int start;
	private int numofimages;
	Resources res ;
	private String pac;
	public MainImageAdapter(String _imgres,Resources _res, String _pac, int _numofimages)
	{
	    imgre =_imgres;	    
	    start =1;
	    res =_res;
	    pac = _pac;
	    numofimages =_numofimages;
	}
	public int GetDesignerImage()
	{
		
		int resourceId = res.getIdentifier(
		           imgre+ "designer", "drawable", pac );
	
		        return resourceId;
		
	}
	public int GetMainImage()
	{

    	int resourceId = res.getIdentifier(
       imgre+ String.valueOf(1), "drawable", pac );
    return resourceId;
		
	}
	public int GetNextImage()
	{
	
	
        if(start +1 > numofimages )
        {
        	start =1;
        }
        else
        {
        	start=start+1;
        }
        
        	int resourceId = res.getIdentifier(
           imgre+ String.valueOf(start), "drawable", pac );
        return resourceId;
		
	}
	public int GetPrevImage()
	{
	
	
        if(start -1 <= 0 )
        {
        	start =numofimages;
        }
        else
        {
        	start= start -1;;
        }
        	int resourceId = res.getIdentifier(
           imgre + String.valueOf(start),"drawable", pac );
        return resourceId;
		
	}
    
	

}

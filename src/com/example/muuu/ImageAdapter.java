package com.example.muuu;
import java.util.ArrayList;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
 

/*class used as image adapter in search result and favourite fragment */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private Activity activity;
    // Keep all Images in array
    int resourceId;
    ArrayList<Integer> lista;
    ArrayList<String> imgresos;
    public Integer[] mThumbIds;
 
    // Constructor
    public ImageAdapter(Context c, Activity a, ArrayList<String> _imgresos){
        mContext = c;
        activity = a;
        imgresos = _imgresos;
        lista = new ArrayList<Integer>();
        
        for(int i=0;i<imgresos.size();i++)
       {
        resourceId = activity.getResources().getIdentifier(
     	       imgresos.get(i)+"1", "drawable", activity.getPackageName() );
        lista.add(resourceId);
       }
       
       }
    
   
   
    
    @Override
    public int getCount() {
        return lista.size();
    }
 
    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }
 
    @Override
    public long getItemId(int position) {
        return 0;
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(lista.get(position));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
        return imageView;
    }
 
}
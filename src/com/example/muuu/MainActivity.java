package com.example.muuu;

import android.app.Activity;
import android.os.Bundle;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.app.FragmentManager;
import java.util.ArrayList;
import android.content.Context;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements SensorEventListener {

	private SensorManager mSensorManager;
    private Sensor mAccelerometr;
    private long lastUpdate = 0;
    private float last_x, last_y, last_z;
    private static final int SHAKE_THRESHOLD = 600;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*initializing accelerometer */
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometr = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.registerListener(this, mAccelerometr , SensorManager.SENSOR_DELAY_NORMAL);
        /*adding information about object to database */
        newItemFuro();
        newItemCongresso();
        newItemAlmanaque();
        changeFav("Furo", 0);
        newItemCadeiraAI();
        newItemCadeiraGoncalo();
        newItemCadeiraOsaka();
        newItemCandeeiroTerra();
        newItemEspelhoAlvaro();
        newItemColeccaoFiligrana();
        newItemLinhaCortez();
        newItemLinhaGoa();
        newItemPortoBarros();
        newItemPuxadorBeta();
        newItemTorneiraPanda();
        /*setting gallery as a main fragment */
        FragmentManager fragmentManager2 = getFragmentManager();
        fragment_gallery fra2 = new fragment_gallery();
        fragmentManager2.beginTransaction().add(R.id.main_fragment_container, fra2).commit();   
        final Button button = (Button) findViewById(R.id.frag1hide);
        /*handling button for showing and hiding menu fragment */
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	fragment_menu fra= new fragment_menu();
                FragmentManager fragmentManager = getFragmentManager();
            	fragmentManager.beginTransaction().add(R.id.overlay_fragment_container, fra).commit();        
                View b = findViewById(R.id.frag1hide);
            	b.setBackgroundResource(R.drawable.background);
            }
        });
      
    }
    
    /*handling accelerometer */
    public void onAccuracyChanged(Sensor arg0, int arg1){
    }
 
    public void onSensorChanged(SensorEvent event){
         Sensor mySensor = event.sensor;
    	  
    	    if (mySensor.getType() == Sensor.TYPE_ACCELEROMETER) {
    	        float x = event.values[0];
    	        float y = event.values[1];
    	        float z = event.values[2];
    	 
    	        long curTime = System.currentTimeMillis();
    	 
    	        if ((curTime - lastUpdate) > 100) {
    	            long diffTime = (curTime - lastUpdate);
    	            lastUpdate = curTime;
    	 
    	            float speed = Math.abs(x + y + z - last_x - last_y - last_z)/ diffTime * 10000;
    	 
    	            if (speed > SHAKE_THRESHOLD) {
    	             	fragment_favorites fra = new fragment_favorites();
    	            	FragmentManager fragmentManager = getFragmentManager();
    	                fragmentManager.beginTransaction().replace(R.id.main_fragment_container, fra).commit();
    	            }
    	           
    	            }
    	 
    	            last_x = x;
    	            last_y = y;
    	            last_z = z;
    	        }
    	    
   
    }
    /*methods to add object to database */
  public void newItemFuro () {
	   MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
	   
	   			String title = "Furo";
				String author = "Fernando Brízio";
				String manufacturer = "Materia";
				String category = "Decoração";
				int date = 2012;
				String type = "Taça";
				String country = "Portugal";
				String colour = "Castanho Cortiça";
				String material = "Aglmoerado de Cortiça e lápis de cor";
				int isFavourite = 0;
				String imgres = "furo";
				int nr_of_pics = 3;
	   Item item = new Item(	title, author, manufacturer, category, 
			   					date, type, country, colour, 
			   					material, isFavourite, 
			   					imgres, nr_of_pics);
	   dbHandler.addItem(item);
 }
  public void newItemCongresso () {
	   MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
	   
	   			String title = "1º Congresso Int. Pessoano";
				String author = "João Machado";
				String manufacturer = "Porto Editora";
				String category = "Livro";
				int date = 1978;
				String type = "Actas";
				String country = "Portugal";
				String colour = "Rosa e Verde";
				String material = "Papel";
				int isFavourite = 0;
				String imgres = "congressointpessoano";
				int nr_of_pics = 1;
	   Item item = new Item(	title, author, manufacturer, category, 
			   					date, type, country, colour, 
			   					material, isFavourite, 
			   					imgres, nr_of_pics);
	   dbHandler.addItem(item);
  }
  public void newItemAlmanaque () {
 	   MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
	   
 	   	String title = "Almanaque";
		String author = "Sebastião Rodrigues";
		String manufacturer = "Ulisseia Editora";
		String category = "Livro";
		int date = 1960;
		String type = "Revista";
		String country = "Portugal";
		String colour = "Verde e Vermelho";
		String material = "Papel";
		int isFavourite = 0;
		String imgres = "almanaque";
		int nr_of_pics = 1;
		Item item = new Item(	title, author, manufacturer, category, 
		   					date, type, country, colour, 
		   					material, isFavourite, 
		   					imgres, nr_of_pics);
		dbHandler.addItem(item);
  }
  public void newItemCadeiraAI () {
  	MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
 	   
  	String title = "Cadeira Al";
		String author = "Filipe Alarcão";
		String manufacturer = null;
		String category = "Mobiliário";
		int date = 0;
		String type = "Cadeira";
		String country = "Portugal";
		String colour = null;
		String material = "Aço e madeira";
		int isFavourite = 0;
		String imgres = "cadeiraal";
		int nr_of_pics = 2;
		Item item = new Item(	title, author, manufacturer, category, 
		   					date, type, country, colour, 
		   					material, isFavourite, 
		   					imgres, nr_of_pics);
		dbHandler.addItem(item);
  }
  public void newItemCadeiraGoncalo () {
  	MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
 	   
  	String title = "Cadeira Gonçalo";
		String author = "Gonçalo Rodrigues dos Santos";
		String manufacturer = "Arcalo";
		String category = "Mobiliário";
		int date = 1950;
		String type = "Cadeira";
		String country = "Portugal";
		String colour = "Verde/Preto/Amarelo/etc";
		String material = "Aço";
		int isFavourite = 0;
		String imgres = "cadeiragoncalo";
		int nr_of_pics = 4;
		Item item = new Item(title, author, manufacturer, category, 
		   					date, type, country, colour, 
		   					material, isFavourite, 
		   					imgres, nr_of_pics);
		dbHandler.addItem(item);
  }    
  public void newItemCadeiraOsaka () {
  	MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
 	   
  	String title = "Cadeira Osaka";
		String author = null;
		String manufacturer = null;
		String category = "Mobiliário";
		int date = 0;
		String type = "Cadeira";
		String country = "Portugal";
		String colour = null;
		String material = "Madeira";
		int isFavourite = 0;
		String imgres = "cadeiraosaka";
		int nr_of_pics = 2;
		Item item = new Item(	title, author, manufacturer, category, 
		   					date, type, country, colour, 
		   					material, isFavourite, 
		   					imgres, nr_of_pics);
		dbHandler.addItem(item);
  } 
  public void newItemCandeeiroTerra () {
  	MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
 	   
  	String title = "Candeeiro Terra";
		String author = "Marco Sousa Santos";
		String manufacturer = null;
		String category = null;
		int date = 0;
		String type = null;
		String country = "Portugal";
		String colour = null;
		String material = null;
		int isFavourite = 0;
		String imgres = "candeeiroterra";
		int nr_of_pics = 2;
		Item item = new Item(	title, author, manufacturer, category, 
		   					date, type, country, colour, 
		   					material, isFavourite, 
		   					imgres, nr_of_pics);
		dbHandler.addItem(item);
  } 
  public void newItemEspelhoAlvaro () {
  	MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
 	   
  	String title = "Espelho Álvaro";
		String author = "Alvaro Siza Vieira";
		String manufacturer = "";
		String category = "Mobiliário";
		int date = 0;
		String type = "Espelho";
		String country = "Portugal";
		String colour = "";
		String material = "";
		int isFavourite = 0;
		String imgres = "espelhoalvaro";
		int nr_of_pics = 3;
		Item item = new Item(	title, author, manufacturer, category, 
		   					date, type, country, colour, 
		   					material, isFavourite, 
		   					imgres, nr_of_pics);
		dbHandler.addItem(item);
  } 	
  public void newItemColeccaoFiligrana () {
  	MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
 	   
  	String title = "Colecção Filigrana";
		String author = "Liliana Guerreiro";
		String manufacturer = "";
		String category = "Joalharia";
		int date = 2005;
		String type = "Anel";
		String country = "Portugal";
		String colour = "Prateado/Dourado";
		String material = "Prata 925 Oxidada e Ouro 19K";
		int isFavourite = 0;
		String imgres = "coleccaofiligrana";
		int nr_of_pics = 4;
		Item item = new Item(	title, author, manufacturer, category, 
		   					date, type, country, colour, 
		   					material, isFavourite, 
		   					imgres, nr_of_pics);
		dbHandler.addItem(item);
  } 
  public void newItemLinhaCortez () {
  	MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
 	   
  	String title = "Linha Cortez";
		String author = "Daciano da Costa";
		String manufacturer = "";
		String category = "Mobiliário";
		int date = 0;
		String type = "";
		String country = "Portugal";
		String colour = "";
		String material = "";
		int isFavourite = 0;
		String imgres = "linhacortez";
		int nr_of_pics = 2;
		Item item = new Item(	title, author, manufacturer, category, 
		   					date, type, country, colour, 
		   					material, isFavourite, 
		   					imgres, nr_of_pics);
		dbHandler.addItem(item);
  } 
  public void newItemLinhaGoa () {
  	MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
 	   
  	String title = "Linha Goa";
		String author = "Joaquim Ribeiro";
		String manufacturer = "Cutipol";
		String category = "Utensilios";
		int date = 2006;
		String type = "Faqueiro";
		String country = "Portugal";
		String colour = "Preto e Prateado";
		String material = "Cromo Níquel, Aço Inóxidavel, Resina";
		int isFavourite = 0;
		String imgres = "linhagoa";
		int nr_of_pics = 2;
		Item item = new Item(	title, author, manufacturer, category, 
		   					date, type, country, colour, 
		   					material, isFavourite, 
		   					imgres, nr_of_pics);
		dbHandler.addItem(item);
  } 
  public void newItemPortoBarros () {
  	MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
 	   
  	String title = "Porto Barros";
		String author = "";
		String manufacturer = "";
		String category = "";
		int date = 0;
		String type = "";
		String country = "Portugal";
		String colour = "";
		String material = "";
		int isFavourite = 0;
		String imgres = "portobarros";
		int nr_of_pics = 2;
		Item item = new Item(	title, author, manufacturer, category, 
		   					date, type, country, colour, 
		   					material, isFavourite, 
		   					imgres, nr_of_pics);
		dbHandler.addItem(item);
  } 
  public void newItemPuxadorBeta () {
  	MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
 	   
  	String title = "Puxador Beta";
		String author = "Carlos Aguiar";
		String manufacturer = "";
		String category = "";
		int date = 0;
		String type = "";
		String country = "Portugal";
		String colour = "";
		String material = "";
		int isFavourite = 0;
		String imgres = "puxadorbeta";
		int nr_of_pics = 2;
		Item item = new Item(	title, author, manufacturer, category, 
		   					date, type, country, colour, 
		   					material, isFavourite, 
		   					imgres, nr_of_pics);
		dbHandler.addItem(item);
  } 
  public void newItemTorneiraPanda () {
  	MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
 	   
  	String title = "Torneira Panda";
		String author = "Carlos Aguiar";
		String manufacturer = null;
		String category = null;
		int date = 0;
		String type = null;
		String country = "Portugal";
		String colour = null;
		String material = null;
		int isFavourite = 0;
		String imgres = "torneirapanda";
		int nr_of_pics = 2;
		Item item = new Item(	title, author, manufacturer, category, 
		   					date, type, country, colour, 
		   					material, isFavourite, 
		   					imgres, nr_of_pics);
		dbHandler.addItem(item);
  } 
  
  /*helper methods to get data from database */
  public void changeFav(String nazwa_elementu, int val){
	   MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
           dbHandler.changeFavourite(nazwa_elementu, val);
  }
  public int ileObrazkow (String nazwa_elementu) 
  {
	   MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
	   int ilosc_obrazkow = 
          dbHandler.findPictureNumber(nazwa_elementu);
	   if (ilosc_obrazkow != 0) {
		   	return ilosc_obrazkow;
      } else {
      	return 0;
      }
  }
  public String nazwisko (String nazwa_elementu)
  {
  	String error ="Something went TERRIBLY wrong.";
	   MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
	 	
	   String nazwisko = 
          dbHandler.AuthorName(nazwa_elementu);
	   if (nazwisko != null) {
		   	return nazwisko;
	    } else {
	    	return error;
	    }     	
  }
  public ArrayList<String> searchByCat(String category){
  	ArrayList<String> list = new ArrayList<String>();
  	MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
  	list=dbHandler.searchByCategory(category);
  	return list;
  }
  public ArrayList<String> searchByDate(int date){
  	ArrayList<String> list = new ArrayList<String>();
  	MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
  	list=dbHandler.searchByDate(date);
  	return list;
  }
  public ArrayList<String> searchByAuthor(String author){
  	ArrayList<String> list = new ArrayList<String>();
  	MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
  	list=dbHandler.searchByAuthor(author);
  	return list;
  }
  public ArrayList<String> searchByFav(int favourite){
  	ArrayList<String> list = new ArrayList<String>();
  	MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
  	list=dbHandler.searchByFavourite(favourite);
  	return list;
  }
    
    
   
}

package com.example.muuu;


/*class represents data model */
public class Item {
    private int _id; //integer
    private String _title; //varchar(50)
    private String _author; //varchar(50)
    private String _manufacturer; //varchar(50)
    private String _category; //varchar(50)
    private int _date; //integer
    private String _type; // varchar(50)
    private String _country; //varchar(50)
    private String _colour; //varchar(50)
    private String _material; //varchar(50)
    private int _isFavourite; //boolean
    private String _imgres; //varchar(50)
    public int _nr_of_pics; // integer

	public Item() {
		
	}
	
	public Item(		int id, 
						String title,
						String author,
						String manufacturer,
						String category,
						int date,
						String type,
						String country,
						String colour,
						String material,
						int isFavourite,
						String imgres,
						int nr_of_pics) {
		this._id = id;
		this._title = title;
		this._author = author;
		this._manufacturer = manufacturer;
		this._category = category;
		this._date = date;
		this._type = type;
		this._country = country;
		this._colour = colour;
		this._material = material;
		this._isFavourite = isFavourite;
		this._imgres = imgres;
		this._nr_of_pics = nr_of_pics;
	}
	
	public Item( 		String title,
						String author,
						String manufacturer,
						String category,
						int date,
						String type,
						String country,
						String colour,
						String material,
						int isFavourite,
						String imgres,
						int nr_of_pics) {
		this._title = title;
		this._author = author;
		this._manufacturer = manufacturer;
		this._category = category;
		this._date = date;
		this._type = type;
		this._country = country;
		this._colour = colour;
		this._material = material;
		this._isFavourite = isFavourite;
		this._imgres = imgres;
		this._nr_of_pics = nr_of_pics;
	}
	
	public void setID(int id) {
		this._id = id;
	}
	
	public int getID() {
		return this._id;
	}
	
	public void setItemTitle(String title) {
		this._title = title;
	}
	
	public String getItemTitle() {
		return this._title;
	}
	
	public void setAuthor(String author) {
		this._author = author;
	}
	
	public String getAuthor() {
		return this._author;
	}
	
	public void setManufacturer(String manufacturer) {
		this._manufacturer = manufacturer;
	}
	
	public String getManufacturer() {
		return this._manufacturer;
	}
	
	public void setCategory(String category) {
		this._category = category;
	}
	
	public String getCategory(){
		return this._category;
	}
	
	public void setDate(int date) {
		this._date = date;
	}
	
	public int getDate() {
		return this._date;
	}	
	
	public void setType(String type) {
		this._type = type;
	}
	
	public String getType(){
		return this._type;
	}
	
	public void setCountry(String country) {
		this._country = country;	
	}
	
	public String getCountry(){
		return this._country;
	}
	
	public void setColour(String colour){
		this._colour = colour;
		
	}
	
	public String getColour(){
		return this._colour;
	}
	
	public void setMaterial(String material) {
		this._material = material;
	}
	
	public String getMaterial(){
		return this._material;
	}
	

	public void setFavourite(int isFavourite){
		this._isFavourite = isFavourite;
	}
	
	public int getFavourite(){
		return this._isFavourite;
	}
	
	public void setImgRes(String imgres) {
		this._imgres = imgres;
	}
	
	public String getImgRes(){
		return this._imgres;
	}
	
	public void setNumberOfPics(int nr_of_pics) {
		this._nr_of_pics = nr_of_pics;
	}
	
	public int getNumberOfPics() {
		return this._nr_of_pics;
	}

}
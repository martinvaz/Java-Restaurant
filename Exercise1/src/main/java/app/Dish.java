package app;

import java.io.Serializable;


public class Dish implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private double prize;
	private int cuisineID;
	
	public void setName(String name){
		this.name=name;
	}
	
	public void setPrize(double prize){
		this.prize=prize;
	}
	
	public String getName(){
		return name;
	}
	
	public double getPrize(){
		return prize;
	}
	
	public void setCuisineID(int cuisineID){
		this.cuisineID=cuisineID;
	}
	
	public int getCuisineID(){
		return cuisineID;
	}
	

}

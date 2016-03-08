package app;

import java.io.Serializable;

public class Drink implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private double prize;
	private boolean lemon=false;
	private boolean ice=false;
	
	
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
	
	public void setLemon(){
		this.lemon=true;
	}
	
	public void setIce(){
		this.ice=true;
	}
}

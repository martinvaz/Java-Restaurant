package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;


public class Menu implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Menu instance;
	
	private Menu(){		
	}
	
	public static Menu Instance() {
		if (instance == null) {
			instance = new Menu();
		}
		return instance;
	}
	
	private ArrayList<Cuisine> menuList = new ArrayList<Cuisine>();
	
	public void setMenuList(ArrayList<Cuisine> list){
		this.menuList=list;
	}
		
	public ArrayList<Cuisine> getMenuList(){
		return menuList;
	}
	
	
	//creates a new cuisine and adds it to the menu ArrayList
	public void NewCuisine() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (isr);
		
		Cuisine cuisine = new Cuisine();
		
		System.out.println("New cuisine. ");
		
		System.out.print("Name: ");
		cuisine.setName(br.readLine());
		
		cuisine.setCuisineID(menuList.size()+1); //setting the id for the new cuisine
		menuList.add(cuisine); //adding the cuisine to the array
		
		ShowCuisines(); //borrar esto despues 
		
		System.out.print("Cuisine added to the system.");
		System.out.println();	
	}
	
	//Runs the menu ArrayList and shows all cuisines
	public void ShowCuisines(){
		Cuisine cuisine = new Cuisine();
		for(int i=0; i< menuList.size(); i++){
			cuisine = menuList.get(i);
			System.out.println((i+1) + ". " + cuisine.getName());
		}
	}
}

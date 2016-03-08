package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;

public class Cuisine implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int cuisineID;
	
	private static ArrayList<Dish> cuisineList = new ArrayList<Dish>();
	
	public void setCuisineList(ArrayList<Dish> list){
		Cuisine.cuisineList=list;
	}
		
	public ArrayList<Dish> getCuisineList(){
		return cuisineList;
	}
	
	public void setName(String name){
		this.name=name;
	}

	public String getName(){
		return name;
	}
	
	public void setCuisineID(int cuisineID){
		this.cuisineID=cuisineID;
	}
	
	public int getCuisineID(){
		return cuisineID;
	}
	
	
	//creates a new dish and add it to the cuisine ArrayList
	public void NewDish() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (isr);
		
		Dish dish = new Dish();	
		Menu menu = Menu.Instance();
		
		System.out.println("New dish. ");
		System.out.println("In which cuisine you want to ad it? (select number). ");
		menu.ShowCuisines();
		int cuisineID = Integer.parseInt(br.readLine());
		
		System.out.println("New dish. ");
		
		System.out.print("New dish name: ");
		dish.setName(br.readLine()); 
		
		System.out.print("Prize: ");
		dish.setPrize(Double.parseDouble(br.readLine()));
		dish.setCuisineID(cuisineID); 
		
		cuisineList.add(dish); //add dish to the cuisine
		
		ShowDishes(cuisineID);//borrar
		
		System.out.println("Dish added to the selected cuisine.");
		System.out.println("");		
	}
	
	
	//buys a dish and adds the prize to the total prize
	public void BuyDish(int i){ //
		Dish dish = new Dish();
		TotalPayment total = new TotalPayment();
		
		dish = cuisineList.get(i-1); //dish number (its i-1 because in ShowDishes it shows i+1 so theres no dish 0.
		System.out.println(dish.getName() + " - " + dish.getPrize() + "zl. Pruchased");
		total.setTotal(total.getTotal() + dish.getPrize()); //add the prize to the total prize
		System.out.println("Total prize: " + total.getTotal() + "zl.");
	}
	
	
	//runs the array to check which dishes are from the selected cuisine.
	public void ShowDishes(int cuisineID){ 
		Dish dish = new Dish();
		for(int i=0; i< cuisineList.size(); i++){
			dish = cuisineList.get(i);
			if (dish.getCuisineID()==cuisineID){ // The id of the dish is the same than cuisine id			
				System.out.println((i+1) + ". " + dish.getName() + " - " + dish.getPrize() + "zl.");
				System.out.println("");
			}
		}
	}
}
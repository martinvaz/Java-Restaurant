package app;

/*
 * Author: Jorge Martin Vazquez
 * Estimated time of development: 20-25h
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	//test to try the methods.
    public static void main(String[] args) {
    	try {
    		
    		AdminMenu admin = new AdminMenu();
    		
    		admin.ReadFile();
    		
	        AdminProxyPassword proxy = new AdminProxyPassword();
	        
	        InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader (isr);
	    
			
			System.out.println("Choose your login:");
			System.out.println("");
			System.out.println("1. Admin login.");
			System.out.println("2. User login");
			int value = Integer.parseInt(br.readLine());
			
			//login system. Admin option is secured with a password
			switch(value){
		    	case 1: 
		    		boolean login = false;
					while(!login){
						login = proxy.CheckCredentials();
						if (login==true){
							admin.AdminPanel();
						}else{
							System.out.println("Wrong Password.");
						}					
					}
			        break;
		    	case 2:
		    		admin.Menu();
		    		break;
			}		
			
			admin.SaveFile();

			}catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	  } 
}

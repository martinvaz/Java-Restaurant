package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//proxy patern to secure the admin login.
public class AdminProxyPassword {
	
	private int password = 1234;

    public boolean CheckCredentials() throws NumberFormatException, IOException {

        boolean correct = false;
        
        InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (isr);
		
		System.out.print("Enter Admin Password (1234): ");
		int password = Integer.parseInt(br.readLine());
		System.out.println();

		
        if (this.password == password) {
            correct = true;
        }
        
        return correct;
    }
}

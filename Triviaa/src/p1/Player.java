package p1;
import java.util.Scanner;
import java.util.regex.Pattern;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//Using User class as parent
public class Player extends User {
	
	public Player(String Name, String password, String email) {
		super(Name, password, email);
	}
	public Player() {	
	}
	
	//Create Player
	public boolean createPlayer() throws IOException {
		Scanner input = new Scanner(System.in);
		String line;
		BufferedReader fileReader = new BufferedReader(new FileReader("./temp/players.txt"));
		
		System.out.println("Enter Name : ");
		this.Name = input.next();
		System.out.println("Enter email : ");
		this.Email = input.next();
		System.out.println("Enter pass : ");
		this.Password = input.next();
		
		//Split Player Information From file
        while ((line = fileReader.readLine()) != null) {
        	String[] player =  line.split(Pattern.quote(","));
        	this.allPlayers.add(new Player(player[0],player[2],player[1]));
        }
        
		//Check if player is already there or not
        boolean found = false;
        for (Player player : this.allPlayers) 
        { 
            if(this.Email.equals(player.Email)) {
            	found = true;
            	break;
            }
        }
        
        //Creating Player and save in File
        if(!found) {
        	BufferedWriter fileWriter = new BufferedWriter(new FileWriter("./temp/players.txt",true));
        	String playerInfo = this.Name + "," + this.Email + "," + this.Password;
        	fileWriter.write(playerInfo+"\n");
    	    fileWriter.close();
    	    return true;
        }else {
        	System.out.println("Player Already Exists.Try again With Uniqe EmailID");
        	this.createPlayer();	
        }		
        return false;
	}
	
	@Override
	public boolean login() throws IOException {
		Scanner input = new Scanner(System.in);
		String line;
		BufferedReader fileReader = new BufferedReader(new FileReader("./temp/players.txt"));
		
	//Split Player Information From file
        while ((line = fileReader.readLine()) != null) {
        	String[] player =  line.split(Pattern.quote(","));
        	this.allPlayers.add(new Player(player[0],player[2],player[1]));
        }
        
		System.out.println("Enter email : ");
		String email = input.next();
        
		//Check if player is already there or not
        for (Player player : this.allPlayers) 
        { 
        	if(player.Email.equals(email)) {
    			System.out.println("Enter pass : ");
    			String password = input.next();
    			if(player.Password.equals(password)) {
    				System.out.println("login");
    				return true;
    			}else {
    				System.out.println("wrong password ");
    				try {
    					this.login();
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    			}
    			
    		}else {
    			System.out.println("wrong user ");
    			try {
    				this.login();
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    		}
        }
		return false;
	}
}

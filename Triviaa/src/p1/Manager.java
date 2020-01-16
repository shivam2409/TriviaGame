package p1;
import java.io.IOException;
import java.util.Scanner;

public class Manager extends User {

	public Manager() {
		super("admin", "admin", "admin");
	}
	
	//Using override Method to log in manager And extending user class
	@Override
	public boolean login() throws IOException {
		System.out.println(this.Email);
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter email : ");
		String email = input.next();
		
		if(this.Email.equals(email)) {
			System.out.println("Enter pass : ");
			String password = input.next();
			if(this.Password.equals(password)) {
				System.out.println("login");
				return true;
			}else {
				System.out.println("wrong password ");
				try {
					this.login();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
		}else {
			System.out.println("wrong user ");
			try {
				this.login();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return false;
	}
}

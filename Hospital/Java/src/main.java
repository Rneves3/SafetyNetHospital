import java.io.IOException;
import java.util.Scanner;

public class main {
	
	public static void main(String [] args){
		
		

		System.out.println("\n \n			Welcome to the Safety Net Hospitals Network \n\n ");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		StartMenu();
		
	}
	
	
	public static void StartMenu(){
		
		//hospitalNetwork network;
		Scanner reader = new Scanner(System.in);
		String input;
		
		System.out.println("\n Please choose what would you like to see! \n");
		
		
		System.out.println("\n 1.Hospitals \n 2.Doctors \n 3.Appointments \n");
		
		input = reader.nextLine();
		
		if(input.equals("1")){
			
			
			hospitalMenu();
			
		}
		else{
		
		if(input.equals("2")){
			
			
			doctorMenu();
			
		}
		else{
		
		if(input.equals("3")){
			
			
			appointmentMenu();
			
		}
		
		else{
			
			
			System.out.println("\n Please select a valid option! \n \n");
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			StartMenu();
			
		}
		}}
		
	}
	

	public static void hospitalMenu(){
		
		int i = 0;
		System.out.println("\n List of Hospitals available in the network  \n \n ");
		
	}
	
	public static void doctorMenu(){
		
		
		System.out.println("\n List of Doctors available in the network  \n \n ");
		
	}
	
	public static void appointmentMenu(){
		
		
		System.out.println("\n List of scheduled appointments  \n \n ");
		
	}

}

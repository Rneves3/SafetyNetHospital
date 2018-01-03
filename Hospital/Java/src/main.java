package Hospital;
import java.io.IOException;
import java.util.Scanner;

import org.overture.codegen.runtime.SetUtil;
import org.overture.codegen.runtime.VDMSet;

import java.util.Iterator;

public class main {
	
	  private static hospitalNetwork network = new hospitalNetwork();
	  private static Doctor doctor1 = new Doctor("Ricardo");
	  private static  Doctor doctor2 = new Doctor("Joana");
	  private static Doctor doctor3 = new Doctor("Jose");
	  private static Hospital hospital1 = new Hospital("S.Jon");
	  private static Hospital hospital2 = new Hospital("S.Jose");
	  private static Hospital hospital3 = new Hospital("CUF");
	  private static Hospital hospital4 = new Hospital("Coimbra");
	  private static Hospital hospital5 = new Hospital("S.Maria");
	  private static Hospital hospital6 = new Hospital("Arrabida");
	  private static Appointment appointment1 = new Appointment("21-01-2018", "15:30", "Ernesto");
	  private static Appointment appointment2 = new Appointment("11-05-2018", "11:30", "Amelia");
	  private static Appointment appointment3 = new Appointment("08-02-2018", "15:00", "Gertrudes");
	  private static Appointment appointment4 = new Appointment("30-01-2018", "16:30", "Arnaldo");
	
	public static void main(String [] args){
		
		hospitalNetworkTest test = new hospitalNetworkTest();
		test.testAll();
		  
		  network.addDoctors(doctor1);
		  network.addDoctors(doctor2);
		  network.addDoctors(doctor3);
		  
		  network.addHospital(hospital1);
		  network.addHospital(hospital2);
		  network.addHospital(hospital3);
		  network.addHospital(hospital4);
		  
		  network.addAppointments(appointment1);
		  network.addAppointments(appointment2);
		  network.addAppointments(appointment3);
		  network.addAppointments(appointment4);
		  
		  doctor1.addHospital(hospital1);
		  doctor1.addHospital(hospital3);
		  doctor2.addHospital(hospital4);
		  doctor3.addHospital(hospital1);
		  doctor3.addHospital(hospital2);
		  doctor3.addHospital(hospital3);
		  doctor3.addHospital(hospital4);
		  
		  doctor1.addAppointments(appointment3);
		  doctor2.addAppointments(appointment2);
		  doctor3.addAppointments(appointment4);
		  doctor3.addAppointments(appointment1);
		  
		  hospital1.addDoctors(doctor1);
		  hospital1.addDoctors(doctor3);
		  hospital4.addDoctors(doctor2);
		  hospital4.addDoctors(doctor3);
		  hospital2.addDoctors(doctor3);
		  hospital3.addDoctors(doctor1);
		  hospital3.addDoctors(doctor3);
		  
		  hospital1.addAppointments(appointment3);
		  hospital4.addAppointments(appointment2);
		  hospital3.addAppointments(appointment4);
		  hospital1.addAppointments(appointment1);
		  
		

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
		
		Scanner reader = new Scanner(System.in);
		int input;
		int i = 1;
		int j = 1;
		
		System.out.println("\n List of Hospitals available in the network  \n \n ");
		
		for (Iterator<Hospital> iter = network.getHospitals().iterator(); iter.hasNext(); ) {
			Hospital hosp = iter.next();
			System.out.println(i + ". Hospital" + ": " + hosp.getName());
			i++;
		}
		
		System.out.println( (i + 1) + ". Add Hospital \n" + (i + 2) + ". Hospital with the most appointments \n" +
		(i+3) + ". Previous Menu \n");
		
		System.out.println("\n Please select what you would like to do \n \n ");
		
		input = reader.nextInt();
		
		if(input > (i+3)){
			
			System.out.println("\n Please enter a possible number \n \n ");
			hospitalMenu();
			
		}
		
		if(input == (i+3)){
			
			StartMenu();
			
		}
		
		if(input == (i+2)){
			
			Hospital result = network.getHospitalMostAppointments();
			System.out.println(" The Hospital with the most appointments is: " + result.getName() + "\n");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			hospitalMenu();
			
		}
		
		if(input == (i+1)){
			
			createAddHospital();
			
		}
		
		if(input <= i){
			
			
			for (Iterator<Hospital> iter = network.getHospitals().iterator(); iter.hasNext(); ) {
				Hospital hosp = iter.next();
				System.out.println(i + ". Hospital" + ": " + hosp.getName());
				if(j <  input){
				j++;
				}
				else{
					individualHospitalMenu(hosp);
					break;
				}
			}
			
		}
		
		}
	
	public static void doctorMenu(){
		
		Scanner reader = new Scanner(System.in);
		int input;
		int i = 1;
		int j = 1;
		
		System.out.println("\n List of Doctors available in the network  \n \n ");
		for (Iterator<Doctor> iter = network.getDoctors().iterator(); iter.hasNext(); ) {
			Doctor doc = iter.next();
			System.out.println("Doctor " + i + ": " + doc.getName()+ "\n");
			i++;
		}
		
		System.out.println( (i + 1) + ". Add Doctor \n" + (i + 2) + ". Multi-Hospital Doctors \n" +
				(i+3) + ". Previous Menu \n");
		
		input = reader.nextInt();
		
		if(input > (i+3)){
			
			System.out.println("\n Please enter a possible number \n \n ");
			doctorMenu();
			
		}
		
		if(input == (i+3)){
			
			StartMenu();
			
		}
		
		if(input == (i+2)){
			
			VDMSet result = SetUtil.set();
			result = network.getDocsMultipleHospitals();		
			System.out.println(" The Multi-Hospital Doctors are: \n");
			
			for (Iterator<Doctor> iter = result.iterator(); iter.hasNext(); ) {
				Doctor doc = iter.next();
				System.out.println("Doctor " + i + ": " + doc.getName()+ "\n");
				i++;
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			doctorMenu();
			
		}
		
		if(input == (i+1)){
			
			createAddDoctor();
			
		}
		
		if(input <= i){
			
			
			for (Iterator<Doctor> iter = network.getDoctors().iterator(); iter.hasNext(); ) {
				Doctor doc = iter.next();
				System.out.println(i + ". Hospital" + ": " + doc.getName());
				if(j <  input){
				j++;
				}
				else{
					individualDoctorMenu(doc);
					break;
				}
			}
		}
		
	}
	
	public static void appointmentMenu(){
		
		Scanner reader = new Scanner(System.in);
		int input;
		int i = 1;
		int j = 1;
		
		System.out.println("\n List of scheduled appointments  \n \n ");
		for (Iterator<Appointment> iter = network.getAppointments().iterator(); iter.hasNext(); ) {
			Appointment app = iter.next();
			System.out.println("Appointment Client " + i + ": " + app.getClientName() + " on " +
			app.getDate() + " at " + app.getTime() + "\n");
			i++;
		}
		
		System.out.println("1. Add Appointment \n" + (i + 2) + "2. Previous Menu \n");
		
		input = reader.nextInt();
		
		if(input > 2){
			
			System.out.println("\n Please enter a possible number \n \n ");
			doctorMenu();
			
		}
		
		if(input == 2){
			
			StartMenu();
			
		}
		
		if(input == 1){
			
			createAddAppointment();
			
		}
		
	}
	
	public static void createAddHospital(){
		
		Scanner reader = new Scanner(System.in);
		String input;
		
		
		System.out.println("\n Please enter the Hospital Name!  \n \n ");
		
		input = reader.nextLine();
		
		Hospital hosp = new Hospital(input);
		
		network.addHospital(hosp);
		
		System.out.println("Hospital " + input + " has been successfully added to the network \n \n ");
		
	}
	
	public static void individualHospitalMenu(Hospital hosp){
		
		Scanner reader = new Scanner(System.in);
		String input;
		int i = 1;
		int j = 1;
		
		System.out.println("Hospital " + hosp.getName() + "\n \n ");
		
		System.out.println("Doctors: \n ");
		for (Iterator<Doctor> iter = hosp.getDoctors().iterator(); iter.hasNext(); ) {
			Doctor doc = iter.next();
			System.out.println("Doctor " + i + ": " + doc.getName()+ "\n");
			i++;
		}
		
		System.out.println("Appointments: \n ");
		for (Iterator<Appointment> iter = hosp.getAppointments().iterator(); iter.hasNext(); ) {
			Appointment app = iter.next();
			System.out.println("Appointment Client " + j + ": " + app.getClientName() + " on " +
			app.getDate() + " at " + app.getTime() + "\n");
			j++;
		}
		
		System.out.println("\n 1.Add Doctor \n 2.Add appointment \n 3.Previous Menu \n");
		
		input = reader.nextLine();
		
		if(input.equals("1")){
			String docName;
			System.out.println("\n Enter doctors name \n");
			docName = reader.nextLine();
			Doctor doc = new Doctor(docName);
			hosp.addDoctors(doc);
			
			System.out.println("\n Doctor " + docName + " has been successfully added to the hospital\n ");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			hospitalMenu();
			
		}
		else{
		
		if(input.equals("2")){
			String date, time, clientName;
			System.out.println("\n Enter a date 'dd-mm-yy' \n");
			date = reader.nextLine();
			System.out.println("\n Enter the time (from 9:00 to 20:00 \n");
			time = reader.nextLine();
			System.out.println("\n Enter the clients name \n");
			clientName = reader.nextLine();
			Appointment app = new Appointment(date, time, clientName);
			hosp.addAppointments(app);
			System.out.println("\n Appointment successfully added \n");
			hospitalMenu();
			
		}
		else{
		
		if(input.equals("3")){
			
			StartMenu();
			
		}
		
		}

		}
	}
	
	public static void createAddDoctor(){
		
		Scanner reader = new Scanner(System.in);
		
		String docName;
		System.out.println("\n Enter doctors name \n");
		docName = reader.nextLine();
		Doctor doc = new Doctor(docName);
		network.addDoctors(doc);
		
		System.out.println("\n Doctor " + docName + " has been successfully added to the hospital\n ");
		
		doctorMenu();
	}
	
	public static void individualDoctorMenu(Doctor d){
		
		Scanner reader = new Scanner(System.in);
		String input;
		int i = 1;
		int j = 1;
		
		System.out.println("Doctor " + d.getName() + "\n \n ");
		
		System.out.println("Hospitals: \n ");
		for (Iterator<Hospital> iter = d.getHospitals().iterator(); iter.hasNext(); ) {
			Hospital h = iter.next();
			System.out.println("Hospital " + i + ": " + h.getName()+ "\n");
			i++;
		}
		
		System.out.println("Appointments: \n ");
		for (Iterator<Appointment> iter = d.getAppointments().iterator(); iter.hasNext(); ) {
			Appointment app = iter.next();
			System.out.println("Appointment Client " + j + ": " + app.getClientName() + " on " +
			app.getDate() + " at " + app.getTime() + "\n");
			j++;
		}
		
		System.out.println("\n 1.Add Hospital \n 2.Add appointment \n 3.Previous Menu \n");
		
		input = reader.nextLine();
		
		if(input.equals("1")){
			String hospName;
			System.out.println("\n Enter Hospital name \n");
			hospName = reader.nextLine();
			Hospital hosp = new Hospital(hospName);
			d.addHospital(hosp);
			
			System.out.println("\n Hospital " + hospName + " has been successfully added to the hospital\n ");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			doctorMenu();
			
		}
		else{
		
		if(input.equals("2")){
			String date, time, clientName;
			System.out.println("\n Enter a date 'dd-mm-yy' \n");
			date = reader.nextLine();
			System.out.println("\n Enter the time (from 9:00 to 20:00 \n");
			time = reader.nextLine();
			System.out.println("\n Enter the clients name \n");
			clientName = reader.nextLine();
			Appointment app = new Appointment(date, time, clientName);
			d.addAppointments(app);
			System.out.println("\n Appointment successfully added \n");
			doctorMenu();
			
		}
		else{
		
		if(input.equals("3")){
			
			StartMenu();
			
		}
		
		}

		}
	}
	
	public static void createAddAppointment(){
		
		Scanner reader = new Scanner(System.in);
		
		String date, time, clientName;
		System.out.println("\n Enter a date 'dd-mm-yy' \n");
		date = reader.nextLine();
		System.out.println("\n Enter the time (from 9:00 to 20:00 \n");
		time = reader.nextLine();
		System.out.println("\n Enter the clients name \n");
		clientName = reader.nextLine();
		Appointment app = new Appointment(date, time, clientName);
		network.addAppointments(app);
		System.out.println("\n Appointment successfully added \n");
		
		appointmentMenu();
		
	}
	
}


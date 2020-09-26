package core;

import static util.AppUtil.*;
import java.io.*;
import java.util.*;


public class Kid {
	
	private String cnp;
	private String firstName;
	private String secondName;
	private int age;
	private String phoneNumber;
	
	public Kid(String cnp,String firstName,String secondName,int age,String phoneNumber) {
		
		this.cnp = cnp;
		this.firstName = firstName;
		this.secondName = secondName;
		this.age = age;
		this.phoneNumber = phoneNumber;	
		
	}
	
	public Kid() {
		
	}

	public static List<Kid> getKidsByFile(FileReader file){
		
		List<Kid> totalKids = new ArrayList<Kid>();
		String line = null;
		String[] splitLine = null;
		BufferedReader bufferedReader = new BufferedReader(file);
		
		try {
			while((line = bufferedReader.readLine()) != null ) {
				
				splitLine = line.split(",");
				
				Kid kid = new Kid(splitLine[0],splitLine[1],splitLine[2],Integer.parseInt(splitLine[3]),splitLine[4]);
				
				totalKids.add(kid);
				
			}
		} catch (IOException e) {
			
			e.printStackTrace();	
			
		} catch (NumberFormatException e) {
			
			System.out.println("You are trying to parse something that is not a number!!! ");
			
			e.printStackTrace();
			
		}
		
		return totalKids;
		
	}
	
	public static void printKids(List<Kid> kids) {
		
		kids.sort(Comparator.comparing(Kid::getFirstName));
		
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.printf("%10s %15s %5s %20s %20s","First Name","Last Name","   Age","CNP      ","Phone    ");
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------------");
		
		for(int i = 0 ; i < kids.size(); i++) {
			
			Kid currentKid = kids.get(i);
			
			System.out.format("%10s %15s %5d %20s %20s",currentKid.getFirstName(),
					currentKid.getSecondName(),currentKid.getAge(),
					currentKid.getCnp(),currentKid.getPhoneNumber());
			
			System.out.println();
			
		}
		
	}
	
	public static Kid enterKidData() {
		
		Scanner keyboard = getKeyboard();
		
		Kid newKid = new Kid();
		
		System.out.println("Enter CNP:");
		newKid.setCnp(keyboard.nextLine());
		System.out.println("Enter First Name:");
		newKid.setFirstName(keyboard.nextLine());
		System.out.println("Enter Last Name:");
		newKid.setSecondName(keyboard.nextLine());
		System.out.println("Enter Age:");
		newKid.setAge(Integer.parseInt(keyboard.nextLine()));
		System.out.println("Enter Phone Number:");
		newKid.setPhoneNumber(keyboard.nextLine());
		System.out.println();
		
		keyboard.close();
		
		return newKid;
	}
	
	public boolean checkCNP(FileReader file) throws IOException {
		
		BufferedReader bufferedReader = new BufferedReader(file);
		String line = null;
		
		while((line = bufferedReader.readLine())!= null) {
			if(line.contains(this.getCnp())) {
				return true;
			}
		}
	
		return false;	
		
	}
	
	public void registedKid(FileWriter file , FileReader fileRead) throws IOException {
		
		if(checkCNP(fileRead)) {
			System.out.println("There is already a kid with this CNP: "+this.getCnp()+" \nPlease check the CNP!");
			return;
		}
		
		String entryLine = this.getCnp() + "," + this.getFirstName() + "," 
		+ this.getSecondName() + "," +this.getAge() + "," +this.getPhoneNumber();
		
		BufferedWriter bufferedWriter = new BufferedWriter(file);
		PrintWriter printWriter = new PrintWriter(bufferedWriter);
		
		printWriter.println(entryLine);
		printWriter.flush();
		
		file.close();
		fileRead.close();
	}
	
	public String getCnp() {
		return cnp;
	}
	public void setCnp(String cnp) {
		this.cnp = cnp;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}

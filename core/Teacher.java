package core;
 
import java.io.*;
import java.util.*;

public class Teacher {
	
	private String cnp;
	private String firstName;
	private String secondName;
	private int age;
	private int yearsOfExperience;
	private String group;
    private String phoneNumber;
	
    public Teacher(String cnp,String firstName,String secondName,int age,int yearsOfExperience,String group,String phoneNumber) {
		
		this.cnp = cnp;
		this.firstName = firstName;
		this.secondName = secondName;
		this.age = age;
		this.yearsOfExperience = yearsOfExperience;
		this.group = group;
		this.phoneNumber = phoneNumber;
	}
    public Teacher() {
		
	}
	public static List<Teacher> getTeacherByFile(FileReader file){
		
    	List<Teacher> totalTeachers = new ArrayList<Teacher>();
    	
		String line = null;
		String[] splitLine = null;
		BufferedReader bufferedReader = new BufferedReader(file);
		
		try {
			while((line = bufferedReader.readLine()) != null ) {
				
				splitLine = line.split(",");
				
				Teacher teacher = new Teacher(splitLine[0],splitLine[1],splitLine[2],Integer.parseInt(splitLine[3]),Integer.parseInt(splitLine[4]),splitLine[5],splitLine[6]);
				
				totalTeachers.add(teacher);
				
			}
		} catch (IOException e) {
			
			e.printStackTrace();	
			
		} catch (NumberFormatException e) {
			
			System.out.println("You are trying to parse something that is not a number!!! ");
			
			e.printStackTrace();
			
		}
		
		return totalTeachers;
		
	}
    public static void printTeachers(List<Teacher> teachers) {
		
		teachers.sort(Comparator.comparing(Teacher::getFirstName));
		
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.printf("%10s %15s %5s %20s %5s %10s %15s","First Name","Last Name","   Age","CNP      ","Years Of Experience    ","Group","Phone Number");
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------------");
		
		for(int i = 0 ; i < teachers.size(); i++) {
			
			Teacher currentTeacher = teachers.get(i);
			
			System.out.format("%10s %15s %5s %20s %5s %10s %15s",currentTeacher.getFirstName(),
					currentTeacher.getSecondName(),currentTeacher.getAge(),
					currentTeacher.getCnp(),currentTeacher.getYearsOfExperience(),currentTeacher.getGroup(),
					currentTeacher.getPhoneNumber());
			
			System.out.println();
		}
		}
		public static Teacher enterTeacherData(Scanner keyboard) {
				
			Teacher newTeacher = new Teacher();
			
			System.out.println("Enter CNP:");
			newTeacher.setCnp(keyboard.nextLine());
			System.out.println("Enter First Name:");
			newTeacher.setFirstName(keyboard.nextLine());
			System.out.println("Enter Last Name:");
			newTeacher.setSecondName(keyboard.nextLine());
			System.out.println("Enter Age:");
			newTeacher.setAge(Integer.parseInt(keyboard.nextLine()));
			System.out.println("Enter Years Of Experience:");
			newTeacher.setPhoneNumber(keyboard.nextLine());
			System.out.println("Enter The Group:");
			newTeacher.setGroup(keyboard.nextLine());
			System.out.println("Enter Phone Number:");
			newTeacher.setPhoneNumber(keyboard.nextLine());
			System.out.println();
			
			return newTeacher;
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
		
		public void registedTeacher(FileWriter file , FileReader fileRead) throws IOException {
			
			
			if(checkCNP(fileRead)) {
				System.out.println("There is already a kid with this CNP: "+this.getCnp()+" \nPlease check the CNP!");
			    return;
			}
			else {
				if(this.getCnp().length()!= 14)
					System.out.println("You dont have 14 numbers in your CNP.\nPlease check them: "+this.getCnp()
					+" and insert all the numbers of your CNP!");		
			}
			String entryLine = this.getCnp() + "," + this.getFirstName() + "," 
					+ this.getSecondName() + "," +this.getAge() + "," +this.getYearsOfExperience()
					+ "," + this.getGroup() + "," + this.getPhoneNumber();
					
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
	
	public int getYearsOfExperience() {
		return yearsOfExperience;
	}
	
    public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
    
    public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}

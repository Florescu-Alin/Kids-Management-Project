package core;

import static core.Kid.*;
import static files.FileUtil.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import util.AppUtil;

public class AppMenu {

	public static void main(String[] args) {
		
	   List<Kid> kids = new ArrayList<Kid>();
	   Kid newkid = new Kid();
	   List<Teacher> teachers = new ArrayList<Teacher>();
	   Teacher newTeacher = new Teacher();
	   
	   FileReader fileRead = loadFile("kids.txt");
	   FileWriter fileWriter = writeInFile("kids.txt");
	   
	   FileReader teachersFileRead = loadFile("teachers.txt");
	   FileWriter teachersFileWriter = writeInFile("teachers.txt");
	   
	   
	   kids = getKidsByFile(fileRead);
	   
	   int  endSimulator = 1;
	   
	   Scanner keyboard = AppUtil.getKeyboard();
	   
	   do {
		   
		   System.out.println("==========Kindergarden Management==========");
		   System.out.println("See the kids.------1");
		   System.out.println("Add a new kid.------2");
		   System.out.println("Remove a kid.-----3");
		   System.out.println("See the teachers.------4");
		   System.out.println("Add a new teacher.-------5");
		   System.out.println("See the groups.------6");
		   System.out.println("Close the program.-----0");
		   
		
		   String line = keyboard.nextLine();
		   endSimulator = Integer.parseInt(line);
		 
		   switch(endSimulator) {
		   
		   	   case 0:
		   	   {
		   		   break;
		   	   }
		   
			   case 1:
			   {
				   System.out.println("The kids in our kindergarden are: ");
				   Kid.printKids(kids);
				   System.out.println();
				   
				   break;
			   }
			   case 2:
			   {
				   System.out.println("Enter the following information for the new kid: ");
				   newkid = Kid.enterKidData(keyboard);
				   kids.add(newkid);
				   try {
						  fileRead = loadFile("kids.txt");
						  newkid.registedKid(fileWriter, fileRead);
						  
					  }
					  catch (IOException e ) {
						  e.printStackTrace();
					  }	   
				   break;
			   }
			   case 3:
			   {
				   System.out.println("Remove kids.");
				   
			   }
			   case 4:
			   {
				   System.out.println("The teachers in our kindergarden are: ");
				   Teacher.printTeachers(teachers);
				   System.out.println();
				   
				   break;
			   }
			   case 5:
			   {
				   System.out.println("Enter the following information for the new teacher: ");
				   newTeacher = Teacher.enterTeacherData(keyboard);
				   teachers.add(newTeacher);
				   try {
					   fileRead = loadFile("teachers.txt");
					   newTeacher.registedTeacher(teachersFileWriter, teachersFileRead);
				   }
				   catch(IOException e) {
					   e.printStackTrace();
				   }
				   break;
			   }
			   default:
			   {
				   
				   System.out.println("Chose a correct option!");
				   break;
			   }		   
		   }	   
	   }
	   
	   while (endSimulator != 0);
	          
	}
	
}



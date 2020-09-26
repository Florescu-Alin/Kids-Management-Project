package core;

import static core.Kid.*;
import static files.FileUtil.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class AppMenu {

	public static void main(String[] args) {
		
	   List<Kid> kids = new ArrayList<Kid>();
	   Kid newkid = new Kid();
	 
	   FileReader fileRead = loadFile("kids.txt");
	   FileWriter fileWriter = writeInFile("kids.txt");
	   
	   kids = getKidsByFile(fileRead);
	   
	   printKids(kids);
	   
	  newkid = Kid.enterKidData();
	  
	  try {
		  fileRead = loadFile("kids.txt");
		  newkid.registedKid(fileWriter, fileRead);
	  }
	  catch (IOException e ) {
		  e.printStackTrace();
	  }
	   
	}
	
}



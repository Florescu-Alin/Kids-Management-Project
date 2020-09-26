package files;

import java.io.*;

public class FileUtil {

	public static final String path = "src/files/";
		
	public static FileReader loadFile(String fileName) {
		
		String filePath = path + fileName;
		FileReader fileReader = null;
		
		try {
			//FileReader reads text files in the default encoding.
			fileReader = new FileReader(filePath);
		}

		catch (FileNotFoundException e){
			
			System.out.println("File"+fileName+"couldn't be loaded!");
			
		}
		return fileReader;
	}
	
	public static FileWriter writeInFile(String fileName) {
		
		String filePath = path + fileName;
		FileWriter fileWriter = null;
		
		try {
			
			fileWriter = new FileWriter(filePath,true);
		}

		catch (FileNotFoundException e){
			
			System.out.println("File"+fileName+"couldn't be loaded!");
			
		}
		catch (IOException e) {
			
			e.printStackTrace();
			
		}
		return fileWriter;
		
	}
	
}

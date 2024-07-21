package fileHandling;

import java.io.File;

public class NewFile {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try
		{
			//creation of file object in a specified path
			File fileobject = new File("D:newFileCreation.txt");
			
			
			//creating a new file
			if(fileobject.createNewFile())
			{
				System.out.println("File "+fileobject.getName()+" is created at "+fileobject.getPath());
				
			}
			else
			{
				System.out.println("The file already exists");
			}
		}
		catch(Exception e)
		{
			System.out.println("File is not created, Error");
			e.printStackTrace();
		}
	}

}

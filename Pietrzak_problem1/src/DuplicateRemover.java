import java.io.*;
import java.util.*;

public class DuplicateRemover {
	
	// Create the scanner and ArrayList to be universal within the object.
	Scanner scn;
	
	private ArrayList<String> uniqueNames = new ArrayList<String>();
	
	//Create a method called remove that removes duplicates from a text file using FileInputStream.
	public void remove(FileInputStream dataFile)
	{
		//Create a temporary string and set it to null, then set a boolean isDuplicate and set it to false.
		String tmp = null;
		boolean isDuplicate = false;
		
		//Initialize the scanner that will be reading from the data file.
		scn = new Scanner(dataFile);
		//Add a blank spot to uniqueNames as so not to cause any errors within the loop.
		uniqueNames.add("");
		//Execute this loop while there is a next variable within the file.
		while(scn.hasNext())
		{
			//Search for the next word within the file.
			tmp = scn.next();
			//Execute this loop until the number of unique names is reached.
			for(int i = 0; i < uniqueNames.size(); i++)
			{
				//If the temporary name is equal to any of the names within the loop, then isDuplicate is true
				if(tmp.equals(uniqueNames.get(i)))
				{
					isDuplicate = true;
				}
			}
			//If there are no duplicates, then add the name to the uniqueNames arrayList.
			if(!isDuplicate)
			{
				uniqueNames.add(tmp);
			}
			
			isDuplicate = false;
		}
	}
	//Create a method called write that writes the code into a new output file using FileOutputStream.
	public void write(FileOutputStream outputFile)
	{
		//Use PrintWriter object to create an object called outFile.
		PrintWriter outFile = new PrintWriter(outputFile);
		//Create a loop that prints the unique names into the output file.
		for(int i = 0; i < uniqueNames.size(); i++)
		{
			outFile.print(uniqueNames.get(i) + " ");
		}	
		//Clean up the outFile
		outFile.flush();
	}
}
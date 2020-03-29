import java.io.*;
import java.util.*;

public class DuplicateCounter {
	//Create a scanner object and set it to null.
	Scanner scn = null;
	//Create a linked hashmap object; the reason it is linked is so that it can be tracked.
	Map<String, Integer> map = new LinkedHashMap<String, Integer>();
	int wordCounter = 0;
	
	//Create a function that counts the number of duplications of words within a file.
	public void count(FileInputStream dataFile)
	{
		//Set a string equal to null and create a new scanner object with a parameter of dataFile.
		String tmp = null;
		scn = new Scanner(dataFile);
		//Initialize the first object within map to an empty variable.
		map.put("", 0);
		
		//Loop through the entire file until the end has been reached
		while(scn.hasNext())
		{
			//Set tmp equal to the upcoming word in the file.
			tmp = scn.next();
			for(int i = 0; i < map.size(); i++)
			{
				//If tmp is equal to the word within the map coordinates, add one to wordCounter.
				if(tmp.equals(map.get(i)))
					wordCounter++;
			}
		}
	}
	
	//This funciton writes the wordCounter into a file.
	public void write(FileOutputStream outputFile)
	{
		//Create a printWriter called printer, then print wordCounter onto it.
		PrintWriter printer = new PrintWriter(outputFile);
		
		printer.print(wordCounter);
		
	}

}

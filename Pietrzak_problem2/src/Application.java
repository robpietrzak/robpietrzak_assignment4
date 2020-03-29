import java.io.*;

public class Application {
	
	public static void main(String[] args){
		//Create  a new instance of DuplicateCounter called duplicateCounter.
		DuplicateCounter duplicateCounter = new DuplicateCounter();
		
		//Set the FileInputStream and FileOutputStream both equal to null.
		FileInputStream input = null;
		FileOutputStream output = null;
		
		//Attempt to open "problem2.txt". If failed, report to the user that the file does not exist.
		try
		{
			input = new FileInputStream("problem2.txt");
			output = new FileOutputStream("unique_word_counts.txt");
			
			duplicateCounter.count(input);
			duplicateCounter.write(output);
			
		}
		catch (IOException e)
		{
			System.out.println("The file does not exist.");
		}
		
		finally
		{
			//Attempt to close the file. If failed, report to the user that the file could not be closed.
			try
			{
				if(input!= null)
				{
					input.close();
				}
				if(output != null)
				{
					output.close();
				}
			}
			catch(IOException e)
			{
				System.out.println("Could not close the file.");
			}
		}
	}

}

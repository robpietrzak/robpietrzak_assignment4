import java.io.*;

public class Application {

	public static void main(String[] args) {
		//Create an instance of DuplicateRemover called duplicateRemover.
		DuplicateRemover duplicateRemover = new DuplicateRemover();
		
		//Create FileInputStream and FileOutputStream objects and set them equal to null.
		FileInputStream input = null;
		FileOutputStream output = null;
		
		//Try to open a text file called "problem1.txt." if unable to, tell the user there was an error.
		try
		{
			input = new FileInputStream("problem1.txt");
			output = new FileOutputStream("unique_words.txt");
			
			duplicateRemover.remove(input);
			duplicateRemover.write(output);
		
		}
		//If an IOException error is caught, the file probably does not exist.
		catch (IOException e)
		{
			System.out.println("Please check if your file exists.");
		}
		
		finally
		{
			//Attempt to close the file. If failed, the file could not be closed for some reason.
			try
			{
				if(input != null)
					input.close();
				if(output != null)
					output.close();
			}
			catch(IOException e)
			{
				System.out.println("Could not close the file.");
			}
		}
	}

}

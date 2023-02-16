import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Peter McLane
 *
 */
public class popularBabyNames {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	//Peter McLane 04/26/21
	//This program will allow you to search for how popular baby names have been over recent years
	//based on the name you search the program will print to the screen the number of babies who were named said name each year
	public static void main(String[] args) throws FileNotFoundException {
		
		
		   //Scanner to get input from user
	       Scanner keyboard = new Scanner(System.in);
	      
	      //another scanner that reads the data from the .txt file
	       Scanner infile = new Scanner(new File("names.txt"));
	      
	       
	       String nameFromUser = ""; 
	       String nameFromFile = ""; 
	       int[] popularity = new int[11]; 
	      
	       //here we will ask the user to enter a name of a baby
	       System.out.print("What is the name you would like to search? ");
	       nameFromUser = keyboard.next();
	      
	       //here we repeat the loop for all names in the file so that we can find correct name 
	       while(infile.hasNext())
	       {
	           //read a name from the file
	           nameFromFile = infile.next();
	          
	           //verify whether the name from file is equal to the name from keyboard
	           if(nameFromFile.equals(nameFromUser))
	           {
	               //here if both names are equal read the popularity of 11 years
	               for(int i = 0; i < popularity.length; i++)
	               {
	                   popularity[i] = infile.nextInt();
	               }
	               break; 
	           }
	           else
	           {
	               
	               infile.nextLine();
	           }
	       }  
	      
	       //here we are checking to make sure that the name from the txt file matches user input
	       if(nameFromFile.equals(nameFromUser))
	       {
	           //if the name matches here we will print the statistics on the name
	           System.out.println("\nStatistics on the name \"" + nameFromUser + "\"\n");
	           for(int i = 0, year = 1900; i < 11; i++, year += 10)
	           {
	               System.out.println(year + ": " + popularity[i]);
	           }
	       }
	       else
	       {
	           //here we are letting the user know we couldn't find the name in the file
	           System.out.println("\n\"" + nameFromUser + "\" was not found in the file!");
	       }
	      
	       //after we are done we close out the file 
	       infile.close();      
	}

}

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DVDCollection {

	// Data fields
	int  hello = 0;
	int runnTime = 0;
	int remv = 0;
	
	
	
	/** The current number of DVDs in the array */
	private int numdvds;		
	
	/** The array to contain the DVDs */
	private DVD[] dvdArray;
	
	/** The name of the data file that contains dvd data */
	private String sourceName;
	
	/** Boolean flag to indicate whether the DVD collection was
	    modified since it was last saved. */
	private boolean modified;
	
	/**
	 *  Constructs an empty directory as an array
	 *  with an initial capacity of 7. When we try to
	 *  insert into a full array, we will double the size of
	 *  the array first.
	 */
	public DVDCollection() {
		numdvds = 0;
		dvdArray = new DVD[7];
	}
	
	public String toString() throws NullPointerException{
		// Return a string containing all the DVDs in the
		// order they are stored in the array along with
		// the values for numdvds and the length of the array.
		// See homework instructions for proper format.
		
		
		String toString = ("numdvds = " + numdvds + '\n' + "dvdArray.length = "+ dvdArray.length + '\n');
		
		try {
		for(int i = 0; i < numdvds; i++) {
			
			toString += dvdArray[i].toString()+ "\n";		
			
		
		}
		}
		catch(NullPointerException e) 
        { 
            //System.out.print("NullPointerException Caught in toStrings()"); 
        } 
		
		return toString;
			
		
		
		
		
		

		



		
	}

	public void addOrModifyDVD(String title, String rating, String runningTime)  throws NumberFormatException{
		// NOTE: Be careful. Running time is a string here
		// since the user might enter non-digits when prompted.
		// If the array is full and a new DVD needs to be added,
		// double the size of the array first.

		
		// To check if its a valid rating 
		
		while (!("PG".equals(rating) | "PG-13".equals(rating) | "R".equals(rating) | "X".equals(rating) | "G".equals(rating)
				| "NC-17".equals(rating)
				)){
			System.out.println("Please enter rating from only these 6 options to continue. Thank you!");
			System.out.println("PG | R | PG-13 | X | G | NC-17");
			Scanner w = new Scanner(System.in);
			rating = w.nextLine();
			
		}

		
		
		// set the title to uppercase
		title = title.toUpperCase();
		
		
		// to check if its valid rating
		String r1 = "PG";String r2 = "PG-13", r3 = "G", r4 = "G", r5 = "X"; String r6 = "R";


		

		
		
		
		
		
		
		// To cast String to int runTime
		int runtime = setRunningTime(runningTime);
		
		
		
				
		// to check if the title exists in the list or not
		if (checkTitle(title) == true)
		{
			//System.out.println("Hey");
			dvdArray[remv].setRating(rating);
            dvdArray[remv].setRunningTime(runtime);
            modified = true;
		}
		// to add the new entry
		else 
		{
			// to double the size of the array
			if (isFull() == true) {
				doubleCapacity();
			}
			
			
			
			//title = sortString(title);
		   DVD newDVD = new DVD(title, rating, runtime);
		   dvdArray[numdvds++] = newDVD;
		   
			
		}
		}
		
		

	
	
	
	
	public void removeDVD(String title) throws NullPointerException{
		
		try {
		title = title.toUpperCase();
		int length = title.length();
		if (checkTitle(title) == true) {
			System.out.println("Yes, it is true");
			
			
//			DVD[] result = new DVD[dvdArray.length - 1];
//			System.arraycopy(dvdArray, 0, result, 0, remv);
//			if (dvdArray.length != remv) {
//			    System.arraycopy(dvdArray, remv + 1, result, remv, dvdArray.length - remv - 1);
//			}
//			

		    System.arraycopy(dvdArray, remv + 1, dvdArray, remv, dvdArray.length - 1 - remv);
			
			numdvds--;
			modified = true;
			
			
		}
		else {
			System.out.println("Sorry the item is not present in the DVD Collection");
		}



		}
		catch(NullPointerException e) 
        { 
            System.out.print("NullPointerException Caught in remove function"); 
        } 
		

	}
	
	public String getDVDsByRating(String rating) {
		String rats = "";
		if(numdvds > 0) {
			for (int t = 0;t < numdvds; t++) {
				if (dvdArray[t].getRating().compareTo(rating) == 0) {
					
					rats += dvdArray[t].getTitle() + "/" + dvdArray[t].getRating() + "/" + dvdArray[t].getRunningTime() +  "\n";
				}
				
			}
			
			}
		return rats;

	}

	public int getTotalRunningTime() {
		
		int output = 0;
		if (numdvds > 0) {
		for (int i = 0; i < numdvds; i++) {
			output += dvdArray[i].getRunningTime();
			
		}
		}
		else {
			output = 0;
		}



		return output;	// STUB: Remove this line.

	}

	
	public void loadData(String filename) {
		String temp = "";
		int in = 0;
		String[] DVDS = {};
		ArrayList<String> cars = new ArrayList<String>(); 
		try (java.util.Scanner keyboard = new java.util.Scanner(new FileReader(filename)).useDelimiter("\n"))
		{
			
			while ((keyboard.hasNext())) {
			
			temp = keyboard.nextLine();
			DVDS = temp.split(",");
			in++;
			
			Pattern pattern = Pattern.compile(",");
			Matcher matcher = pattern.matcher(temp);
			
			 int count = 0;
		        while (matcher.find()) {
		            count++;
		        }
		        if (count == 2) { 
		        	addOrModifyDVD(DVDS[0], DVDS[1], DVDS[2]);
		        	
		        }
		        else {
		        	System.out.println("two many commas, that is not valid.");
		        }
			
			
			
			
			
			}
			
			modified = false;
			
		}
		
		
		 catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("error caught in load()");
			}

		
	}
	
	public void save() {
		
		
			
				// local variabls
			//String ok = "";
			
				
				
				try {
					//System.out.println("Hello");
			      FileWriter myWriter = new FileWriter("/home/pyaks/Desktop/DVDS/DVDFile.txt", false);
			      
			     // myWriter.write("Files in Java might be tricky, but it is fun enough!");
			      
			      for (int i = 0; i < numdvds; i++) {
			    	  myWriter.write(dvdArray[i].getTitle() + "," + dvdArray[i].getRating() + "," + dvdArray[i].getRunningTime() +  "\n");
			
			      }
			      //myWriter.append(ok);
			      myWriter.close();
			      //System.out.println("Successfully wrote to the file.");
			    } catch (IOException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			    }
			
			System.out.println("Saved succesfully in file.Thank you");
			
		}



	
	// Additional private helper methods go here:
	
	// To check if the Array is full
	public boolean isFull() {
		boolean yes = false;
		
		for (int i = 0; i <   dvdArray.length;i++) {
			if (dvdArray[i] != null) 
			{
				//System.out.println("not full");
				yes = true;
			}
			else {
				//System.out.println("full");
				yes = false;
			}
		
		}
		return yes;
	}
	
	// To double the capacity
	public void doubleCapacity() {
		dvdArray = Arrays.copyOf(dvdArray, dvdArray.length * 2);
	}
	
	// check if the Title exists in the dvdArray
	public boolean checkTitle(String title) {
		boolean yyy = false;
		try
        { 
		//System.out.println(dvdArray.length);
		if(numdvds > 0) {
		for (int i = 0; i < numdvds; i++) {
			if (dvdArray[i].getTitle().compareTo(title) == 0) {
				yyy = true;
				//hello = i;
				remv = i;
			}
		}
		}
        } 
        catch(NullPointerException e) 
        { 
            //System.out.print("NullPointerException Caught"); 
        } 
		
		
		
		return yyy;
	}
	
	// To set up runing time int
	public int setRunningTime(String runningTime) throws NumberFormatException
	{
		
		try {
			
			runnTime = Integer.parseInt(runningTime);
			
			 
		}
		catch (NumberFormatException e) {
			
	        System.out.println("Convertion Error");
	        System.out.println("Please enter the digit again, only digit for running time. Thank you!");
	        Scanner keyboards = new Scanner(System.in);
	        runningTime = keyboards.nextLine();
	        runnTime = Integer.parseInt(runningTime);
	        
			
	        
	    }

		return runnTime;
	}
	
	public boolean setCheckRating (String rating) throws NullPointerException{
		boolean yes = false;
		try 
		{
		if (rating == "PG" || rating == "R" || rating == "PG-13" || rating == "X") {
			yes = true;
		}
		}
		catch (NullPointerException e) {
		if (yes != true) {
			
			System.out.println("Please enter the ratings from only following options");
			System.out.println("PG | R | PG-13 | X");
			Scanner x = new Scanner(System.in);
			String xx = x.nextLine();
			setCheckRating(rating);
			
		}
		}
		return yes;
	}
		
	
	
	
	
	
}
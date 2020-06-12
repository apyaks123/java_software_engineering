public class DVD {

	// Fields:

	private String title;		// Title of this DVD
	private String rating;		// Rating of this DVD
	private int runningTime;	// Running time of this DVD in minutes

	public DVD(String dvdTitle, String dvdRating, int dvdRunningTime) 
	{
		// My code for setting constructor
		
		this.title = dvdTitle;
		this.rating = dvdRating;
		this.runningTime = dvdRunningTime;


	
	}
	
	public String getTitle() 
	{



		return this.title;	// STUB: Remove this line.
	}
	
	public String getRating() 
	{



		return this.rating;	// STUB: Remove this line.
	}
	
	public int getRunningTime() 
	{

//		String x;
//		x = Integer.toString(this.runningTime);

		return this.runningTime;	// STUB: Remove this line.
	}

	public void setTitle(String newTitle) {
//        java.util.Scanner keyboard = new java.util.Scanner(System.in); 
//        newTitle =  keyboard.nextLine();
        //this.title = newTitle.toString(newTitle);
        this.title = newTitle;
		



	}

	public void setRating(String newRating) {

//		java.util.Scanner keyboard = new java.util.Scanner(System.in); 
//		newRating = keyboard.nextLine();
		this.rating = newRating;
		



	}

	public void setRunningTime(int newRunningTime) {


//		java.util.Scanner keyboard = new java.util.Scanner(System.in); 
//		newRunningTime = keyboard.nextInt();
		this.runningTime = newRunningTime;


	}

	public String toString() {

		//String yo;
		

		return this.title + "/" + this.rating + "/" +this.runningTime + "mins";	// STUB: Remove this line.
	}
	
	
}

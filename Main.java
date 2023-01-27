import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//an instance is needed, otherwise I get an cannot make static reference to non-static errors
		Main main = new Main();
		
		//Run is where the code to be executed is placed
		main.run();
	}
	
	public void run() {	
		//Make a linked list to hold race records
		WorkingRecordsList recList = new WorkingRecordsList();
		
		//create a record object for testing and add to linked list, did not have time to implement the use of a MySQL database, so using this as a starting point
		recList.add( new RaceRecord("Stockton Speedway", "4/15/2023", "Nissan Silvia s14", 5, "Raining") );
		recList.add( new RaceRecord("Stockton Speedway", "4/16/2023", "Nissan Silvia s14", 8, "Clear")   );
		recList.add( new RaceRecord("Stockton Speedway", "4/17/2023", "Nissan Silvia s14", 9, "Cloudy")  );
		recList.add( new RaceRecord("Stockton Speedway", "4/18/2023", "Nissan Silvia s14", 12, "Raining") );
		recList.add( new RaceRecord("Stockton Speedway", "4/19/2023", "Nissan Silvia s14", 4, "Clear")   );
		recList.add( new RaceRecord("Stockton Speedway", "4/20/2023", "Nissan Silvia s14", 31, "Cloudy")  );
		recList.add( new RaceRecord("Stockton Speedway", "4/21/2023", "Nissan Silvia s14", 20, "Raining") );
		recList.add( new RaceRecord("Stockton Speedway", "4/22/2023", "Nissan Silvia s14", 19, "Clear")   );
		recList.add( new RaceRecord("Stockton Speedway", "1/15/2023", "Nissan Silvia s14", 16, "Cloudy")  );
		
		//Scanner object for user input
		Scanner scan = new Scanner(System.in);
		
		//Initialize choice
		int choice = -1;
		
		//Program loop
		do {
			//Print the options available to user
			System.out.println("""
					Please enter a choice (type an integer):
					
					0. Exit
					1. Add new race record
					2. Remove a race record
					3. Modify a race record
					4. Sort the list of race records
					5. Search for records with matching criteria
					6. Print records in the list by index
					7. Print all records in list
					8. Input lap times for a record
							   """);
			
			//Get User input
			choice = Integer.parseInt( scan.nextLine() );
			
			//Switch to handle user input
			switch(choice) {
				case 0: //Simply prevents the default case from running, if to exit is the choice
					System.out.println("Exited...");
					break;
				case 1: // Add new record
					System.out.println("Please enter: Trackname, date, car, weather, and laps");
					
					String track = scan.nextLine();
					String day = scan.nextLine();
					String car = scan.nextLine();
					String weather = scan.nextLine();
					Integer lap = Integer.parseInt( scan.nextLine() );
										
					recList.add( new RaceRecord(track, day, car, lap, weather) );
					break;
					
				case 2: //Remove a record
					System.out.println("Please enter an index to delete a record from the list");
					recList.remove( Integer.parseInt(scan.nextLine()) );
					break;
					
				case 3: // Modify a record
					System.out.println("""
							Please enter the index of the record to modify, then enter a choice of which part of a record to modify:
							1. Track name
							2. Date
							3. Car
							4. Laps
							5. Weather
							""");
					int index = Integer.parseInt(scan.nextLine());
					int mod = Integer.parseInt(scan.nextLine());
					
					switch(mod) {
						case 1:
							System.out.println("Please enter updated Track Name: ");
							recList.get(index).setTrackName( scan.nextLine() );
							break;
							
						case 2:
							System.out.println("Please enter updated Date: ");
							recList.get(index).setDate( scan.nextLine() );
							break;
							
						case 3:
							System.out.println("Please enter updated Car: ");
							recList.get(index).setVehicle( scan.nextLine() );
							break;
							
						case 4:
							System.out.println("Please enter updated Lap number: ");
							recList.get(index).setLaps( Integer.parseInt(scan.nextLine()) );
							break;
							
						case 5:
							System.out.println("Please enter updated Weather: ");
							recList.get(index).setWeather( scan.nextLine() );
							break;
							
						default:
							System.out.println("Invalid input...");
					}
					break;
					
				case 4:
					System.out.println("""
							Please select what to sort by:
							0. Track name
							1. Date
							2. Weather
							3. Car
									   """);
					recList.sort( Integer.parseInt(scan.nextLine()) );
					break;
					
				case 5:
					System.out.println("""
							Please enter what column you'd like to search through, then a string to check for matches
							0. Track name
							1. Date
							2. Weather
							3. Car
									   """);
					WorkingRecordsList ls = recList.find(Integer.parseInt(scan.nextLine()), scan.nextLine());
					
					for(RaceRecord rec : ls) {
						rec.printAll();
					}
					
					break;
					
				case 6:
					System.out.println("Please enter the index of the record to print");
					recList.get( Integer.parseInt(scan.nextLine()) ).printAll();
					break;
					
				case 7:
					for(RaceRecord rec: recList) {
						rec.printAll();
					}
					break;
					
				case 8:
					System.out.println("Enter the index of the record you wish to add lap times to: ");
					recList.get( Integer.parseInt(scan.nextLine()) ).inputLapTimes();
					
				default:
					System.out.println("Invalid input...");
			}
		} while(choice != 0); //Check if we should exit
		scan.close(); //Clean up, generally a good idea to free resources
	}
}

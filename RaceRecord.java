import java.util.Scanner;

public class RaceRecord {
	//Information a racer would want to remember
	private String trackName = "Not Set";
	private String date = "00/00/0000"; //date format MM/DD/YYYY
	private String vehicle = "No make or model given";
	private String weather = "No Data";
	private int laps = 0;
	private int[] lapTimes; //In seconds
	private int[] splits; //In seconds
	
	//Constructor for RaceRecord object
	public RaceRecord(String trackName, String date, String vehicle, int laps, String weather) {
		//Set values
		this.setTrackName(trackName);
		this.setDate(date);
		this.setVehicle(vehicle);
		this.setLaps(laps);
		this.setWeather(weather);
		
		//Initialize these lists after number of laps is given
		lapTimes = new int[laps];
		splits = new int[laps];
		
		//inputLapTimes(); //gets lap times from user
	}

	//Getters and Setters
	public String getTrackName() {
		return trackName;
	}

	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	public int getLaps() {
		return laps;
	}

	public void setLaps(int laps) {
		this.laps = laps;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}
	
	//Print all contents of a race record (excluding the lap times)
	public void printAll() {
		System.out.println( getTrackName() );
		System.out.println( getDate()      );
		System.out.println( getVehicle()   );
		System.out.println( getLaps()      );
		System.out.println( getWeather() + "\n");
	}
	
	//Input lap times (in seconds)
	public void inputLapTimes() {
		//User input object
		Scanner scan = new Scanner(System.in);
		
		//Prompt the user
		System.out.println("Please enter lap times: ");
		
		//Assign to list lap times
		for(int i = 0; i < laps; i++) {
			lapTimes[i] = Integer.parseInt( scan.nextLine() );
		}
		
		//Clean up, release resources
		scan.close();
		
		//calculates splits from lap times
		calcSplits();
	}
	
	//Calculates lap time splits (difference in time between one lap and the next)
	public void calcSplits() {
		//splits[0] = 0; //There is no split for the 1st lap since there is no lap before the 1st lap
		
		for(int i = 0; i < (laps - 1); i++) {
			splits[i+1] = lapTimes[i+1] - lapTimes[i];
		}
	}
	
	//Print lap time splits
	public void printSplits(int lapIndex) {
		//If user asks for lap -1, print all lap time splits
		if (lapIndex == -1) {
			for(int time : splits) {
				System.out.println( time );
			}
		}
		//Else print the split from the lap user asks for
		else {
			System.out.println( splits[lapIndex] );
		}
	}
}

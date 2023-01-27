import java.util.LinkedList;

public class WorkingRecordsList extends LinkedList<RaceRecord>{

	/**
	 * Idk what this is, but it has something to do with saving so better safe than sorry
	 */
	private static final long serialVersionUID = 2550020387030692262L;
	
	//Constructor calls LinkedList<Integer>'s constructor to handle initialization
	public WorkingRecordsList() {
		super(); //Creates an empty list using the parent class' (LinkedList) constructor
	}
	
	//Uses selection sort algorithm since we are working with a small data set of strings
	public void sort(int sortBy) {
		
		switch (sortBy) {
			case 0: //Sort by track name
				for(int i = 0; i < this.size()-1; i++) {
					
					//Find the min in list
					int min = i;
					for(int j = i+1; j < this.size(); j++) {
						if(this.get(j).getTrackName().compareToIgnoreCase( this.get(min).getTrackName() ) < 0 ) {
							min = j;
						}
					}
					
					//This will swap records places in the linked list
					RaceRecord temp = this.get(i);
					this.set(i, this.get(min));
					this.set(min, temp);
				}
				break;
				
			case 1: //Sort by date
				for(int i = 0; i < this.size()-1; i++) {
					
					//Find the min in list
					int min = i;
					for(int j = i+1; j < this.size(); j++) {
						if(this.get(j).getDate().compareToIgnoreCase( this.get(min).getDate() ) < 0 ) {
							min = j;
						}
					}
					
					//This will swap records places in the linked list
					RaceRecord temp = this.get(i);
					this.set(i, this.get(min));
					this.set(min, temp);
				}
				break;
				
			case 2: //Sort by weather
				for(int i = 0; i < this.size()-1; i++) {
					
					//Find the min in list
					int min = i;
					for(int j = i+1; j < this.size(); j++) {
						if(this.get(j).getWeather().compareToIgnoreCase( this.get(min).getWeather() ) < 0 ) {
							min = j;
						}
					}
					
					//This will swap records places in the linked list
					RaceRecord temp = this.get(i);
					this.set(i, this.get(min));
					this.set(min, temp);
				}
				break;
				
			case 3: //Sort by car
				for(int i = 0; i < this.size()-1; i++) {
					
					//Find the min in list
					int min = i;
					for(int j = i+1; j < this.size(); j++) {
						if(this.get(j).getVehicle().compareToIgnoreCase( this.get(min).getVehicle() ) < 0 ) {
							min = j;
						}
					}
					
					//This will swap records places in the linked list
					RaceRecord temp = this.get(i);
					this.set(i, this.get(min));
					this.set(min, temp);
				}
				break;
				
			default:
				System.out.println("There was an error in sort...");
		}
	}
	
	//Find records by criteria
	public WorkingRecordsList find(int findBy, String key) {
		System.out.println(key);
		WorkingRecordsList retList = new WorkingRecordsList();
		
		switch (findBy) {
			case 0: //Find by track name
				for(RaceRecord rec : this) { //Iterate through the records in this instance
					if (rec.getTrackName().equals(key)) {
						retList.add(rec); //If a record has a value matching key add to return list
					}
				}
				break;
				
			case 1: //Find by date
				for(RaceRecord rec : this) { //Iterate through the records in this instance
					if (rec.getDate().equals(key)) {
						retList.add(rec); //If a record has a value matching key add to return list
					}
				}
				break;
				
			case 2: //Find by weather
				for(RaceRecord rec : this) { //Iterate through the records in this instance
					if (rec.getWeather().equals(key)) {
						retList.add(rec); //If a record has a value matching key add to return list
					}
				}
				break;
				
			case 3: //Find by car
				for(RaceRecord rec : this) { //Iterate through the records in this instance
					if (rec.getVehicle().equals(key)) {
						retList.add(rec); //If a record has a value matching key add to return list
					}
				}
				break;
				
			default:
				System.out.println("There was an error in find...");
		}
		
		return retList; //After executing a case, return the list. If no matches were found, the list will be empty. Can use size() to see if empty
	}
}

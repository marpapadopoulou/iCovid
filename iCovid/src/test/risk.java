package test;

public class risk {
	
	
	
	public static int calculateRisk(result result) {
		int totalPoints=0;
		
		if(result.age.equals("18-34")) {
			totalPoints=totalPoints + 5;
		}
		else if(result.age.equals( "35-50")) {
			totalPoints=totalPoints + 6;
		}
		else if(result.age.equals("51-65")) {
			totalPoints=totalPoints + 8;
		}
		else if(result.age.equals( "66-79")) {
			totalPoints=totalPoints + 9;
		}
		else  {
			totalPoints=totalPoints + 10;
		}
		
		if(result.temp.equals("35.5°C - 37°C")) {
			totalPoints=totalPoints + 0;
		}
		else if(result.temp.equals("37.1°C - 37.9°C")) {
			totalPoints=totalPoints + 6;
		}
		else if(result.temp.equals( "38°C - 38.5°C")) {
			totalPoints=totalPoints + 9;
		}
		else  {
			totalPoints=totalPoints + 10;
		}
		
		if(result.drycough.equals("yes")){
			totalPoints=totalPoints + 10;
		}
		else {
			totalPoints=totalPoints + 0;
		}
		
		if(result.breathing.equals("yes")) {
			totalPoints=totalPoints + 10;
		}
		else {
			totalPoints=totalPoints + 0;
		}
		
		if(result.smelltaste.equals("yes")) {
			totalPoints=totalPoints + 10;
		}
		else {
			totalPoints=totalPoints + 0;
		}
		
		if(result.exhausted.equals("yes")) {
			totalPoints=totalPoints + 10;
		}
		else {
			totalPoints=totalPoints + 0;
		}
		
		if(result.question8.equals("sorethroat")) {
			totalPoints=totalPoints + 3;
		}
		else if(result.question8.equals("headache")) {
			totalPoints=totalPoints + 3;
		}
		else if(result.question8.equals("diarrhea")) {
			totalPoints=totalPoints + 3;
		}
		else  {
			totalPoints=totalPoints + 0;
		}
		
		if(result.confirmedcase.equals("yes")) {
			totalPoints=totalPoints + 10;
		}
		else {
			totalPoints=totalPoints + 0;
		}
		
		if(result.vulnerability.equals("yes")) {
			totalPoints=totalPoints + 10;
		}
		else {
			totalPoints=totalPoints + 0;
		}
		
		
		
	return totalPoints;
	}
}

package test;

public class risk {
	
	
	
	public static int calculateRisk(result result) {
		int totalPoints=0;
		
		if(result.age=="18-34") {
			totalPoints=totalPoints + 5;
		}
		else if(result.age == "35-50") {
			totalPoints=totalPoints + 6;
		}
		else if(result.age == "51-65") {
			totalPoints=totalPoints + 8;
		}
		else if(result.age== "66-79") {
			totalPoints=totalPoints + 9;
		}
		else  {
			totalPoints=totalPoints + 10;
		}
		
		if(result.temp=="35.5°C - 37°C") {
			totalPoints=totalPoints + 0;
		}
		else if(result.temp=="37.1°C - 37.9°C") {
			totalPoints=totalPoints + 6;
		}
		else if(result.temp== "38°C - 38.5°C") {
			totalPoints=totalPoints + 9;
		}
		else  {
			totalPoints=totalPoints + 10;
		}
		
		if(result.drycough=="yes"){
			totalPoints=totalPoints + 10;
		}
		else {
			totalPoints=totalPoints + 0;
		}
		
		if(result.breathing=="yes") {
			totalPoints=totalPoints + 10;
		}
		else {
			totalPoints=totalPoints + 0;
		}
		
		if(result.smelltaste=="yes") {
			totalPoints=totalPoints + 10;
		}
		else {
			totalPoints=totalPoints + 0;
		}
		
		if(result.exhausted=="yes") {
			totalPoints=totalPoints + 10;
		}
		else {
			totalPoints=totalPoints + 0;
		}
		
		if(result.question8 == "sorethroat") {
			totalPoints=totalPoints + 3;
		}
		else if(result.question8=="headache") {
			totalPoints=totalPoints + 3;
		}
		else if(result.question8 == "diarrhea") {
			totalPoints=totalPoints + 3;
		}
		else  {
			totalPoints=totalPoints + 0;
		}
		
		if(result.confirmedcase == "yes") {
			totalPoints=totalPoints + 10;
		}
		else {
			totalPoints=totalPoints + 0;
		}
		
		if(result.vulnerability == "yes") {
			totalPoints=totalPoints + 10;
		}
		else {
			totalPoints=totalPoints + 0;
		}
		
		
		
	return totalPoints;
	}
}

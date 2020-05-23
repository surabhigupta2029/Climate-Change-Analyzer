package climatechange;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

// This class implements the IClimateAnalyzer interface and extends the WeatherIO class
// Contains all the methods for respective tasks
public class ClimateAnalyzer extends WeatherIO implements IClimateAnalyzer {
	ArrayList<ITemperature> tempList;
	TreeSet<String> countrySet; //from tempList get all countries.
	Scanner countrySC = new Scanner(System.in);
	Scanner monthSC = new Scanner(System.in);
	Scanner tempSC = new Scanner(System.in);
	Scanner yearSC = new Scanner(System.in);


	// CONSTRUCTOR
	public ClimateAnalyzer() {
		tempList = new ArrayList<ITemperature>();
		countrySet = new TreeSet<String>();
	}

	//converter for months from integer to string
	public String monthIntToString(int month) {
		String tmp = "Jan";
		switch (month) {
		case 1:
			tmp = "Jan";
			break;
		case 2:
			tmp = "Feb";
			break;
		case 3:
			tmp = "Mar";
			break;
		case 4:
			tmp = "Apr";
			break;
		case 5:
			tmp = "May";
			break;
		case 6:
			tmp = "Jun";
			break;
		case 7:
			tmp = "Jul";
			break;
		case 8:
			tmp = "Aug";
			break;
		case 9:
			tmp = "Sep";
			break;
		case 10:
			tmp = "Oct";
			break;
		case 11:
			tmp = "Nov";
			break;
		case 12:
			tmp = "Dec";
			break;
		}
		return tmp;
	}

	// ================================================================================================================================================
	// --------------------------------------------------------TASK A1-----------------------------------------------------------------------------------
	// ================================================================================================================================================

	// For all data that matches the specified country and month, get the lowest temperature
	// reading
	public ITemperature getLowestTempByMonth(String country, int month) throws IOException {
		int i = 0;
		double min = 0;
		double currentTemp = 0;
		String countryCode = "";
		int year = 0;

		ArrayList<ITemperature> result = new ArrayList<ITemperature>();
		// Traverse over all entries of the database. Match country, Match Month and
		// find max temperature.
		for (ITemperature c : tempList) {
			if (c.getCountry().equals(country) && c.getMonth().equals(monthIntToString(month))) {
				currentTemp = c.getTemperature(false);
				countryCode = c.getCountry3LetterCode();
				year = c.getYear();
				if (i == 0) { //first iteration, min is the first temperature
					min = currentTemp;
				}
				if (min > currentTemp) {
					min = currentTemp;
				}
				i++;
			}
		}
		// Create ITemperature object with the result and return it.
		ITemperature A1 = new Temperature(country, countryCode, monthIntToString(month), year, min);
		result.add(A1);
	
		writeSubjectHeaderInFile("C:\\Users\\surab\\eclipse-workspace\\midterm2\\A1.csv",
				"A1: Lowest temperature for " + country + " for the month of " + monthIntToString(month));
		writeDataToFile("C:\\Users\\surab\\eclipse-workspace\\midterm2\\A1.csv", "", result);

		return A1;
	}

	// For all data that matches the specified country and month, get the highest temperature
	// reading
	public ITemperature getHighestTempByMonth(String country, int month) throws IOException {
		int i = 0;
		double max = 0;
		double currentTemp = 0;
		String countryCode = null;
		int year = 0;
		ArrayList<ITemperature> result = new ArrayList<ITemperature>();

		// Traverse over all entries of the database. Match country, Match Month and
		// find max temperature.

		for (ITemperature c : tempList) {
			if (c.getCountry().equals(country) && c.getMonth().equals(monthIntToString(month))) {
				currentTemp = c.getTemperature(false);
				countryCode = c.getCountry3LetterCode();
				if (i == 0) { //first iteration, max is the first temperature
					max = currentTemp;
					year = c.getYear();

				}
				if (max < currentTemp) {
					max = currentTemp;
					year = c.getYear();

				}
				i++;
			}
		}

		// Create ITemperature object with the result and return it.
		ITemperature A1 = new Temperature(country, countryCode, monthIntToString(month), year, max);
		result.add(A1);
		
		writeSubjectHeaderInFile("C:\\Users\\surab\\eclipse-workspace\\midterm2\\A1.csv",
				"A1: Highest temperature for " + country + " for the month of " + monthIntToString(month));
		writeDataToFile("C:\\Users\\surab\\eclipse-workspace\\midterm2\\A1.csv", "", result);
		return A1;
	}

	// ================================================================================================================================================
	// --------------------------------------------------------TASK A2-----------------------------------------------------------------------------------
	// ================================================================================================================================================
	

	// For all data that matches the specified country and year, get the lowest temperature
	// reading
	public ITemperature getLowestTempByYear(String country, int year) throws IOException {
		int i = 0;
		double min = 0;
		double currentTemp = 0;
		String countryCode = "";
		String month = "";
		ArrayList<ITemperature> result = new ArrayList<ITemperature>();

		// Traverse over all entries of the database. Match country and year entered.
		for (ITemperature c : tempList) {
			if (c.getCountry().equals(country) && c.getYear() == year) {
				currentTemp = c.getTemperature(false);
				countryCode = c.getCountry3LetterCode();
				if (i == 0) {
					min = currentTemp;
					month = c.getMonth();

				}
				if (min > currentTemp) {
					min = currentTemp;
					month = c.getMonth();

				}
				i++;

			}
		}
		
		// Create ITemperature object with the result and return it.
		ITemperature A2 = new Temperature(country, countryCode, month, year, min);
		result.add(A2);
		
		writeSubjectHeaderInFile("C:\\Users\\surab\\eclipse-workspace\\midterm2\\A2.csv",
				"A2: Lowest temperature for " + country + " in the year " + year);
		writeDataToFile("C:\\Users\\surab\\eclipse-workspace\\midterm2\\A2.csv", "", result);
		return A2;
	}

	// For all data that matches the specified country and year, get the highest temperature
	// reading
	public ITemperature getHighestTempByYear(String country, int year) throws IOException {
		int i = 0;
		double max = 0;
		double currentTemp = 0;
		String countryCode = "";
		String month = "";
		ArrayList<ITemperature> result = new ArrayList<ITemperature>();

		// Traverse over all entries of the database
		for (ITemperature c : tempList) {
			if (c.getCountry().equals(country) && c.getYear() == year) {
				currentTemp = c.getTemperature(false);
				countryCode = c.getCountry3LetterCode();
				if (i == 0) {
					max = currentTemp;
					month = c.getMonth();
				}
				if (max < currentTemp) {
					max = currentTemp;
					month = c.getMonth();
				}
				i++;
			}
		}
		
		// Create ITemperature object with the result and return it.
		ITemperature A2 = new Temperature(country, countryCode, month, year, max);
		result.add(A2);
		
		writeSubjectHeaderInFile("C:\\Users\\surab\\eclipse-workspace\\midterm2\\A2.csv",
				"A2: Highest temperature for " + country + " in the year " + year);
		writeDataToFile("C:\\Users\\surab\\eclipse-workspace\\midterm2\\A2.csv", "", result);
		return A2;
	}

	// ================================================================================================================================================
	// --------------------------------------------------------TASK A3-----------------------------------------------------------------------------------
	// ================================================================================================================================================
	
	// Get all temperature data that fall within the given temperature range
	// the set is sorted from lowest to highest temperature
	// input parameter values are in Celsius.
	public TreeSet<ITemperature> getTempWithinRange(String country, double rangeLowTemp, double rangeHighTemp)
			throws IOException {

		TreeSet<ITemperature> tempRangeList = new TreeSet<ITemperature>();
		// Traverse over all entries of the database. Match the country.
		for (ITemperature c : tempList) {
			if (c.getCountry().equals(country)) {
				//Ensure temperature is within range
				if (c.getTemperature(false) > rangeLowTemp && c.getTemperature(false) < rangeHighTemp) {
					tempRangeList.add(c);
				}
			}
		}
		
		// ArrayList with the treeSet results, return eventually
		ArrayList<ITemperature> result = new ArrayList<ITemperature>(tempRangeList);
		writeSubjectHeaderInFile("C:\\Users\\surab\\eclipse-workspace\\midterm2\\A3.csv",
				"A3: Range of Temperatures for " + country + " between " + rangeLowTemp + " C and " + rangeHighTemp
						+ " C");
		writeDataToFile("C:\\Users\\surab\\eclipse-workspace\\midterm2\\A3.csv", "", result);
		return tempRangeList;
	}

	// ================================================================================================================================================
	// --------------------------------------------------------TASK A4-----------------------------------------------------------------------------------
	// ================================================================================================================================================

	// Get the lowest temperature reading amongst all data for that country
	public ITemperature getLowestTempYearByCountry(String country) throws IOException {
		double min = 0;
		int i = 0;
		double currentTemp = 0;
		int yearLowest = 0;
		String month = "";
		String countryCode = "";

		ArrayList<ITemperature> result = new ArrayList<ITemperature>();
		Temperature A4 = new Temperature();
		// Traverse over all entries of the database
		for (ITemperature c : tempList) {
			if (c.getCountry().equals(country)) {
				currentTemp = c.getTemperature(false);
				if (i == 0) {
					min = currentTemp;
				}
				if (min > currentTemp) {
					min = currentTemp;
					yearLowest = c.getYear();
					month = c.getMonth();
					countryCode = c.getCountry3LetterCode();

				}
				i++;
			}
		}
		
		// Obtain the other necessary parameters of the Temperature object
		A4.temperature = min;
		A4.year = yearLowest;
		A4.country = country;
		A4.month = month;
		A4.code = countryCode;
		result.add(A4);
		writeSubjectHeaderInFile("C:\\Users\\surab\\eclipse-workspace\\midterm2\\A4.csv",
				"A4: lowest temperature year by country for " + country);
		writeDataToFile("C:\\Users\\surab\\eclipse-workspace\\midterm2\\A4.csv", "", result);
		return A4;
	}

	// Get the highest temperature reading amongst all data for that country
	public ITemperature getHighestTempYearByCountry(String country) throws IOException {
		double max = 0;
		int i = 0;
		double currentTemp = 0;
		int yearLowest = 0;
		String month = "";
		String countryCode = "";

		ArrayList<ITemperature> result = new ArrayList<ITemperature>();
		Temperature A4 = new Temperature();
		// Traverse over all entries of the database
		for (ITemperature c : tempList) {
			if (c.getCountry().equals(country)) {
				currentTemp = c.getTemperature(false);
				if (i == 0) {
					max = currentTemp;
				}
				if (max < currentTemp) {
					max = currentTemp;
					yearLowest = c.getYear();
					month = c.getMonth();
					countryCode = c.getCountry3LetterCode();

				}
				i++;
			}
		}
		// Obtain the other necessary parameters of the Temperature object
		A4.temperature = max;
		A4.year = yearLowest;
		A4.country = country;
		A4.month = month;
		A4.code = countryCode;
		result.add(A4);
		writeSubjectHeaderInFile("C:\\Users\\surab\\eclipse-workspace\\midterm2\\A4.csv",
				"A4: Highest temperature year by country for" + country);
		writeDataToFile("C:\\Users\\surab\\eclipse-workspace\\midterm2\\A4.csv", "", result);
		return A4;
	}

	// ================================================================================================================================================
	// --------------------------------------------------------TASK B1-----------------------------------------------------------------------------------
	// ================================================================================================================================================

	// ------------------------------TASK B-1: TOP 10 LOWEST(MONTH)---------------------
	// The return list is sorted from lowest to highest temperature
	public ArrayList<ITemperature> allCountriesGetTop10LowestTemp(int month) throws IOException {

		TreeSet<ITemperature> resultTreeAll = new TreeSet<ITemperature>();

		// Traverse over all entries of the database. For a month, add All entries to treeSet.
		for (ITemperature c : tempList) {
			if (c.getMonth().equals(monthIntToString(month))) {
				resultTreeAll.add(c);
			}
		}

		Iterator<ITemperature> itr1 = resultTreeAll.iterator();

		// From original treeSet create a Map which has one entry for each country.
		// Store lowest temperature of each country in this map.
		// Key - country
		// Value - ITemperature
		Map<String, ITemperature> countryMap = new HashMap<String, ITemperature>();
		ITemperature cur, stored = new Temperature();
		while (itr1.hasNext()) {
			cur = itr1.next();
			// if country is not present in map then add it.
			if (!countryMap.containsKey(cur.getCountry())) {
				countryMap.put(cur.getCountry(), cur);
			} else {
				stored = countryMap.get(cur.getCountry());
			}

			// compare temperature of stored with cur. Put the minimum in the Map.
			if (stored.getTemperature(false) > cur.getTemperature(false)) {
				countryMap.put(cur.getCountry(), cur);
			}
		}

		// Inserting values of hashMap into a treeMap, based on temperatures as key and,
		// complete ITemperature object as value.
		// Key - temperature
		// Value - ITemperature
		ArrayList<ITemperature> resultArrLowest = new ArrayList<ITemperature>();

		TreeMap<Double, ITemperature> tempMap = new TreeMap<Double, ITemperature>();
		for (Entry<String, ITemperature> entry : countryMap.entrySet()) {
			tempMap.put(entry.getValue().getTemperature(false), entry.getValue());
		}
		for (Entry<Double, ITemperature> entry : tempMap.entrySet()) {
			if (resultArrLowest.size() < 10) {
				resultArrLowest.add(entry.getValue());
			}
		}

		writeSubjectHeaderInFile("C:\\Users\\surab\\eclipse-workspace\\midterm2\\B1.csv",
				"B1: Top 10 lowest temperature for countries in the month of " + monthIntToString(month));
		writeDataToFile("C:\\Users\\surab\\eclipse-workspace\\midterm2\\B1.csv", "", resultArrLowest);

		return resultArrLowest;
	}

	// ------------------------------TASK B-1: TOP 10 HIGHEST (MONTH)---------------------
	// The return list is sorted from lowest to highest temperature
	@Override
	public ArrayList<ITemperature> allCountriesGetTop10HighestTemp(int month) throws IOException {
		TreeSet<ITemperature> resultTreeAll = new TreeSet<ITemperature>();

		// Traverse over all entries of the database. For a month, add All entries to treeSet.
		for (ITemperature c : tempList) {
			if (c.getMonth().equals(monthIntToString(month))) {
				resultTreeAll.add(c);
			}
		}

		Iterator<ITemperature> itr1 = resultTreeAll.iterator();
		
		// From original treeSet create a Map which has one entry for each country.
		// Store lowest temperature of each country in this map.
		// Key - country
		// Value - ITemperature
		Map<String, ITemperature> countryMap = new HashMap<String, ITemperature>();
		ITemperature cur, stored = new Temperature();
		while (itr1.hasNext()) {
			cur = itr1.next();
			// if country is not present in map then add it.
			if (!countryMap.containsKey(cur.getCountry())) {
				countryMap.put(cur.getCountry(), cur);
			} else {
				stored = countryMap.get(cur.getCountry());
			}

			// compare temperature of stored with cur. Put the minimum in the Map.
			if (stored.getTemperature(false) < cur.getTemperature(false)) {
				countryMap.put(cur.getCountry(), cur);
			}
		}

		// Inserting values of hashMap into a treeMap, based on temperatures as key and,
		// complete ITemperature object as value.
		// Key - temperature
		// Value - ITemperature
		ArrayList<ITemperature> resultArr = new ArrayList<ITemperature>();
		ArrayList<ITemperature> resultArrHighest = new ArrayList<ITemperature>();

		TreeMap<Double, ITemperature> tempMap = new TreeMap<Double, ITemperature>();
		for (Entry<String, ITemperature> entry : countryMap.entrySet()) {
			tempMap.put(entry.getValue().getTemperature(false), entry.getValue());
		}
		for (Entry<Double, ITemperature> entry : tempMap.entrySet()) {
						resultArr.add(entry.getValue());
		}

		for (int t = resultArr.size() - 10; t < resultArr.size(); t++) {
			resultArrHighest.add(resultArr.get(t));
		}

		writeSubjectHeaderInFile("C:\\Users\\surab\\eclipse-workspace\\midterm2\\B1.csv",
				"B1: Top 10 highest temperature for countries in the month of " + monthIntToString(month));
		writeDataToFile("C:\\Users\\surab\\eclipse-workspace\\midterm2\\B1.csv", "", resultArrHighest);

		return resultArrHighest;
	}

	// ================================================================================================================================================
	// --------------------------------------------------------TASK B2---------------------------------------------------------------------------------
	// ================================================================================================================================================

	// -------------------------------TASK B2: TOP 10 LOWEST-------------------------------------------------
	public ArrayList<ITemperature> allCountriesGetTop10LowestTemp() throws IOException {
		TreeSet<ITemperature> resultTreeAll = new TreeSet<ITemperature>();

		// Traverse over all entries of the database. For a month, add All entries to treeSet.
		for (ITemperature c : tempList) {
			resultTreeAll.add(c);
		}

		Iterator<ITemperature> itr1 = resultTreeAll.iterator();
		
		// From original treeSet create a Map which has one entry for each country.
		// Store lowest temperature of each country in this map.
		// Key - country
		// Value - ITemperature
		Map<String, ITemperature> countryMap = new HashMap<String, ITemperature>();
		ITemperature cur, stored = new Temperature();
		while (itr1.hasNext()) {
			cur = itr1.next();
			// if country is not present in map then add it.
			if (!countryMap.containsKey(cur.getCountry())) {
				countryMap.put(cur.getCountry(), cur);
			} else {
				stored = countryMap.get(cur.getCountry());
			}

			// compare temperature of stored with cur. Put the minimum in the Map.
			if (stored.getTemperature(false) > cur.getTemperature(false)) {
				countryMap.put(cur.getCountry(), cur);
			}
		}

		// Inserting values of hashMap into a treeMap, based on temperatures as key and,
		// complete ITemperature object as value.
		// Key - temperature
		// Value - ITemperature
		ArrayList<ITemperature> resultArr = new ArrayList<ITemperature>();

		TreeMap<Double, ITemperature> tempMap = new TreeMap<Double, ITemperature>();
		for (Entry<String, ITemperature> entry : countryMap.entrySet()) {
			tempMap.put(entry.getValue().getTemperature(false), entry.getValue());
		}
		
		// Obtaining the top 10 list
		for (Entry<Double, ITemperature> entry : tempMap.entrySet()) {
			if (resultArr.size() < 10) {
				resultArr.add(entry.getValue());
			}
		}

		writeSubjectHeaderInFile("C:\\Users\\surab\\eclipse-workspace\\midterm2\\B2.csv",
				"B2: Top 10 lowest temperature countries");
		writeDataToFile("C:\\Users\\surab\\eclipse-workspace\\midterm2\\B2.csv", "", resultArr);

		return resultArr;
	}

	// -------------------------------TASK B2: TOP 10 HIGHEST-------------------------------------------------
	public ArrayList<ITemperature> allCountriesGetTop10HighestTemp() throws IOException {
		TreeSet<ITemperature> resultTreeAll = new TreeSet<ITemperature>();

		// Traverse over all entries of the database.
		for (ITemperature c : tempList) {
			resultTreeAll.add(c);
		}

		Iterator<ITemperature> itr1 = resultTreeAll.iterator();
		
		// From original treeSet create a Map which has one entry for each country.
		// Store lowest temperature of each country in this map.
		// Key - country
		// Value - ITemperature
		Map<String, ITemperature> countryMap = new HashMap<String, ITemperature>();
		ITemperature cur, stored = new Temperature();
		while (itr1.hasNext()) {
			cur = itr1.next();
			// if country is not present in map then add it.
			if (!countryMap.containsKey(cur.getCountry())) {
				countryMap.put(cur.getCountry(), cur);
			} else {
				stored = countryMap.get(cur.getCountry());
			}

			// compare temperature of stored with cur. Put the minimum in the Map.
			if (stored.getTemperature(false) < cur.getTemperature(false)) {
				countryMap.put(cur.getCountry(), cur);
			}
		}

		// Inserting values of hashMap into a treeMap, based on temperatures as key and,
		// complete ITemperature object as value.
		// Key - temperature
		// Value - ITemperature
		ArrayList<ITemperature> resultArr = new ArrayList<ITemperature>();
		ArrayList<ITemperature> resultArrHighest = new ArrayList<ITemperature>();

		TreeMap<Double, ITemperature> tempMap = new TreeMap<Double, ITemperature>();
		for (Entry<String, ITemperature> entry : countryMap.entrySet()) {
			tempMap.put(entry.getValue().getTemperature(false), entry.getValue());
		}
		for (Entry<Double, ITemperature> entry : tempMap.entrySet()) {
			resultArr.add(entry.getValue());
		}
		
		// Obtaining the top 10 list
		for (int t = resultArr.size() - 10; t < resultArr.size(); t++) {
			resultArrHighest.add(resultArr.get(t));
		}
		writeSubjectHeaderInFile("C:\\Users\\surab\\eclipse-workspace\\midterm2\\B2.csv",
				"B2: Top 10 highest temperature countries");
		writeDataToFile("C:\\Users\\surab\\eclipse-workspace\\midterm2\\B2.csv", "", resultArrHighest);

		return resultArrHighest;
	}

	// ================================================================================================================================================
	// --------------------------------------------------------TASK B3---------------------------------------------------------------------------------
	// ================================================================================================================================================

	public ArrayList<ITemperature> allCountriesGetAllDataWithinTempRange(double lowRangeTemp, double highRangeTemp)
			throws IOException {
		TreeSet<ITemperature> resultTreeAll = new TreeSet<ITemperature>();
		TreeSet<ITemperature> rangeTree = new TreeSet<ITemperature>();

		// Traverse over all entries of the database and add to a treeSet
		for (ITemperature c : tempList) {
			resultTreeAll.add(c);
		}

		// If the temperature lies between range, add to another treeSet
		for (ITemperature c : resultTreeAll) {
			if (c.getTemperature(false) > lowRangeTemp && c.getTemperature(false) < highRangeTemp) {
				rangeTree.add(c);
			}
		}

		// Use treeMap to sort the temperatures in ascending order
		Iterator<ITemperature> itr1 = rangeTree.iterator();
		TreeMap<Double, ITemperature> tempMap = new TreeMap<Double, ITemperature>();
		ITemperature cur;
		while (itr1.hasNext()) {
			cur = itr1.next();
			tempMap.put(cur.getTemperature(false), cur);
		}
		ArrayList<ITemperature> rangeArr = new ArrayList<ITemperature>();
		
		// Enter data of treeSet in an ArrayList, to return eventually
		for (Entry<Double, ITemperature> entry : tempMap.entrySet()) {
			rangeArr.add(entry.getValue());
		}

		writeSubjectHeaderInFile("C:\\Users\\surab\\eclipse-workspace\\midterm2\\B3.csv",
				"B3: All temperatures for all countries within range of " + lowRangeTemp + " C and " + highRangeTemp
						+ " C");
		writeDataToFile("C:\\Users\\surab\\eclipse-workspace\\midterm2\\B3.csv", "", rangeArr);

		return rangeArr;
	}

	// ================================================================================================================================================
	// --------------------------------------------------------TASK C1---------------------------------------------------------------------------------
	// ================================================================================================================================================
	public ArrayList<ITemperature> allCountriesTop10TempDelta(int month, int year1, int year2) throws IOException {
		TreeSet<ITemperature> resultTreeAll = new TreeSet<ITemperature>();

		Double diff = 0.0;
		// Traverse over all entries of the database, check for same month and year as
		// parameters
		for (ITemperature c : tempList) {
			if (c.getMonth().equals(monthIntToString(month))) {
				if (c.getYear() == year1 || c.getYear() == year2) {
					resultTreeAll.add(c);
				}
			}
		}

		
		Iterator<ITemperature> itr1 = resultTreeAll.iterator();
		
		// From original treeSet create a Map which has one entry for each country.
		// Store lowest temperature of each country in this map.
		// Key - country
		// Value - ITemperature
		Map<String, ITemperature> countryMap = new HashMap<String, ITemperature>();
		TreeMap<Double, ITemperature> tempMap = new TreeMap<Double, ITemperature>();
		ITemperature cur;
		ITemperature stored = new Temperature();
		while (itr1.hasNext()) {
			cur = itr1.next();
			// if country is not present in map then add it.
			if (!countryMap.containsKey(cur.getCountry())) {
				countryMap.put(cur.getCountry(), cur);
			} else { // second time for the same country
				stored = countryMap.get(cur.getCountry());
				diff = Math.abs(stored.getTemperature(false) - cur.getTemperature(false));
				tempMap.put(diff, cur); // inserting temp difference in treeMap
			}
		}

		// Inserting values of hashMap into a treeMap, based on temperatures as key and,
		// complete ITemperature object as value.
		// Key - temperature
		// Value - ITemperature
		ArrayList<ITemperature> resultArr = new ArrayList<ITemperature>();
		ArrayList<ITemperature> resultArrHighest = new ArrayList<ITemperature>();
		Temperature element;

		for (Entry<Double, ITemperature> entry : tempMap.entrySet()) {
			element = new Temperature(entry.getValue().getCountry(), entry.getValue().getCountry3LetterCode(),
					entry.getValue().getMonth(), Math.abs(year1 - year2), entry.getKey());
			resultArr.add(element);
		}
		
		// Obtaining the top 10 list
		for (int t = resultArr.size() - 10; t < resultArr.size(); t++) {
			resultArrHighest.add(resultArr.get(t));
		}

		writeSubjectHeaderInFile("C:\\Users\\surab\\eclipse-workspace\\midterm2\\C1.csv",
				"C1: Top 10 greatest temperature differences for the month of " + monthIntToString(month) + " between " + year1 + " and " + year2);
		writeDataToFile("C:\\Users\\surab\\eclipse-workspace\\midterm2\\C1.csv",
				"Temperature Delta in C and F, Year Delta, Month, Country, Country Code", resultArrHighest);

		return resultArrHighest;
	}
	// ================================================================================================================================================
	// --------------------------------------------------------- METHODS TO CHECK VALID INPUT---------------------------------------------------------
	// ================================================================================================================================================
	
	//Asks user to Input Country, Checks for Valid name and returns if it is a valid country.
	public String scanValidCountry() {
		int countryValid = 0;
		String country = "";


		while (countryValid == 0) {
			System.out.println("Enter a country name: ");
			country = countrySC.next();
			//check countrySet for entered country
			for (String c : countrySet) {
				if (country.equals(c)) {
					countryValid = 1;
					break; //out of for loop
				}
			}
			//if country is valid then exit while loop and go to next step.
			if (countryValid == 0) {
				System.out.println("Invalid Country entered.");
			}
		}
		return country;
	}
	
	//Asks user to Input Month, Checks for Valid number and returns if it is a valid month.
	public int scanValidMonth() {
		int monthNum = 0;
		String strInput = "";
		while (true) {
			//Get a normal string input
			System.out.println("Enter a numerical value for month (between 1 and 12, inclusive): ");
			strInput = monthSC.next();
			
			//if input can be converted to Integer then good. Else throw exception. While loop continues.
			try{
	    		monthNum = Integer.parseInt(strInput);
				//if it is a valid integer check the range
	        	if (!((monthNum > 0) && (monthNum <= 12))) {
	        		System.out.println("Invalid Month entered.");
	        	} else {
	        		break; //got a valid month
	        	}
			} catch (NumberFormatException ex) {
			    System.out.println("Invalid Month entered " + strInput);
			}
		}
		return monthNum;
	}
	
	//Asks user to Input Year, Checks for Valid number and returns if it is a valid Year.
	public int scanValidYear() {
		int yearNum = 0;
		String strInput = "";
		while (true) {
			//Get a normal string input
			System.out.println("Enter a numerical value for year (between 2000 and 2016, inclusive): ");
			strInput = yearSC.next();
			
			//if input can be converted to Integer then good. Else throw exception. While loop continues.
			try{
	    		yearNum = Integer.parseInt(strInput);
				//if it is a valid integer check the range
	        	if (!((yearNum >= 2000) && (yearNum <= 2016))) {
	        		System.out.println("Invalid Year entered.");
	        	} else {
	        		break; //got a valid month
	        	}
			} catch (NumberFormatException ex) {
			    System.out.println("Invalid Year entered " + strInput);
			}
		}
		return yearNum;
	}
	
	//Asks user to Input Temp, Checks for Valid number and returns if it is a valid Temp.
		public ArrayList<Double> scanValidTemp() {
			Double lowTemp = 0.0;
			Double highTemp = 0.0;
			String strInput = "";
			ArrayList<Double> tempList = new ArrayList<Double>();
		// Get a normal string input
		System.out.println("Enter a low range temperature in C (without typing the C): ");
		strInput = tempSC.next();
		lowTemp = Double.parseDouble(strInput);
		tempList.add(lowTemp);

		System.out.println("Enter a high range temperature in C (without typing the C): ");
		strInput = tempSC.next();
		highTemp = Double.parseDouble(strInput);
		tempList.add(highTemp);
			
		return tempList;
		}
	
	// ================================================================================================================================================
	// --------------------------------------------------------RUN CLIMATE ANALYZER--------------------------------------------------------------------
	// ================================================================================================================================================
	
	public void runClimateAnalyzer() throws Exception {
		String country = "";
		int month;
		int year;
		double lowTemp;
		double highTemp;
		
		//populate countrySet with all countries mentioned in the tempList.
		for (ITemperature c : this.tempList) {
			countrySet.add(c.getCountry());
		}
		
		// ------------------------------ TASK A1 ---------------------------------------------
		System.out.println("Task A1: Lowest Temperature for a country in a specific month: ");
		country = this.scanValidCountry();
		month = this.scanValidMonth();
		this.getLowestTempByMonth(country, month);



		System.out.println("Task A1: Highest Temperature for a country in a specific month: ");
		country = this.scanValidCountry();
		month = this.scanValidMonth();
		this.getHighestTempByMonth(country, month);

		// ------------------------------ TASK A2 ---------------------------------------------

		System.out.println("Task A2: Lowest Temperature for a country in a specific year: ");
		country = this.scanValidCountry();
		year = this.scanValidYear();
		this.getLowestTempByYear(country, year);

		System.out.println("Task A2: Highest Temperature for a country in a specific year: ");
		country = this.scanValidCountry();
		year = this.scanValidYear();
		this.getHighestTempByYear(country, year);

		// ----------------------------- Task A3 ------------------------------------------------
		System.out.println("Task A3: Temperature for a country in a specific temperature range: ");
		country = this.scanValidCountry();
		lowTemp = this.scanValidTemp().get(0);
		highTemp = this.scanValidTemp().get(1);
		this.getTempWithinRange(country, lowTemp, highTemp);

		// ------------------------------- Task A4-----------------------------------------------
		System.out.println("Task A4: Lowest temperature for a country: ");
		country = this.scanValidCountry();
		this.getLowestTempYearByCountry(country);

		System.out.println("Task A4: Highest temperature for a country: ");
		country = this.scanValidCountry();
		this.getHighestTempYearByCountry(country);

		// ------------------------------- Task B1----------------------------------------------
		System.out.println("Task B1: Top 10 countries list for lowest temperature for a specific month: ");
		month = this.scanValidMonth();

		this.allCountriesGetTop10LowestTemp(month);

		System.out.println("Task B1: Top 10 countries list for highest temperature for a specific month: ");
		month = this.scanValidMonth();

		this.allCountriesGetTop10HighestTemp(month);

		// ------------------------------- Task B2-----------------------------------------------
		System.out.println("Task B2: Top 10 countries list for lowest temperature");
		System.out.println("No user input required; check respectice file for task");

		this.allCountriesGetTop10LowestTemp();

		System.out.println("Task B2: Top 10 countries list for highest temperature");
		System.out.println("No user input required; check respectice file for task");

		this.allCountriesGetTop10HighestTemp();

		// ------------------------------- Task B3-----------------------------------------------
		System.out.println("Task B3: Temperature for ALL countries in a specific temperature range: ");
		country = this.scanValidCountry();
		lowTemp = this.scanValidTemp().get(0);
		highTemp = this.scanValidTemp().get(1);
		
		this.allCountriesGetAllDataWithinTempRange(lowTemp, highTemp);

		// ------------------------------- Task C1-----------------------------------------------
		System.out.println(
				"Task C1: Top 10 countries with biggest difference in temperature for a specific month between two years ");

		month = this.scanValidMonth();
		int yearF = this.scanValidYear();
		int yearS = this.scanValidYear();

		this.allCountriesTop10TempDelta(month, yearF, yearS);

		tempSC.close();
		yearSC.close();
		monthSC.close();
		countrySC.close();
		
	}
	public static void main(String[] args) throws Exception, IOException {

		ClimateAnalyzer cli = new ClimateAnalyzer();
		cli.tempList = cli.readDataFromFile("world_temp_2000-2016.csv");
		cli.countrySet = new TreeSet<String>();
		for (ITemperature c : cli.tempList) {
			cli.countrySet.add(c.getCountry());
		}
		for (String s : cli.countrySet) {
		//	System.out.println(s);
		}
		// System.out.println("-------From method run-------");
		 cli.allCountriesTop10TempDelta(12, 2000, 2016);
		 System.out.println("1a" + cli.getHighestTempByYear("Finland", 2000));
		 System.out.println("1b" + cli.getHighestTempByYear("Finland", 2016));
		 System.out.println("1c" + cli.getLowestTempByYear("Finland", 2000));
		 System.out.println("1d" + cli.getLowestTempByYear("Finland", 2016));
		 System.out.println("2" + cli.getHighestTempByMonth("Finland", 1));
		 System.out.println("3" + cli.getLowestTempByMonth("Finland", 1));
		 ArrayList<ITemperature> tmp = new ArrayList<ITemperature>();
		 tmp = cli.allCountriesTop10TempDelta(1, 2000, 2016);
		 for (ITemperature c : tmp) {
			 System.out.println(c);
		 }

		// cli.runClimateAnalyzer();
		// System.out.println("-------From method A1-------");
		// cli.getHighestTempByMonth("China", 1);
		// cli.allCountriesTop10TempDelta(2, 2000, 2011);
		// cli.allCountriesGetAllDataWithinTempRange(20.0, 20.2);
		// System.out.println(cli.getHighestTempByMonth("Kuwait", 7));
		// 2).getTemperature(false));
	}
		

} //end of class

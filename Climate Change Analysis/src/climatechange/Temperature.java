package climatechange;

// This class implements the ITemperature and the Comparable interface 
// Contains details of the Temperature object
public class Temperature implements ITemperature, Comparable<Temperature> {

	//Temperature object variables
	String country;
	String code;
	String month;
	int monthNum;
	int year;
	Double temperature;

	// NO PARAMETER CONSTRUCTOR
	public Temperature() {
		country = "";
		code = "";
		month = "";
		monthNum = 0;
		year = 0;
		temperature = 0.0;
	}

	// 5-PARAMETER CONSTRUCTOR
	public Temperature(String country, String code, String month, int year, double temperature) {
		this.country = country;
		this.code = code;
		this.month = month;
		this.year = year;
		this.temperature = temperature;
		this.monthNum = this.monthStringToInt(month);
	}

	//ACCESSOR METHODS
	
	public String getCountry() {
		return this.country;
	}

	public String getCountry3LetterCode() {
		return this.code;
	}

	public String getMonth() {
		return this.month;
	}

	public int getYear() {
		return this.year;
	}

	public double getTemperature(boolean getFahrenheit) {
		if (getFahrenheit == true) {
			double tempInF = (((this.temperature) * (1.8)) + 32);
			return tempInF;
		} else {
			return this.temperature;
		}
	}

	//COMPARE-TO METHOD
	// This function compares month, then year, then country, then temperature
	public int compareTo(Temperature o) {
		// compare month
		int tmonthInt = this.monthStringToInt(month);
		int amonthInt = this.monthStringToInt(o.month);
		int monthComp = this.compareValues(tmonthInt, amonthInt);

		// compare year
		int yearComp = this.compareValues(this.year, o.year);

		// compare country
		int countryComp = this.country.compareTo(o.country);

		// compare temperature
		int tempComp = this.temperature.compareTo(o.temperature);

		if (monthComp != 0) {
			return monthComp;
		} else if (yearComp != 0) {
			return yearComp;
		} else if (countryComp != 0) {
			return countryComp;
		} else {
			return tempComp;
		}

	}

	// Comparison method for integers.
	public int compareValues(int a, int b) {
		if (a < b) {
			return -1;
		} else if (a > b) {
			return 1;
		} else {
			return 0;
		}
	}

	// Overridden toString for printing Temperature objects
	public String toString() {
		String result = "";
		result += "(C): " + String.format("%.2f", this.getTemperature(false)) + ",";
		result += "(F): " + String.format("%.2f", this.getTemperature(true)) + ",";
		result += this.getYear() + ",";
		result += this.getMonth() + ",";
		result += this.getCountry() + ",";
		result += this.getCountry3LetterCode();
		return result;
	}

	// Converts month to integer values
		public int monthStringToInt(String month) {
			int tmp = 1;
			switch (month) {
			case "Jan":
				tmp = 1;
				break;
			case "Feb":
				tmp = 2;
				break;
			case "Mar":
				tmp = 3;
				break;
			case "Apr":
				tmp = 4;
				break;
			case "May":
				tmp = 5;
				break;
			case "Jun":
				tmp = 6;
				break;
			case "Jul":
				tmp = 7;
				break;
			case "Aug":
				tmp = 8;
				break;
			case "Sep":
				tmp = 9;
				break;
			case "Oct":
				tmp = 10;
				break;
			case "Nov":
				tmp = 11;
				break;
			case "Dec":
				tmp = 12;
				break;
			}
			return tmp;
		}

}// end of class

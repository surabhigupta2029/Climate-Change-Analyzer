package climatechange;

// This class is for specifically running the runClimateAnalyzer() method
// from the ClimateAnalyzer class
public class runClimateAnalyzer extends ClimateAnalyzer {

	public static void main(String[] args) throws Exception {
		ClimateAnalyzer runner = new ClimateAnalyzer();
		runner.tempList = runner.readDataFromFile("world_temp_2000-2016.csv");
		runner.runClimateAnalyzer();
	}
}

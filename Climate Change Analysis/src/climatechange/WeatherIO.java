package climatechange;

import java.io.*;
import java.util.*;

//This class implements the IWeatherIO interface.
//Contains methods to successfully write to data files
public class WeatherIO implements IWeatherIO {

	// Open the original csv file and read it.
	public java.util.ArrayList<ITemperature> readDataFromFile(String fileName) throws FileNotFoundException {
		File inputFile = new File(fileName);
		ArrayList<ITemperature> ArrList = new ArrayList<ITemperature>();
		Scanner input = new Scanner(inputFile);
		String header = input.nextLine(); // remove header first

		// Obtaining information by splitting array, and
		// assigning to a Temperature object, which is added
		// to an ArrayList, returned eventually
		while (input.hasNextLine()) {
			Temperature tempObj = null;
			String line = input.nextLine();
			String[] splitArr = line.split(",");
			String country = splitArr[3].trim();
			String code = splitArr[4].trim();
			String month = splitArr[2].trim();
			String yearst = splitArr[1].trim();
			int year = Integer.parseInt(yearst);
			double temperature = Double.parseDouble(splitArr[0].trim());
			tempObj = new Temperature(country, code, month, year, temperature);
			ArrList.add(tempObj);
		}
		input.close();
		return ArrList;
	}

	// This method writes the specific task headers
	@Override
	public void writeSubjectHeaderInFile(String filename, String subject) throws IOException {
		File inputFile = new File(filename);
		FileWriter fw = new FileWriter(inputFile, true);
		PrintWriter pw = new PrintWriter(fw);

		pw.write(subject); // the task information, from user
		pw.println();
		pw.close();
		fw.close();
	}

	// This method writes the ArrayLists returned from each task method into its
	// respective file
	@Override
	public void writeDataToFile(String filename, String topic, java.util.ArrayList<ITemperature> theWeatherList)
			throws IOException {
		ArrayList<ITemperature> climateAnalyze = theWeatherList;

		File taskFile = new File(filename);
		FileWriter fw = new FileWriter(taskFile, true);
		PrintWriter pw = new PrintWriter(fw);

		// if else statements for writing custom topic header
		if (topic.equals("")) {
			pw.write("Temperature, Year, Month, Country, Country Code" + "\n");
		} else {
			pw.write(topic);
			pw.println();
		}

		// printWrtiting the Temperature objects in file
		for (ITemperature c : climateAnalyze) {
			if (c != null) {
				pw.write(c.toString());
				pw.println();

			}
		}
		pw.close();
		fw.close();

	}
}// end of class

package parse;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Parse {
	
	public static BufferedWriter writer = null;
	

	public static void main(String[] args) {
		
		try {
			writer = new BufferedWriter(new FileWriter("cvc.txt"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try (BufferedReader br = new BufferedReader(new FileReader("GPGGA.txt"))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				parseGPS(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
		

	}

	private static void parseGPS(String gpsData) {

		String northData = "";
		String westData = "";
		
		String[] splitGPSData = gpsData.split(",");
		
		
		for(int i = 0; i < splitGPSData.length; i++) {
			if(splitGPSData[i].equals("N")) {
				northData = splitGPSData[i-1];
			}
			if(splitGPSData[i].equals("W")) {
				westData = splitGPSData[i-1];
			}
		}
		
		
		// we exit out if there is faulty data
		if(northData.length() <= 0 || westData.length() <= 0) {
			return;
		}
		
		
		int northDeg = Integer.parseInt(northData.substring(0, 2));
		double northMin = Double.parseDouble(northData.substring(2, northData.length()));
		
		System.out.print(northMin + ",");
		
		//System.out.print(northDeg + " " + northMin + ", ");
		
		
		int westDeg = Integer.parseInt(westData.substring(0, 2));
		double westMin = Double.parseDouble(westData.substring(2, westData.length()));
		
		System.out.print(westMin + "\n");
		
		
		
		try {
			writer.write(northMin + "," + westMin + "\n");
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
}
		
		//System.out.print(westDeg + " " + westMin + "\n");
		
	}

}

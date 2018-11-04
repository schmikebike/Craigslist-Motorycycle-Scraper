package webScraperDemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Scanner;

public class FileInput {
	private static ArrayList<String> motorcycleNames = new ArrayList<>();
	private static ArrayList<String> motorcyclePrices = new ArrayList<>();
	private static String title;
	private static String price;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		InputStream in = new URL("https://drive.google.com/uc?authuser=0&id=1ur9GxAUPnlsjsGnuyWDkadQbgkL_rNRT&export=download").openStream();
		Files.copy(in, Paths.get("/Users/Mike/Documents/testFile.txt"), StandardCopyOption.REPLACE_EXISTING);
		
		
		
		try {
			File in1 = new File (args[0]);
			Scanner scan = new Scanner (in1);
			
			while (scan.hasNext()) {
				
				if (scan.hasNext()) {
				title = scan.nextLine();
				motorcycleNames.add(title);
				System.out.println(title);
				}
				if (scan.hasNext()) {
				price = scan.nextLine();
				motorcyclePrices.add(price);
				System.out.println(price);
				}
				
			}
				
			System.out.println(motorcycleNames.get(0));
			System.out.println(motorcyclePrices.get(0));
			System.out.println(averagePrice());
		
		}
	
				
				
//				System.out.println(scan.next());
//				if (scan.next().contains("Make:")) {
//					make=scan.nextLine();
//					System.out.println(make);
//					motorcycleNames.add(make);
//					
				
				
				
//				else if (scan.next()=="Price: ") {
//					price=scan.next();
//					motorcyclePrices.add(price);
//					
//				}
//					
//			}
//			System.out.println(motorcycleNames.toString());
//			System.out.println(motorcyclePrices.toString());
			
			

			catch(FileNotFoundException e) {
				System.out.println("File not Found");
		}

		

	}
	
	public static int averagePrice () {
		int added=0;
		String temp="";
		int tempNum=0;
		for (int i=0; i<motorcyclePrices.size(); i++) {
			
			temp = motorcyclePrices.get(i);
			temp=temp.replaceAll(" ", "");
			temp = temp.replaceAll("$", "");
			if (temp.length()>0) {
			if (Character.isDigit(temp.charAt(0))) {
				
			
//			temp=temp.substring(1, temp.length());
			tempNum = Integer.parseInt(temp);
			added+=tempNum;
			}
		}
		}
		return added/motorcyclePrices.size();
		
	
		
	}
}


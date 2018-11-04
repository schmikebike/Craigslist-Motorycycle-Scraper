package webScraperDemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.JauntException;
import com.jaunt.UserAgent;

public class test {
	
	
	
	
	
	
	static ArrayList array = new ArrayList<Motorcycle>();
	static ArrayList motorcycleName= new ArrayList<String>();
	static ArrayList motorcyclePrice= new ArrayList<String>();
	 static ArrayList <Motorcycle> mList = new ArrayList<>();
	 
	 
		 
	 
	
	public static void main (String[] args) throws IOException, InterruptedException {
		
		//while (1==1) {
		
		String content = null;
		URLConnection connection = null;
		try {
		  connection =  new URL("https://denver.craigslist.org/d/motorcycles-scooters/search/mca?postal=80222&search_distance=20.3").openConnection();
		  Scanner scanner = new Scanner(connection.getInputStream());
		  scanner.useDelimiter("\\Z");
		  content = scanner.next();
		}catch ( Exception ex ) {
		    ex.printStackTrace();
		}
		System.out.println(content);
		
		
		Integer [] years = new Integer [100];
		int startYear=1950;
		for (int i=0; i<years.length; i++) {
			years[i]= startYear;
			startYear++;
		}
		
	

		  
		  ArrayList<String> motorcycles = new ArrayList<>();
		  
		  Scanner nameInput = new Scanner (content); //scanner for motorcycle names
		  Scanner priceInput= new Scanner (content);

		 String price ="";
		 String x="";
		 String name ="";
		  //creates arraylist of motorcycle names 
		  while (nameInput.hasNext()) {
//			  
//			  
			  if (nameInput.next().contains("result-title")) {
				  x=nameInput.nextLine();
				  x=x.replace("hdrlnk\">", "");
				  x=x.replace("</a>", "");
				  motorcycleName.add(x);
				  
		  }
			  }
		  //System.out.println(motorcycleName.toString());
		  
		  //creates arraylist of motorcycle prices
		  while (priceInput.hasNext()) {
			  if (priceInput.next().contains("result-image")) {
				  priceInput.nextLine();
				  price=priceInput.nextLine();
				  price= price.replaceAll("<span class=\"result-price\">", "");
				  price= price.replaceAll("</span>", "");
				  price=price.replaceAll("$", "");
				  motorcyclePrice.add(price);
		  }
		  }
		  //System.out.println(motorcyclePrice.toString());
		  
		  for (int i=0; i<motorcycleName.size();i++) {
			  
			  Motorcycle qwery = new Motorcycle ((String)motorcycleName.get(i),(String) motorcyclePrice.get(i));
			  mList.add(qwery);
			  
		  }
		  System.out.println(mList.toString());
	
			  
			 
			  
			
			
			 
				  
			  
			  
			  
			  
			  
		  
		 
//		 while (input.hasNext()) {
//			 String re;
//			 String x=input.next();
//			 if (x.contains(borderString)){
//				 String temp =(x.substring(borderString.length()+6, x.length()));
//				 
//				 temp=temp.substring(0, temp.indexOf("/"));
////				 for (int i= 0; i< years.length;i++ ) {
////				 if (temp.contains(years[i].toString())) {
////
////					 System.out.println(moyears);
////				 }
////				 }
//				 System.out.println(temp);
//				 input.nextLine();
//				 System.out.println(input.nextLine());
//				 input.nextLine();
//				 
//			 }
//		 }
//		  while (input.hasNext()) {
//		  motorcycles.add(input.next());
//		  }
	
		  
		  //print the document as HTML
//		  while (input.hasNext()) {
//			  for (int i=0; i< 1000; i++) {
//				  
//			  if (input.nextLine()=="<time class=") {
//				  input.nextLine();
//				  
//				  motorcycles.add(input.nextLine());
//			  
//				  
//		  }
//		  }
//			  
//		  }
//		  System.out.println(motorcycles.get(0));
//		  System.out.println(motorcycles.get(1));
//		  System.out.println(motorcycles.get(2));
//		  
//		  for (int i=0; i<10000; i++) {
//		  if (motorcycles.get(i).contains("href=\"https://denver.craigslist.org/mcy/d/")) {
//			  //Motorcycle newMotorcycle = new Motorcycle(input.next(), )
//			  System.out.println(motorcycles.get(i));
//		  }
//		  else {
//			  motorcycles.remove(i);
//		  }
//		  }
//	}
	
		
		try {
			
			//FileWriter fw = new FileWriter ("/Users/Mike/Documents/testFile.txt");
//			FileWriter write = new FileWriter("/Users/Mike/Documents/testFile.txt", true);
			
			FileWriter write = new FileWriter ("/Users/Mike/Desktop/craigslistApp/testFile.txt");
//			for (int i=0; i<mList.size(); i++) {
//				write.println(mList.get(i));
//			}
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			   LocalDateTime now = LocalDateTime.now();  
			   write.append('\n');
				write.append('\n');
				write.append('\n');
				write.append('\n');
			write.append(dtf.format(now)); 
			write.append('\n');
			write.append('\n');
			
			
			write.append(mList.toString());
			write.close();
			
			}
			
			catch (FileNotFoundException e){
//				File file = new File ("/Users/Mike/Documents/testFile.txt");
				File file = new File ("/Users/Mike/Desktop/craigslistApp/testFile.txt");
			}
		TimeUnit.SECONDS.sleep(1);
		
	}
	}
//}
	
	
//}
	

	

	


	
	

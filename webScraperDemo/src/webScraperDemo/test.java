package webScraperDemo;

import java.util.ArrayList;
import java.util.Scanner;

import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.JauntException;
import com.jaunt.UserAgent;

public class test {
	static ArrayList array = new ArrayList<Motorcycle>();
	
	static ArrayList motorcycleName= new ArrayList<String>();
	static ArrayList motorcyclePrice= new ArrayList<String>();
	
	public static void main (String[] args) {
		Integer [] years = new Integer [100];
		int startYear=1950;
		for (int i=0; i<years.length; i++) {
			years[i]= startYear;
			startYear++;
		}
		
	try{
		String borderString = "https://denver.craigslist.org/mcy/d/";
		  UserAgent userAgent = new UserAgent();                       //create new userAgent (headless browser).
		  userAgent.visit("https://denver.craigslist.org/d/motorcycles-scooters/search/mca");                        //visit a url  
		  
		  System.out.println(userAgent.doc.innerHTML());
		  
		  ArrayList<String> motorcycles = new ArrayList<>();
		  
		  Scanner nameInput = new Scanner (userAgent.doc.innerHTML()); //scanner for motorcycle names
		  Scanner priceInput= new Scanner (userAgent.doc.innerHTML());
		  UserAgent userAg = new UserAgent();
		  userAg.visit("https://denver.craigslist.org/d/motorcycles-scooters/search/mca");   
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
		  System.out.println(motorcycleName.toString());
		  
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
		  System.out.println(motorcyclePrice.toString());
	}
			  
			 
			  
			
			
			 
				  
			  
			  
			  
			  
			  
		  
		 
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
	
		catch(JauntException e){         //if an HTTP/connection error occurs, handle JauntException.
		  System.err.println(e);
		}
	


}
}
	

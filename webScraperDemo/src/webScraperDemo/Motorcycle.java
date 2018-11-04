package webScraperDemo;

public class Motorcycle {
	private String make;
	private String model;
	private int year;
	private int mileage;
	private int price;
	private String priceString;
	private int dateUploaded;
	
	public Motorcycle (String make, String model, int year, int mileage,int price, int dateUploaded) {
		this.make= make;
		this.model= model;
		this.year=year;
		this.mileage=mileage;
		this.price= price;
		this.dateUploaded=dateUploaded;
		
	}
	public Motorcycle (String name, String price) {
		this.make = name;
		this.priceString = price.replace("$", "");
		this.priceString = priceString.replaceAll(" ", "");
		
	}
	
	public String toString() {
		return (make+'\n'+priceString+'\n');
	}
}

/*
 * Project 15
 * @author Alex Kloppenburg (with partner Kevin Le)
 */

import java.util.ArrayList;

public class Donor {

	//Data
	private String name;
	private ArrayList<Double> donations;
		
	//Constructors
	
	//This creates a donor without an initial donation amount, but that can be added later
	public Donor(String name){
		donations = new ArrayList<Double>();
		this.name = name;
	}
	
	//This creates a donor with a name and an initial donation
	public Donor(String name, double donation){
		donations = new ArrayList<Double>();
		this.name = name;
		this.donations.add(donation);
	}
		
	//Accessors
	
	//Returns the name of the specified donor
	public String getName(){
		return this.name;
	}
	
	//Returns the sum of all the specified donor's contributions to date
	public double getTotalDonations(){
		
		double sum = 0;
		
		for(int i = 0; i < donations.size(); ++i){
			sum = sum + donations.get(i);
		}
		
		return sum;
	}
		
	//Mutators
	
	//Returns the donor's name and a list of their individual donations as a String
	public String toString(){
		return name + " " + donations.toString();
	}
	
	//Adds a donation to the specified donor object
	public void addDonation(Double donation){
		donations.add(donation);
	}
	
}

import java.util.ArrayList;


public class Campaign {
	
	//Data
	private String candidateName;
	private ArrayList<Donor> donors;
	
	//Constructor
	public Campaign(String name){
		donors = new ArrayList<Donor>();
		this.candidateName = name;
	}
	
	//Accessors
	
	//Gets name of candidate
	public String getCandidateName(){
		return this.candidateName;
	}
	
	//Gets list of all donors to the campaign and what they've donated
	public String getDonors(){
		
		String donorList = new String(candidateName + "\n");
		
		for(int i = 0; i < donors.size(); ++i){
			donorList = donorList + donors.get(i).toString();
		}
		
		return donorList;
	}
	
	//Gets sum of all donations to the entire campaign
	public double getAllDonations(){
		double sum = 0;
		
		for(int i = 0; i < donors.size(); ++i){
			sum = sum + (donors.get(i)).getTotalDonations();
		}
		
		return sum;
	}
	
	//Finds how much a single donor has donated in total
	public double getDonation(String donor){
		
		double donation = 0;
		
		for(int i = 0; i < donors.size(); ++i){
			if(((donors.get(i)).getName()).equals(donor)){
				donation = (donors.get(i)).getTotalDonations();
			}
		}
		return donation;
	}
	
	//Uses toString from donor class to get a list of the donor's donations
	public String getDonationList(String donor){
		
		String donationList = new String("");
		
		for(int i = 0; i < donors.size(); ++i){
			if(((donors.get(i)).getName()).equals(donor)){
				donationList = (donors.get(i)).toString();
			}
		}
		return donationList;
	}
	
	//Adds a new donor to the list  of donors
	public void addDonor(String name){
		Donor newDonor = new Donor(name);
		donors.add(newDonor);
	}
	
	//Adds a new donation to the specified donor
	public void addDonation(String donorName, double donation){
		
		for(int i = 0; i < donors.size(); ++i){
			if(((donors.get(i)).getName()).equals(donorName)){
				(donors.get(i)).addDonation(donation);
			}
		}
	}
}
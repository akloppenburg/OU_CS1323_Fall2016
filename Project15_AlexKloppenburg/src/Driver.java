import java.util.ArrayList;

public class Driver {
	
	public static void main(String[] args){
		
		//Demonstration of both constructors
		Donor alKlop = new Donor("Alex Kloppenburg");
		Donor kevLe = new Donor("Kevin Le", 50.0);
		
		//Demonstration of getName accessor
		String klopName = alKlop.getName();
		System.out.println(klopName);
		
		//Demonstration of getTotalDonations object
		Double kevDonations = kevLe.getTotalDonations();
		System.out.println(kevDonations);
		
		//Demonstration of addDonation mutator
		kevLe.addDonation(70.4);
		kevDonations = kevLe.getTotalDonations();
		System.out.println(kevDonations);
		
		//Demonstration of toString mutator
		String kevProfile = kevLe.toString();
		System.out.println(kevProfile);
		
		//Demonstration of adding donation info to a name-only donor
		alKlop.addDonation(100.0);
		System.out.println(alKlop.toString());
		
		/*//Campaign class testing
		
		//Constructor and name accessor
		Campaign duck = new Campaign("Donald Duck");
		System.out.println(duck.getCandidateName());
		
		//Add and get donors
		duck.addDonor("Junaid Ahmed");
		duck.addDonor("Hayden Reed");
		System.out.println(duck.getDonors());
		
		//Adding multiple donations and summing all
		duck.addDonation("Junaid Ahmed", 50.0);
		duck.addDonation("Junaid Ahmed", 50.0);
		duck.addDonation("Junaid Ahmed", 50.0);
		duck.addDonation("Hayden Reed", 50.0);
		duck.addDonation("Hayden Reed", 50.0);
		System.out.println(duck.getDonors());
		System.out.println(duck.getAllDonations());
		
		//Get a single donor's total donations
		System.out.println(duck.getDonation("Junaid Ahmed"));
		
		//Get a single donor's name and all their separate donations
		System.out.println(duck.getDonationList("Junaid Ahmed"));*/
	}
	
}


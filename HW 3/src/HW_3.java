import java.util.Scanner;

public class HW_3 
{

	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		
		final double TAX_RATE = 0.065;
		final double DOLLARS_PER_POUND_SHIPPING = 1.39;
		
		// Priming read
		System.out.println("Enter the price, weight, desired days to delivery for your purchase, "
				+ "or a negative or zero price to exit");
		double price = keyboard.nextDouble();
		double weight;
		int daysToDelivery;
		boolean taxable;
		boolean elYunqueComposite;
		
		// Negative values and zero are sentinel
		while (price > 0)
		{
			weight = keyboard.nextDouble();
			daysToDelivery = keyboard.nextInt();
			keyboard.nextLine();
			
			System.out.println("You are an El Yunque Composite member? (true or false)");
			elYunqueComposite = keyboard.nextBoolean();
			System.out.println("Your purchase is taxable? (true or false)");
			taxable = keyboard.nextBoolean();
			
			//Let the user see the results
			double shipping = calculateShippingCharges(daysToDelivery,elYunqueComposite, price, weight, DOLLARS_PER_POUND_SHIPPING );
			System.out.println("Your shipping is " + shipping);
			double tax = calculateSalesTax(price, TAX_RATE, taxable);
			System.out.println("Your tax is " + tax);
			System.out.println("Your total cost is " + (price + shipping + tax));
			
			//Priming read
			System.out.println("Enter the price, weight, desired days to delivery for your purchase, "
					+ "or a negative or zero price to exit");
			price = keyboard.nextDouble();
		} // end while
			
	}

	public static double calculateShippingCharges(int daysToDeliver, boolean compositeMember, double price, double weight,
			double costPerPound)
	{
		if (compositeMember)
		{
			if (daysToDeliver >= 3)
				return 0.0;
		}
	
		double shippingPrice = weight * costPerPound;
		
		if (price >= 200)
			return 0.0;
		else if (price >= 100)
			return shippingPrice * 0.5;
		else
			return shippingPrice;
	
	}
	
	public static double calculateSalesTax(double price, double rate, boolean isTaxable)
	{
		double tax = price * rate;
		if (isTaxable)
			return tax;
		else
			return 0.0;
	}
}

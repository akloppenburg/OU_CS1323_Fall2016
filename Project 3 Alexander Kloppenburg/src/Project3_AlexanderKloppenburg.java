
public class Project3_AlexanderKloppenburg
{
	public static void main(String[] args)
	
	//Author: Alexander Kloppenburg
	//Date: 9/6/16
	{
		final double costDesignPatterns = 32.46;
		final double costEffectiveJava = 35.48;
		final double costJavaPuzzlers = 27.86;
		final double salesTaxRate = 0.065;
		int numDesignPatterns = 1;
		int numEffectiveJava = 2;
		int numJavaPuzzlers = 4;
		double totalCost = 0;
		double totalSalesTax = 0;
		double totalCostPlusTax = 0;
		
		totalCost = (costDesignPatterns * numDesignPatterns) + (costEffectiveJava * numEffectiveJava) + (costJavaPuzzlers * numJavaPuzzlers);
		System.out.println("Total cost is: " + totalCost);
		
		totalSalesTax = totalCost * salesTaxRate;
		System.out.println("Sales tax is: " + totalSalesTax);
		
		totalCostPlusTax = totalCost + totalSalesTax;
		System.out.println("Total cost with tax is: " + totalCostPlusTax);
	}
}

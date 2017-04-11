import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/** Play a simple game like Go Fish!
 * 
 * @author Alex Kloppenburg
 * @author Kevin Le
 * @version 1.0
 *
 */
public class Project13_AlexKloppenburg {

	/** Each player gets 7 cards initially
	 * 
	 */
	public static int STARTING_HAND_SIZE = 7;
	
	/** Play a game of Go Fish!  The rules are below.
	 * A regular deck of cards consists of 52 cards.  
	 * There are four suits and thirteen card ranks (Ace, 2, 3,…10, Jack, Queen, and King). 
	 * We’re going to simplify our cards.  The cards will have ranks from 1 to 13, 
	 * and each rank will have identical cards.  This removes suit from the game.
	 * 
	 * The computer deals seven cards to the human and the computer from a shuffled deck. The 
	 * remaining cards are shared in a pile.
	 * 
	 * The human player should play first. The human asks the computer for all its card(s) 
	 * of a particular rank that is already in his or her hand. 
	 * For example Mayra may ask, "Computer, do you have any threes?" Mayra must have at 
	 * least one card of the rank she requested in her hand. The computer must hand over 
	 * all cards of that rank. If the computer has no cards of that rank, 
	 * Mayra is told to "Go fish," and she draws a card from the pool and places 
	 * it in her own hand. When any player at any time has all four cards of one rank,
	 *  it forms a book, and the cards must be removed from the hand and placed face 
	 *  up in front of that player. 
	 *  
	 *  If the player has no cards in their hand, they may not request cards form the other 
	 *  player, they just draw a card.
	 *  When the pile is empty, no cards are drawn, but the player still gets to ask for cards 
	 *  following the same rules.
	 *  
	 *  The computer is not allowed to examine or deduce the human player’s cards while 
	 *  playing the game. The computer should randomly pick one card from their hand to request.  
	 *  This means that the computer is not being strategic at all and will 
	 *  probably lose most of the time (unless the player really stinks at Go Fish!). 
	 *  
	 *  When all sets of cards have been laid down, the game ends. The player with the 
	 *  most cards in piles wins.
	 *  
	 *  The game is easier to play if the cards are printed out in sorted order.  
	 *  This also uses a method in the Collections class, which meets a learning objective.

	 * @param args There are no command line arguments.
	 */
	public static void main(String[] args) 
	{
		//Create deck of cards
		ArrayList<Integer> pool = createDeck();
		
		Scanner input = new Scanner(System.in);
		
		// Shuffle cards
		Collections.shuffle(pool);
		
		//Begin game play
		playOneGame(pool, input);
		
		input.close();
	}

	/** Play one full game of Go Fish!. 
	 * 
	 * @param pool The deck of cards, already shuffled.
	 * @param input Attached to the keyboard to interact with the user.
	 */
	public static void playOneGame(ArrayList<Integer> pool, Scanner input)
	{
		ArrayList<Integer> computer = new ArrayList<Integer>(52);
		ArrayList<Integer> person = new ArrayList<Integer>(52);
		ArrayList<Integer> computerPile = new ArrayList<Integer> (52);
		ArrayList<Integer> personPile = new ArrayList<Integer>(52);

		//Deal cards
		dealHands(pool, computer, person);
		
		//Show the person their starting hand
		System.out.println("Your starting hand contains: ");
		showCards(person);
		
		// Play the game
		while (computerPile.size() + personPile.size() < 52 || !pool.isEmpty())
		{
			// Let the person play first
			if (!person.isEmpty())
			{
				System.out.println("What card do you want?");
				int card = input.nextInt();
				
				//Play one turn with the person doing the choosing
				playOneTurn(card, person, computer, personPile, computerPile, pool);
			}
			else
			{
				//Let the player draw from the deck
				System.out.println("Draw a card from the deck.");
				person.add(pool.get(0));
				pool.remove(0);
			}
			
			showGameState(person, computerPile, personPile);
			
			// Now it is the computer's turn
			// Randomly choose a card
			if (!computer.isEmpty())
			{
				int card = computer.get((int)(Math.random()*computer.size()));	
				System.out.println("Do you have any "  + card + "'s ?");
				
				//Play one turn with the computer doing the choosing
				playOneTurn(card, computer, person, computerPile, personPile, pool);
			}
			else if (!pool.isEmpty())
			{
				//Let the computer draw from the deck
				System.out.println("Draw a card from the deck.");
				computer.add(pool.get(0));
				pool.remove(0);
			}
			
			showGameState(person, computerPile, personPile);
		}
		
		//Determine the winner and tell the user--remember ties are possible
		showWinner(personPile, computerPile);
	}
	
	public static void showWinner(ArrayList<Integer> personPile, ArrayList<Integer> computerPile){
		if(computerPile.size() > personPile.size()){
			System.out.println("Computer wins.");
		}
		else if(computerPile.size() < personPile.size()){
			System.out.println("Person wins.");
		}
		else if(computerPile.size() == personPile.size()){
			System.out.println("Tie.");
		}
	}
	
	/** Show the user their cards and their pile and the computer's pile.
	 * 
	 * @param person The cards in the person's hand.
	 * @param computerPile The pile of completed books for the computer.
	 * @param personPile The pile of completed books for the person.
	 */
	public static void showGameState(ArrayList<Integer> person, ArrayList<Integer> computerPile,
			ArrayList<Integer> personPile)
	{
		System.out.println("Here are your cards:");
		showCards(person);
		System.out.println("Here is your pile:");
		showCards(personPile);
		System.out.println("Here is my pile:");
		showCards(computerPile);
	}
	
	/** Play one turn of Go Fish!. The chooser is the person who is selecting a card from the
	 * other person's hand.  This will alternate between the person and the computer.
	 * @param card The card that has been selected.
	 * @param chooser The hand for the player who is currently choosing.
	 * @param chosen The hand for the player who is being asked for cards.
	 * @param chooserPile The pile for the player who is currently choosing.
	 * @param chosenPile The pile for the player who is being asked for cards.
	 * @param pool The deck of cards that have not yet been distributed, already sorted.
	 */
	public static void playOneTurn(int card, ArrayList<Integer> chooser, ArrayList<Integer> chosen,
			ArrayList<Integer> chooserPile, ArrayList<Integer> chosenPile, ArrayList<Integer> pool)
	{
		if (chosen.contains(card))
		{
			//Chosen gives cards to Chooser
			System.out.println("Here's your " + card);
			chooser.add(new Integer(card));
			chosen.remove(new Integer(card));
			//If there is a set of four matching cards, put them up on the table
			ArrayList<Integer> one = new ArrayList<Integer>();
			ArrayList<Integer> two = new ArrayList<Integer>();
			ArrayList<Integer> three = new ArrayList<Integer>();
			ArrayList<Integer> four = new ArrayList<Integer>();
			ArrayList<Integer> five = new ArrayList<Integer>();
			ArrayList<Integer> six = new ArrayList<Integer>();
			ArrayList<Integer> seven = new ArrayList<Integer>();
			ArrayList<Integer> eight = new ArrayList<Integer>();
			ArrayList<Integer> nine = new ArrayList<Integer>();
			ArrayList<Integer> ten = new ArrayList<Integer>();
			ArrayList<Integer> eleven = new ArrayList<Integer>();
			ArrayList<Integer> twelve = new ArrayList<Integer>();
			ArrayList<Integer> thirteen = new ArrayList<Integer>();
			
			if((card == 1 || card == 2 || card == 3 || card == 4)){
				one.add(new Integer(card));
			}
			if(one.size() == 4){
				chooserPile.addAll(one);
			}
			if((card == 5 || card == 6 || card == 7 || card == 8)){
				two.add(new Integer(card));
			}
			if(two.size() == 4){
				chooserPile.addAll(two);
			}
			if((card == 9 || card == 10 || card == 11 || card == 12)){
				three.add(new Integer(card));
			}
			if(three.size() == 4){
				chooserPile.addAll(three);
			}
			if((card == 13 || card == 14 || card == 15 || card == 16)){
				four.add(new Integer(card));
			}
			if(three.size() == 4){
				chooserPile.addAll(four);
			}
			if((card == 17 || card == 18 || card == 19 || card == 20)){
				five.add(new Integer(card));
			}
			if(five.size() == 4){
				chooserPile.addAll(five);
			}
			if((card == 21 || card == 22 || card == 23 || card == 24)){
				six.add(new Integer(card));
			}
			if(six.size() == 4){
				chooserPile.addAll(six);
			}
			if((card == 25 || card == 26 || card == 27 || card == 28)){
				seven.add(new Integer(card));
			}
			if(seven.size() == 4){
				chooserPile.addAll(seven);
			}
			if((card == 29 || card == 30 || card == 31 || card == 32)){
				eight.add(new Integer(card));
			}
			if(eight.size() == 4){
				chooserPile.addAll(eight);
			}
			if((card == 33 || card == 34 || card == 35 || card == 36)){
				nine.add(new Integer(card));
			}
			if(nine.size() == 4){
				chooserPile.addAll(nine);
			}
			if((card == 37 || card == 38 || card == 39 || card == 40)){
				ten.add(new Integer(card));
			}
			if(ten.size() == 4){
				chooserPile.addAll(ten);
			}
			if((card == 41 || card == 42 || card == 43 || card == 44)){
				eleven.add(new Integer(card));
			}
			if(eleven.size() == 4){
				chooserPile.addAll(eleven);
			}
			if((card == 45 || card == 46 || card == 47 || card == 48)){
				twelve.add(new Integer(card));
			}
			if(twelve.size() == 4){
				chooserPile.addAll(twelve);
			}
			if((card == 49 || card == 50 || card == 51 || card == 52)){
				thirteen.add(new Integer(card));
			}
			if(thirteen.size() == 4){
				chooserPile.addAll(thirteen);
			}
			
		}
		else
		{
			System.out.println("Go fish!");
			
			//Draw a card by removing it from the pool and putting it in the chooser's hand
			if(!pool.isEmpty()){
				chooser.add(pool.get(0));
				pool.remove(0);
			}
			else{
			
			//If there is a set of four matching cards, put them on the table
				ArrayList<Integer> one = new ArrayList<Integer>();
				ArrayList<Integer> two = new ArrayList<Integer>();
				ArrayList<Integer> three = new ArrayList<Integer>();
				ArrayList<Integer> four = new ArrayList<Integer>();
				ArrayList<Integer> five = new ArrayList<Integer>();
				ArrayList<Integer> six = new ArrayList<Integer>();
				ArrayList<Integer> seven = new ArrayList<Integer>();
				ArrayList<Integer> eight = new ArrayList<Integer>();
				ArrayList<Integer> nine = new ArrayList<Integer>();
				ArrayList<Integer> ten = new ArrayList<Integer>();
				ArrayList<Integer> eleven = new ArrayList<Integer>();
				ArrayList<Integer> twelve = new ArrayList<Integer>();
				ArrayList<Integer> thirteen = new ArrayList<Integer>();
				
				if((card == 1 || card == 2 || card == 3 || card == 4)){
					one.add(new Integer(card));
				}
				if(one.size() == 4){
					chooserPile.addAll(one);
				}
				if((card == 5 || card == 6 || card == 7 || card == 8)){
					two.add(new Integer(card));
				}
				if(two.size() == 4){
					chooserPile.addAll(two);
				}
				if((card == 9 || card == 10 || card == 11 || card == 12)){
					three.add(new Integer(card));
				}
				if(three.size() == 4){
					chooserPile.addAll(three);
				}
				if((card == 13 || card == 14 || card == 15 || card == 16)){
					four.add(new Integer(card));
				}
				if(three.size() == 4){
					chooserPile.addAll(four);
				}
				if((card == 17 || card == 18 || card == 19 || card == 20)){
					five.add(new Integer(card));
				}
				if(five.size() == 4){
					chooserPile.addAll(five);
				}
				if((card == 21 || card == 22 || card == 23 || card == 24)){
					six.add(new Integer(card));
				}
				if(six.size() == 4){
					chooserPile.addAll(six);
				}
				if((card == 25 || card == 26 || card == 27 || card == 28)){
					seven.add(new Integer(card));
				}
				if(seven.size() == 4){
					chooserPile.addAll(seven);
				}
				if((card == 29 || card == 30 || card == 31 || card == 32)){
					eight.add(new Integer(card));
				}
				if(eight.size() == 4){
					chooserPile.addAll(eight);
				}
				if((card == 33 || card == 34 || card == 35 || card == 36)){
					nine.add(new Integer(card));
				}
				if(nine.size() == 4){
					chooserPile.addAll(nine);
				}
				if((card == 37 || card == 38 || card == 39 || card == 40)){
					ten.add(new Integer(card));
				}
				if(ten.size() == 4){
					chooserPile.addAll(ten);
				}
				if((card == 41 || card == 42 || card == 43 || card == 44)){
					eleven.add(new Integer(card));
				}
				if(eleven.size() == 4){
					chooserPile.addAll(eleven);
				}
				if((card == 45 || card == 46 || card == 47 || card == 48)){
					twelve.add(new Integer(card));
				}
				if(twelve.size() == 4){
					chooserPile.addAll(twelve);
				}
				if((card == 49 || card == 50 || card == 51 || card == 52)){
					thirteen.add(new Integer(card));
				}
				if(thirteen.size() == 4){
					chooserPile.addAll(thirteen);
				}
			}
		}
	}
	
	/** Transfer all cards of rank card from the source to the destination.
	 * 
	 * @param card The rank of the selected card.
	 * @param destination The hand that will receive the cards.
	 * @param source The hand that will lose the cards.
	 */
	public static void transferCards(int card, ArrayList<Integer> destination, ArrayList<Integer> source)
	{
		while (source.contains(card))
		{
			destination.add(card);
			source.remove(new Integer(card)); // this is that tricky thing from the handout
		}
	}
	
	/** Deal two equal size hands, one to each player.
	 * 
	 * @param deck The deck of cards that should be dealt. These cards should have been shuffled.
	 * @param hand1 The first player.
	 * @param hand2 The second player.
	 */
	public static void dealHands(ArrayList<Integer> deck, ArrayList<Integer> hand1, ArrayList<Integer> hand2)
	{
		//Deal cards to person
		for(int i = 0; i < STARTING_HAND_SIZE; ++i){
			int card = deck.get(i);
			transferCards(card, hand1, deck);
		}
		//Deal cards to computer
		for(int i = 0; i < STARTING_HAND_SIZE; ++i){
			int card = deck.get(i);
			transferCards(card, hand2, deck);
		}
	}
	
	/** Build a deck of 52 cards, 4 of each rank from 1 to 13
	 * 
	 * @return The deck of cards.
	 */
	public static ArrayList<Integer> createDeck()
	{
		//Create a deck of cards
		ArrayList<Integer> pool = new ArrayList<Integer>(52);
		
		//For loop puts cards numbered 0-51 in indices 0-51
		//Cards are ranked by ((card #) % 13) + 1
		for(int i = 0; i <=51; ++i){
			pool.add(i);
		}
		return pool;// keep the compiler happy and quiet
	}
	

	/** Show all of the cards is any given pack, hand, deck, or pile.
	 * 
	 * @param cards The cards to be displayed
	 */
	public static void showCards(ArrayList<Integer> cards)
	{
		//Sort the cards to make it easier for the user to know what they have
		Collections.sort(cards);
		
		for (Integer i: cards)
		{
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
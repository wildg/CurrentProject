import java.util.Random;
import java.util.Scanner;

/**

 Program that generates a random number between 1 and 20 inclusive
 and prompts for integer input until the user guesses it correctly.
 
 Team Exercise 1
 
 CPSC233
 Section: L01
 Instructor: Leanne Wu
 Group: T01-04
 Members: Mark Tremblay, Ezra Guia, Brandon Fisher, Wild Guevara 
 
 Last Changed: January 22nd, 2017.
*/

public class NumberGuesser
{
	public static void main(String[] args)
	{
		Random randObj = new Random();
		Scanner keyboard = new Scanner(System.in);
		
		int numberToGuess = randObj.nextInt(20) + 1; /** add 1 so that chosen number lands between 1-20 inclusive
													     as nextInt(20) generates numbers 0-19 inclusive.*/	
														 
		boolean isItAnInteger = false; // Variable to check if input is integer.
		int userGuess = 42; // Pick a number that numberToGuess cannot be to avoid automatically exiting loop.
		
		System.out.println("I'm thinking of a number between 1 and 20");
		
		while (userGuess != numberToGuess)
		{
			System.out.print("What is your guess?: ");
			isItAnInteger = keyboard.hasNextInt(); // Allow user to enter input and check if its an integer.
				
			if  (isItAnInteger == true)  // If it's an integer continue.
			{
				userGuess = keyboard.nextInt();
				
				if ((userGuess <= 20) && 
				   (userGuess >= 1))
				{	
					
					if (userGuess == numberToGuess)
						System.out.println("You got it! The number is indeed " + numberToGuess );
				
					else if (userGuess < numberToGuess)
						System.out.println("Too low");
				
					else if (userGuess > numberToGuess)
						System.out.println("Too high");
					
				}
					
				else // If not an integer: ERROR and prompt again.
				{
					System.out.println("ERROR: Please enter an integer between 1 and 20 inclusive.");
				}
					
			}
			
			else
			{
				System.out.println("ERROR: Please enter an integer.");
				keyboard.next(); // Move to next line otherwise we get infinite loop.
				
			}
					
		}
		
	}
}
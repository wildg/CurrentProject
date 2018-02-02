import java.util.Scanner;

	// February 1st, 2018
	
	// By Mark Tremblay
	
	// 
	
	/* 
	Version 20
	1. Made addToActiveObstacleList a private method.
	2. Added addToActiveCollectibleList and addToActivePlayerList methods.
	3. Made certain instance variables plural.
	4. Removed separate methods to instantiate objects and placed them into one method
	   instantiateObject.
	**/

public class AnimationApplication
{
	private final int MAX_ACTIVE_OBSTACLES = 4; 
	private final int MAX_ACTIVE_PLAYERS = 4;
	private final int MAX_ACTIVE_COLLECTIBLES = 4;
	
	private int numActiveObstacles = 0;
	private int numActivePlayers = 0;
	private int numActiveCollectibles= 0;
	
	// The following are the active object lists. They maintain references to objects that are currently
	// active in the game.
	Scanner[] activeObstacleList = new Scanner[MAX_ACTIVE_OBSTACLES]; // Will use Scanner for Array type until Obstacle class imported
	Player[] activePlayerList = new Player[MAX_ACTIVE_PLAYERS];
	Scanner[] activeCollectibleList= new Scanner[MAX_ACTIVE_COLLECTIBLES]; // Will use Scanner for Array type until Collectible class imported.
	
	/*Places newly instantiated obstacles in the first free index of the activeObstacleList**/
	private void addToActiveObstacleList(Scanner myObject)
	{
		for(int index=0; index < activeObstacleList.length; index++)
		{
			if(activeObstacleList[index] == null)
			{
				activeObstacleList[index] = myObject;
				break;
			}
			
		}
	}
	
	/*Places newly instantiated players in the first free index of the activePlayerList**/
	private void addToActivePlayerList(Player myObject)
	{
		for(int index=0; index < activePlayerList.length; index++)
		{
			if(activePlayerList[index] == null)
			{
				activePlayerList[index] = myObject;
				break;
			}
			
		}
	}
	
	/*Places newly instantiated collectibles in the first free index of the activeCollectibleList**/
	private void addToActiveCollectibleList(Scanner myObject)
	{
		for(int index=0; index < activeCollectibleList.length; index++)
		{
			if(activeCollectibleList[index] == null)
			{
				activeCollectibleList[index] = myObject;
				break;
			}
			
		}
	}

	/*Prints out contents of one of the Active Object Lists corresponding 
	  to the String that the method takes as an argument. Valid String
      arguments are as follows: "Obstacle","Collectible", and "Player".
	  Case matters.**/
	public void printActiveObjectList(String whichList)
	{
		//Prints out obstacle list.
		if(whichList.equals("Obstacle"))
		{
			System.out.print("activeObstacleList: [ "); 
			for(int index = 0; index < activeObstacleList.length;) 
			{
				if(activeObstacleList[index] != null)
				{	
					System.out.print(activeObstacleList[index].getClass().getName() + " , ");
					index++;
				}
				
				else
				{
					System.out.print(activeObstacleList[index] + " , ");
					index++;
				}
			
			}
			System.out.println("]");
		}
		
		// Prints out collectible list.
		if(whichList.equals("Collectible"))
		{
			System.out.print("activeCollectibleList: [ "); 
			for(int index = 0; index < activeCollectibleList.length;) 
			{
				if(activeCollectibleList[index] != null)
				{	
					System.out.print(activeCollectibleList[index].getClass().getName() + " , ");
					index++;
				}
				
				else
				{
					System.out.print(activeCollectibleList[index] + " , ");
					index++;
				}
			
			}
			System.out.println("]");
		}
		
		// Prints out player list.
		if(whichList.equals("Player"))
		{
			System.out.print("activePlayerList: [ "); 
			for(int index = 0; index < activePlayerList.length;) 
			{
				if(activePlayerList[index] != null)
				{	
					System.out.print(activePlayerList[index].getClass().getName() + " , ");
					index++;
				}
				
				else
				{
					System.out.print(activePlayerList[index] + " , ");
					index++;
				}
			
			}
			System.out.println("]");
		}
		
	}
	
	/* Removes obstacle at specified index from activeObstacleList by putting a null value in its place. **/
	public void deleteObstacle(int index) 
	{
		if (index < activeObstacleList.length && index >= 0)
		{
			activeObstacleList[index] = null;
			numActiveObstacles = numActiveObstacles - 1;
		}
		
	}
	
	/* Instantiate a new object corresponding to a String that describes which type
	   of object should be instantiated, and adds it to its corresponding Active
	   Object List. Valid strings include: "Obstacle", "Player", and "Collectible".
	   Case matters.**/
	private void instantiateObject(String objectType)
	{
		int maximumActive = 0;
		int currentActive = 0;
		boolean isObstacle = objectType.equals("Obstacle");
		boolean isPlayer = objectType.equals("Player");
		boolean isCollectible = objectType.equals("Collectible");
		
		if(!(isObstacle || isPlayer || isCollectible))
		{
			System.out.println("");
			System.out.println("ERROR: Please enter a valid String to define");
			System.out.println(	"which type of object to instantiate when using");
			System.out.println( "instantiateObject method: " +"'" + objectType +"' " + " is");
			System.out.println( "not a valid string");
			System.exit(0);
		}
		
		if(isObstacle)
		{
			maximumActive = MAX_ACTIVE_OBSTACLES;
			currentActive = numActiveObstacles;
		}
		else if(isPlayer)
		{
			maximumActive = MAX_ACTIVE_PLAYERS;
			currentActive = numActivePlayers;
		}
		
		else if(isCollectible)
		{
			maximumActive = MAX_ACTIVE_COLLECTIBLES;
			currentActive = numActiveCollectibles;
		}
		
		if( currentActive < maximumActive && 
		    currentActive >= 0)
		{	
			if(isObstacle)
			{
				Scanner obstacleObject = new Scanner(System.in);
				numActiveObstacles++;
				currentActive = numActiveObstacles; // for debugging message
				addToActiveObstacleList(obstacleObject);
			}
			
			if(isPlayer)
			{
				Player playerObject = new Player(); 
				numActivePlayers++;
				currentActive = numActivePlayers; // for debugging message
				addToActivePlayerList(playerObject);
			}
			
			if(isCollectible)
			{
				Scanner collectibleObject = new Scanner(System.in);
				numActiveCollectibles++;
				currentActive = numActiveCollectibles; // for debugging message
				addToActiveCollectibleList(collectibleObject);
			}

				
		}
		
		else // for debugging
		{
			 System.out.println("");
			 System.out.println("Can't instantiate anymore " + objectType + "s max exceeded"); 
			 System.out.println("Current instantiated" + objectType + "s" + " = " + currentActive);
			 System.out.println("");
		}
		
	}
	
	
	public static void main(String[]args)
	{
		AnimationApplication gameEngine = new AnimationApplication();
		
		gameEngine.instantiateObject("Player");
		gameEngine.instantiateObject("Player");
		gameEngine.instantiateObject("Player");
		
		gameEngine.instantiateObject("Obstacle");
		gameEngine.instantiateObject("Obstacle");
		gameEngine.instantiateObject("Obstacle");
		
		gameEngine.instantiateObject("Collectible");
		gameEngine.instantiateObject("Collectible");
		gameEngine.instantiateObject("Collectible");
		
		gameEngine.printActiveObjectList("Obstacle");
		gameEngine.printActiveObjectList("Player");
		gameEngine.printActiveObjectList("Collectible");
	}
}

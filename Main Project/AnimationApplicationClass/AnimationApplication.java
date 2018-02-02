import java.util.Scanner;

	// February 2nd, 2018
	
	// By Mark Tremblay
	
	// 
	
	/* 
	Version 21
	1. Removed instantiateObject method. Was too complex. Replaced with makeObstacle(), makeCollectible, and makePlayer()
	   classes. These new methods take integer x and y positions as arguments.
	2. Cleaned  up implementation of printActiveObjectList.
	3. Created deleteCollectible and deletePlayer methods.
	4. Tightened whitespace.
	**/

public class AnimationApplication
{
	private final int MAX_ACTIVE_OBSTACLES = 3; 
	private final int MAX_ACTIVE_PLAYERS = 1;
	private final int MAX_ACTIVE_COLLECTIBLES = 2;
	
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
		boolean isObstacle = whichList.equals("Obstacle");
		boolean isPlayer = whichList.equals("Player");
		boolean isCollectible = whichList.equals("Collectible");
		
		Object[]listToPrint; // Object list allows me store any of my Active Object Lists in this variable.
		listToPrint = new Object[1]; // Arbitrary Array size. Just need to initialize
		String listName = ""; // Arbitrary String. Just need to initialize.
		
		if(isObstacle)
		{
			listToPrint = activeObstacleList;
			listName = "activeObstacleList";
		}
		
		else if(isPlayer)
		{
			listToPrint = activePlayerList;
			listName = "activePlayerList";
		}
		
		else if(isCollectible)
		{
			listToPrint = activeCollectibleList;
			listName = "activeCollectibleList";
		}
		
		else
		{
			System.out.println("ERROR: Please enter a valid String argument for");
			System.out.println("the printActiveObjectList method: " + "'" + whichList + "'");
			System.out.println("is not a valid argument.");
			System.exit(0);
		}
		
		System.out.println("");
		System.out.print(listName + ": [ "); 
		for(int index = 0; index < listToPrint.length;) 
		{
			if(listToPrint[index] != null)
			{	
				System.out.print(listToPrint[index].getClass().getName() + " , ");
				index++;
			}
			
			else
			{
				System.out.print(listToPrint[index] + " , ");
				index++;
			}
		}
		System.out.println("]");
		System.out.println("");
	}
	
	/*Instantiates an Obstacle at the specified x and y positions on the map. Takes
	  two integers representing the x and y positions as arguments.**/
	private void makeObstacle(int xpos, int ypos)
	{
		int maximumActive = MAX_ACTIVE_OBSTACLES;
		int currentActive = numActiveObstacles;
		
		if( currentActive < maximumActive && 
		    currentActive >= 0)
		{	
			Scanner obstacleObject = new Scanner(System.in);
			numActiveObstacles++;
			addToActiveObstacleList(obstacleObject);
		}
		
		else // for debugging
		{
			 System.out.println("");
			 System.out.println("Can't instantiate anymore obstacles, max exceeded"); 
			 System.out.println("Current instantiated obstacles " + "= " + numActiveObstacles);
			 System.out.println("");
		}
	}
	
	/*Instantiates a Player at the specified x and y positions on the map. Takes
	  two integers representing the x and y positions as arguments.**/
	private void makePlayer(int xpos, int ypos) 
	{
		int maximumActive = MAX_ACTIVE_PLAYERS;
		int currentActive = numActivePlayers;
		
		if( currentActive < maximumActive && 
		    currentActive >= 0)
		{	
			Player playerObject = new Player();
			numActivePlayers++;
			addToActivePlayerList(playerObject);
		}
		
		else // for debugging
		{
			 System.out.println("");
			 System.out.println("Can't instantiate anymore players, max exceeded"); 
			 System.out.println("Current instantiated players " + "= " + numActivePlayers);
			 System.out.println("");
		}
	}
	
	/*Instantiates a Collectible at the specified x and y positions on the map. Takes
	  two integers representing the x and y positions as arguments.**/
	private void makeCollectible(int xpos, int ypos) 
	{
		int maximumActive = MAX_ACTIVE_COLLECTIBLES;
		int currentActive = numActiveCollectibles;
		
		if( currentActive < maximumActive && 
		    currentActive >= 0)
		{	
			Scanner collectibleObject = new Scanner(System.in);
			numActiveCollectibles++;
			addToActiveCollectibleList(collectibleObject);
		}
		
		else // for debugging
		{
			 System.out.println("");
			 System.out.println("Can't instantiate anymore collectibles, max exceeded"); 
			 System.out.println("Current instantiated collectibles " + "= " + numActiveCollectibles);
			 System.out.println("");
		}
	}
	
	/* Removes obstacle at specified index from activeObstacleList by putting a null value in its place. **/
	private void deleteObstacle(int index) 
	{
		if (index < activeObstacleList.length && index >= 0)
		{
			activeObstacleList[index] = null;
			numActiveObstacles = numActiveObstacles - 1;
		}	
	}
	
	/* Removes player at specified index from activePlayerList by putting a null value in its place. **/
	private void deletePlayer(int index) 
	{
		if (index < activePlayerList.length && index >= 0)
		{
			activePlayerList[index] = null;
			numActivePlayers = numActivePlayers - 1;
		}	
	}
	
	/* Removes obstacle at specified index from activeObstacleList by putting a null value in its place. **/
	private void deleteCollectible(int index) 
	{
		if (index < activeCollectibleList.length && index >= 0)
		{
			activeCollectibleList[index] = null;
			numActiveCollectibles = numActiveCollectibles - 1;
		}	
	}
	
	public static void main(String[]args)
	{
		AnimationApplication gameEngine = new AnimationApplication();
		
		gameEngine.makePlayer(4,2);
		gameEngine.makeObstacle(4,2);
		gameEngine.makeObstacle(4,2);
		gameEngine.makeObstacle(4,2);
		gameEngine.makeCollectible(4,2);
		
		gameEngine.printActiveObjectList("Obstacle");
		gameEngine.printActiveObjectList("Player");
		gameEngine.printActiveObjectList("Collectible");
		
		gameEngine.deleteObstacle(2);
		gameEngine.deleteCollectible(0);
		gameEngine.deletePlayer(0);
		
		gameEngine.printActiveObjectList("Obstacle");
		gameEngine.printActiveObjectList("Player");
		gameEngine.printActiveObjectList("Collectible");
	}
}

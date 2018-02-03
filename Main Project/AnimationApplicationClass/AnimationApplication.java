	// February 2, 2018
	
	// By Mark Tremblay
	
	// 
	
	/* 
	Version 23
	1. Created registerCollision class and functionality. At the current
	   it deletes all objects in a type specified by a string argument, but in later
	   implementation it will only delete overlapping objects. Otherwise functionality
	   seems to work properly.
	**/

public class AnimationApplication
{
	// These values set size of Arrays that contain active objects.
	private final int MAX_ACTIVE_OBSTACLES = 3; 
	private final int MAX_ACTIVE_PLAYERS = 3;
	private final int MAX_ACTIVE_COLLECTIBLES = 3;
	
	private int numActiveObstacles = 0;
	private int numActivePlayers = 0;
	private int numActiveCollectibles= 0;
	
	// The following are the active object lists. They maintain references to objects that are currently
	// active in the game.
	
	String[] activeObstacleList = new String[MAX_ACTIVE_OBSTACLES]; // Will use String for Array type until Obstacle class imported
	Player[] activePlayerList = new Player[MAX_ACTIVE_PLAYERS];
	String[] activeCollectibleList= new String[MAX_ACTIVE_COLLECTIBLES]; // Will use String for Array type until Collectible class imported.
	
	/*Places newly instantiated obstacles in the first free index of the activeObstacleList**/
	private void addToActiveObstacleList(String myObject)
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
	private void addToActiveCollectibleList(String myObject)
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
		String listName = ""; 
		String typeName = "";
		int numActive = 0;
		
		if(isObstacle)
		{
			listToPrint = activeObstacleList;
			listName = "activeObstacleList";
			typeName = "Obstacle";
			numActive = numActiveObstacles;
		}
		
		else if(isPlayer)
		{
			listToPrint = activePlayerList;
			listName = "activePlayerList";
			typeName = "Player";
			numActive = numActivePlayers;
			
		}
		
		else if(isCollectible)
		{
			listToPrint = activeCollectibleList;
			listName = "activeCollectibleList";
			typeName = "Collectible";
			numActive = numActiveCollectibles;
		}
		
		else
		{
			System.out.println("ERROR: Please enter a valid String argument for");
			System.out.println("the printActiveObjectList method: " + "'" + whichList + "'");
			System.out.println("is not a valid argument.");
			System.exit(0);
		}
		
		System.out.println("________________________________________________________");
		System.out.print(listName + ": [ "); 
		for(int index = 0; index < listToPrint.length;index++) 
		{
			if(listToPrint[index] != null)
			{	
				System.out.print(listToPrint[index].getClass().getName());
			}
			
			else
			{
				System.out.print(listToPrint[index]);
			}
			
			if(index != listToPrint.length-1)
			{
				System.out.print(" , ");
			}
		}
		System.out.println("]");
		System.out.println("");
		
		System.out.println("Number of active " + typeName + "(s) is " +  numActive);
		System.out.println("________________________________________________________");
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
			String obstacleObject = new String();
			numActiveObstacles++;
			addToActiveObstacleList(obstacleObject);
		}
		
		// else // for debugging
		// {
			 // System.out.println("");
			 // System.out.println("Can't instantiate anymore obstacles, max exceeded"); 
			 // System.out.println("Current instantiated obstacles " + "= " + numActiveObstacles);
			 // System.out.println("");
		// }
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
		
		// else // for debugging
		// {
			 // System.out.println("");
			 // System.out.println("Can't instantiate anymore players, max exceeded"); 
			 // System.out.println("Current instantiated players " + "= " + numActivePlayers);
			 // System.out.println("");
		// }
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
			String collectibleObject = new String();
			numActiveCollectibles++;
			addToActiveCollectibleList(collectibleObject);
		}
		
		// else // for debugging
		// {
			 // System.out.println("");
			 // System.out.println("Can't instantiate anymore collectibles, max exceeded"); 
			 // System.out.println("Current instantiated collectibles " + "= " + numActiveCollectibles);
			 // System.out.println("");
		// }
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
	
	/*Checks all active objects of a certain type, as specified by a String argument, for
	  overlap with an active object it can collide with, and deletes the active object if 
	  this is true. Valid String arguments include: "Obstacle", "Player" and "Collectible".
	  Case matters. As of the current all active objects of a chosen type are deleted by
	  the algorithm, but this will be changed to the former definition in a later 
	  implementation.**/
	private void registerCollision(String whichType)
	{
		boolean isObstacle = whichType.equals("Obstacle");
		boolean isPlayer = whichType.equals("Player");
		boolean isCollectible = whichType.equals("Collectible");
		
		boolean collisionHappened = true;
		
		Object[]listToCheck; 
		listToCheck = new Object[1]; // Arbitrary Array size. Just need to initialize
		
		int numActive = 0;
		
		if(isObstacle)
		{
			listToCheck = new String[1];
			listToCheck = activeObstacleList;
			numActive = numActiveObstacles;
		}
		
		else if(isPlayer)
		{
			listToCheck = new Player[1];
			listToCheck = activePlayerList;
			numActive = numActivePlayers;
		}
		
		else if(isCollectible)
		{
			listToCheck = new String[1];
			listToCheck = activeCollectibleList;
			numActive = numActiveCollectibles;
		}
		
		else
		{
			System.out.println("ERROR: Please enter a valid String argument for");
			System.out.println("the registerCollision method: " + "'" + whichType + "'");
			System.out.println("is not a valid argument.");
			System.exit(0);
		}
		
		if (numActive > 0)
		{
			for(int index = 0; index < listToCheck.length;index++) 
			{
				if(listToCheck[index] != null)
					System.out.print("");
					// collisionHappened = listToCheck[index].overlapMethod (note this overlapMethod should return true or false)
				else
					continue;
				
				if (collisionHappened)
				{
					if(isObstacle)
						deleteObstacle(index);
					
					else if(isCollectible)
						deleteCollectible(index);
					
					else if (isPlayer)
						deletePlayer(index);
				}
			}
		}
	}
	
	public static void main(String[]args)
	{
		AnimationApplication gameEngine = new AnimationApplication();
		
		gameEngine.makePlayer(4,3);
		gameEngine.makePlayer(4,3);
		gameEngine.makePlayer(4,3);

		gameEngine.makeObstacle(4,3);
		gameEngine.makeObstacle(4,3);
		gameEngine.makeObstacle(4,3);
		
		gameEngine.makeCollectible(4,3);
		gameEngine.makeCollectible(4,3);
		gameEngine.makeCollectible(4,3);
		
		// gameEngine.deletePlayer(1);
		// gameEngine.deleteObstacle(1);
		// gameEngine.deleteCollectible(1);
		
		gameEngine.printActiveObjectList("Player");
		gameEngine.printActiveObjectList("Obstacle");
		gameEngine.printActiveObjectList("Collectible");
		
		gameEngine.registerCollision("Player");
		gameEngine.registerCollision("Obstacle");
		gameEngine.registerCollision("Collectible");
		
		System.out.println("");	
		System.out.println("THERE WAS A SERIES OF UNFORTUNATE COLLISIONS");
		System.out.println("");
		
		gameEngine.printActiveObjectList("Player");
		gameEngine.printActiveObjectList("Obstacle");
		gameEngine.printActiveObjectList("Collectible");
	}
}

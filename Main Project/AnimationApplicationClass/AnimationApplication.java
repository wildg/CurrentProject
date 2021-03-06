	// February 3, 2018
	
	// By Mark Tremblay
	
	// 
	
  /** 
	*Version 27_2 Feb 3rd
	* 1. Fixed a logic error in delete methods where it was possible to
	*	 decrement numActiveObject variables below 0 by using the method
	*	 on null indexes.
	* 2. Fixed another error in delete methods where you could specify an
	* 	 index out of range without warning.
	*/

public class AnimationApplication
{
	// These values set size of Arrays that contain active objects.
	private final int MAX_ACTIVE_OBSTACLES = 3; 
	private final int MAX_ACTIVE_PLAYERS = 3;
	private final int MAX_ACTIVE_COLLECTIBLES = 3;
	
	private final int MAX_OBJECTS_GAME = 2; // Will be mainly used to control instantiation in main method.
	
	private int numActiveObstacles = 0;
	private int numActivePlayers = 0;
	private int numActiveCollectibles= 0;
	
	// The following are the active object lists. They maintain references to objects that are currently
	// active in the game.
	Obstacle[] activeObstacleList = new Obstacle[MAX_ACTIVE_OBSTACLES]; // Will use String for Array type until Obstacle class imported
	Player[] activePlayerList = new Player[MAX_ACTIVE_PLAYERS];
	Collectible[] activeCollectibleList= new Collectible[MAX_ACTIVE_COLLECTIBLES]; // Will use String for Array type until Collectible class imported.
	
	/**
	  *Places newly instantiated obstacles in the first free index of the activeObstacleList.
	  */
	private void addToActiveObstacleList(Obstacle myObject)
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
	
   /** 
	 * Places newly instantiated players in the first free index of the activePlayerList.
	 */
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
	
	/** 
	  *Places newly instantiated collectibles in the first free index of the activeCollectibleList.
	  */
	private void addToActiveCollectibleList(Collectible myObject)
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

	/** Prints out contents of one of the Active Object Lists corresponding 
	  * to the String that the method takes as an argument. Valid String
      * arguments are as follows: "Obstacle","Collectible", and "Player".
	  * Case matters.
	  */
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
		System.out.print(listName + ": ["); 
		for(int index = 0; index < listToPrint.length; index++) // Step through list and print.
		{
			if(listToPrint[index] != null) // If index not null print name.
			{	
				System.out.print(listToPrint[index].getClass().getName());
			}
			
			else // If index is null print that index as is.
			{
				System.out.print(listToPrint[index]);
			}
			
			if(index != listToPrint.length-1) // Check each time so we don't print comma for final index.
			{
				System.out.print(" , ");
			}
		}
		System.out.println("]");
		System.out.println("");
		
		System.out.println("Number of active " + typeName + "(s) is " +  numActive);
		System.out.println("________________________________________________________");
	}
	
	/** Instantiates an Obstacle at the specified x and y positions on the map. Takes
	  * two integers representing the x and y positions as arguments.
	  */
	public void makeObstacle(int xpos, int ypos)
	{
		int maximumActive = MAX_ACTIVE_OBSTACLES;
		int currentActive = numActiveObstacles;
		
		if( currentActive < maximumActive && 
		    currentActive >= 0)
		{	
			Obstacle obstacleObject = new Obstacle();
			numActiveObstacles++; 				  
			addToActiveObstacleList(obstacleObject);
			// NOTE: Since obstacleObject is local to this method,
			// when this method is complete the only reference
			// to the new Obstacle object is the index we set it to in the
			// Obstacle[] instance variable activeObstacleList. Therefore
			// when we remove this reference in deleteObstacle, Java will
			// reallocate the memory for the unreferenced object, preventing
			// garbage data building up. Same goes for other make methods.
		}
	}
	
	/** 
	  * Instantiates a Player at the specified x and y positions on the map. Takes
	  * two integers representing the x and y positions as arguments.
	  */
	public void makePlayer(int xpos, int ypos) 
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
	}
	
   /** Instantiates a Collectible at the specified x and y positions on the map. Takes
	 * two integers representing the x and y positions as arguments.
	 */
	public void makeCollectible(int xpos, int ypos) 
	{
		int maximumActive = MAX_ACTIVE_COLLECTIBLES;
		int currentActive = numActiveCollectibles;
		
		if( currentActive < maximumActive && 
		    currentActive >= 0)
		{	
			Collectible collectibleObject = new Collectible();
			numActiveCollectibles++;
			addToActiveCollectibleList(collectibleObject);
		}
	}
	
	/**  
	  * Removes obstacle at specified index from activeObstacleList by putting a null value in its place. 
	  */
	public void deleteObstacle(int index) 
	{
		if (index < activeObstacleList.length && index >= 0)
		{
			if(activeObstacleList[index]!=null) // So we can't make numActivePlayers a negative value by
			{								    // making null indexes null and decrementing numActive.
				activeObstacleList[index] = null;
				numActiveObstacles = numActiveObstacles - 1;
			}
			
			else
			{
				System.out.println("ILLEGAL ACTION: Tried to delete reference at an empty index of the activeObstacleList");
				System.out.println("while using deleteObstacle()");
				System.exit(0);
			}
		}
		
		else
		{
			System.out.println("ILLEGAL ACTION: Tried to delete an index out of the range of activeObstacleList");
			System.out.println("while using deleteObstacle()");
			System.exit(0);
		}
	}
	
   /** 
	 * Removes player at specified index from activePlayerList by putting a null value in its place. 
	 */
	public void deletePlayer(int index) 
	{
		if (index < activePlayerList.length && index >= 0)
		{
			if(activePlayerList[index]!=null) // So we can't make numActivePlayers a negative value by
			{								  // making null indexes null and decrementing numActive.
				activePlayerList[index] = null;
				numActivePlayers = numActivePlayers - 1;
			}
			
			else
			{
				System.out.println("ILLEGAL ACTION: Tried to delete reference at an empty index of the activePlayerList");
				System.out.println("while using deletePlayer()");
				System.exit(0);
			}
		}	
		
		else
		{
			System.out.println("ILLEGAL ACTION: Tried to delete an index out of the range of activePlayerList");
			System.out.println("while using deletePlayer()");
			System.exit(0);
		}
	}
	
	/**  
	  * Removes obstacle at specified index from activeObstacleList by putting a null value in its place. 
	  */
	public void deleteCollectible(int index) 
	{
		if (index < activeCollectibleList.length && index >= 0)
		{
			if(activeCollectibleList[index]!=null) // So we can't make numActiveCollectibles a negative value by
												   // making null indexes null and decrementing numActive.
			{
				activeCollectibleList[index] = null;
				numActiveCollectibles = numActiveCollectibles - 1;
			}
			
			else
			{
				System.out.println("ILLEGAL ACTION: Tried to delete reference at an empty index of the activeCollectibleList");
				System.out.println("while using deleteCollectible()");
				System.exit(0);
			}
		}	
		
		else
		{
			System.out.println("ILLEGAL ACTION: Tried to delete an index out of the range of activeCollectibleList");
			System.out.println("while using deleteCollectible()");
			System.exit(0);
		}
	}
	
	/** 
	  * Checks all active Player objects for collisions with members of a valid active object type, as specified
	  * by a String argument, and takes necessary action if this is true. As of the current this method is not fully 
	  * implemented. Valid arguments for String include "Obstacle", and "Collectible". Case matters.
	  */
	private void registerCollisionPlayer(String activeObjectType)
	{	
		if(activeObjectType == "Obstacle")
		{
			if (numActivePlayers > 0 & numActiveObstacles > 0)
			{
				for(int playerIndex = 0; playerIndex < activePlayerList.length; playerIndex++) // Run through each index of activePlayerList
				{
					//getPlayer(playerIndex).hasCollisionObstacle <AnimationApplication>
					
										 // Method should check for collisions with objects
										 // in activeObstacleList by stepping through it using
										 // getObstacle() and activeObstacleLength() on the AnimationApplication 
										 // object taken as an argument. If a collision is registered,
										 // necessary action should be taken with the aid of deleteObstacle().
				}
			}
		}
		
		else if(activeObjectType == "Collectible")
		{
			if (numActivePlayers > 0 & numActiveCollectibles > 0)
			{
				for(int playerIndex = 0; playerIndex < activePlayerList.length; playerIndex++) // Run through each index of activePlayerList
				{
					//getPlayer(playerIndex).hasCollisionCollectible <gameEngine> 
					
									   // Method should check for collisions with objects
									   // in activeCollectibleList by stepping through it using
									   // getCollectible() and activeCollectibleLength() on the AnimationApplication 
									   // object taken as an argument. If a collision is registered,
									   // necessary action should be taken with the aid of deleteCollectible().
				}
			}
		}
		
		else
		{
			System.out.println("ERROR: Please enter a valid String argument for");
			System.out.println("the registerPlayerCollision method: " + "'" + activeObjectType + "'");
			System.out.println("is not a valid argument.");
			System.exit(0);	
		}
	}
	
	/** 
	  * Returns Player object at specified index in activePlayerList.
	  **/
	public Player getPlayer(int index)
	{
		return activePlayerList[index];
	}
	
	/** 
	  *Returns Obstacle object at specified index in activeObstacleList.
	  */
	public Obstacle getObstacle(int index)
	{
		return activeObstacleList[index];
	}
	
	/** 
	  * Returns Collectible object at specified index in activeCollectibleList.
	  */
	public Collectible getCollectible(int index)
	{
		return activeCollectibleList[index];
	}
	
	/** 
	  *Returns an integer corresponding to the size of the activeObstacleList
	  */
	public int activeObstacleLength()
	{
		return MAX_ACTIVE_OBSTACLES;
	}
	
	/** 
	  *Returns an integer corresponding to the size of the activeCollectibleList
	  */
	public int activeCollectibleLength()
	{
		return MAX_ACTIVE_COLLECTIBLES;
	}
	
	/** 
	  *Returns an integer corresponding to the size of the activePlayerList
	  */
	public int activePlayerLength()
	{
		return MAX_ACTIVE_PLAYERS;
	}
	
	public static void main(String[]args)
	{
		AnimationApplication gameEngine = new AnimationApplication();
		
		gameEngine.makePlayer(0,10); 
		Player playerOne = gameEngine.getPlayer(0); // NOTE: Make sure to clear this reference too if you delete player.
		gameEngine.makeObstacle(30,10); // So we have at least one obstacle when game starts.
		
		boolean gameOver = (gameEngine.numActivePlayers < 0);
	
		while(!(gameOver))
		{				
			gameEngine.makeCollectible(0,0); // To test to see if it appears in list.
			gameEngine.printActiveObjectList("Player");
			gameEngine.printActiveObjectList("Obstacle");
			gameEngine.printActiveObjectList("Collectible");
			
			gameEngine.registerCollisionPlayer("Collectible");
			gameEngine.registerCollisionPlayer("Obstacle");
			
			gameOver = true;
		}
	}
}

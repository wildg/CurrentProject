import java.util.Scanner;

	// February 1st, 2018
	
	// By Mark Tremblay
	
	// 
	
	/* 
	Version 19
	1. Updated printActiveObstacleList method, by removing parameters, and making
	   method only print contents of that instance variable.
	2. Updated method descriptions, and made them Java-doc compatible, as well as version description.
	3. Removed unnecessary parameter for instantiation methods.
	4. Added several new instance variables to control max objects instantiated
	   and keep track of how many objects have been instantiated.	
	5. Created new active object lists.
	6. Changed printActiveObstacleList to a method capable of printing any of the active object lists
	   called printActiveObjectList
	**/

public class AnimationApplication
{
	private final int MAX_ACTIVE_OBSTACLES = 2; 
	private final int MAX_ACTIVE_PLAYERS = 1;
	private final int MAX_ACTIVE_COLLECTIBLES = 1;
	
	private int numActiveObstacle = 0;
	private int numActivePlayer = 0;
	private int numActiveCollectibles = 0;
	
	// The following are the active object lists. They maintain references to objects that are currently
	// active in the game.
	Scanner[] activeObstacleList = new Scanner[MAX_ACTIVE_OBSTACLES]; // Will use Scanner for Array type until Obstacle class imported
	Player[] activePlayerList = new Player[MAX_ACTIVE_PLAYERS];
	Scanner[] activeCollectibleList= new Scanner[MAX_ACTIVE_COLLECTIBLES]; // Will use Scanner for Array type until Collectible class imported.
	
	public void addToActiveObstacleList(Scanner myObject)
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
	
	/*Prints out contents of one of the Active Object Lists. Prints out a list 
      corresponding to the String that the method takes as an argument. Valid String
      arguments are as follows: "obstacle","collectible","player"**/
	public void printActiveObjectList(String whichList)
	{
		if(whichList.equalsIgnoreCase("obstacle"))
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
		
		if(whichList.equalsIgnoreCase("collectible"))
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
		
		if(whichList.equalsIgnoreCase("player"))
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
			numActiveObstacle = numActiveObstacle - 1;
		}
		
	}
	
	/* Creates a new Player object **/
	public void instantiatePlayer()
	{
			Player playerObject = new Player();
	}
	
	
	/* Creates new Obstacle object and adds it to the activeObstacleList.**/
	public void instantiateObstacle()
	{
		if( numActiveObstacle < MAX_ACTIVE_OBSTACLES && 
		    numActiveObstacle >= 0 )
		{	
			Scanner obstacleObject = new Scanner(System.in); //using Scanner Object as placeholder until real classes are imported.
			numActiveObstacle++;
			addToActiveObstacleList(obstacleObject);
		}
		
		else // this is for testing method. Will remove later.
		{
			System.out.println("Cannot instantiate object. The number of active objects");
			System.out.println("exceeds the max object limit or the number of objects is a");
			System.out.println("negative number.");
			System.out.println("Current Number of Objects: " +  numActiveObstacle);
		}
		
	}
	
	public static void main(String[]args)
	{
		AnimationApplication gameEngine = new AnimationApplication();
		gameEngine.instantiateObstacle();
		gameEngine.instantiatePlayer();
		gameEngine.printActiveObjectList("obstacle");
		gameEngine.printActiveObjectList("player");
		gameEngine.printActiveObjectList("collectible");
		System.out.println("Please ENTER an integer: ");
		int aNum = gameEngine.activeObstacleList[0].nextInt(); // Testing to make sure we can use the methods in our indexed object.
		System.out.println("Your Number is: " + aNum);
		
	}
}

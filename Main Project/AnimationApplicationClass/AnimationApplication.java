import java.util.Scanner;

	// January 30th, 2018
	
	// By Mark Tremblay
	/* 
	Version 18 Notes: JAN 30
	
			1. Remove object method test in main method.
			2. import Player Class. Current working version
			   in my structure is PlayerWV2.java
			3. Changed any references activeObjList to activeObstacleList. It will only
			   deal with objects of Obstacle type, although for the time being I'm using 
			   Scanner as a placeholder.
			4. Changed all methods to reflect changes in program form, replacing obj
			   with obstacle.
			5. Updated comments to reflect changes
			6. Created test to test simple changes.
		
	*/

public class AnimationApplication
{
	
	private final int MAX_ACTIVE_OBSTACLES = 4; 
	private int numActiveObstacle = 0;
	
	Scanner[] activeObstacleList = new Scanner[MAX_ACTIVE_OBSTACLES]; // Will use Scanner for Array type until Obstacle class imported
	
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
	
	// This method is used for testing. It will print out the contents of the activeObstacleList
	public void printActiveObstacleList(Object[] myList)
	{
		System.out.print("activeObstacleList: [ "); 
		for(int index = 0; index < myList.length;) 
		{
			if(myList[index] != null)
			{	
				System.out.print(myList[index].getClass().getName() + " , ");
				index++;
			}
			
			else
			{
				System.out.print(myList[index] + " , ");
				index++;
			}
			
		}
		System.out.println("]");
		
	}
	
	//Removes obstacle at specified index from activeObstacleList by putting a null value in its place.
	public void deleteObstacle(int index) 
	{
		if (index < activeObstacleList.length && index >= 0)
		{
			activeObstacleList[index] = null;
			numActiveObstacle = numActiveObstacle - 1;
		}
		
	}
	
	// Creates a new Player object
	public void instantiatePlayer(AnimationApplication gameEngine)
	{
			Player playerObject = new Player();
	}
	
	
	// Creates new Obstacle object and adds it to the activeObstacleList.
	public void instantiateObstacle(AnimationApplication gameEngine)
	{
		if( numActiveObstacle < MAX_ACTIVE_OBSTACLES && 
		    numActiveObstacle >= 0 )
		{	
			Scanner obstacleObject = new Scanner(System.in); //using Scanner Object as placeholder until real classes are imported.
			numActiveObstacle++;
			gameEngine.addToActiveObstacleList(obstacleObject);
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
		gameEngine.instantiateObstacle(gameEngine);
		gameEngine.instantiateObstacle(gameEngine);
		gameEngine.instantiateObstacle(gameEngine);
		gameEngine.instantiateObstacle(gameEngine);
		gameEngine.instantiateObstacle(gameEngine);
		gameEngine.instantiatePlayer(gameEngine);
		gameEngine.printActiveObstacleList(gameEngine.activeObstacleList);
		System.out.println("Please ENTER an integer: ");
		int aNum = gameEngine.activeObstacleList[1].nextInt(); // Testing to make sure we can use the methods in our indexed object.
		System.out.println("Your Number is: " + aNum);
		
	}
}

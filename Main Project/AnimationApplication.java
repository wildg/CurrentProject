import java.util.Scanner;

	// Working Version 15
	// January 30th, 2018
	
	// By Mark Tremblay
	
	// Version 15
	/* In this version I've:
					
					1. Edited object instantiation and deletion test.
					2. Created a printActiveObjList class to aid in test.
	*/

public class AnimationApplication
{
	
	private final int MAX_ACTIVE_OBJECTS = 4; 
	private int numActiveObj = 0;
	
	Object[] activeObjList = new Object[MAX_ACTIVE_OBJECTS];
	// This list will be used to keep track of and reference active objects in the game.
	
	public void addToActiveObjList(Scanner myObject)
	{
		for(int index=0; index < activeObjList.length; index++)
		{
			if(activeObjList[index] == null)
			{
				activeObjList[index] = myObject;
				break;
			}
			
		}
	}
	
	// This method is used for testing. It will print out the contents of the activeObjList
	public void printActiveObjList(Object[] myList)
	{
		System.out.print("activeObjectList: [ "); // print out activeObjList to see if items were properly added when instantiated.
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
		System.out.println("");
		System.out.println("");
		
	}
	
	public void instantiatePlayer(AnimationApplication gameEngine)
	{
		if(numActiveObj < MAX_ACTIVE_OBJECTS && 
		   numActiveObj >=0)
		{
			//Player playerCharacter = new Player();
			//activeObjList[0] = playerCharacter;
			Scanner playerObject = new Scanner(System.in); //using Scanner Object as placeholder until real classes are imported.
			numActiveObj++;
			gameEngine.addToActiveObjList(playerObject);
		}
		
		else
		{
			System.out.println("Cannot instantiate player. The number of active objects");
			System.out.println("exceeds the max object limit or the number of objects is a");
			System.out.println("negative number.");
			System.out.println("Current Number of Objects: " +  numActiveObj);
			System.out.println("");
		}
	}
	
	public void instantiateObstacle(AnimationApplication gameEngine)
	{
		if( numActiveObj <= MAX_ACTIVE_OBJECTS && 
		    numActiveObj >= 0 )
		{
			//Obstacle obstacleCharacter = new Obstacle();
			//activeObjList[0] = obstacleCharacter;
			
			Scanner obstacleObject = new Scanner(System.in); //using Scanner Object as placeholder until real classes are imported.
			numActiveObj++;
			gameEngine.addToActiveObjList(obstacleObject);
		}
		
		else
		{
			System.out.println("Cannot instantiate object. The number of active objects");
			System.out.println("exceeds the max object limit or the number of objects is a");
			System.out.println("negative number.");
			System.out.println("Current Number of Objects: " +  numActiveObj);
		}
		
	}
	
	public void deleteObject(Object myObject)
	{
		myObject = null;
		numActiveObj = numActiveObj - 1;
	}
	
	public static void main(String[]args)
	{
		AnimationApplication gameEngine = new AnimationApplication();
		
		//OBJECT INSTANTIATION TEST
		System.out.println("");
		System.out.println("Max Number of Active Objects: " + gameEngine.MAX_ACTIVE_OBJECTS);
		System.out.println("");
		System.out.println("Number of instantiated objects at application start = " + gameEngine.numActiveObj);
		System.out.println("");
		gameEngine.printActiveObjList(gameEngine.activeObjList);
		System.out.println("");
		
		gameEngine.instantiatePlayer(gameEngine);
		System.out.println("After 1 player instantiated # active objects = " + gameEngine.numActiveObj);
		System.out.println("");
		
		gameEngine.instantiateObstacle(gameEngine);
		gameEngine.instantiateObstacle(gameEngine);
		gameEngine.instantiateObstacle(gameEngine);
		System.out.println("After 3 obstacles instantiated # active objects = " + gameEngine.numActiveObj);
		System.out.println("");
		
		gameEngine.printActiveObjList(gameEngine.activeObjList); // print list to see if objects properly instantiated.
		System.out.println("");
		
		System.out.println("Try instantiating one objects too many");
		System.out.println("");
		gameEngine.instantiatePlayer(gameEngine); //Test to make sure I don't accidentally instantiate another object above max.
		System.out.println("");
		
		System.out.println("Try deleting an object and show list afterwards.");
		System.out.println("");
		 // Delete the object stored in index.
		gameEngine.printActiveObjList(gameEngine.activeObjList); // print out activeObjList to see if item was properly deleted.
		System.out.println("");
		
		
	}
}

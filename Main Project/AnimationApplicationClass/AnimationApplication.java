import java.util.Scanner;

	// January 30th, 2018
	
	// By Mark Tremblay
	
	// Version 17
	/* 
	Version 17 Notes: JAN 30th

			1. Fixed <=MAX_ACTIVE_OBJECTS to < MAX_ACTIVE_OBJECTS in if statement for instantiateObstacle method.
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
		
	}
	
	//Removes object at specified index from activeObjList by putting a null value in its place.
	public void deleteActiveObject(int index) 
	{
		if (index < activeObjList.length && index >= 0)
		{
			activeObjList[index] = null;
			numActiveObj = numActiveObj - 1;
		}
		
	}
	
	// Creates a new Player object and adds it to the activeObjList.
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
			System.out.println("negative number. The current number of objects is " + numActiveObj + ".");
			System.out.println("");
		}
	}
	
	
	// Creates new Obstacle object and adds it to the activeObjList.
	public void instantiateObstacle(AnimationApplication gameEngine)
	{
		if( numActiveObj < MAX_ACTIVE_OBJECTS && 
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
		
		System.out.println("Try instantiating one objects too many:");
		System.out.println("");
		gameEngine.instantiatePlayer(gameEngine); //Test to make sure I don't accidentally instantiate another object above max.
		System.out.println("");
		
		System.out.println("Try deleting objects at indexes 0 and 3 and show list afterwards.");
		System.out.println("");
		gameEngine.deleteActiveObject(3);        				// Delete objects at index 2 and 3 of activeObjList.
		gameEngine.deleteActiveObject(0);
		gameEngine.printActiveObjList(gameEngine.activeObjList); // print out activeObjList to see if item was properly deleted.
		System.out.println("");
		System.out.println(" Number of active objects = " + gameEngine.numActiveObj);
		System.out.println("");
		
		System.out.println("Add one more object for fun");
		System.out.println("");
		gameEngine.instantiateObstacle(gameEngine);
		System.out.println("");
		gameEngine.printActiveObjList(gameEngine.activeObjList);
		System.out.println("");
		System.out.println(" Number of active objects = " + gameEngine.numActiveObj);
		
		
		
		
		
		
	}
}

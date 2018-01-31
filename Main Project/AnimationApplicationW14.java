import java.util.Scanner;

	// Working Version 14
	// January 30th, 2018
	
	// By Mark Tremblay
	
	/* Version 14 Notes: 
						 In this version I've: 
						 1. Built methods to instantiate player and obstacle objects. I've built
							conditions in these methods to control the max number of objects allowed
							in the game at a time using a constant called MAX_ACTIVE_OBJECTS.
							
						 2. Created an instance variable of type Object Array called activeObjList, 
							which will be useful to keep track of objects that have been instantiated 
							during the application run. Instantiated objects are automatically
							added to this list, and indexes for these objects are chosen by iterating
							through the indexes and appending to the first that contains null.
							
						 3. Created a test in the main method to try out these new methods.
	*/

public class AnimationApplication
{
//__________________________________________________________________________________________
	
	private final int MAX_ACTIVE_OBJECTS = 4; 
	private int numActiveObj = 0;
	
	Object[] activeObjList = new Object[MAX_ACTIVE_OBJECTS];
	// This list will be used to keep track of and reference active objects in the game.

	private boolean playerAlive = false;

//__________________________________________________________________________________________
	
	public void addToActiveObjList(Scanner aScannerDarkly)
	{
		for(int index=0; index < activeObjList.length; index++)
		{
			if(activeObjList[index] == null)
			{
				activeObjList[index] = aScannerDarkly;
				break;
			}
			
		}
	}
	
	public void instantiatePlayer(AnimationApplication gameEngine)
	{
		if(numActiveObj < MAX_ACTIVE_OBJECTS && 
		   numActiveObj >=0)
		{
			//Player playerCharacter = new Player();
			//activeObjList[0] = playerCharacter;
			Scanner hat = new Scanner(System.in); //using Scanner Object as placeholder until real classes are imported.
			numActiveObj++;
			gameEngine.addToActiveObjList(hat);
		}
		
		else
		{
			System.out.println("Cannot instantiate player. The number of active objects");
			System.out.println("exceeds the max object limit or the number of objects is a");
			System.out.println("negative number.");
			System.out.println("Current Number of Objects: " +  numActiveObj);
		}
	}
	
	public void instantiateObstacle(AnimationApplication gameEngine)
	{
		if( numActiveObj <= MAX_ACTIVE_OBJECTS && 
		    numActiveObj >= 0 )
		{
			//Obstacle obstacleCharacter = new Obstacle();
			//activeObjList[0] = obstacleCharacter;
			
			Scanner keyboard = new Scanner(System.in); //using Scanner Object as placeholder until real classes are imported.
			numActiveObj++;
			gameEngine.addToActiveObjList(keyboard);
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
		//OBJECT INSTANTIATION TEST
		AnimationApplication gameEngine = new AnimationApplication();
		System.out.println("Number of instantiated objects at application start = " + gameEngine.numActiveObj);
		
		gameEngine.instantiatePlayer(gameEngine);
		System.out.println("After player instantiated # active objects = " + gameEngine.numActiveObj);
		
		gameEngine.instantiateObstacle(gameEngine);
		gameEngine.instantiateObstacle(gameEngine);
		gameEngine.instantiateObstacle(gameEngine);
		System.out.println("After objects instantiated # active objects = " + gameEngine.numActiveObj);
		
		System.out.print("activeObjectList: [ "); // print out activeObjList to see if items were properly added when instantiated.
		for(int index = 0; index < gameEngine.activeObjList.length;) 
		{
			if(gameEngine.activeObjList[index] != null)
			{	
				System.out.print(gameEngine.activeObjList[index].getClass().getName() + " , ");
				index++;
			}
			
			else
			{
				System.out.print(gameEngine.activeObjList[index] + " , ");
				index++;
			}
		}
		System.out.println("]");
		
		gameEngine.instantiatePlayer(gameEngine); //Test to make sure I don't accidentally instantiate another object above max.
	}
}
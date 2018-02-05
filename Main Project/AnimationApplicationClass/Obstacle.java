public class Obstacle {
	private static int length = 1;
			
	private static int yValue = 1;	//Here, the values of length and height of the
	private static int xValue = 10;
	
	private void moveObstaclePosition()
	{
		xValue -= 1;
	}
	
	private int getObstaclePosition()
	{
		return xValue;
	}
	
	private boolean hitObstacle( int xPos, int yPos )
	{
		if ( (xValue == xPos) && (yValue == yPos ) )
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
}

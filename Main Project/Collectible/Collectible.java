import java.util.Random;

public class Collectible {
    private String weed;
    private int healthBoost;
    private int[] rectangle;
    Random rand = new Random();
    private double n = rand.nextInt(maxHeight) + 1;

    public boolean overlapsWith(avatar: Avatar){
        if (Avatar.x == this.x && Avatar.y == this.y)
            return true;
        else
            return false;
    }

    public void moveCollectible(){

    }
}

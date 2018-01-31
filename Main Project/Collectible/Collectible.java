import java.util.Random;

public class Collectible {
    private String weed;
    private int healthBoost;
    private int[] rectangle;
    Random rand = new Random();
    private double n = rand.nextInt(maxHeight) + 1;

    public boolean overlapsWith(Avatar avatar){
        if (avatar.x == this.x && avatar.y == this.y)
            return true;
        else
            return false;
    }

    public void moveCollectible(){

    }
}

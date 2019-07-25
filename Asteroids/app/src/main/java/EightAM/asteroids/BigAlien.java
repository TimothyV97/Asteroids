package EightAM.asteroids;

import static EightAM.asteroids.Constants.ALIEN_BIG_MAXSPEED;

import android.content.Context;

import java.util.Random;

public class BigAlien extends Alien {


    /**
     * Spawns a new alien on the screen at a random y position on either
     * the left or the right of the screen
     *
     * @param xTotalPix total x dimensions of the screen
     * @param yTotalPix total y dimensions of the screen
     * @param context   context of the game (passed from game model)
     */
    protected BigAlien(int xTotalPix, int yTotalPix, Context context) {
        // prepare bitmap
        if (bitmap == null) bitmap = ImageUtils.getVectorBitmap(context, R.drawable.ic_alien);

        spawn(xTotalPix, yTotalPix);

        // TODO: change behavior
        this.setMoveBehavior();

        // might use later
        this.setTimer();
        this.setShotDelay();
    }


    /**
     * Sets move behavior for this alien. Used in its constructor.
     */
    private void setMoveBehavior() {
        float speed, direction;

        Random rand = new Random();
        // TODO: change these #s later

        speed = ALIEN_BIG_MAXSPEED;
        direction = 1 + (rand.nextFloat() * 360);
        this.vel = new Velocity(speed, direction);
    }

    /**
     * Set random max and min timer for Alien to change directions.
     * max and min are in frames.
     */
    protected void setTimer() {
        Random rand = new Random();
        //int randomNum = rand.nextInt((max - min) + 1) + min;
        this.delay = rand.nextInt((6000 - 4000) + 1) + 4000;

    }

    /**
     * Sets a shot delay for Alien as to not shoot continuously.
     */
    protected void setShotDelay() {
        Random rand = new Random();
        this.shotDelay = rand.nextInt((5000 - 3000) + 1) + 3000;
    }
}

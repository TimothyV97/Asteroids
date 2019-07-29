package EightAM.asteroids.specs;

import android.graphics.Point;
import android.util.Pair;

import EightAM.asteroids.R;

public class BigAlienSpec extends BaseAlienSpec {
    public static String tag = "big_alien";
    public static String bitMapName = "big_alien";
    public static int resID = R.drawable.ic_alien;
    public static Point dimensions = new Point(30, 30);
    public static float dbmRatio = 5f;
    public static String paintName = "alien";
    public static int pointValue = 10;
    public static int hitPoints = 1;
    public static float reloadTime = 30;
    public static float maxSpeed = 0.1f;
    public static float initialAngle = (float)Math.PI * 0.25f;

    public Pair<Integer, Integer> turnDelayRange = new Pair<>(4000, 6000);
    public Pair<Integer, Integer> shotDelayRange = new Pair<>(3000, 5000);

    public BigAlienSpec() {
        super(tag, bitMapName, resID, dimensions, dbmRatio, paintName);
        setHitPoints(hitPoints);
        setMaxSpeed(maxSpeed);
        setPointValue(pointValue);
        setReloadTime(reloadTime);
        setInitialAngle(initialAngle);
    }

}

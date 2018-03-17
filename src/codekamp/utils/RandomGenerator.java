package codekamp.utils;

import java.util.Random;

/**
 * Created by cerebro on 27/06/17.
 */
public class RandomGenerator {
    private static Random r = new Random();

    public static int randomInt(int limit) {
        return r.nextInt(limit);
    }

    public static int randomInt(int lowerLimit, int upperLimit) {
        int randomInt = r.nextInt(upperLimit - lowerLimit);

        return randomInt + lowerLimit;
    }
}

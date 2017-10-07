package org.firstinspires.ftc.teamcode;

/**
 * Created by Codewolf on 10/5/2017.
 */

public class GenFuncs {
    public static double constrain(double val, double max, double min) {
        if (val > max) {
            val = max;
        } else if (val < min) {
            val = min;
        }
        return val;
    }
}

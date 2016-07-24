package com.zappers.gola.Models;

/**
 * Created by akriti on 19/7/16.
 */
public class Calculations {
    public static int classes,present,absent;
    public static double percent;

    public static int getAbsent() {
        return absent;
    }

    public static void setAbsent(int absent) {
        Calculations.absent  = Calculations.absent + absent;
    }

    public static int getClasses() {
        return classes;
    }

    public static void setClasses(int classes) {
        Calculations.classes = Calculations.classes + classes;
    }

    public static double getPercent() {
        return percent;
    }

    public static void setPercent(double percent) {
        Calculations.percent = percent;
    }

    public static int getPresent() {
        return present;
    }

    public static void setPresent(int present) {
        Calculations.present = present;
    }
}

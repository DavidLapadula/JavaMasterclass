package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DecimalComparator {

    public static boolean areEqualByThreeDecimalPlaces(double num1, double num2) {
        // move the decimal over three places by multiplying by 1000 to check if numbers are equal the same to three decimal places
        return (int)  (num1 * 1000) == (int) (num2 * 1000);
    }
}

package com.company;

public class FlourPack {

    public static boolean canPack(int bigCount, int smallCount, int goal) {
            int bigBagVal = 5;
            int smallBagVal = 1;
            int sum = 0;
            int totalValue = (bigCount * bigBagVal) + (smallCount * smallBagVal);

            if (bigCount < 0 || smallCount < 0 || totalValue < goal) return false;
            if (totalValue == goal) return true;

            while (bigCount > 0 ) {
                if (sum + bigBagVal > goal)
                    break;
                sum += bigBagVal;
                bigCount--;
                if (sum == goal)
                    return true;
            }

            while (smallCount > 0) {
                if (sum + smallBagVal > goal)
                    break;
                sum += smallBagVal;
                smallCount--;
                if (sum == goal)
                    return true;
            }

            return false;
    };
}

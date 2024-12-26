package arrays.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
https://leetcode.com/problems/gas-station/description/
 */
public class GasStationsRoute {

    public int checkIfExists(int[] gas, int[] cost) {
        int deltaSum = 0;
        int startIndex = 0;
        int totalGain = 0;
        for (int i = 0; i < gas.length; i++) {
            var delta = gas[i] - cost[i];
            deltaSum = deltaSum + delta;
            if (totalGain + delta < 0) {
                startIndex = i + 1;
                totalGain = 0;
            } else {
                totalGain = totalGain + delta;
            }
        }

        return deltaSum >= 0 ? startIndex : -1;
    }

    @Test
    public void routeExists_1() {
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};
        var gasStationsRoute = new GasStationsRoute();
        assertEquals(3, gasStationsRoute.checkIfExists(gas, cost));
    }

    @Test
    public void routeExists_2() {
        int[] gas = new int[]{5, 8, 2, 8};
        int[] cost = new int[]{6, 5, 6, 6};
        var gasStationsRoute = new GasStationsRoute();
        assertEquals(3, gasStationsRoute.checkIfExists(gas, cost));

    }

    @Test
    public void routeExists_3() {
        int[] gas = new int[]{1,2,3,4,5,5,70};
        int[] cost = new int[]{2,3,4,3,9,6,2};
        var gasStationsRoute = new GasStationsRoute();
        assertEquals(6, gasStationsRoute.checkIfExists(gas, cost));

    }

    @Test
    public void noRoute() {
        int[] gas = new int[]{2, 3, 4};
        int[] cost = new int[]{3, 4, 3};
        var gasStationsRoute = new GasStationsRoute();
        assertEquals(-1, gasStationsRoute.checkIfExists(gas, cost));
    }

}


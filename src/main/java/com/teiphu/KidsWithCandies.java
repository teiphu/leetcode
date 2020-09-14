package com.teiphu;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

/**
 * 1431. 拥有最多糖果的孩子
 *
 * @author Zheng Lifu
 */
public class KidsWithCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        OptionalInt max = Arrays.stream(candies).max();
        int m = max.getAsInt();
        List<Boolean> res =
                Arrays.stream(candies).mapToObj(c -> c + extraCandies >= m).collect(Collectors.toList());
        return res;
    }
}

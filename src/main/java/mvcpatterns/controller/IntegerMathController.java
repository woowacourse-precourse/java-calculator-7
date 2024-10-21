package mvcpatterns.controller;

import java.math.BigInteger;
import java.util.Arrays;
import mvcpatterns.model.MathModel;

public class IntegerMathController {


    final private MathModel mathModel = new MathModel();

    public String sumPositiveInteger(String... numbers) {

        if (numbers.length == 0) {
            System.out.println("[PositiveSum] input is empty. input : " + Arrays.toString(numbers));
            throw new IllegalArgumentException("Input is emtpy.");
        }

        BigInteger[] numList = transformToBiginteger(numbers);

        for (BigInteger n : numList) {

            if (!isPositive(n)) {
                System.out.println("[PositiveSum] please check input. input : " + Arrays.toString(numbers));
                System.out.println("[PositiveSum] input is not positive. integer : " + n.toString());
                throw new IllegalArgumentException("Input is not positive.");
            }
        }

        return mathModel.sum(numList).toString();

    }

    private boolean isPositive(BigInteger number) {

        int state = number.signum();

        return state == 1;

    }
    
    private BigInteger[] transformToBiginteger(String... numbers) {
        BigInteger[] ret = new BigInteger[numbers.length];

        int i = 0;

        for (String n : numbers) {

            try {
                ret[i] = new BigInteger(n);
            } catch (Exception e) {
                System.out.println(
                        "[transformToBiginteger] numbers including string not able to be transformed to integer. num : "
                                + n);
                System.out.println("[transformToBiginteger] please check input : " + Arrays.toString(numbers));
                throw new IllegalArgumentException("number can't be transformed to integer.");
            }
            ++i;
        }

        return ret;
    }
}



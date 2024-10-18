package calculator.calculator;

import java.util.ArrayList;

public class Calculator {


    public static int allSum(ArrayList<Integer> savedNumberRepository) {

        int sum = 0;
        for (int i = 0; i < savedNumberRepository.size(); i++) {
            sum += savedNumberRepository.get(i);
        }

        return sum;

    }
}
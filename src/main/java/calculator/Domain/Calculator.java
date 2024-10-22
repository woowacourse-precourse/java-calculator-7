package calculator.Domain;

import java.util.ArrayList;

public class Calculator {
    public static int addNumbers(ArrayList<Integer> numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }
}

package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;
import java.util.ArrayList;


public class Calculator {
    public Calculator(ArrayList<Integer> intList) {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String userInput = readLine();
        IntegerPrinter integerPrinter = new IntegerPrinter(userInput);
        int integerSum = getSum(integerPrinter.print());
        System.out.println(integerSum);
    }

    private static int getSum(ArrayList<Integer> intList) {
        int sum = 0;
        for (Integer i : intList) {
            sum += i;
        }
        return sum;
    }
}

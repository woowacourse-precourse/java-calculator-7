package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();
        String[] splitedNumber;
        //  //;\n1;2;3

        if (input.startsWith("//") && input.startsWith("\\n", 3)) {
            char sperator = input.charAt(2);
            String sparatorString = String.valueOf(sperator);
            splitedNumber = input.substring(5).split(sparatorString);
            checkNegative(splitedNumber);
        } else {
            splitedNumber = input.split("[:,]");
            checkNegative(splitedNumber);
        }
        System.out.println("결과 : " + getSum(splitedNumber));
    }

    private static void checkNegative(String[] splitedNumber) {
        Boolean hasNegative = Arrays.stream(splitedNumber).anyMatch(n -> Integer.valueOf(n) < 0);
        if (hasNegative) {
            throw new IllegalArgumentException();
        }
    }


    static int getSum(String[] array) {
        int sum = 0;
        for (String number : array) {
            int num = Integer.parseInt(number);
            sum += num;
        }
        return sum;
    }

}

package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력 값이 비어 있습니다.");
        }
        String[] splitedNumber;
        //  //;\n1;2;3

        if (input.startsWith("//") && input.startsWith("\\n", 3)) {
            char sperator = input.charAt(2);
            String sparatorString = String.valueOf(sperator);
            splitedNumber = input.substring(5).split(sparatorString);
            checkNegative(splitedNumber);
        }else {
            splitedNumber = input.split("[:,]");
            checkNegative(splitedNumber);
        }
        System.out.println("결과 : " + getSum(splitedNumber));
    }

    private static void checkNegative(String[] splitedNumber) {
        try {
            boolean hasNegative = Arrays.stream(splitedNumber).anyMatch(n -> Integer.parseInt(n) < 0);
            if (hasNegative) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자가 아닙니다.");
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

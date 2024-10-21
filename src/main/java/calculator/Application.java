package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력 값이 비어 있습니다.");
        }
        String[] splitedNumber;
        //  //;\n1;2;3

        if (input.startsWith("//")) {
            String[] section = input.split("\n", 2);
            if (section.length < 2) {
                throw new IllegalArgumentException("잘못된 포맷입니다.");
            }
            String delimiter = section[0].substring(2);
            if (delimiter.isEmpty()) {
                throw new IllegalArgumentException("커스텀 구분자가 없습니다.");
            }
            splitedNumber = section[1].split(delimiter);
            checkNegative(splitedNumber);
        } else {
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

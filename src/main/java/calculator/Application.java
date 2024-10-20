package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try {
            String userInput = Console.readLine();
            System.out.println("결과 : " + calculate(userInput));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    private static int calculate(String input) {
        if (input.startsWith("//")) {
            int end = input.indexOf("\n");
            if (end == -1) {
                throw new IllegalArgumentException("구분자 형식이아님.");
            }
            //"//"의 문자열 기후 부터 end 의 범위까지
            String customDelimiter = input.substring(2, end);
            return splitAndSum(input.substring(end + 1), customDelimiter);
        } else {
            return splitAndSum(input, ",|:");
        }
    }

    private static int splitAndSum(String numbers, String delimiter) {
        if (numbers.isEmpty())
            return 0;
        String[] tokens = numbers.split(delimiter);
        int sum = 0;
        for (String token : tokens) {
            sum += parse(token);
        }
        return sum;
    }

    private static int parse(String number) {
        int num = Integer.parseInt(number);
        if (num < 0) {
            throw new IllegalArgumentException("음수는 허용안함.");
        }
        return num;
    }
}
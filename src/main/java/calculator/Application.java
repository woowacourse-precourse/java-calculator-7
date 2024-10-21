package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();  

        try {
            int result = add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다.");
        }
    }

    public static int add(String text) {
        if (text == null || text.isEmpty()) {
            return 0; 
        }

        String delimiter = ",|:";

        if (text.startsWith("//")) {
            int delimiterIndex = text.indexOf("\n");
            delimiter = text.substring(2, delimiterIndex); 
            text = text.substring(delimiterIndex + 1); 
        }

        String[] numbers = text.split(delimiter);
        return sum(numbers);
    }

    private static int sum(String[] numbers) {
        int total = 0;
        for (String number : numbers) {
            int num = toPositive(number);
            total += num;
        }
        return total;
    }

    private static int toPositive(String number) {
        int result = Integer.parseInt(number);
        if (result < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
        }
        return result;
    }
}

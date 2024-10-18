package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        
        String delimiter = ",|:";
        String numbers = input;

        if (input.startsWith("//")) {

            if (input.contains("\\n")) {
                input = input.replace("\\n", "\n");
            }

            if (input.length() < 4 || input.charAt(3) != '\n') {

                throw new IllegalArgumentException("잘못된 형식의 입력입니다.");
            }

            delimiter = String.valueOf(input.charAt(2));
            numbers = input.substring(4);
        }

        String[] tokens = numbers.split(delimiter);
        int sum = 0;
        for (String token : tokens) {
            int num = parseInt(token);
            if (num < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + num);
            }
            sum += num;
        }
        return sum;
    }

    private static int parseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 형식입니다: " + str);
        }
    }

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요:");
        String input = Console.readLine();
        try {
            int result = add(input);
            System.out.println("결과: " + result);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } finally {
            Console.close();
        }
    }
}




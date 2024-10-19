package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = "[,:]";
        String numbers = input;

        if (input.startsWith("//")) {

            if (input.contains("\\n")) {
                input = input.replace("\\n", "\n");
            }

            if (input.length() < 4 || input.charAt(3) != '\n') {
                throw new IllegalArgumentException("커스텀 구분자 문법이 잘못 입력되었습니다.");
            }

            delimiter = String.valueOf(input.charAt(2));
            numbers = input.substring(4);


        }

        String[] tokens = numbers.split(delimiter);
        int sum = 0;
        for (String token : tokens) {
            int num = parseInt(token);
            sum += num;
        }
        return sum;
    }

    private static int parseInt(String str) {
        try {
            int num = Integer.parseInt(str);
            if (num < 0) {
                throw new IllegalArgumentException("음수는 사용할 수 없습니다");
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 형식입니다 : " + str);
        }
    }


    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요:");
        String input = Console.readLine();
        try {
            int result = add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("오류가 발생했습니다." + '\n' + e.getMessage());
        } finally {
            Console.close();
        }
    }
}




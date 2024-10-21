package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static int calculator_7(String str) {
        if (str.trim().isEmpty()) return 0;

        if (str.substring(0, 2).equals("//")) {
            if (str.charAt(3) == '\\' && str.charAt(4) =='n'){
                String customDelimiter = str.substring(2, 3);
                str = str.substring(5).replace(customDelimiter, ",");
            }
            else {
                return 0; // 예외처리 할 상황
            }
            if (str.trim().isEmpty()) return 0;
        }

        String[] numbers = str.split("[,:]");
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number.trim());
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int result = calculator_7(input);
        System.out.println("결과 : " + result);
    }
}
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
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
            if (str.trim().isEmpty()) return 0;
        }

        String[] numbers = str.split("[,:]");
        int sum = 0;
        for (String number : numbers) {
            int num = Integer.parseInt(number.trim());
            if (num < 0) throw new IllegalArgumentException("잘못된 입력입니다.");
            sum += num;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        try {
            int result = calculator_7(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e){
            System.out.println("오류: " + e.getMessage());
        }
    }
}
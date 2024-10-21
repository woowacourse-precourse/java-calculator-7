package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String divider = ".:";

        String input = Console.readLine();

        if (input.contains("//") && input.contains("\\n")){     // 커스텀 구분자 추가
            int endIdx = input.indexOf("\\n");
            String customDivider = input.substring(2, endIdx);
            divider += customDivider;

            input = input.substring(endIdx+2);
        }

        if (input.matches(".*[^0-9"+divider+"].*"))
            throw new IllegalArgumentException();


        int result = 0;
        String[] numbers = input.split("["+divider+"]");

        for (String number : numbers){
            if (!number.isEmpty())
                result += Integer.valueOf(number);
        }

        System.out.println("결과 : " + result);
    }
}

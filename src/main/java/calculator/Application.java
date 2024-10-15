package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static int parseNumber(String number) {
        if (number.isEmpty()){
            return 0;
        }
        return Integer.parseInt(number);
    }

    public static int getResult(String input) {
        String delimiter = "[,:]";
        int result=0;

        if (input.startsWith("//")) {
            int customDelimiterEndIndex = input.indexOf("\\n");
            delimiter = input.substring(2, customDelimiterEndIndex);
            input = input.substring(customDelimiterEndIndex + 2);
        }

        String[] numbers = input.split(delimiter);

        for (String number : numbers) {
            result += parseNumber(number);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        System.out.println("결과 : " + getResult(input));
    }
}

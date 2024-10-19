package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static int stringCalc(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        String[] numbers = str.split("[,:]");

        int result = 0;
        for (String number : numbers) {
            result += Integer.parseInt(number);
        }
        return result;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열 : ");
        String str = Console.readLine();

        int answer = stringCalc(str);
        System.out.println("결과 : " + answer);
    }
}

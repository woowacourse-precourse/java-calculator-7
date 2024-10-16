package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String strToAdd = Console.readLine();

        if (!isValid(strToAdd)) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }

        String[] numbers = strToAdd.split("[,:]");

        int sum = 0;
        if (numbers.length > 1) {
            for (String number : numbers) {
                sum += Integer.parseInt(number);
            }
        }

        System.out.println("결과 : " + sum);
    }

    public static boolean isValid(String input) {
        if (input.isEmpty()) {
            return true;
        }

        String regex = "^[1-9][0-9]*([,|:][1-9][0-9]*)*$";

        return Pattern.matches(regex, input);
    }
}

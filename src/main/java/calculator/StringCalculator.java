package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class StringCalculator {
    public String input() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public void printResult(int result) {
        System.out.println("결과 : " + result);
    }

    public boolean isNullOrEmpty(String userInput) {
        return userInput == null || userInput.isEmpty();
    }

    public boolean isInvalid(String userInput, String separator) {
        String regString = separator.replace("|", "");
        Pattern pattern = Pattern.compile("[^0-9" + regString + "]");

        return pattern.matcher(userInput).find();
    }
}
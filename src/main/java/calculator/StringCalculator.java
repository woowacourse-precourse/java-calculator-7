package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StringCalculator {
    private final List<String> delimiters = new ArrayList<>(List.of(":","."));
    private final String defaultRegex = "[:.]";
    private String regex;
    private final String isNumberRegex = "^[^0]\\d*";

    public void run() {
        System.out.printf("덧셈할 문자열을 입력해 주세요. ");
        String input = Console.readLine();
        UserInput userInput = new UserInput(input);
        setThirdDelimiterAndCalculate(userInput);
    }

    private void setThirdDelimiterAndCalculate(UserInput userInput) {
        if(userInput.isCustomDelimiterPresent()) {
            String customDelimiter = userInput.getCustomDelimiter();
            regex = "[:."+customDelimiter+"]";
            calculate(userInput.getNumberString(),regex);
        }
        else {
            calculate(userInput.getNumberString(),defaultRegex);
        }
    }

    private void calculate(String numberString,String regex) {
        int sum = 0;
        String[] split = numberString.split(regex);
        validateNumberString(split);
        try {
            for(String num : split) {
                sum += Integer.parseInt(num);
            }
        }catch (NumberFormatException e) {
            throw new NumberFormatException("숫자 형식이 아닌 문자열입니다.");
        }
        printResult(sum);
    }

    private void printResult(int sum) {
        System.out.printf("결과 : %d",sum);
    }

    private void validateNumberString(String[] split) {
        Optional<String> any = Arrays.stream(split).filter(num -> !num.matches(isNumberRegex)).findAny();
        if (any.isPresent() || split.length==0) {
            throw new IllegalArgumentException("숫자 섹션에 구분자외 문자하거나 0이 존재합니다.");
        }
    }


}

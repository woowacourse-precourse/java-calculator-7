package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.Optional;

public class StringCalculator {
    private final String defaultRegex = "[:.]";
    private String customRegex;
    private final String isPositiveNumberRegex = "^[^0]\\d*";

    public void run() {
        System.out.print("덧셈할 문자열을 입력해 주세요. ");
        String input = Console.readLine();
        UserInput userInput = new UserInput(input);
        setThirdDelimiterAndCalculate(userInput);
    }
    private void setThirdDelimiterAndCalculate(UserInput userInput) {
        if(userInput.isCustomDelimiterPresent()) {
            String customDelimiter = userInput.getCustomDelimiter();
            customRegex = "[:."+customDelimiter+"]";
            calculate(userInput.getNumberString(), customRegex);
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
            throw new IllegalArgumentException("숫자 형식이 아닌 문자열입니다.");
        }
        printResult(sum);
    }

    private void printResult(int sum) {
        System.out.printf("결과 : %d",sum);
    }

    private void validateNumberString(String[] split) {
        Optional<String> any = Arrays.stream(split).filter(num -> !num.matches(isPositiveNumberRegex)).findAny();
        if (any.isPresent() || split.length==0) {
            throw new IllegalArgumentException("숫자 섹션에 구분자외 문자나 0으로 시작하는 숫자가 존재합니다.");
        }
    }


}

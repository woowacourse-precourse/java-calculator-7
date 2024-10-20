package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.Optional;

public class StringCalculator {
    private final String defaultRegex = "[:,]";
    private String customRegex;
    private final String isPositiveNumberRegex = "^[^0-]\\d*";

    public void run() {
        System.out.print("덧셈할 문자열을 입력해 주세요. ");
        String input = Console.readLine();
        if(UserInput.isEmptyString(input)) {
            printResult(0);
        }else {
            setThirdDelimiterAndCalculate(new UserInput(input));
        }
    }
    private void setThirdDelimiterAndCalculate(UserInput userInput) {
        if(userInput.isCustomDelimiterPresent()) {
            String customDelimiter = userInput.getCustomDelimiter();
            customRegex = "[:,"+customDelimiter+"]";
            calculate(userInput.getNumberString(), customRegex);
        }
        else {
            calculate(userInput.getNumberString(),defaultRegex);
        }
    }
    private void calculate(String numberString,String regex) {
        long sum = 0;
        String[] split = numberString.split(regex);
        validateNumberString(split);
        try {
            for(String num : split) {
                sum += Integer.parseInt(num);
                if(sum <0) {
                    throw new IllegalArgumentException("오버플로우 발생");
                }
            }
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 형식이 아닌 문자열입니다.");
        }
        printResult(sum);
    }

    private void printResult(long sum) {
        System.out.printf("결과 : %d",sum);
    }

    private void validateNumberString(String[] split) {
        Optional<String> any = Arrays.stream(split).filter(num -> !num.matches(isPositiveNumberRegex)).findAny();
        if (any.isPresent() || split.length==0) {
            throw new IllegalArgumentException("구분자외 문자나 0으로 시작하는 숫자가 존재합니다. 혹은 숫자 섹션 자체가 존재하지 않습니다.");
        }
    }
}

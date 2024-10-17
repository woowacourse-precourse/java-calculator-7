package calculator.service;

import calculator.model.Calculator;
import calculator.model.PositiveNumbers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//계산기의 전반적인 기능을 담당하는 클래스
public class CalculateService {

    private List<String> delimeters = new ArrayList<>(Arrays.asList(",", ":"));

    private static final String customDelimeterPrefix = "//";
    private static final String customDelimeterPostfix = "\\n";

    //임시 메서드
    public Long calculate(final String userInput) {

        addDelimeter(userInput);
        PositiveNumbers positiveNumbers = getPositiveNumbersByDelimeter(userInput);
        Calculator calculator = new Calculator();

        return calculator.addCalculate(positiveNumbers);

    }

    //custom Delimeter 존재시 delimeter 에 넣기
    private void addDelimeter(final String userInput) {

        int firstIndexOfPrefix = userInput.indexOf(customDelimeterPrefix);
        int firstIndexOfPostfix = userInput.indexOf(customDelimeterPostfix);
        checkDelimterForm(firstIndexOfPrefix, firstIndexOfPostfix);

        if (hasCustomDelimeter(userInput)) {
            delimeters.add(userInput.substring(firstIndexOfPrefix + 2, firstIndexOfPostfix));
        }


    }

    //올바른 Deliter 형식인지 판단할 것!
    private void checkDelimterForm(int firstIndexOfPrefix, int firstIndexOfPostfix) {

    }

    //customDelimber 존재 여부 확인
    private boolean hasCustomDelimeter(final String userInput) {

        int firstIndexOfPrefix = userInput.indexOf(customDelimeterPrefix);
        int firstIndexOfPostfix = userInput.indexOf(customDelimeterPostfix);

        if (firstIndexOfPrefix == -1 && firstIndexOfPostfix == -1) {
            return false;
        }

        return true;
    }

    //input 으로 부터 Delimeter 로 PositiveNumbers 추출 및 반환
    private PositiveNumbers getPositiveNumbersByDelimeter(final String userInput) {

        String numberAndDelimeters = hasCustomDelimeter(userInput) ?
                userInput.substring(userInput.indexOf(customDelimeterPostfix) + 2)
                : userInput.substring(0);

        String regexString = "";
        for (String regex : delimeters) {
            regexString += regex;
        }

        String[] numbers = numberAndDelimeters.split("[" + regexString + "]");

        PositiveNumbers positiveNumbers = new PositiveNumbers();
        Arrays.stream(numbers).forEach(number -> positiveNumbers.addNumber(Integer.valueOf(number)));

        return positiveNumbers;
    }


}

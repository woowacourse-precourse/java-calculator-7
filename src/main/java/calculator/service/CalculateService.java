package calculator.service;

import calculator.model.Calculator;
import calculator.model.Delimeters;
import calculator.model.PositiveNumbers;
import java.util.List;

//계산기의 전반적인 기능을 담당하는 클래스
public class CalculateService {

    private static final String customDelimeterPrefix = "//";
    private static final String customDelimeterPostfix = "\\n";

    //임시 메서드
    public long calculate(final String userInput) {

        Delimeters delimeters = new Delimeters();
        addDelimeter(userInput, delimeters);

        PositiveNumbers positiveNumbers = getPositiveNumbersByDelimeter(userInput, delimeters);

        Calculator calculator = new Calculator();

        return calculator.addCalculate(positiveNumbers);

    }

    //custom Delimeter 존재시 delimeter 에 넣기
    private void addDelimeter(final String userInput, final Delimeters delimeters) {

        int firstIndexOfPrefix = userInput.indexOf(customDelimeterPrefix);
        int firstIndexOfPostfix = userInput.indexOf(customDelimeterPostfix);
        checkDelimterForm(firstIndexOfPrefix, firstIndexOfPostfix);

        if (hasCustomDelimeterForm(userInput)) {
            delimeters.addDelimeter(userInput.substring(firstIndexOfPrefix + 2, firstIndexOfPostfix));
        }


    }

    //올바른 Deliter 형식인지 판단할 것!
    private void checkDelimterForm(int firstIndexOfPrefix, int firstIndexOfPostfix) {

    }

    //customDelimber 존재 여부 확인
    private boolean hasCustomDelimeterForm(final String userInput) {

        int firstIndexOfPrefix = userInput.indexOf(customDelimeterPrefix);
        int firstIndexOfPostfix = userInput.indexOf(customDelimeterPostfix);

        if (firstIndexOfPrefix == -1 && firstIndexOfPostfix == -1) {
            return false;
        }

        return true;
    }

    //input 으로 부터 Delimeter 로 PositiveNumbers 추출 및 반환
    private PositiveNumbers getPositiveNumbersByDelimeter(final String userInput, final Delimeters delimters) {

        String calculationFormula = delimters.hasCustomDelimeter() ?
                userInput.substring(userInput.indexOf(customDelimeterPostfix) + 2)
                : userInput.substring(0);

        List<String> numbers = delimters.getNumbersFromCalculationFormula(calculationFormula);
        
        PositiveNumbers positiveNumbers = new PositiveNumbers();

        try {
            numbers.forEach(number -> positiveNumbers.addNumber(Integer.valueOf(number)));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("안된다니까!");
        }

        return positiveNumbers;
    }


}

package calculator.service;

import calculator.domain.Calculator;
import calculator.domain.Separator;
import calculator.exception.InvalidInputException;
import calculator.exception.ParamCountException;

import java.util.List;

public class CalculationService {

    private final Separator separator;
    private final Calculator calculator;

    public CalculationService() {
        this.separator = new Separator();
        this.calculator = new Calculator();
    }

    public int calculate(String input) {
        checkParams(input);
        String newInput = checkNewParam(input);
        extractNumbers(newInput);
        List<Integer> nums = separator.getNums();
        return calculator.calculate(nums);
    }

    private void checkParams(String input) {
        String processedString = checkNewParam(input);
        for (char ch : processedString.toCharArray()) {
            if (!Character.isDigit(ch) && !separator.getParams().contains(ch)) {
                throw new InvalidInputException("허용되지 않는 문자입니다.");
            }
        }
    }

    private String checkNewParam(String input) {
        if (input.startsWith("//")) {
            char newParam = input.charAt(2);
            separator.addParam(newParam);
            return input.substring(5);
        }
        return input;
    }

    private void extractNumbers(String input) {
        StringBuilder currentNumber = new StringBuilder();
        int paramCount = 0;

        // 입력이 비어있는 경우 예외 처리
        if (input == null || input.isEmpty()) {
            throw new InvalidInputException("입력이 비어있습니다.");
        }

        // 첫 번째 문자가 숫자가 아닌 경우 예외 처리
        if (!Character.isDigit(input.charAt(0))) {
            throw new InvalidInputException("입력의 첫 번째 문자는 숫자여야 합니다.");
        }

        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)) {
                currentNumber.append(ch);
                paramCount = 0; // 숫자가 계속 들어오는 경우 paramCount를 초기화
            } else {
                if (!Character.isDigit(ch) && paramCount > 0) {
                    throw new ParamCountException("파라미터의 개수가 1개를 초과합니다.");
                } else {
                    paramCount++;
                    separator.addNum(Integer.parseInt(currentNumber.toString()));
                    currentNumber.setLength(0); // currentNumber 초기화
                }
            }
        }

        if (paramCount > 0){
            throw new InvalidInputException("문자열은 숫자로 종결되어야 합니다.");
        }

        if (!currentNumber.isEmpty()) {
            separator.addNum(Integer.parseInt(currentNumber.toString()));
        }


    }
}
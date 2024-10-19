package calculator.domain.calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Calculator {

    private final Delimiter delimiter;

    private String expression;
    private ArrayList<Integer> operands = new ArrayList<>();
    private Integer result = 0;

    public Calculator(Delimiter delimiter) {
        this.delimiter = delimiter;
    }

    public void plusOperation() {
        this.getString();
        this.extractNumberList();
        this.plusCalculate();
        this.printResult();
    }

    private void getString() {
        System.out.println(CalculatorConstant.START_MESSAGE);
        this.expression = Console.readLine();
        Console.close();

        this.validateInputData();
    }

    private void validateInputData() {
        if (this.expression.length() >= 5 && this.expression.charAt(0) == '/' && this.expression.charAt(1) == '/'
                && this.expression.charAt(3) == '\\' && this.expression.charAt(4) == 'n') {
            if (Character.isDigit(this.expression.charAt(2))) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_CUSTOM_DELIMITER);
            }
            delimiter.addDelimiter(this.expression.charAt(2));
            this.expression = this.expression.substring(5);
        }

        for (int i = 0; i < this.expression.length(); i++) {
            char ch = this.expression.charAt(i);
            if (!(Character.isDigit(ch) || delimiter.isDelimiter(ch))) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_VALIDATION);
            }
        }
    }

    private void extractNumberList() {
        int num = 0;
        for (char ch : this.expression.toCharArray()) {
            if (delimiter.isDelimiter(ch)) {
                operands.add(num);
                num = 0;
            } else {
                num *= 10;
                num += (ch - '0');
                if (num >= CalculatorConstant.LIMIT_NUMBER) {
                    throw new IllegalArgumentException(ErrorMessage.INVALID_VALIDATION_EXCEED_BILLION);
                }
            }
        }
        operands.add(num);
    }

    private void plusCalculate() {
        for (Integer operand : operands) {
            result += operand;
            if (result >= CalculatorConstant.LIMIT_NUMBER) {
                throw new IllegalArgumentException(ErrorMessage.EXCEED_BILLION);
            }
        }
    }

    private void printResult() {
        System.out.println(CalculatorConstant.RESULT_MESSAGE + result);
    }
}

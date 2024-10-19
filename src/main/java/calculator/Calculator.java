package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private final Delimiter delimiter;

    public Calculator(String inputString) {
        this.delimiter = new Delimiter(inputString);
    }

    public int calculate(String inputString) {
        if (delimiter.hasCustomDelimiter()) {
            inputString = delimiter.removeCustomDelimiterForm(inputString);
        }
        String[] splitArray = inputString.split(delimiter.getDelimiterPattern());

        List<Operand> operandList = convertOperandList(splitArray);

        return totalSum(operandList);
    }

    private int totalSum(List<Operand> operandList) {
        return operandList.stream()
                .mapToInt(Operand::getNumber)
                .sum();
    }

    private List<Operand> convertOperandList(String[] splitArray) {
        List<Operand> operandList = new ArrayList<>();
        for (String number : splitArray) {
            Operand operand = new Operand(number);
            operandList.add(operand);
        }
        return operandList;
    }
}

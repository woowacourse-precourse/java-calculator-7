package calculator.service;

import calculator.domain.CalcTarget;
import calculator.util.CustomSeparatorRegister;
import calculator.util.InputValidator;

import java.util.ArrayList;

public class CalculatorService {
    private static String separator = ",:";

    public int calculate(CalcTarget input) {
        CalcTarget calcTarget = CustomSeparatorRegister.registerCustomSeparator(input);
        InputValidator.validate(calcTarget);
        ArrayList<Integer> numbers = extractNumbers(calcTarget);
        int sum = 0;
        for(int number : numbers){
            sum += number;
        }
        return sum;
    }

    private ArrayList<Integer> extractNumbers(CalcTarget target) {
        ArrayList<Integer> numbers = new ArrayList<>();
        String value = target.getValue();
        separator += target.getCustomSeparator();

        String[] split = value.split("[" + separator + "]");
        for(String num : split) {
            numbers.add(Integer.parseInt(num));
        }

        return numbers;
    }
}

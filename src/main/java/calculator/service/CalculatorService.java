package calculator.service;

import calculator.domain.CalcTarget;
import calculator.util.CustomSeparatorRegister;
import calculator.util.InputValidator;

import java.util.ArrayList;

public class CalculatorService {
    private static String separator = ",:";

    public int calculate(CalcTarget input) {
        CalcTarget calcTarget = CustomSeparatorRegister.registerCustomSeparator(input.getValue());
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
        char prefix = ' ';
        separator += target.getCustomSeparator();

        for(int i = 0; i < value.length(); i++){
            if(separator.indexOf(value.charAt(i)) != -1){
                prefix = value.charAt(i);
                continue;
            }
            if(Character.isDigit(value.charAt(i))){
                if(prefix != ' '){
                    prefix = ' ';
                }
                numbers.add(Character.getNumericValue(value.charAt(i)));
            }
        }

        return numbers;
    }
}

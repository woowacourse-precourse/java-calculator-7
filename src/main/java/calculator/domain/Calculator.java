package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private Delimiter delimiter;
    final private List<Integer> operands = new ArrayList<>();


    public Calculator(String calculation){
        setDelimiter();
        setOperands(calculation);
    }

    public Calculator(String customDelimeter, String calculation){
        setDelimiter(customDelimeter);
        setOperands(calculation);
    }

    private void setDelimiter(){
        this.delimiter = new Delimiter();
    }

    private void setDelimiter(String customDelimeter){
        this.delimiter = new Delimiter(customDelimeter);
    }

    private void setOperands(String calculation){
        if(calculation.isEmpty()){
            operands.add(0);
            return;
        }
        String[] tokens = calculation.split(delimiter.getDelimiters());

        for (String token : tokens) {
            try {
                operands.add(Integer.parseInt(token));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
    }



    public int calculate(){
        if (operands.isEmpty()) {
            return 0;
        }

        int sum = 0;
        for (int operand : operands) {
            sum += operand;
        }

        return sum;
    }

}

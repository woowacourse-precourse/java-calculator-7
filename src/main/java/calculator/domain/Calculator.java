package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private Delimiter delimiter;
    final private List<Integer> operands = new ArrayList<>();
    private String customDelimeters;
    private String calculation;

    public Calculator(String str){
        setString(str);
        setDelimiter(customDelimeters);
        setOperands(calculation);
        validateCalculator(str);
    }



    public void setString(String str){
        Pattern pattern = Pattern.compile("//(.*)\\\\n(.*)");
        Matcher matcher = pattern.matcher(str);

        if (matcher.matches()) {
            customDelimeters = matcher.group(1);
            calculation = matcher.group(2);

        } else {
            calculation = str;
        }
    }


    private void validateCalculator(String str){
        // 패턴이 맞지 않는 경우
        checkPattern(str);

    }

    private void checkPattern(String str){
        // 1. //으로 시작하는 경우에 대한 패턴
        Pattern customPattern = Pattern.compile("//(.*)\\\\n(.*)");
        Matcher customMatcher = customPattern.matcher(str);
        Pattern calculatorPattern = Pattern.compile("(\\d+\\D+)+");
        Matcher calculatorMatcher = calculatorPattern.matcher(str);


        if(!customMatcher.matches() && !calculatorMatcher.matches()){
            throw new IllegalArgumentException("Invalid pattern");
        }




    }



    private void setDelimiter(String customDelimeter){
        if(customDelimeter == null){
            this.delimiter = new Delimiter();
        }
        else{
            this.delimiter = new Delimiter(customDelimeter);
        }

    }

    private void setOperands(String calculation) {
        if (calculation.isEmpty()) {
            operands.add(0);
            return;
        }

        String[] tokens = calculation.split(delimiter.getDelimiters());

        for (String token : tokens) {
            if (token.isEmpty()) {
                operands.add(0);
            } else {
                try {
                    int number = Integer.parseInt(token);

                    if (number <= 0) {
                        throw new IllegalArgumentException("Invalid number: " + token + " (must be a positive integer)");
                    }

                    operands.add(number);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid number format: " + token);
                }
            }
        }
    }


    public int calculate(){
        if (operands.isEmpty()) {
            System.out.println("here");
            return 0;
        }

        int sum = 0;
        for (int operand : operands) {
            sum += operand;
        }

        return sum;
    }

}

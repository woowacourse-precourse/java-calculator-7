package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorParser {
    private final List<Character> delimiters = new ArrayList<>(Arrays.asList(':',','));

    public List<Double> parse(String input){
        if(isDelimiterCustom(input)){
            input = parseAndValidCustomDelimiter(input);
        }
        return parseAndValidateOperands(input);
    }

    private boolean isDelimiterCustom(String input){
        return input.startsWith("//");
    }

    private String parseAndValidCustomDelimiter(String input) {
        String regex = "^//(.)\\\\n(.*)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if(matcher.find()){
            char delimiter = matcher.group(1).charAt(0);
            String pureInput = matcher.group(2);

            if(Character.isDigit(delimiter)){
                throw new IllegalArgumentException("숫자는 구분자로 사용할 수 없습니다.");
            }
            delimiters.add(delimiter);
            return pureInput;
        } else{
            throw new IllegalArgumentException("구분자는 길이가 1인 문자여야 합니다.");
        }
    }


    private List<Double> parseAndValidateOperands(String sentence){
        List<Double> operands = new ArrayList<>();
        double operand;
        for(String word : sentence.split(generateDelimiterRegex())){
            operand = parseOperand(word);
            validateOperand(operand);
            operands.add(operand);
        }
        return operands;
    }

    private String generateDelimiterRegex(){
        StringBuilder delimiterRegex = new StringBuilder();
        for(int i=0; i<delimiters.size(); i++){
            delimiterRegex.append(delimiters.get(i));
            if(i == delimiters.size()-1){
                continue;
            }
            delimiterRegex.append("|");
        }
        return delimiterRegex.toString();
    }

    private double parseOperand(String word){
        try{
            System.out.println(word);
            return Double.parseDouble(word);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("피연산자가 숫자가 아닙니다.");
        }
    }

    private void validateOperand(double operand){
        if(operand <= 0){
            throw new IllegalArgumentException("피연산자가 양수가 아닙니다.");
        }
    }
}


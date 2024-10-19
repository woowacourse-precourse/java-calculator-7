package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculatorParser {
    private final List<Character> delimiters = new ArrayList<>(Arrays.asList(':',','));

    public List<Double> parse(String sentence){
        if(isDelimiterCustom(sentence)){
            parseAndValidCustomDelimiter(sentence);
            sentence = removeCustomDelimiterDefinition(sentence);
        }
        return parseAndValidateOperands(sentence);
    }

    private boolean isDelimiterCustom(String input){
        return input.startsWith("//");
    }

    private void parseAndValidCustomDelimiter(String input) {
        String regex = "^//(.)\\n.*";

        if(input.matches(regex)){
            char delimiter = input.charAt(2);
            if(Character.isDigit(delimiter)){
                throw new IllegalArgumentException("숫자는 구분자로 사용할 수 없습니다.");
            }
            delimiters.add(delimiter);
        } else{
            throw new IllegalArgumentException("구분자는 길이가 1인 문자여야 합니다.");
        }
    }

    private String removeCustomDelimiterDefinition(String sentence){
        return sentence.substring(4);
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


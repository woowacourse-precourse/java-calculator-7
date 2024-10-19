package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculatorParser {
    private final List<Character> delimiters = new ArrayList<>(Arrays.asList(':',','));

    public List<Double> parse(String sentence){
        List<Double> operands;

        if(sentence.startsWith("//")){
            processCustomDelimiter(sentence);
            sentence = removeCustomDelimiterDefinition(sentence);
        }

        operands = parseAndValidOperands(sentence);
        return operands;
    }

    private void processCustomDelimiter(String sentence) {
        String[] result = sentence.split("\n");

        if (result[0].length() != 3) {
            throw new IllegalArgumentException("커스텀 구분자가 1글자를 초과했습니다.");
        }
        delimiters.add(result[0].charAt(2));
    }

    private String removeCustomDelimiterDefinition(String sentence){
        return sentence.substring(4);
    }

    private List<Double> parseAndValidOperands(String sentence){
        List<Double> operands = new ArrayList<>();
        double operand;
        for(String word : sentence.split(getDelimiterRegex())){
            operand = parseOperand(word);
            validateOperand(operand);
            operands.add(operand);
        }
        return operands;
    }

    private String getDelimiterRegex(){
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


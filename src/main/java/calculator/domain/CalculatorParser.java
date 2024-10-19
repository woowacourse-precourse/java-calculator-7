package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculatorParser {
    private final List<Character> delimiters = new ArrayList<>(Arrays.asList(':',','));

    public List<Double> parse(String sentence){
        List<Double> operands = new ArrayList<>();

        if(sentence.startsWith("//")){
            processCustomDelimiter(sentence);
            sentence = sentence.substring(4);
        }


        for(String word : sentence.split(makeDelimiterRegex())){
            double operand = 0;
            operand = Double.parseDouble(word);
            operands.add(operand);
        }

        return operands;
    }

    private String makeDelimiterRegex(){
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

    private void processCustomDelimiter(String sentence) {
        String[] result = sentence.split("\n");

        if (result[0].length() != 3) {
            throw new IllegalArgumentException("커스텀 구분자가 1글자를 초과했습니다.");
        }
        delimiters.add(result[0].charAt(2));
    }

}


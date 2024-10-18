package calculator.service;

import calculator.calculator.Calculator;
import calculator.delimiterExtractor.DelimiterExtractor;
import calculator.numberExtractor.NumberExtractor;
import java.util.ArrayList;

public class Service {


    public String extractDelimiter(DelimiterExtractor extractor, String input) {

        return extractor.extractDelimiter(input);

    }


    public ArrayList<Integer> extractNumbers(String delimiter, NumberExtractor numberExtractor, String input) {

        return numberExtractor.extractNumbers(input, delimiter);

    }


    public String checkTypeOfInput(String input) {
        char[] inputToCharArray = input.toCharArray();
        String firstString = String.valueOf(inputToCharArray[0]);
        String secondString = String.valueOf(inputToCharArray[1]);

        if (firstString.equals("/") && secondString.equals("/")) {
            return "CustomInput";
        }

        if (input.contains(",") || input.contains(":")) {
            return "DefaultInput";
        }

        throw new IllegalArgumentException();
    }


    public int addAll(ArrayList<Integer> extractNumbers) {
        return Calculator.allSum(extractNumbers);
    }


}
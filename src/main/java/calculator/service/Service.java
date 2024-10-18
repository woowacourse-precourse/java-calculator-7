package calculator.service;

import calculator.calculator.Calculator;
import calculator.constants.StringConst;
import calculator.delimiterExtractor.DelimiterExtractor;
import calculator.dto.DelimiterDto;
import calculator.dto.NumberDto;
import calculator.numberExtractor.NumberExtractor;
import java.util.ArrayList;

public class Service {


    public String extractDelimiter(DelimiterExtractor extractor, String input) {
        DelimiterDto delimiterDto = extractor.extractDelimiter(input);
        return delimiterDto.getDelimiter();

    }


    public ArrayList<Integer> extractNumbers(String delimiter, NumberExtractor numberExtractor, String input) {
        NumberDto numberDTO = numberExtractor.extractNumbers(input, delimiter);
        return numberDTO.getNumberRepository();

    }


    public String checkTypeOfInput(String input) {
        char[] inputToCharArray = input.toCharArray();

        if (input.startsWith(StringConst.CUSTOM_START_STRING) && input.contains(StringConst.LINE_SEPARATOR_STRING)) {
            return "CustomInput";
        }

        if (input.contains(StringConst.COMMA) || input.contains(StringConst.COLON)) {
            return "DefaultInput";
        }

        throw new IllegalArgumentException();
    }


    public int addAll(ArrayList<Integer> extractNumbers) {
        return Calculator.allSum(extractNumbers);
    }


}
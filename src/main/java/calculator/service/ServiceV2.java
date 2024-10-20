package calculator.service;

import calculator.calculator.Calculator;
import calculator.delimiterExtractor.DelimiterExtractor;
import calculator.dto.DelimiterDto;
import calculator.dto.NumberDto;
import calculator.numberExtractor.NumberExtractor;
import calculator.validator.Validator;
import java.util.ArrayList;

public class ServiceV2 implements Service {

    public String extractDelimiter(DelimiterExtractor extractor, String input) {
        DelimiterDto delimiterDto = extractor.extractDelimiter(input);
        return delimiterDto.getDelimiter();

    }


    public ArrayList<Integer> extractNumbers(String delimiter, NumberExtractor numberExtractor, String input) {
        NumberDto numberDTO = numberExtractor.extractNumbers(input, delimiter);
        return numberDTO.getNumberRepository();

    }


    public String checkTypeOfInput(String input, Validator validator) {

        return validator.canParseToNumber(input);

    }


    public int addAll(ArrayList<Integer> extractNumbers) {
        return Calculator.allSum(extractNumbers);
    }


}
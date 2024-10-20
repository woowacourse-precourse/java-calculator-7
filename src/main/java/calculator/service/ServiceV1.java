package calculator.service;


import calculator.calculator.Calculator;
import calculator.constants.StringConst;
import calculator.delimiterExtractor.DelimiterExtractor;
import calculator.dto.DelimiterDto;
import calculator.dto.NumberDto;
import calculator.numberExtractor.NumberExtractor;
import calculator.utils.ExceptionUtils;
import calculator.validator.Validator;
import java.util.ArrayList;

public class ServiceV1 implements Service {


    public String extractDelimiter(DelimiterExtractor extractor, String input) {
        DelimiterDto delimiterDto = extractor.extractDelimiter(input);
        return delimiterDto.getDelimiter();

    }


    public ArrayList<Integer> extractNumbers(String delimiter, NumberExtractor numberExtractor, String input) {
        NumberDto numberDTO = numberExtractor.extractNumbers(input, delimiter);
        return numberDTO.getNumberRepository();

    }


    public String checkTypeOfInput(String input, Validator validator) {

        if (input.startsWith(StringConst.CUSTOM_START_STRING) && input.contains(StringConst.LINE_SEPARATOR_STRING)) {
            return StringConst.CUSTOM_INPUT;
        }

        if (input.contains(StringConst.COMMA) || input.contains(StringConst.COLON)) {
            return StringConst.DEFAULT_INPUT;
        }

        ExceptionUtils.throwCanNotParseToNumberException();
        return null;
    }


    public int addAll(ArrayList<Integer> extractNumbers) {
        return Calculator.allSum(extractNumbers);
    }


}
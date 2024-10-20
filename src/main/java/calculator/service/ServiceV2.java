package calculator.service;

import calculator.calculator.Calculator;
import calculator.constants.StringConst;
import calculator.delimiterExtractor.DelimiterExtractor;
import calculator.dto.DelimiterDto;
import calculator.dto.NumberDto;
import calculator.inputType.InputType;
import calculator.inputType.InputTypeProvider;
import calculator.numberExtractor.NumberExtractor;
import java.util.ArrayList;
import java.util.List;

public class ServiceV2 implements Service {


    public String extractDelimiter(DelimiterExtractor extractor, String input) {
        DelimiterDto delimiterDto = extractor.extractDelimiter(input);
        return delimiterDto.getDelimiter();

    }


    public ArrayList<Integer> extractNumbers(String delimiter, NumberExtractor numberExtractor, String input) {
        NumberDto numberDTO = numberExtractor.extractNumbers(input, delimiter);
        return numberDTO.getNumberRepository();

    }


    public String checkTypeOfInput(String input) {

        List<InputType> inputTypelist = InputTypeProvider.provideInputTypelist();

        InputType customInput = inputTypelist.get(0);
        String customInputName = customInput.getType();
        if (customInput.check(input) && customInputName.equals(StringConst.CUSTOM_INPUT)) {
            return StringConst.CUSTOM_INPUT;
        }

        InputType defaultInput = inputTypelist.get(1);
        String defaultInputName = defaultInput.getType();
        if (defaultInput.check(input) && defaultInputName.equals(StringConst.DEFAULT_INPUT)) {
            return StringConst.DEFAULT_INPUT;
        }

        throw new IllegalArgumentException();

    }


    public int addAll(ArrayList<Integer> extractNumbers) {
        return Calculator.allSum(extractNumbers);
    }


}
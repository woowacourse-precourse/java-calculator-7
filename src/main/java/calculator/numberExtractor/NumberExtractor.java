package calculator.numberExtractor;


import calculator.dto.NumberDto;

public interface NumberExtractor {


    public NumberDto extractNumbers(String input, String delimiter);
}

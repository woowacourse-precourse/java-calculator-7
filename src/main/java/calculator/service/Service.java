package calculator.service;

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


}
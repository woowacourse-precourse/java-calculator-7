package calculator.parser;

import calculator.Validator;
import calculator.dto.Data;

public class DefaultDataParser implements DataParser {

    private static final String PREFIX = "//";

    @Override
    public boolean isSupport(String inputData) {
        return !inputData.startsWith(PREFIX);
    }

    @Override
    public Data parseData(String inputData) {
        char[] separators = getSeparator(inputData);
        char[] contents = getContents(inputData);
        Validator.checkValidContents(separators, contents);

        String contentsString = getContentString(contents, separators);
        String separatorsString = getSeparatorsString(separators);
        return new Data(separatorsString, contentsString);
    }

    private static char[] getSeparator(String inputData) {
        return new char[]{',', ':'};
    }

    private char[] getContents(String inputData) {
        if (inputData.isEmpty()) {
            return new char[]{'0'};
        }
        return inputData.toCharArray();
    }
}

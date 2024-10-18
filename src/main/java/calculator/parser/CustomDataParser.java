package calculator.parser;

import calculator.Validator;
import calculator.dto.Data;

public class CustomDataParser implements DataParser {

    private static final String REGEX = "\\\\n";
    private static final String PREFIX = "//";
    private static final String INVALID_SEPARATOR_LENGTH_ERROR_MESSAGE = "커스텀 구분자는 1개만 입력할 수 있습니다.";

    @Override
    public boolean isSupport(String inputData) {
        return inputData.startsWith(PREFIX);
    }

    @Override
    public Data parseData(String inputData) {
        Validator.checkValidCustomFormat(inputData);

        char[] separators = getCustomSeparator(inputData);
        char[] contents = getContents(inputData);

        Validator.checkValidContents(separators, contents);

        String contentsString = getContentString(contents, separators);
        String separatorsString = getSeparatorsString(separators);
        return new Data(separatorsString, contentsString);

    }

    private char[] getCustomSeparator(String inputData) {
        String[] split = inputData.split(REGEX);
        String prefix = split[0];
        if (prefix.length() != 3) {
            throw new IllegalArgumentException(INVALID_SEPARATOR_LENGTH_ERROR_MESSAGE);
        }
        char separator = prefix.charAt(2);
        return new char[]{separator, ':', ','};
    }

    private char[] getContents(String inputData) {

        String[] data = inputData.split(REGEX);
        if (data.length == 1) {
            return new char[]{'0'};
        }
        String datum = data[1];
        return datum.toCharArray();
    }
}

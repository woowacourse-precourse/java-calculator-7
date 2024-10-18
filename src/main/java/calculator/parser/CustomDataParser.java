package calculator.parser;

import calculator.validator.CustomDataValidator;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CustomDataParser implements DataParser {

    private static final String DELIM= "\\n";
    private static final String PREFIX = "//";
    private static final String INVALID_SEPARATOR_LENGTH_ERROR_MESSAGE = "커스텀 구분자는 1개만 입력할 수 있습니다.";
    private static final String NOT_INTEGER_DATA_ERROR_MESSAGE = "정수형 범위의 데이터가 아닙니다.";

    @Override
    public boolean isSupport(String inputData) {
        return inputData.startsWith(PREFIX);
    }

    @Override
    public List<Integer> parseData(String inputData) {
        List<Integer> result = new ArrayList<>();

        CustomDataValidator.checkValidCustomFormat(inputData);

        String separators = getCustomSeparator(inputData);
        String contents = getContents(inputData);

        CustomDataValidator.checkValidContents(contents, separators);

        StringTokenizer st = new StringTokenizer(contents, separators);

        try {
            while (st.hasMoreTokens()) {
                int number = Integer.parseInt(st.nextToken());
                result.add(number);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER_DATA_ERROR_MESSAGE);
        }
        return result;
    }

    private String getCustomSeparator(String inputData) {
        StringTokenizer st = new StringTokenizer(inputData, DELIM);
        String prefix = st.nextToken();
        if (prefix.length() != 3) {
            throw new IllegalArgumentException(INVALID_SEPARATOR_LENGTH_ERROR_MESSAGE);
        }
        char separator = prefix.charAt(2);
        return separator + ":,";
    }

    private String getContents(String inputData) {
        StringTokenizer st = new StringTokenizer(inputData, DELIM);
        int count = st.countTokens();
        if (count == 1) {
            return "";
        }
        return getSecondToken(st);
    }

    private static String getSecondToken(StringTokenizer st) {
        st.nextToken();
        return  st.nextToken();
    }
}

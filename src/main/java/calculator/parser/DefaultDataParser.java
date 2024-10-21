package calculator.parser;

import calculator.validator.DefaultDataValidator;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DefaultDataParser implements DataParser {

    private static final String SEPARATORS = ",:";
    private static final String PREFIX = "//";
    private static final String NOT_INTEGER_DATA_ERROR_MESSAGE = "정수형 범위의 데이터가 아닙니다.";

    @Override
    public boolean isSupport(String inputData) {
        return !inputData.startsWith(PREFIX);
    }

    @Override
    public List<Integer> parseData(String inputData) {
        List<Integer> result = new ArrayList<>();
        DefaultDataValidator.checkValidContents(inputData);
        StringTokenizer st = new StringTokenizer(inputData, SEPARATORS);

        try {
            while (st.hasMoreTokens()) {
                String s = st.nextToken();
                int number = Integer.parseInt(s);
                result.add(number);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER_DATA_ERROR_MESSAGE);
        }

        return result;
    }

}

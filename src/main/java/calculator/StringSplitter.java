package calculator;

import java.util.Arrays;
import java.util.List;

public class StringSplitter {
    public static List<String> SplitbyDefaultDelimiter(String inputString) {
        List<String> defaultSplitValues = Arrays.asList(inputString.split(",|:"));
        return defaultSplitValues;
    }
    public static List<String> SplitbyCustomDelimiter(String inputString) {
        String customDelimiter = String.valueOf(inputString.charAt(2));
        String remainingInput = inputString.substring(5);

        if (Validator.checkRemainStringFormat(remainingInput, customDelimiter)) {
            List<String> customSplitValues = Arrays.asList(remainingInput.split(customDelimiter));
            return customSplitValues;
        }
        throw new IllegalArgumentException("커스텀 구분자 지정형식 뒤의 계산할 문자열 형식을 확인해주세요");
    }
}

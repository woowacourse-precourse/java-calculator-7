package calculator;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class StringFilter {
    private final String DEFAULT_DELIMITER = "[,:]";
    private final StringValidator validator = new StringValidator();

    //입력값을 정수 배열로 변환
    public int[] convertToIntArray(String input){
        String[] splitInput = checkDelimiterType(input);

        validator.validateString(splitInput);
        validator.validateNegativeNumber(splitInput);

        int[] result = new int[splitInput.length];
        for (int i = 0; i < splitInput.length; i++) {
                result[i] = Integer.parseInt(splitInput[i]);
        }
        return result;
    }
    
    //구분자 타입 확인
    public String[] checkDelimiterType(String input) {
        if (input.contains("//") && input.contains("\\n")) {
            return findCustomDelimiter(input);
        }
        return splitDefaultDelimiter(input);
    }
    
    //기본구분자로 나누기
    private String[] splitDefaultDelimiter(String input) {
        return input.split(DEFAULT_DELIMITER);
    }

    //커스텀 구분자 추출하기
    private static String[] findCustomDelimiter(String Input) {
        String replaceString = Input.replace("//", "").replace("\\n", "");
        String customDelimiter = replaceString.substring(0, 1);
        return splitByDelimiter(replaceString, customDelimiter);
    }
    
    //커스텀 구분자로 나누기
    private static String[] splitByDelimiter(String replaceString, String customDelimiter) {
        return replaceString.substring(1).split(Pattern.quote(customDelimiter));
    }
}
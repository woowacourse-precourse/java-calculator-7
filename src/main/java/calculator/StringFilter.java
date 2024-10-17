package calculator;

import java.util.Arrays;

public class StringFilter {
    private final String DEFAULT_DELIMITER = "[,:]";

    public String[] StringController(String input) {
        String[] sanitizedInput = splitAndTrim(input);

        if (validateDelimiter(sanitizedInput)){
        validateNegativeNumber(sanitizedInput); //첫번째 인덱스가 음수,양수인지 확인
            return sanitizedInput;
        }
        else
            return customDelimiter(sanitizedInput);
    }

    //문자열 나누기
    private String[] splitAndTrim(String input) {
        String[] splitInput = input.split(DEFAULT_DELIMITER);

        return Arrays.stream(splitInput)
                .filter(s -> !s.isEmpty())
                .map(String::trim)
                .toArray(String[]::new);
    }

    //구분자 검증
    private boolean validateDelimiter(String[] splitedString) {
        try{
            Integer.parseInt(splitedString[0]);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
    
    //입력값에 대한 음수,양수 검증
    private static void validateNegativeNumber(String[] splitedString) {
        for (String numberStr : splitedString) {
            if (Integer.parseInt(numberStr.trim()) < 0) {
                throw new IllegalArgumentException();
            }
        }
    }

    //커스텀 구분자 추출
    private String[] customDelimiter(String[] filteredString) {
        String s = String.join("", filteredString);
        String replaceInput = s.replace("//", "").replace("\\n", "").trim();
        String customDelimiter = replaceInput.substring(0, 1);
        return replaceInput.substring(1).split(customDelimiter);
    }


}

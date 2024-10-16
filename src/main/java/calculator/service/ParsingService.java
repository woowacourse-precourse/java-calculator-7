package calculator.service;

import calculator.util.NumberValidator;
import java.util.Arrays;

public class ParsingService {

    //====================== business ======================//
    public int[] parseNumbers(String input) {
        //TODO: 입력 문자열 파싱 로직 구현
        String delimiter = ",|:";

        if(input.startsWith("//")){
            delimiter += extractCustomDelimiter(input);
            input = preprocessingInput(input);
        }

        String[] numberStrings = splitString(input, delimiter);

        return Arrays.stream(numberStrings)
                .mapToInt(this :: parsePositiveNumber)
                .toArray();
    }

    private String[] splitString(String input, String delimiter) {
        //TODO: 문자열 분리 로직 구현
        return input.split(delimiter);
    }


    private String extractCustomDelimiter(String input) {
        //TODO: 커스텀 구분자 추출 로직 구현
        int newlineIndex = input.indexOf("\\n");

        if (newlineIndex == -1) {
            throw new IllegalArgumentException("\\n 가 존재하지 않습니다.");
        }

        return "|" + input.substring(2, newlineIndex);
    }

    //====================== builder ======================//
    private String preprocessingInput(String input){
        int newlineIndex = input.indexOf("\\n");
        return input.substring(newlineIndex + 2);
    }

    private int parsePositiveNumber(String numberString) {
        NumberValidator.isValidNumber(numberString);
        return Integer.parseInt(numberString);
    }
}

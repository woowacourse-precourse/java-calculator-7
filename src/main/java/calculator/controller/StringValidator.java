package calculator.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StringValidator {
    private static final String EMPTY_INPUT_ERROR_MESSAGE = "입력 받은 문자열이 비어있습니다.";
    private static final String INVALID_INPUT_ERROR_MESSAGE = "잘못된 입력입니다.";
    public List<Integer> validate(String inputString) {
        if(!isEmpty(inputString)) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR_MESSAGE);
        }
        else if(!isValid(inputString)) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR_MESSAGE);
        }
        return convertStringToIntegerList(inputString);
    }

    private boolean isEmpty(String inputString) {
        return !Objects.isNull(inputString) && !inputString.isEmpty();
    }

    private boolean isValid(String inputString) {
        return inputString.matches("[0-9]+(\\s[0-9]+)*");
    }


    private List<Integer> convertStringToIntegerList(String inputString) {
        return Arrays.stream(inputString.split(" "))
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());
    }
}

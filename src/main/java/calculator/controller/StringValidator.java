package calculator.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 문자열 검증을 위한 StringValidator
 */
public class StringValidator {
    private static final String EMPTY_INPUT_ERROR_MESSAGE = "입력 받은 문자열이 비어있습니다.";
    private static final String INVALID_INPUT_ERROR_MESSAGE = "잘못된 입력입니다.";

    /**
     * 사용자의 입력을 각 검증을 통해 에러를 반환하는 메소드
     * @param inputString
     * @throws IllegalArgumentException
     * @return 에러 없을 때 IntegerList 변환 메소드 호출
     */
    public List<Integer> validate(String inputString) {
        if(!isEmpty(inputString)) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR_MESSAGE);
        }
        else if(!isValid(inputString)) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR_MESSAGE);
        }
        return convertStringToIntegerList(inputString);
    }

    /**
     * 문자열이 Null 이거나 비어있는지 확인하기 위한 메소드
     * @param inputString
     * @return 문자열이 Null 혹은 비어있는지 여부
     */
    private boolean isEmpty(String inputString) {
        return !Objects.isNull(inputString) && !inputString.isEmpty();
    }

    /**
     * 문자열이 주어진 조건 내에 부합하는지 확인하기 위한 메소드
     * @param inputString
     * @return 문자열이 패턴에 부합하는지 여부
     */
    private boolean isValid(String inputString) {
        return inputString.matches("[0-9]+(\\s[0-9]+)*");
    }

    /**
     * 문자열을 Integer로 변환하기 위한 메소드
     * @param inputString
     * @return Integer List
     */
    private List<Integer> convertStringToIntegerList(String inputString) {
        return Arrays.stream(inputString.split(" "))
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());
    }
}

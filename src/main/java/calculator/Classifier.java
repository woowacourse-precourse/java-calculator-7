package calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * - 역할: 입력된 문자열을 구분자로 분류하여 숫자를 추출
 * - 책임: 문자열의 유효성을 검사하고, 올바른 형식이면 숫자를 분류
 */
public class Classifier {
    private final Delimiters delimiters;
    private final List<Integer> numbers;


    /**
     * 생성자: 입력 문자열과 구분자를 받아 유효성을 검사한 후 숫자를 분류
     * @param input 입력 문자열
     * @param delimiters Delimiters 객체 (구분자 처리)
     */
    public Classifier(String input, Delimiters delimiters) {
        this.delimiters = delimiters;
        isValid(input);
        this.numbers = classifyNumbers(input);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    /**
     * 입력 문자열의 전체 유효성을 검사
     * - 커스텀 구분자 여부에 따라 각각의 유효성 검사 실행
     * @param input 입력 문자열
     */
    private void isValid(String input) {
        if(delimiters.isCustomDelimiterPresent()){
            isCustomStringValid(input);
        }
        if(!delimiters.isCustomDelimiterPresent()){
            isStringValid(input);
        }
    }


    /**
     * 입력 문자열을 분류하여 숫자를 추출
     * - 구분자에 따라 다르게 처리
     * @param input 입력 문자열
     * @return 분류된 숫자 리스트
     */
    private List<Integer> classifyNumbers(String input) {
        if(input.isEmpty()){
            return List.of(0);
        }
        if(!delimiters.isCustomDelimiterPresent()) {
            return splitAndConvertInput(input, delimiters.generateDefaultDelimiterRegex());
        }
        return splitAndConvertInput(getExcludedString(input), delimiters.generateCustomDelimiterRegex());
    }

    /**
     * 문자열을 구분자로 나누고 숫자로 변환
     * - 이 함수의 기능이 너무 많지 않은지 한번 더 생각해봐야 함
     * @param input 입력 문자열
     * @param delimiter 구분자 (정규 표현식)
     * @return 숫자로 변환된 리스트
     */
    private List<Integer> splitAndConvertInput(String input, String delimiter) {
        String[] numbersString = input.split(delimiter);
        List<Integer> numbersInteger = new ArrayList<>();
        for (String number : numbersString) {
            numbersInteger.add(Integer.parseInt(number));
        }
        return numbersInteger;
    }


    /**
     * 커스텀 구분자를 제외한 문자열의 형식이 맞는지 확인
     * @param input 입력 문자열
     */
    private void isCustomStringValid(String input) {
        if(!getExcludedString(input).matches(delimiters.regexForCustomPatten())) {
            throw new IllegalArgumentException("Invalid custom delimiter");
        }
    }

    /**
     * 커스텀 구분자를 제외한 문자열 가져오기
     * - 특정 구분자에 대한 regex가 들어감. 이건 Delimiter의 책임도 아니고 Classifier의 책임도 아니라고 생각.
     * - 이건 따로 설정 클래스를 만들던지 해서 빼야 할 것 같음.
     * @param input 입력 문자열
     * @return 커스텀 구분자를 제외한 문자열
     */
    private String getExcludedString(String input) {
        return input.split("\\Q\\n\\E")[1];
    }

    /**
     * 커스텀 구분자가 없는 경우 문자열 형식을 확인
     * - 기본 구분자로 나뉘어진 문자열이 올바른 형식인지 확인
     * @param input 입력 문자열
     */
    private void isStringValid(String input) {
        if(!input.isEmpty() && !input.matches(delimiters.regexForDefaultPattern())) {
            throw new IllegalArgumentException("Invalid string");
        }
    }

}

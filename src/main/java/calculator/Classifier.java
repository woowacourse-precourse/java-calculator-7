package calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * - input을 받아서 커스텀 구분자와 숫자 분류
 * - 제대로 된 입력을 받아야 함
 * - 더 나은 구조가 분명 있을 것 같음. 리팩토링 필요. 일단 기능 구현을 마친 후에 다시 리팩토링
 */
public class Classifier {
    private static final String DEFAULT_DELIMITERS = ":|,";
    private String customDelimiter = "|";
    private final List<Integer> numbers;


    public Classifier(String input) {
        isValid(input);
        this.numbers = classifyNumbers(input);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    /**
     * 전체 validation 처리 함수
     * @param input
     */
    private void isValid(String input) {
        if(isCustomDelimiterPresent(input)){
            this.customDelimiter = "|" + getCustomDelimiter(input);
            isCustomStringValid(input);
        }
        if(!isCustomDelimiterPresent(input)){
            isStringValid(input);
        }
    }


    /**
     * 숫자를 분류해내는 함수
     * @param input
     * @return
     */
    private List<Integer> classifyNumbers(String input) {
        if(input.isEmpty()){
            return List.of(0);
        }
        if(customDelimiter.equals("|")) {
            String noCustomRegexForSplit = "[" + DEFAULT_DELIMITERS + "]";
            return splitAndConvertInput(input, noCustomRegexForSplit);
        }
        String customRegexForSplit = "["+ DEFAULT_DELIMITERS + customDelimiter + "]";

        return splitAndConvertInput(input.substring(4), customRegexForSplit);
    }

    /**
     * 이 함수의 기능이 너무 많지 않은지 한번 더 생각해봐야 함
     *
     * @param input
     * @param delimiter 구분자를 기준으로 정규표현식으로 쪼갬
     * @return
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
     * custom delimiter 추출
     * substring 부분은 너무 한정적임. 다른 방식을 고려해야 함
     * @param input
     * @return
     */
    private String getCustomDelimiter(String input) {
        return input.substring(2,3);
    }


    /**
     * 현재는 커스텀 문자열 선언 부분의 문자를 숫자, 문자 입력 금지로 함.
     * 다른 예외처리 고려해봐야 함.
     * @param input
     * @return
     */
    private boolean isCustomDelimiterPresent(String input) {
        String regex = "^//[^a-zA-Z0-9]\\n.*";
        return input.matches(regex);
    }

    /**
     * custom delimiter을 제외한 문자열의 형식이 맞는지 확인
     * @param input
     */
    private void isCustomStringValid(String input) {
        String excludedString = input.substring(4);
        String customRegex = "^[0-9]+([" + DEFAULT_DELIMITERS + customDelimiter + "][0-9]+)*$";
        if(!excludedString.matches(customRegex)) {
            throw new IllegalArgumentException("Invalid custom delimiter: ");
        }
    }

    /**
     * 커스텀 구분자가 없는 문자열의 validation 처리
     * @param input
     */
    private void isStringValid(String input) {
        String regex = "^[0-9]+(([,:])[0-9]+)*$";
        if(!input.isEmpty() && !input.matches(regex)) {
            throw new IllegalArgumentException("Invalid string");
        }
    }

}

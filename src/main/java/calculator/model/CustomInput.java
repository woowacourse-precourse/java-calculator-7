package calculator.model;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class CustomInput extends UserInput {
    private static final String CUSTOM_START_FORMAT = "//";
    private static final String CUSTOM_END_FORMAT = "\\n";

    public CustomInput(String userInput) {
        super(userInput);
    }

    @Override
    protected void parseInputForCalculate(String userInput) {
        checkCustomDelimFormat(userInput);

        int delimiterStartIdx = userInput.indexOf(CUSTOM_START_FORMAT) + 2;
        int delimiterEndIdx = userInput.indexOf(CUSTOM_END_FORMAT);

        extractCustomDelimiterAndAdd(userInput, delimiterStartIdx, delimiterEndIdx);

        String[] splitValues = splitCalculatePartByDelimiters(extractCalculatePart(userInput, delimiterEndIdx + 2));
        checkValueToCalculateIsNumber(splitValues);

        inputNumbers = Arrays.stream(splitValues)
                .mapToLong(Long::parseLong)
                .toArray();
    }

    @Override
    protected String[] splitCalculatePartByDelimiters(String calculatePart) {
        try {
            String regex = String.join("|", delimiters.stream().map(Pattern::quote).toArray(String[]::new));
            return calculatePart.split(regex);
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException("구분자(, 또는 :)와 숫자로만 입력해주세요.");
        }
    }

    /***
     * 커스텀 구분자포맷이 지켜졌는지 확인합니다.
     * @param userInput : 사용자의 입력
     */
    private void checkCustomDelimFormat(String userInput) {
        if (!userInput.contains("\\n")) {
            throw new IllegalArgumentException("커스텀 구분자 포맷을 지켜주세요");
        }
    }

    /***
     * 사용자의 입력으로부터 커스텀 구분자를 추출합니다.
     * @param userInput : 사용자의 입력
     * @param startIdx : 커스텀 구분자의 추출 시작 인덱스
     * @param endIdx : 커스텀 구분자의 추출 마지막 인덱스
     */
    private void extractCustomDelimiterAndAdd(String userInput, int startIdx, int endIdx) {
        delimiters.add(userInput.substring(startIdx, endIdx));
    }

    /***
     * 사용자의 입력으로부터 계산할 문자열을 추출합니다.
     * @param userInput : 사용자의 입력
     * @param startIdx : 추출 시작 인덱스
     * @return : 추출된 계산 문자열
     */
    private String extractCalculatePart(String userInput, int startIdx) {
        return userInput.substring(startIdx);
    }
}

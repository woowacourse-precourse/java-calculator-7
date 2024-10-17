package calculator.model;

public class DelimiterCalculator {

    private static final String DELIMITER_REGEX = "[,:]";

    /**
     * 커스텀 구분자 존재 여부 판단 -> 구분자에 따라 split
     *
     * @param input 사용자의 입력 값
     * @return String 배열 : 숫자
     */
    private String[] splitInput(String input) {
        if (input.startsWith("//")) {
            String[] parts = input.split("\n", 2);
            String delimiter = parts[0].substring(2);
            return parts[1].split(delimiter);
        }

        return input.split(DELIMITER_REGEX);
    }
}

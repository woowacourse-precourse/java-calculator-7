package calculator;

public class Separator {

    static final int START_OF_CUSTOM_SEPARATOR = 2;
    static final String[] DEFAULT_SEPARATOR = {",", ":"};
    String customSeparator = "";

    public String extractCustomSeparatorFrom(String input) {
        int endOfCustomSeparator = input.indexOf("\\n");

//        \\n이 없는 경우 예외 처리
        if (endOfCustomSeparator == -1) {
            throw new IllegalArgumentException("구분자는 반드시 //와 \\n 사이에 있어야 합니다.");
        }

//         커스텀 문자의 길이가 1이 아닐 경우 예외처리
        String extractedSeparator = input.substring(START_OF_CUSTOM_SEPARATOR,
            endOfCustomSeparator);
        if (extractedSeparator.length() != 1) {
            throw new IllegalArgumentException("커스텀 구분자는 하나의 문자만 가능합니다.");
        }

//        커스텀 구분자가 숫자인 경우 예외 처리
        if (Character.isDigit(extractedSeparator.charAt(0))) {
            throw new IllegalArgumentException("커스텀 구분자는 숫자가 될 수 없습니다.");
        }

        this.customSeparator = extractedSeparator;

//         커스텀 구분자 정의를 제외하고 반환
        return input.substring(endOfCustomSeparator + 2);
    }
}

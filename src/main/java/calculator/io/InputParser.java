package calculator.io;

/**
 * 문자열을 읽어 커스텀구분자 문자열과 숫자 문자열로 분리하는 역할
 */
public class InputParser {

    /**
     * 문자열을 읽어 커스텀구분자 문자열과 숫자 문자열로 분리하고, 이를 InputParseResult 객체로 반환한다.
     *
     * @param input 사용자 입력값
     * @return InputParseResult - 분리된 커스텀구분자 문자열과 숫자 문자열
     */
    public InputParseResult parse(String input) {
        InputParseResult result;
        if (input.startsWith("//")) {
            result = parseInputIncludeSeparatorPart(input);
        } else {
            result = parseInputExcludeSeparatorPart(input);
        }
        return result;
    }

    private static InputParseResult parseInputIncludeSeparatorPart(String input) {
        String numberPart;
        String customSeparatorPart;
        int separatorPartEnd = 0;
        int numberPartStart = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '\\' && i + 1 < input.length() && input.charAt(i + 1) == 'n') {
                separatorPartEnd = i;
                numberPartStart = i + 2;
                break;
            }
        }

        customSeparatorPart = input.substring(2, separatorPartEnd);
        numberPart = input.substring(numberPartStart);
        return new InputParseResult(customSeparatorPart, numberPart);
    }

    private static InputParseResult parseInputExcludeSeparatorPart(String input) {
        return new InputParseResult("", input);
    }
}

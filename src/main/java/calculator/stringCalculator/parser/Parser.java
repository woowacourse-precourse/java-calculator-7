package calculator.stringCalculator.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {

    private static final String USER_DEFINED_SPLITTER_INPUT_FORMAT = "// \\n";

    private final List<Character> splitters = new ArrayList<>(Arrays.asList(',', ':'));

    public List<Long> parse(String input) {
        List<Long> result = new ArrayList<>();
        input = tryParseUserDefinedSplitter(input);

        StringBuilder builder = new StringBuilder();
        for (char character : input.toCharArray()) {
            if (splitters.contains(character)) {
                if (!builder.isEmpty()) {
                    try {
                        result.add(Long.parseLong(builder.toString()));
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("정수로 변환할 수 없는 수");
                    }
                    builder = new StringBuilder();
                }
                continue;
            }


            if ("0123456789".contains(""+character)) {
                builder.append(character);
            } else {
                throw new IllegalArgumentException("숫자가 아닙니다.");
            }
        }

        if (!builder.isEmpty()) {
            result.add(Long.parseLong(builder.toString()));
        }

        return result;
    }

    public String tryParseUserDefinedSplitter(String input) {
        if (input.length() < USER_DEFINED_SPLITTER_INPUT_FORMAT.length()) {
            return input;
        }

        try {
            validateUserDefinedFormat(input.substring(0, USER_DEFINED_SPLITTER_INPUT_FORMAT.length()));
            splitters.add(input.charAt(2));
            return input.substring(USER_DEFINED_SPLITTER_INPUT_FORMAT.length());
        } catch (IllegalArgumentException ignored) {
            return input;
        } catch (Exception e) {
            throw new IllegalArgumentException("사용자 지정 구분자 파싱 중 에러", e);
        }
    }

    private void validateUserDefinedFormat(String input) {
        for (int i = 0; i < USER_DEFINED_SPLITTER_INPUT_FORMAT.length(); i++) {
            if (i == 2) {
                continue;
            }

            if (input.charAt(i) != USER_DEFINED_SPLITTER_INPUT_FORMAT.charAt(i)) {
                throw new IllegalArgumentException();
            }
        }
    }
}

package calculator.service;

import java.util.Arrays;

public class Separator {
    private static final String BASIC_SEPARATOR_COMMA = ",";
    private static final String BASIC_SEPARATOR_COLON = ":";


    public int[] basicSeparate(String content) {
        return Arrays.stream(
                content.replaceAll(BASIC_SEPARATOR_COLON, BASIC_SEPARATOR_COMMA).split(BASIC_SEPARATOR_COMMA)
        ).mapToInt(this::convertToNumber).toArray();
    }

    private int convertToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] Separator: 에러 메시지 추천");
        }
    }

}

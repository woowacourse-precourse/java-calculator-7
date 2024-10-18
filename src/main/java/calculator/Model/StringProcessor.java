package calculator.Model;


import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringProcessor {
    private final String input;

    public StringProcessor(String input) {
        this.input = input;
    }

    public int[] getAdditionNumbers() {
        if (input.isEmpty()) {
            return new int[]{0};
        }
        String[] separatorList = getSeparator();
        String separator = prefixSeparator(separatorList);
        String trimmedInput = trimInput();
        String[] parsedInput = parseInput(trimmedInput, separator);
        return convertToIntArray(parsedInput);

    }

    public String[] getSeparator() {
        // 구분자 정의하기
        if (hasCustomSeparator()) {
            return getCustomSeparator();
        }
        return new String[]{",", ":"};
    }

    private boolean hasCustomSeparator() {
        return input.contains("//") || input.contains("\n");
    }

    private String[] getCustomSeparator() {
        // 커스텀 구분자 추출하기
        int separatorStartIndex = getSeparatorStartIndex();
        int separatorEndIndex = getSeparatorEndIndex();

        validateCustomSeparator(separatorStartIndex, separatorEndIndex);

        return new String[]{(String) input.subSequence(separatorStartIndex, separatorEndIndex + 1)};
    }

    private String prefixSeparator(String[] separator) {
        return Arrays.stream(separator).map(Pattern::quote).collect(Collectors.joining("|"));
    }

    private int getSeparatorStartIndex() {
        return input.indexOf("//") + 2;
    }

    private int getSeparatorEndIndex() {
        return input.indexOf("\n") - 1;
    }

    private void validateCustomSeparator(int startIndex, int endIndex) {
        if (startIndex != 2 || endIndex <= 0) {
            throw new IllegalArgumentException("커스텀 구분자가 올바르게 정의되지 않았습니다.");
        }
    }

    private String[] parseInput(String trimmedInput, String separator) {
        // 계산할 숫자 리스트 생성하기
        //  - 구분자를 기준으로 입력받은 문자열 분리해서 리스트 생성하기
        return trimmedInput.split(separator);
    }

    private String trimInput() {
        if (hasCustomSeparator()) {
            return (String) input.subSequence(getSeparatorEndIndex() + 2, input.length());
        }
        return input;
    }

    private int[] convertToIntArray(String[] parsedInput) {
        // String 리스트를 Int 형으로 변경
        return Arrays.stream(parsedInput)
                .mapToInt(str -> {
                    if (str.isEmpty()) {
                        return 0;
                    }
                    int number = parseStringToInt(str);
                    validatePositive(number);
                    return number;
                }).toArray();
    }

    private int parseStringToInt(String str) {
        try {
            return Integer.parseInt(str); // 문자열을 숫자로 변환
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + str);
        }
    }

    private void validatePositive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수 값이 포함되어 있습니다: " + number);
        }
    }

}

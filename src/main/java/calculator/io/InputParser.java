package calculator.io;

public class InputParser {

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

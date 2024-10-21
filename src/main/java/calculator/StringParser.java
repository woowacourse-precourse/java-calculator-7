package calculator;

public class StringParser {

    public static String parseBr(String input) {
        return input.replace("\\n", "\n");
    }

    public static String parseOperationFormula(String input) {
        final int OPERATION_FORMULA_INDEX = 1;

        if (DelimiterType.CUSTOM.equals(new DelimiterExtractor(input).type())) {
            return input.split("\n")[OPERATION_FORMULA_INDEX];
        }

        return input;
    }
}

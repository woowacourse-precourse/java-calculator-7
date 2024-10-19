package calculator.model;

public class Formatter {
    public static int[] formatInput(String input, String delimiters) {
        input = removeCustomSetting(input, delimiters);

        String[] splitResult = input.split("[" + delimiters + "]");

        return generateFormatResult(splitResult);
    }

    private static String removeCustomSetting(String input, String delimiters) {
        if (delimiters.length() > 2) {
            input = input.substring(5);
        }
        return input;
    }

    private static int[] generateFormatResult(String[] splitResult) {
        int[] formatResult = new int[splitResult.length];
        for (int i = 0; i < formatResult.length; i++) {
            formatResult[i] = Integer.parseInt(splitResult[i]);
        }

        return formatResult;
    }
}
package calculator;

import calculator.dto.Data;

public class DataParser {
    public static Data parseData(String inputData) {

        boolean isCustom = isCustom(inputData);

        if (isCustom) {
            Validator.checkValidCustomFormat(inputData);
        }

        char[] separators = createSeparators(inputData, isCustom);
        char[] contents = createContents(inputData, isCustom);
        Validator.checkValidContents(separators, contents);
        return new Data(separators, contents);
    }

    private static char[] createSeparators(String inputData, boolean isCustom) {
        if (isCustom) {
            return getCustomSeparator(inputData);
        }
        return new char[]{',', ':'};
    }

    private static char[] createContents(String inputData, boolean isCustom) {
        if (isCustom) {
            String[] data = inputData.split("\\\\n");

            if (data.length == 1) {
                return new char[0];
            }
            String datum = data[1];
            return datum.toCharArray();
        }
        return inputData.toCharArray();
    }

    private static char[] getCustomSeparator(String inputData) {
        String[] split = inputData.split("\\\\n");
        String prefix = split[0];
        if (prefix.length() != 3) {
            throw new IllegalArgumentException();
        }
        char separator = prefix.charAt(2);
        return new char[]{separator, ':', ','};
    }


    private static boolean isCustom(String inputData) {
        return inputData.startsWith("//");
    }
}

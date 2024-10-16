package calculator;

import calculator.dto.Data;

public class DataParser {
    public static Data parseData(String inputData, boolean isCustom) throws IllegalAccessException {
        if (isCustom) {
            checkValidCustomFormat(inputData);
        }
        char[] separators = createSeparators(inputData, isCustom);
        char[] contents = createContents(inputData, isCustom);
        checkValidContents(separators, contents);
        return new Data(separators, contents);
    }

    private static void checkValidCustomFormat(String inputData) throws IllegalAccessException {
        if (!inputData.contains("\\n")) {
            throw new IllegalAccessException();
        }
        String[] splitData = inputData.split("\\\\n");
        int count = splitData.length;
        if (!(count == 1 || count == 2)) {
            throw new IllegalAccessException();
        }
    }

    private static char[] createSeparators(String inputData, boolean isCustom) throws IllegalAccessException {
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
            String contents = data[1];
            return contents.toCharArray();
        }
        return inputData.toCharArray();
    }

    private static char[] getCustomSeparator(String inputData) throws IllegalAccessException {
        String[] split = inputData.split("\\\\n");
        String prefix = split[0];
        if (prefix.length() != 3) {
            throw new IllegalAccessException();
        }
        char separator = prefix.charAt(2);
        return new char[]{separator};
    }

    private static void checkValidContents(char[] separators, char[] contents) throws IllegalAccessException {
        int index = 0;
        while (index < contents.length) {
            char c = contents[index];
            if (!(isSeparators(c, separators) || isNumber(c))) {
                throw new IllegalAccessException();
            }
            index++;
        }
    }

    private static boolean isSeparators(char c, char[] separators) {
        for (int i = 0; i < separators.length; i++) {
            if (c == separators[i]) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumber(char c) {
        if ('0' <= c && c <= '9') {
            return true;
        }
        return false;
    }
}

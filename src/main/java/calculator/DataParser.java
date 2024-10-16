package calculator;

import calculator.dto.Data;

public class DataParser {
    public static Data parseData(String inputData, boolean isCustom) throws IllegalAccessException {
        if (isCustom) {
            checkValidCustomFormat(inputData);
        }
        char[] separators = createSeparators(inputData, isCustom);
        char[] contents = new char[3];
        return new Data(separators, contents);
    }

    private static void checkValidCustomFormat(String inputData) throws IllegalAccessException {
        if (!inputData.contains("\n")) {
            throw new IllegalAccessException();
        }
    }

    private static char[] createSeparators(String inputData, boolean isCustom) throws IllegalAccessException {
        if (isCustom) {
            return getCustomSeparator(inputData);
        }
        return new char[]{',', ':'};
    }

    private static char[] getCustomSeparator(String inputData) throws IllegalAccessException {
        int count = 0;
        int index = 1;
        char[] arr = inputData.toCharArray();

        while (arr[index] != '\n') {
            count++;
            index++;
        }
        if (count != 1) {
            throw new IllegalAccessException();
        }
        return new char[]{arr[--index]};
    }
}

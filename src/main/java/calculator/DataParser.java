package calculator;

import calculator.dto.Data;

public class DataParser {
    public static DataParser parseData(String inputData, boolean isCustom) throws IllegalAccessException {
        if (isCustom) {
            checkValidCustomFormat(inputData);
        }
        return new Data();
    }

    private static void checkValidCustomFormat(String inputData) throws IllegalAccessException {
        if (!inputData.contains("\n")) {
            throw new IllegalAccessException();
        }
    }
}

package calculator;

import calculator.dto.Data;

public class DataParser {

    private static final String regex = "\\\\n";

    public static Data parseData(String inputData) {

        boolean isCustom = isCustom(inputData);

        if (isCustom) {
            Validator.checkValidCustomFormat(inputData);
        }

        char[] separators = createSeparators(inputData, isCustom);
        char[] contents = createContents(inputData, isCustom);
        Validator.checkValidContents(separators, contents);

        String contentsString = getContentString(contents, separators);
        String separatorsString = getSeparatorsString(separators);
        return new Data(separatorsString, contentsString);
    }

    private static char[] createSeparators(String inputData, boolean isCustom) {
        if (isCustom) {
            return getCustomSeparator(inputData);
        }
        return new char[]{',', ':'};
    }

    private static char[] createContents(String inputData, boolean isCustom) {
        if (isCustom) {
            String[] data = inputData.split(regex);
            if (data.length == 1) {
                return new char[]{'0'};
            }
            String datum = data[1];
            return datum.toCharArray();
        }
        if (inputData.isEmpty()) {
            return new char[]{'0'};
        }
        return inputData.toCharArray();
    }

    private static char[] getCustomSeparator(String inputData) {
        String[] split = inputData.split(regex);
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

    private static String getContentString(char[] contents, char[] separator) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        if (isSeparator(contents[0], separator)) {
            index = 1;
        }
        for (int i = index; i < contents.length; i++) {
            sb.append(contents[i]);
        }
        return sb.toString();
    }

    private static String getSeparatorsString(char[] separators) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < separators.length - 1; i++) {
            sb.append(separators[i]);
        }
        char lastElement = separators[separators.length - 1];
        sb.append(lastElement);
        return "[" + sb.toString() + "]";
    }

    private static boolean isSeparator(char c, char[] separator) {
        for (int i = 0; i < separator.length; i++) {
            if (c == separator[i]) {
                return true;
            }
        }
        return false;
    }
}

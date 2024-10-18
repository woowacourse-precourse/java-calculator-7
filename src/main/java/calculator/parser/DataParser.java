package calculator.parser;

import calculator.dto.Data;

public interface DataParser {

    boolean isSupport(String inputData);

    Data parseData(String inputData);

    default String getContentString(char[] contents, char[] separator) {
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

    default String getSeparatorsString(char[] separators) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < separators.length - 1; i++) {
            sb.append(separators[i]);
        }
        char lastElement = separators[separators.length - 1];
        sb.append(lastElement);
        return "[" + sb + "]";
    }

    default boolean isSeparator(char c, char[] separator) {
        for (int i = 0; i < separator.length; i++) {
            if (c == separator[i]) {
                return true;
            }
        }
        return false;
    }
}

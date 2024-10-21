package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Unify {

    private static String expression;
    private static List<String> delimiters;

    public static void setting (String essential, List<String> elements) {
        expression = essential;
        delimiters = new ArrayList<>(elements);
    }

    public static String allDelimiters (String essential, List<String> delimiters) {
        setting(essential, delimiters);
        for (String delimiter : delimiters) {
            expression = unifyDelimiter(delimiter);
        }
        return expression;
    }

    private static String unifyDelimiter (String delimiter) {
        return expression.replaceAll(delimiter,delimiters.getFirst());
    }
}

package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Parser {

    private static final String CUSTOM = "custom";
    private static final String DEFAULT = "default";
    private static final String PREFIX_CUSTOM_START = "//";
    private static final String WRONG_INPUT_MESSAGE = "잘못된 입력입니다.";

    public static List<Integer> parse(String input) {
        List<Integer> list = new ArrayList<>();
        String type = checkType(input);

        if (type.equals(CUSTOM)) {
            Validator.validateCustomSeparator(input);
        }

        String separators = getSeparator(input, type);
        String contents = getNumberString(input, type);

        StringTokenizer st = new StringTokenizer(contents, separators);
        appendNumbers(st, list);
        return list;
    }

    public static String getSeparatorString(String input) {
        int separatorIdx = getLastSeparatorIdx(input);
        char[] customSeparatorArr = new char[separatorIdx];
        for (int i = 0; i < separatorIdx; i++) {
            customSeparatorArr[i] = input.charAt(i);
        }
        return new String(customSeparatorArr);
    }

    private static String checkType(String input) {
        if (input.startsWith(PREFIX_CUSTOM_START)) {
            return CUSTOM;
        }
        return DEFAULT;
    }

    private static String getSeparator(String input, String type) {
        List<String> separators = new ArrayList<>();
        separators.add(",");
        separators.add(":");

        if (type.equals(DEFAULT)) {
            Validator.isCorrectDefaultInput(input);
            return String.join("", separators);
        }
        Validator.validateCustomSeparator(input);
        appendCustomSeparators(separators, input);
        return String.join("", separators);
    }

    private static void appendNumbers(StringTokenizer st, List<Integer> list) {
        try {
            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                list.add(num);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WRONG_INPUT_MESSAGE);
        }
    }

    private static void appendCustomSeparators(List<String> separators, String input) {
        String separatorString = getSeparatorString(input);
        for (int i = 0; i + 4 < separatorString.length(); i++) {
            String newCustomSeparator = String.valueOf(separatorString.charAt(i + 2));
            separators.add(newCustomSeparator);
            separatorString = separatorString.substring(i + 4);
        }
    }

    private static String getNumberString(String input, String type) {
        String contents = input;
        if (type.equals(CUSTOM)) {
            int startIdx = getLastSeparatorIdx(input);
            contents = input.substring(startIdx);
        }
        return contents;
    }

    private static int getLastSeparatorIdx(String input) {
        int idx = input.length() - 1;
        while (idx >= 1 && (input.charAt(idx) != 'n' || input.charAt(idx - 1) != '\\')) {
            idx--;
        }
        return idx + 1;
    }
}
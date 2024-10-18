package calculator;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    private static final String CUSTOM = "custom";
    private static final String DEFAULT = "default";

    public static List<String> parse(String input) {
        List<String> separators = new ArrayList<>();
        separators.add(",");
        separators.add(":");

        String type = checkInput(input);
        if (type.equals(DEFAULT)) {
            return separators;
        }
        addCustomSeparators(separators, input);
        return separators;
    }

    public static void addCustomSeparators(List<String> separators, String input) {
        System.out.println(separators);
        String separatorString = getSeparatorString(input);
        for (int i = 0; i + 4 < separatorString.length(); i++) {
            String newCustomSeparator = String.valueOf(separatorString.charAt(i + 2));
            separators.add(newCustomSeparator);
            separatorString = separatorString.substring(i + 4);
        }
    }


    public static String checkInput(String input) {

        if (hasCustomSeparator(input)) {
            return CUSTOM;
        } else {
            return DEFAULT;
        }
    }

    public static boolean hasCustomSeparator(String input) {
        if (input.startsWith("//")) {
            String separator = getSeparatorString(input);
            if (validateCustomSeparatorForm(separator)) {
                return true;
            } else {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }
        return false;
    }

    public static String getSeparatorString(String input) {
        int separatorIdx = getLastSeparatorIdx(input);
        char[] customSeparatorArr = new char[separatorIdx];
        for (int i = 0; i < separatorIdx; i++) {
            customSeparatorArr[i] = input.charAt(i);
        }
        String str = new String(customSeparatorArr);
        return str;
    }

    public static int getLastSeparatorIdx(String input) {
        int idx = 1;
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                if (input.charAt(i - 1) != 'n') {
                    idx--;
                }
                break;
            } else {
                idx++;
            }
        }
        return idx;
    }

    public static boolean validateCustomSeparatorForm(String input) {
        return isCorrectPair(input);
    }

    public static boolean isCorrectPair(String input) {
        int startPair = 0;
        int lastPair = 0;
        int flag = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '/' && input.charAt(i + 1) == '/') {
                if (i + 4 >= input.length()) {
                    return false;
                }
                if (!isCorrectLastElement(input, i + 3)) {
                    return false;
                }
                startPair++;
                flag = 1;
                i++;
            }
            if (input.charAt(i) == '\\' && input.charAt(i + 1) == 'n') {
                if (flag == 0) {
                    return false;
                }
                lastPair++;
                flag = 0;
                i++;
            }
        }
        if ((startPair == lastPair) && startPair != 0) {
            return true;
        }
        throw new IllegalArgumentException();
    }

    public static boolean isCorrectLastElement(String input, int idx) {
        if (input.charAt(idx) == '\\' && input.charAt(idx + 1) == 'n') {
            return true;
        }
        return false;
    }
}

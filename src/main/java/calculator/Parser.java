package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Parser {

    private static final String CUSTOM = "custom";
    private static final String DEFAULT = "default";

    public static List<String> parse(String input) {
        List<String> separators = new ArrayList<>();
        separators.add(",");
        separators.add(":");

        String type = checkInput(input);
        if (type.equals(DEFAULT)) {
            if (!(isCorrectInput(input))) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
            return separators;
        }
        if (!validateCustomSeparatorForm(input)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        addCustomSeparators(separators, input);
        return separators;
    }

    private static boolean isCorrectInput(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!(input.charAt(i) == ',' || input.charAt(i) == ':' || isNumber(input.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    private static void addCustomSeparators(List<String> separators, String input) {
        System.out.println(separators);
        String separatorString = getSeparatorString(input);
        for (int i = 0; i + 4 < separatorString.length(); i++) {
            String newCustomSeparator = String.valueOf(separatorString.charAt(i + 2));
            separators.add(newCustomSeparator);
            separatorString = separatorString.substring(i + 4);
        }
        System.out.println("separators = " + separators);
    }

    private static String checkInput(String input) {

//        if (hasCustomSeparator(input)) {
//            return CUSTOM;
//        } else {
//            return DEFAULT;
//        }
        if (input.startsWith("//")) {
            return CUSTOM;
        }
        return DEFAULT;
    }

    private static boolean hasCustomSeparator(String input) {
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

    public static String getNumberString(String input) {
        String contents;
        if (hasCustomSeparator(input)) {
            int startIdx = getLastSeparatorIdx(input);
            contents = input.substring(startIdx);
        } else {
            contents = input;
        }
        return contents;
    }

    private static String startWithNumberString(String input) {
        String numberString = input;
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                numberString = numberString.substring(i);
                return numberString;
            }
        }
        return numberString;
    }

    public static int[] getNumbers(String input, List<String> separators) {
        String contents = startWithNumberString(input);
        StringTokenizer st = new StringTokenizer(contents, separators.toString());
        int tokenCount = st.countTokens();
        int[] numbers = new int[tokenCount];
        for (int i = 0; i < tokenCount; i++) {
            try {
                numbers[i] = Integer.parseInt(st.nextToken());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("정수형의 최대 범위를 초과하였습니다.");
            }
        }
        return numbers;
    }

    private static String getSeparatorString(String input) {
        int separatorIdx = getLastSeparatorIdx(input);
        char[] customSeparatorArr = new char[separatorIdx];
        for (int i = 0; i < separatorIdx; i++) {
            customSeparatorArr[i] = input.charAt(i);
        }
        String str = new String(customSeparatorArr);
        return str;
    }

    private static int getLastSeparatorIdx(String input) {
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

    private static boolean validateCustomSeparatorForm(String input) {
        return isCorrectPair(input);
    }

    private static boolean isCorrectPair(String input) {
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
        return false;
    }

    private static boolean isCorrectLastElement(String input, int idx) {
        if (input.charAt(idx) == '\\' && input.charAt(idx + 1) == 'n') {
            return true;
        }
        return false;
    }
}

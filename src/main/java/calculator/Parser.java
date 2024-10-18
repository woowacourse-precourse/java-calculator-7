package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Parser {

    private static final String CUSTOM = "custom";
    private static final String DEFAULT = "default";

    public static List<Integer> parse(String input) {
        List<Integer> list = new ArrayList<>();
        String type = checkType(input);
        if (type.equals(CUSTOM)) {
            Validation.checkCustomSeparator(input);
        }
        String separators = getSeparator(input);
        String contents = getNumberString(input);

        StringTokenizer st = new StringTokenizer(contents, separators);
        try {
            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                list.add(num);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return list;
    }

    private static String checkType(String input) {
        if (input.startsWith("//")) {
            return CUSTOM;
        }
        return DEFAULT;
    }

    public static String getSeparator(String input) {
        List<String> separators = new ArrayList<>();
        separators.add(",");
        separators.add(":");

        String type = checkInputV2(input);
        if (type.equals(DEFAULT)) {
            if (!(isCorrectInput(input))) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
            return listToString(separators);
        }
        if (!Validation.isCorrectCustomSeparatorForm(input)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        addCustomSeparators(separators, input);

        return listToString(separators);

    }

    private static String listToString(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        return sb.toString();
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

    public static String checkInputV2(String input) {
        if (input.startsWith("//")) {
            return CUSTOM;
        }
        return DEFAULT;
    }

    private static boolean hasCustomSeparator(String input) {
        if (input.startsWith("//")) {
            String separator = getSeparatorString(input);
            if (Validation.isCorrectCustomSeparatorForm(separator)) {
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
}
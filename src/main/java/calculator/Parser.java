package calculator;

public class Parser {

    public static void checkInput(String input) {
        if (hasCustomSeparator(input)) {
            int count = countCustomSeparator(input);
            System.out.println("통과");
        } else {
            System.out.println("기본 구분자");
        }
    }

    public static boolean hasCustomSeparator(String input) {
        if (input.startsWith("//")) {
            String upToSeparator = stringUpToCustomSeparator(input);
            if (isCorrectCustomSeparatorForm(upToSeparator)) {
                return true;
            } else {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }
        return false;
    }

    public static String stringUpToCustomSeparator(String input) {
        int separatorIdx = checkSeparatorIdx(input);
        char[] customSeparatorArr = new char[separatorIdx];
        for (int i = 0; i < separatorIdx; i++) {
            customSeparatorArr[i] = input.charAt(i);
            System.out.println("input.charAt(i) = " + input.charAt(i));
        }
        String str = new String(customSeparatorArr);
        System.out.println("str = " + str);
        return str;
    }

    public static int checkSeparatorIdx(String input) {
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

    public static boolean isCorrectCustomSeparatorForm(String input) {
        if (isCorrectPair(input)) {
            System.out.println(input);
            return true;
        }
        return false;
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
                if (!isCorrectPairLast(input, i + 3)) {
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

    public static boolean isCorrectPairLast(String input, int idx) {
        if (input.charAt(idx) == '\\' && input.charAt(idx + 1) == 'n') {
            return true;
        }
        return false;
    }

    public static int countCustomSeparator(String input) {
        int count = 0;
        return count;
    }

}

package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Application {
    static StringBuilder delim = new StringBuilder(",:");

    public static void main(String[] args) {
        final String input = input();
        if (input.isEmpty()) {
            System.out.println("결과 : 0");
            return;
        }
        List<String> tokens = new ArrayList<>();

        System.out.println("결과 : " + calculateSum(input, tokens));
    }

    private static String input() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    private static void splitInput(String input, List<String> tokens) {
        if (input == null || input.isEmpty()) {
            return;
        }

        StringTokenizer st = new StringTokenizer(input, delim.toString());
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (isNumber(token)) { // 토큰이 숫자 타입인지 확인
                tokens.add(token);
            } else if (token.contains("//") && token.contains("\\n")) { // 커스텀 구분자 등록
                String[] customArray = token.split("//");
                if (!customArray[0].isEmpty() && isNumber(customArray[0])) { // 숫자가 먼저 나온 경우 ex. 1,2//;\n1,2;3
                    tokens.add(customArray[0]);
                }
                customArray = customArray[1].split("\\\\n"); // \n 문자 그대로 분리
                registerDelim(customArray);
                splitInput(customArray[1], tokens); // 재귀 호출로 토큰 분리
            } else if (isDelimIn(token)) { // 커스텀 구분자 등록 후 기본 구분자 다음에 나오는 토큰 ex. 1,2//;\n1,2;3
                splitInput(token, tokens);
            } else {  // 음수 혹은, 기본 구분자와 커스텀 구분자가 아닌 문자열
                throw new IllegalArgumentException("입력 문자열에 허용되지 않는 문자열이 포함되어 있습니다. (ex. 음수, 기본 지정자와 커스텀 지정자 외의 문자)");
            }
        }
    }

    private static void registerDelim(String[] customArray) {
        if (customArray[0].length() == 1) {
            delim.append(customArray[0]);
        } else {
            throw new IllegalArgumentException("커스텀 구분자는 문자 하나만 등록 가능합니다.");
        }
    }

    private static boolean isNumber(String str) {
        try {
            long l = Long.parseLong(str);
            return l > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isDelimIn(String token) {
        char[] delims = delim.toString().toCharArray();
        for (int i = delims.length - 1; i >= 0; i--) {
            if (token.contains(delims[i] + "")) {
                return true;
            }
        }
        return false;
    }

    private static String calculateSum(String input, List<String> tokens) {
        splitInput(input, tokens);
        return add(tokens);
    }

    private static String add(List<String> tokens) { // overflow 막기 위해 토큰의 문자를 숫자로 변환한 뒤 덧셈
        int max_len = 0;
        for (String token : tokens) {
            if (token.length() > max_len) {
                max_len = token.length();
            }
        }
        int[] a = stringToIntArray(tokens.get(0), max_len);

        for (int i = 1; i < tokens.size(); i++) {
            String token = tokens.get(i);
            int[] b = stringToIntArray(token, max_len);
            addArrays(a, b, token.length());
        }
        return getReversedResult(a);
    }

    private static int[] stringToIntArray(String token, int max_len) {
        int[] array = new int[max_len + 1];
        for (int i = token.length() - 1, idx = 0; i >= 0; i--, idx++) {
            array[idx] = token.charAt(i) - '0';
        }
        return array;
    }

    private static void addArrays(int[] a, int[] b, int min_len) {
        for (int i = 0; i < a.length; i++) {
            int value = a[i] + b[i];
            a[i] = value % 10;
            if (value > 9) {
                a[i + 1] = a[i + 1] + 1;
            } else {
                if (i > min_len) {
                    break;
                }
            }
        }
    }

    private static String getReversedResult(int[] a) {
        StringBuilder result = new StringBuilder();
        int last = a.length - 1;
        if (a[last] != 0) { // 마지막 올림수
            result.append(a[last]);
        }
        for (int i = last - 1; i >= 0; i--) {
            result.append(a[i]);
        }
        return result.toString();
    }
}


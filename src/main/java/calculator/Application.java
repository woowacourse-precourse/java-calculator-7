package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Application {
    static StringBuilder delim = new StringBuilder(",:");
    static final String input = input();
    static List<String> tokens;
    static List<Long> nums;

    public static void main(String[] args) {
        if (input.isEmpty()) {
            System.out.println("결과 : 0");
            return;
        }
        tokens = new ArrayList<>();
        nums = new ArrayList<>();

        System.out.println("결과 : " + calculateSum());
    }

    private static String input() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    private static void splitInput(String input) {
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
                if (!customArray[0].isEmpty()) {
                    tokens.add(customArray[0]);
                }
                customArray = customArray[1].split("\\\\n"); // \n 문자 그대로 분리
                delim.append(customArray[0]);
                splitInput(customArray[1]);
            } else if (isDelimIn(token)) { // 커스텀 구분자 등록 후 기본 구분자 다음에 나오는 토큰 ex. 1,2//;\n1,2;3
                splitInput(token);
            } else {  // 음수 혹은, 기본 구분자와 커스텀 구분자가 아닌 문자열
                throw new IllegalArgumentException("입력 문자열에 허용되지 않는 문자열이 포함되어 있습니다. (ex. 음수, 기본 지정자와 커스텀 지정자 외의 문자)");
            }
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

    private static long calculateSum() {
        splitInput(input);
        strToNumber();
        long result = 0L;
        for (Long num : nums) {
            result += num;
        }
        return result;
    }


    private static void strToNumber() {
        for (String token : tokens) {
            nums.add(Long.parseLong(token));
        }
    }
}


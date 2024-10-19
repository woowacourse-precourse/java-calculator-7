package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class Application {
    static String delimeter = ",|:";
    static String inputExpression;

    static int hasCustom(String str) {
        int start = str.indexOf("//");
        return start;
    }

    static void registerCustom(String str) {
        int customStart = hasCustom(str);
        for (int i = customStart + 2; i < str.length() - 2; i++) {
            if (str.startsWith("\\n", i)) {
                String tmp = str.substring(customStart + 2, i);
                for (int j = 0; j < tmp.length(); j++) {
                    delimeter += "|\\" + tmp.charAt(j);
                }
                inputExpression = inputExpression.substring(i + 2);
                break;
            }
        }
    }

    public static void main(String[] args) {
        // 입력
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        inputExpression = Console.readLine();

        // 구분자 등록
        if (hasCustom(inputExpression) != -1) {
            registerCustom(inputExpression);
        }

        // 구분자로 문자열 자르기
        String[] numbers = inputExpression.split(delimeter);

        // 추출된 숫자들의 합 구하기
        int cnt = 0;
        for (String nowStr : numbers) {
            String REGEXP_ONLY_NUM = "^[\\d]*$";
            if (!Pattern.matches(REGEXP_ONLY_NUM, nowStr)) {
                throw new IllegalArgumentException();
            }
            if (nowStr.equals("")) {
                continue;
            }
            int nowInt = Integer.parseInt(nowStr);
            if (nowInt <= 0) {
                throw new IllegalArgumentException();
            }
            cnt += nowInt;
        }

        // 결과 출력
        System.out.println("결과 : " + cnt);
    }
}


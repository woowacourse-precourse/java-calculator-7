package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 1. 입력
        String str = Console.readLine();
        String[] seperator = new String[1];

        // 문자열 처리 - 숫자 분리
        String[] result = getSepAndStringArr(str, seperator);

        int[] resultInt = forStringToIntArray(result);
        int sum = sumIntArr(resultInt);

        System.out.println("결과 : " + sum);
    }

    // Input Processing
    public static String[] getSepAndStringArr(String input, String[] seperator) {
        // 2. 커스텀 구분자
        // 커스텀 구분자 하면 기존 구분자는 무시하기로 하였음
        String regex = "//(.*?)\\\\n";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            seperator[0] = matcher.group(1);
            return input.substring(matcher.end()).split(seperator[0]);
        }
        // 3. 기본 구분자
        else {
            seperator[0] = "[,:]";
            return input.split(seperator[0]);
        }
    }

    // 문자열 To 숫자열
    public static int[] forStringToIntArray(String[] strArr) {
        int[] result = new int[strArr.length];
        try {
            for (int i = 0; i < strArr.length; i++) {
                result[i] = Integer.parseInt(strArr[i]);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        return result;
    }

    // 양수 검증
    public static boolean isPositive(int[] intArr) {
        for (int i : intArr) {
            if (i <= 0) {
                throw new IllegalArgumentException();
            }
        }
        return true;
    }

    // Sum
    public static int sumIntArr(int[] intArr) {
        int sum = 0;
        if (isPositive(intArr)) {
            for (int i : intArr) {
                sum += i;
            }
        }
        return sum;
    }
}

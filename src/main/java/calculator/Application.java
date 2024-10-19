package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 1. 입력
        String str = Console.readLine();
        String seperator;
        boolean isBasic;

        // 2. 커스텀 구분자
        // 커스텀 구분자 하면 기존 구분자는 무시하기로 하였음
        String regex = "//(.*?)\\\\n";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        if (matcher.find()) {
            seperator = matcher.group(1);
            str = str.substring(matcher.end());
            isBasic = false;
        }
        // 3. 기본 구분자
        else {
            seperator = "[,:]";
            isBasic = true;
        }

        // 4. 문자열 처리 - 숫자 분리
        String[] result = str.split(seperator);

        int[] resultInt = forStringToIntArray(result);
        int sum = 0;

        if (isPositive(resultInt)) {
            for (int i : resultInt) {
                sum += i;
            }
        } else {
            throw new IllegalArgumentException();
        }

        System.out.println("결과 : " + sum);
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
                return false;
            }
        }
        return true;
    }

//    public static
}

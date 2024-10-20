package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    static final String CUSTOM_DELIMITER = "//(.)\\\\n(.*)";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int sum = 0;

        System.out.println("덧셈할 문자열을 입력해주세요.");
        String numbersStr = Console.readLine();

        if (numbersStr == null || numbersStr.isEmpty()) {
            System.out.println("결과 : " + 0);
        }else {
            if (numbersStr.matches(CUSTOM_DELIMITER)) {
                sum = customDelimiterSum(numbersStr);
            } else{
                sum = delimiterSum(numbersStr);
            }
            System.out.println("결과 : " + sum);
        }
    }

    // 기본 구분자
    public static int delimiterSum(String numbersStr) {
        int sum = 0;
        final String DELIMITER = ",|:";

        // 정규 표현식 패턴 컴파일
        Pattern pattern = Pattern.compile(DELIMITER);
        Matcher matcher = pattern.matcher(numbersStr);

        // - 지정 구분자로 분리
        if (matcher.find()) {
            String[] numbersArr = numbersStr.split(DELIMITER);
            if (validNumber(numbersArr)) {
                int[] num = Arrays.stream(numbersArr).mapToInt(Integer::parseInt).toArray();
                for (int i : num) {
                    sum += i;
                }
            }
        } else {
            isValidNumber(numbersStr);
            sum = Integer.parseInt(numbersStr);
        }
        return sum; //
    }

    // 커스텀 구분자
    public static int customDelimiterSum(String numbersStr){
        int sum = 0;

        Matcher customMatcher = Pattern.compile(CUSTOM_DELIMITER).matcher(numbersStr);
        if (customMatcher.find()) {
            String customDelimiter = customMatcher.group(1);
            String[] numbersArr = customMatcher.group(2).split(customDelimiter);

            if (validNumber(numbersArr)) {
                int[] numberSum = Arrays.stream(numbersArr).mapToInt(Integer::parseInt).toArray();
                for (int i : numberSum) {
                    sum += i;
                }
            }
        }
        return sum;
    }

    private static boolean isValidNumber(String numbersStr) {
        String numRegEx = "^[0-9]+$";

        Pattern patternNum = Pattern.compile(numRegEx);
        Matcher matcherNum = patternNum.matcher(numbersStr);

        if (!matcherNum.matches()){
            throw new IllegalArgumentException();
        }
        if (Integer.parseInt(numbersStr) < 0){
            throw new IllegalArgumentException();
        }
        return true;
    }

    public static boolean validNumber(String[] numbersArr) {
        String numRegEx = "^[0-9]+$";

        Pattern patternNum = Pattern.compile(numRegEx);

        for (String number : numbersArr){
            Matcher matcherNum = patternNum.matcher(number.trim());

            if (!matcherNum.matches()){
                throw new IllegalArgumentException();
            }
            if (Integer.parseInt(number.trim()) < 0){
                throw new IllegalArgumentException();
            }
        }
        return true;
    }
}

package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int sum = 0;

         // 문자열 입력
         // - 안내문 출력
        System.out.println("덧셈할 문자열을 입력해주세요.");
        // - 입력 받기
        String numbers = Console.readLine();

        // - 예외처리
        if (numbers == null || numbers.isEmpty()) {
            System.out.println("결과: " + 0);
        }else {
            if (numbers.startsWith("//")){
                sum = customDelimiterSum(numbers);
            } else{
                sum = delimiterSum(numbers);
            }
        }
        System.out.println("결과: " + sum);
    }

    // 기본 구분자
    public static int delimiterSum(String numbers) {
        int sum = 0;
        final String DELIMITER = ",|:";

        // 정규 표현식 패턴 컴파일
        Pattern pattern = Pattern.compile(DELIMITER);
        Matcher matcher = pattern.matcher(numbers);
        // -- 숫자와 구분자만 포함하는지 판단
        // - 지정 구분자로 분리
        if (matcher.find()) {
            if (isValidNumber(numbers)) {
                String[] splitNumbers = numbers.split(DELIMITER);
                int[] num = Arrays.stream(splitNumbers).mapToInt(Integer::parseInt).toArray(); //형변환
                for (int i : num) { // 계산 기능 구현
                    sum += i;
                }
            }
        }
        return sum;
    }

    // 커스텀
    public static int customDelimiterSum(String numbers){
        int sum = 0;
        final String CUSTOM_DELIMITER = "//(.)\n(.*)";

        Matcher customMatcher = Pattern.compile(CUSTOM_DELIMITER).matcher(numbers);
        if (customMatcher.find()) {
            String customDelimiter = customMatcher.group(1);
            String[] splitCustom = customMatcher.group(2).split(customDelimiter);

            if (isValidNumber(numbers)) {
                int[] numberSum = Arrays.stream(splitCustom).mapToInt(Integer::parseInt).toArray();
                for (int i : numberSum) {
                    sum += i;
                }
            }
        }
        return sum;
    }

    //숫자인지 확인
    public static boolean isValidNumber(String numbers) {
        String numRegEx = "[0-9]+"; // 문자 형태의 숫자를 검토해야하는 거였음

        Pattern patternNum = Pattern.compile(numRegEx);
        Matcher matcherNum = patternNum.matcher(numbers);
        return matcherNum.find();
    }
}

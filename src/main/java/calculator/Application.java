package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    public static final String DELIMITER_PATTERN = "//(.)\\\\n(.*)";
    public static void main(String[] args) {
        String input = Console.readLine(); //문자열 입력받기.
        if (input == null || input.trim().isEmpty()) { // 사용자 입력이 null이거나 ""일 경우
            System.out.println(0);
        } else {
            String[] numbers = splitNumbers(input); // 구분자로 구분한 후 추출한 숫자
            System.out.println(calculateSum(numbers));
        }
    }

    public static String extractDelimiter(String input){ // "//(.)\\\\n(.*)" 패턴에서 구분자 추출하여 반환.
        Pattern pattern = Pattern.compile(DELIMITER_PATTERN);
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()){
            return matcher.group(1);
        }
        return null;
    }

    public static String[] splitNumbers(String input){ // 구분자를 기준을 문자로된 숫자 추출 후 반환.
        String delimiters = ",:"; // 기본 구분자
        String customDelimiter = extractDelimiter(input); // 커스텀 구분자 추출
        if(customDelimiter != null){ // 커스텀 구분자 존재시 기본 구분자에 추가
            delimiters += customDelimiter;
            input = input.substring(5); //커스텀 구분자 패턴 삭제
        }
        return input.split("[" + delimiters + "]");
    }

    public static int calculateSum(String[] numbers){ // 문자열 배열의 숫자를 int로 변환후 sum에 합하여 반환.
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
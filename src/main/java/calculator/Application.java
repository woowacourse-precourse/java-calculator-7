package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    public static final String CUSTOM_DELIMITER_PATTERN = "^//(.)\\\\n*";
    public static void main(String[] args) {
        String input = Console.readLine(); //문자열 입력받기.
        System.out.println(processCalculation(input));
    }

    public static int processCalculation(String input){ //주어진 입력문자열 처리하여 숫자의 합 반환.
        Matcher matcher = hasCustomDelimiter(input);
        String[] numbers;
        if(matcher != null){ //커스텀 구분자가 있을 경우
            numbers = splitNumbers(input, matcher);
        } else{ // 커스텀 구분자가 없을 경우
            numbers = splitNumbers(input);
        }
        return calculateSum(numbers);
    }

    public static Matcher hasCustomDelimiter(String input){ // "^//(.)\\\\n(.*)" 패턴이 있을 시 Matcher반환.
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_PATTERN);
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()){
            return matcher;
        }
        return null;
    }

    public static String[] splitNumbers(String input){ // 구분자를 기준으로 숫자로된 문자열 배열 반환.
        String delimiters = ",:"; // 기본 구분자
        return input.split("[" + delimiters + "]");
    }

    public static String[] splitNumbers(String input, Matcher matcher){ // 구분자 + 커스텀 구분자를 기준으로 숫자로된 문자열 배열 반환.
        String delimiters = ",:"; // 기본 구분자
        delimiters += matcher.group(1); // 커스텀 구분자 추가
        input = input.substring(5); // 커스텀 구분자 패턴 제거
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
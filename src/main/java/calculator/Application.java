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

    public static int processCalculation(String input){ // 주어진 입력문자열 처리하여 숫자의 합 반환.
        if(inputIsEmpty(input)){ // 입력이 "" 이면 0반환.
            return 0;
        }
        String[] validatedInput;
        try{
            validatedInput = validateAndPrepareInput(input); // 사용자 입력 유효성 검사 및 전처리
        } catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
            return 0;
        }
        String preparedInput = validatedInput[0]; // 유효성 검사 및 전처리 완료된 input
        String delimiters = validatedInput[1]; // 전처리 완료된 구분자
        String[] numbers = splitNumbers(preparedInput, delimiters);
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


    public static String[] splitNumbers(String input, String delimiters){ // 구분자 + 커스텀 구분자를 기준으로 숫자로된 문자열 배열 반환.
        return input.split("[" + delimiters + "]");
    }

    public static int calculateSum(String[] numbers){ // 문자열 배열의 숫자를 int로 변환후 sum에 합하여 반환.
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }

    public static String[] validateAndPrepareInput(String input){ // 사용자 입력 유효성 검사 및 전처리
        Matcher matcher = hasCustomDelimiter(input);
        String delimiter = ",|:"; // 기본 구분자
        if(matcher != null){ //커스텀 구분자가 있을시
            delimiter += "|" + matcher.group(1); // 커스텀 구분자 추가
            input = input.substring(5); // 커스텀 구분자 패턴 제거
            validatePattern(input, delimiter); // 유효성 검사
            return new String[]{input,delimiter.replace("|","")};
        }
        validatePattern(input, delimiter); // 유효성 검사
        return new String[]{input,delimiter.replace("|","")};
    }

    public static void validatePattern(String input, String delimiter){ // 입력 패턴 유효성 검사
        String pattern = "^[0-9]+([" + delimiter + "][0-9]+)*$";
        if(!input.matches(pattern)){ // 유효하지 않을시 예외 발생
            throw new IllegalArgumentException("IllegalArgumentException");
        }
    }

    public static boolean inputIsEmpty(String input){ // 사용자 입력이 "" 인지 판단
        return input == null || input.trim().isEmpty();
    }
}
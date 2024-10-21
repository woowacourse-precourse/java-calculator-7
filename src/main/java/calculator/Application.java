package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    private static final String NEGATIVE_NUMBER_EXCEPTION_MESSAGE = "숫자는 양수 값이어야 합니다.";
    private static final String INPUT_VALIDATION_EXCEPTION_MESSAGE = "입력값 오류입니다.";
    private static final String COMMA = ",";
    private static final String SEMICOLON = ";";
    private static final String CUSTOM_DELIMITER_START_STR = "//";
    private static final String CUSTOM_DELIMITER_END_STR = "\\n";


    static List<Long> numberList;

    public static void inputMessage(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        inputParser(input);
    }

    public static void inputParser(String input){
        try {
            numberList = new ArrayList<>();
//            커스텀 구분자 여부 체크
            String delimiter;
            if(input.startsWith(CUSTOM_DELIMITER_START_STR)) {
                input = input.substring(2);
                delimiter = customDelimiter(input);
                int idx = input.indexOf(CUSTOM_DELIMITER_END_STR);
                input = input.substring(idx + 2);
            }
            else delimiter = parserDelimiter(input);
            String[] inputArray = input.split(delimiter);
            Arrays.stream(inputArray).forEach(s -> {
                try {
                    System.out.println("현재 값 : " + Long.valueOf(s));
                    numberList.add(Long.valueOf(s));
                }catch (NumberFormatException e){
                    throw new IllegalArgumentException(INPUT_VALIDATION_EXCEPTION_MESSAGE);
                }
            });
            negativeCheck();
        }   catch (Exception e){
            throw new IllegalArgumentException(INPUT_VALIDATION_EXCEPTION_MESSAGE);
        }
    }

    public static String customDelimiter(String input){
//        ||와 \n 사이에 커스텀 구분자가 있는 경우
        int idx = input.indexOf(CUSTOM_DELIMITER_END_STR);
        if(idx > 0){
            return input.substring(0, idx);
        }
        throw new IllegalArgumentException(INPUT_VALIDATION_EXCEPTION_MESSAGE);
    }

    public static String parserDelimiter(String input){
        inputCheck(input);
        return input.contains(SEMICOLON)?SEMICOLON:COMMA;
    }

    public static String inputCheck(String input){
//        잘 못 된 입력 체크
        if(!input.contains(SEMICOLON) && !input.contains(COMMA)) throw new IllegalArgumentException(INPUT_VALIDATION_EXCEPTION_MESSAGE);
        return input;
    }

    public static void negativeCheck(){
        for(Long l: numberList){
            if(l <= 0) throw new IllegalArgumentException(NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    public static void printResult(long value){
        System.out.println("결과 : " + value);
    }

    public static long plus(){
        return numberList
                .stream()
                .mapToLong(l -> l)
                .sum();
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        inputMessage();
        printResult(plus());
    }
}

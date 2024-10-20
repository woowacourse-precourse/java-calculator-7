package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    private static final String CUSTOM_SEPARATOR_START = "//";
    private static final String CUSTOM_SEPARATOR_END = "\\n";
    private static String userInput;
    private static String baseSeparator = ",:";

    public static void main(String[] args) {
        run();
    }

    public static void run(){
        userInput = Console.readLine();
        inputValidationCheck(userInput);
        claculate(userInput);
    }

    public static void claculate(String userInput) {
        long sum = Arrays.stream(getNumber(userInput))
                .reduce(0L, Long::sum);
        System.out.println("결과 : " + sum);
    }

    public static Long[] getNumber(String userInput){
        String regex = "[" + baseSeparator + "]";
        return Arrays.stream(userInput.split(regex))
                .map(s -> s.isEmpty() ? "0" : s)
                .map(Long::parseLong)
                .toArray(Long[]::new);
    }

    public static void inputValidationCheck(String input){
        checkBlankExist(input);
        checkMinusExist(input);
        if (checkCustomSeparatorExist(input)){
            char customSeparator = input.charAt(2);
            if (Character.isDigit(customSeparator)){
                throw new IllegalArgumentException("숫자를 구분자로 지정할 수 없습니다.");
            }
            baseSeparator += customSeparator;
            input = input.substring(5);
        }
        containsOnlyDelimitersAndDigits(input);
        isEndWithDigit(input);
        userInput = input;
    }

    public static boolean isEmptyInput(String input){
        return input == null || input.isEmpty();
    }

    public static void isEndWithDigit(String input) {
        if (isEmptyInput(input)) return;
        if (!Character.isDigit(input.charAt(input.length() - 1))){
            throw new IllegalArgumentException("마지막 문자가 숫자가 아닙니다.");
        }
    }

    public static void containsOnlyDelimitersAndDigits(String input) {
        if (isEmptyInput(input)) return;
        String regex = "[0-9" + baseSeparator+"]+";
        if (!input.matches(regex)) throw new IllegalArgumentException("지정 구분자, 숫자 외의 다른 문자가 존재합니다.");
    }

    public static void checkMinusExist(String input) {
        if (input.contains("-")) throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
    }

    public static boolean checkCustomSeparatorExist(String input) {
        if (!input.startsWith(CUSTOM_SEPARATOR_START)) return false;
        if (input.length() < 5) return false;
        String customSeparatorEnd = input.substring(3,5);
        return customSeparatorEnd.equals(CUSTOM_SEPARATOR_END);
    }

    public static void checkBlankExist(String input){
        if (input.contains(" ")){
            throw new IllegalArgumentException("입력에 공백이 포함되어 있습니다.");
        }
    }
}

package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Application {

    private static ArrayList<Character> delimiters = new ArrayList<>();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = "";
        try{
            input = Console.readLine();
        } catch (NoSuchElementException e){
        }

        int result = customProcess(input);

        System.out.println("결과 : " + result);
    }


    private static int customProcess(String input) {
        int result = 0;
        initDelimiter();

        if (isCustom(input)) {
            char customDelimiter = input.charAt(2);
            addDelimiter(customDelimiter);

            input = input.substring(input.indexOf("\n") + 1);
        }
        result = calc(input, result);

        return result;
    }

    private static boolean isCustom(String input) {
        return input.startsWith("//") && input.charAt(3) == 92 && input.charAt(4) == 'n';
    }

    private static int calc(String input, int result) {
        String[] numbers = splitInput(input);
        if (isCustom(input)) {
            numbers = splitInput(input.substring(5));
        }

        for (String number : numbers) {
            if (!number.isEmpty()) {
                result += validValue(number);
            }
        }
        return result;
    }

    private static String[] splitInput(String input) {
        StringBuilder regex = new StringBuilder();
        for (Character delimiter : delimiters) {
            if (!regex.isEmpty()) {
                regex.append("|");
            }
            regex.append("\\").append(delimiter);
        }

        return input.split(regex.toString());
    }

    private static void initDelimiter() {
        delimiters.add(',');
        delimiters.add(':');
    }

    private static void addDelimiter(char charDelimiter) {
        if (validCharacter(charDelimiter)) {
            delimiters.add(charDelimiter);
        }
    }

    private static boolean validCharacter(char character) {
        if ((33 <= character && character <= 47) || (58 <= character && character <= 63)) {
            return true;
        }
        throw new IllegalArgumentException("잘못된 기호가 들어갔습니다.");
    }

    public static int validValue(String value) {
        int integerValue = Integer.parseInt(value);
        if (integerValue >= 0) {
            return integerValue;
        }
        throw new IllegalArgumentException("음수의 값이 들어왔습니다.");
    }
}
package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final List<Character> delimContainer = new ArrayList<>(Arrays.asList(',', '.'));
    public static void main(String[] args){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        String parsedInput = parseCustomDelimiter(input);

        if(validateInput(parsedInput)) throw new IllegalArgumentException("잘못된 입력입니다.");

        List<Integer> intList = extractNumberFromString(parsedInput);

        Integer result = addIntList(intList);

        System.out.println("결과 : " +  result);
    }

    private static String parseCustomDelimiter(String str){
        if(str.startsWith("//")){
            delimContainer.add(str.charAt(2));
            return str.substring(6);
        }
        return str;
    }

    private static boolean validateInput(String input){
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if(!isDigit(ch) && !delimContainer.contains(ch)) return true;
        }

        return false;
    }

    private static boolean isDigit(char ch){
        int chValue = ch - '0';
        return chValue >= 0 && chValue <= 9;
    }

    private static List<Integer> extractNumberFromString(String str){
        List<Integer> result = new ArrayList<>();

        int beginIdx = 0;
        boolean delimiterDetected = false;

        for (int i = 0; i < str.length(); i++) {
            if(!isDigit(str.charAt(i))){
                result.add(Integer.parseInt(str.substring(beginIdx, i)));
                beginIdx = i + 1;
            }
        }

        result.add(Integer.parseInt(str.substring(beginIdx)));

        return result;
    }

    private static Integer addIntList(List<Integer> intList){
        return intList
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}

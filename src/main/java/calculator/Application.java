package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    static final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]+");

    public static void main(String[] args) throws IllegalArgumentException {
        String input = null;
        boolean hasInputException = false;
        int[] splitedNumbers = null;
        try {
            input = Console.readLine(); // 입력 받기
        } catch (Exception e) {
            splitedNumbers = new int[]{};
            hasInputException = true;
        }
        if (!hasInputException) {
            System.out.println(input);

            splitedNumbers = split(input);  // 구분자로 분리하기
        }
        printResult(splitedNumbers);
    }

    private static int[] split(String input) {
        String[] splitInput = null;

        if (input.length() >= 5 && hasCustom(input)) {
            String custom = String.valueOf(input.charAt(2));
            String newInput = input.substring(5);
            splitInput = newInput.split(custom);
        } else {
            splitInput = input.split("[,:]");
        }

        System.out.println(Arrays.toString(splitInput));
        int[] integerArray = Arrays.stream(splitInput).mapToInt(x -> {
            Matcher matcher = NUMBER_PATTERN.matcher(x);
            if (!matcher.matches()) {
                throw new IllegalArgumentException();
            }
            return Integer.parseInt(x);
        }).toArray();

        return integerArray;
    }

    private static boolean hasCustom(String input) {
        if (input.charAt(0) != '/' || input.charAt(1) != '/' ||
                input.charAt(3) != '\\' || input.charAt(4) != 'n') {
            return false;
        }
        return true;
    }

    private static void printResult(int[] splitedNumbers) {
        int result = Arrays.stream(splitedNumbers).sum();
        System.out.println("결과 : " + result);
    }

}

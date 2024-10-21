package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine(); // 입력 받기
        Integer[] splitedNumbers = split(input);  // 구분자로 분리하기

    }

    private static Integer[] split(String input) {
        String[] splitInput = null;
        if (hasCustom(input)) {
            String custom = String.valueOf(input.charAt(2));
            String newInput = input.substring(5);
            splitInput = newInput.split(custom);
        } else {
            splitInput = input.split("[,:]");
        }
//        System.out.println(Arrays.toString(splitInput));
        Integer[] integerArray = (Integer[]) Arrays.stream(splitInput).map(Integer::parseInt).toArray();
        return integerArray;
    }

    private static boolean hasCustom(String input) {
        if (input.charAt(0) != '/' || input.charAt(1) != '/' ||
                input.charAt(3) != '\\' || input.charAt(4) != 'n') {
            return false;
        }
        return true;
    }

}

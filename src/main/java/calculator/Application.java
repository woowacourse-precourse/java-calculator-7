package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 덧셈할 문자열 입력
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        // 입력이 없을 경우 "결과 : 0" 출력
        if (input.isEmpty()) {
            System.out.println("결과 : 0");
        }

        DelimiterParser delimiterParser = new DelimiterParser(input);
        String[] stringArray = delimiterParser.splitString();
        int[] intArray = convertStringArrayToIntArray(stringArray);
        System.out.println(sumIntArray(intArray));
    }

    public static int[] convertStringArrayToIntArray(String[] stringArray) {
        int[] intArray = new int[stringArray.length];

        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }

        return intArray;

    }

    public static int sumIntArray(int[] intArray) {
        int sum = 0;

        for (int j : intArray) {
            sum += j;
        }
        return sum;
    }
}

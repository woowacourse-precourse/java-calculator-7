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
        int result = sumIntArray(intArray);
        System.out.println("결과 : " + result);
    }

    public static int[] convertStringArrayToIntArray(String[] stringArray) {
        int[] intArray = new int[stringArray.length];

        for (int i = 0; i < stringArray.length; i++) {
            try {
                intArray[i] = Integer.parseInt(stringArray[i]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 문자가 포함되어 있습니다." + stringArray[i]);
            }
            if (intArray[i] <= 0) {
                throw new IllegalArgumentException("음수 혹은 0으로 숫자가 구성되어 있습니다." + intArray[i]);
            }
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

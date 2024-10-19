package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input;
        char[] seperatorArray = {',', ':'};
        int[] numberArray;
        int result = 0;

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        input = Console.readLine();    // 사용자로부터 문자열 입력 받기
        numberArray = convertStringToIntArray(input, seperatorArray);

        for (int i : numberArray) {
            if (i == -1)
                break;
            result += i;
        }

        System.out.print("결과 : ");
        System.out.println(result);
    }

    public static int[] convertStringToIntArray(String input, char[] seperator) {
        int[] temp = new int[input.length()];

        int lastIndex = 0;
        int inputIndex = 0;

        for (int i = 0; i < input.length(); i++) {
            temp[i] = -1;

            for (char c : seperator) {
                if (input.charAt(i) == c) {
                    temp[inputIndex++] = Integer.parseInt(input.substring(lastIndex, i));
                    lastIndex = i + 1;
                }
            }
            if (i == input.length() - 1) {
                temp[inputIndex] = Integer.parseInt(input.substring(lastIndex));
            }
        }

        return temp;
    }
}

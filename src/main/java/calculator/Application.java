package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input;
        List<Character> seperatorArray = new ArrayList<>(Arrays.asList(',', ':'));
        char customSeperator;
        int[] numberArray;
        int result = 0;

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        input = Console.readLine();    // 사용자로부터 문자열 입력 받기

        customSeperator = getCustomSeperator(input);

        if(customSeperator != ' ')
        {
            seperatorArray.add(customSeperator);
            input = input.substring(5);
        }

        numberArray = convertStringToIntArray(input, seperatorArray);

        for (int i : numberArray) {
            if (i == -1)
                break;
            result += i;
        }

        System.out.print("결과 : ");
        System.out.println(result);
    }

    public static char getCustomSeperator(String input) {
        char temp = ' ';

        if(input.length() < 5)
            return temp;

        if(input.charAt(0) == '/' && input.charAt(1) == '/')
        {
            if(input.charAt(3) == '\\' && input.charAt(4) == 'n')
            {
                temp = input.charAt(2);
            }
        }

        return temp;
    }

    public static int[] convertStringToIntArray(String input, List<Character> seperator) {
        int[] temp = new int[input.length()];

        int lastIndex = 0;
        int inputIndex = 0;

        for (int i = 0; i < input.length(); i++) {
            temp[i] = -1;

            for (char c : seperator) {
                if (c == ' ')
                    continue;

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

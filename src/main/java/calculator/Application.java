package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        if (input == null) {
            throw new IllegalArgumentException();
        }

        if (input.isEmpty()) {
            System.out.println("결과: " + 0);
        } else {
            int escapeIdx = input.indexOf("\\n");
            if(escapeIdx > 0) {
                String delimiter = input.substring(0, escapeIdx);
                if(delimiter.startsWith("//")){
                    delimiter = delimiter.replace("//", "");
                }
                String leftInput = input.substring(escapeIdx + 2);
                String splitInput = Arrays.toString(leftInput.split(delimiter));
                System.out.println(splitInput);
            } else {
                String delimiter = "[,:]";
                String splitInput = Arrays.toString(input.split(delimiter));
                System.out.println(splitInput);
            }
        }
    }
}

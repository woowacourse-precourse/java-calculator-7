package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> processedInput = new ArrayList<>();

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
                String[] splitInput = leftInput.split(delimiter);
                processedInput.addAll(Arrays.asList(splitInput));
            } else {
                String delimiter = "[,:]";
                String[] splitInput = input.split(delimiter);
                processedInput.addAll(Arrays.asList(splitInput));
            }
        }
        for (String number : processedInput) {
            if (Integer.parseInt(number) < 0) {
                throw new IllegalArgumentException();
            }
        }
    }
}

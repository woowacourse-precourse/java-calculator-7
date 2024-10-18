package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Application {

    static int[] number;

    private static final String DEFAULT_SEPARATOR = ",|:";
    private static final String START_SEPARATOR = "//";
    private static final String END_SEPARATOR = "\n";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        String separator = DEFAULT_SEPARATOR;

        input = input.replace("\\n", "\n");

        if (input == null || input.isEmpty()) {
            input = "0";
        }

        if (input.startsWith(START_SEPARATOR)) {
            int endIndex = input.indexOf(END_SEPARATOR);
            if (endIndex == -1) {
                throw new IllegalArgumentException();
            }
            separator += "|" + Pattern.quote(input.substring(2, endIndex));

            input = input.substring(endIndex + 1);
        }

        String[] inputArray = input.split(separator);
        number = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
                number[i] = Integer.parseInt(inputArray[i]);
            if (number[i] < 0) {
                throw new IllegalArgumentException();
            }
        }

        System.out.println("결과 : " + Arrays.stream(number).sum());
    }
}

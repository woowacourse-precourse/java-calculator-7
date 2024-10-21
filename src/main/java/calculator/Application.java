package calculator;
import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = getInput();
    }

    private static String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    private static String[] parseInput(String input) {
        String delimiter = ",|:";
        String number = input;

        if (input.startsWith("//")) {
            int delimiterIdx = input.indexOf("\n");
            if (delimiterIdx != -1) {
                delimiter = Pattern.quote(input.substring(2, delimiterIdx));
                number = input.substring(delimiterIdx + 1);
            }
        }
        return number.split(delimiter);
    }
}

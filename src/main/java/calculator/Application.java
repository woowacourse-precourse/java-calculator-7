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

    private static int parseNumber(String token) {
        try {
            int number = Integer.parseInt(token.trim());
            if(number < 0) {
                throw new IllegalArgumentException(number + "은 음수이므로 허용되지 않습니다");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(token + "은 유효하지 않은 숫자입니다");
        }
    }

    private static int calculatorSum(String input) {
        if(input.isEmpty()) {
            return 0;
        }
        String[] tokens = parseInput(input);
        int sum = 0;
        for(String token : tokens) {
            sum += parseNumber(token);
        }
        return sum;
    }

    private static void printResult(int result) {
        System.out.println("결과 : " + result);
    }
}

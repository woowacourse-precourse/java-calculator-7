package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static int emptyInput(String input) {
        if (input == null || input.isEmpty()) {
            return 0; // 빈 문자열을 입력했다면,
        }
        return -1; // 정상적인 값을 넣었다면,
    }

    public static String[] customSep(String input) {
        String delimiter = ",|:";
        String numbers = input;

        if (input.startsWith("//")) {
            input = input.replace("\\n", "\n");
            String[] splitStr = input.split("\n", 2);
            delimiter = splitStr[0].substring(2);
            numbers = splitStr[1];
        }
        return new String[]{delimiter, numbers};
    }

    public static String[] numberSplit(String numbers, String delimiter) {
        return numbers.split(delimiter);
    }

    public static int totalSum(String[] tokens) {
        int sum = 0;
        for (String token: tokens) {
            int number = Integer.parseInt(token);
            sum += number;
        }
        return sum;

    }

    public static int add(String input) {
        int result = emptyInput(input);
        if (result != -1) {
            return result; // 빈 문자열이면 0 반환
        }
        String[] customResult = customSep(input);
        String delimiter = customResult[0];
        String numbers = customResult[1];

        String[] tokens = numbers.split(delimiter);

        return totalSum(tokens);
    }

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요 : ");
        String input = Console.readLine();
        try {
            int result = add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }
}

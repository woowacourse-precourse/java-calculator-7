package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // Get input
        String input = readLine();

        // 1-1. 기본 구분자만 입력된 경우
        int sum = add(input);

        System.out.println(sum);
    }

    private static int add(String input) {
        String defaultDelimiter = ",|:";
        String[] tokens = input.split(defaultDelimiter);
        int sum = 0;

        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }
        return sum;
    }
}

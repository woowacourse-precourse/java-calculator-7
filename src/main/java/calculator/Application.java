package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();



        int result = calculateSum(input);
        System.out.println("결과 : " + result);


    }

    private static int calculateSum(String input) {
        input = input.replace("\\n", "\n");

        String delimiter = "[,:]";
        if (input.startsWith("//")) {
            String[] parts = input.split("\n", 2);

            delimiter = "[" + parts[0].substring(2) + "]";
            input = parts[1];
        }

        String[] tokens = input.split(delimiter);

        int sum = 0;
        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }
        return sum;
    }
}

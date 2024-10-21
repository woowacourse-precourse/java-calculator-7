package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        String delimiters = ",|:";
        String inputTokens[] = splitByDelimiters(input, delimiters);
        int result = calculateSum(inputTokens);
        System.out.println("결과 : " + result);

    }

    public static int calculateSum(String inputTokens[]) {
        int sum = 0;

        for (String inputToken : inputTokens) {

            inputToken = inputToken.strip();
            if (!inputToken.isEmpty()) {

                try {
                    int numberToken = Integer.parseInt(inputToken);

                    if (numberToken > 0) {
                        sum += numberToken;
                    } else {
                        throw new IllegalArgumentException();
                    }

                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException();
                }
            }
        }
        return sum;
    }


    public static String[] splitByDelimiters(String input, String delimiters) {
        String[] inputTokens;

        if (input.startsWith("//")) {
            int start_index = input.indexOf('/');
            if (start_index + 3 == input.indexOf('\\') && start_index + 4 == input.indexOf('n')) {
                delimiters += "|" + input.charAt(start_index + 2);
                input = input.substring(start_index + 5);
            }
        }

        inputTokens = input.split(delimiters);
        return inputTokens;
    }


}

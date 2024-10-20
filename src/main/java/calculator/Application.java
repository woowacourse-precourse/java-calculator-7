package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String word = Console.readLine();

        try {
            int checkInput = checkInput(word);
            if (checkInput == 0) {
                System.out.println("결과 : " + 0);
            } else {
                String delimiter = getDelimiter(word);
                String[] numbers = extractNumbers(word, delimiter);
                int resultSum = sumNumbers(numbers);
                System.out.println("결과 : " + resultSum);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int checkInput(String word) {
        if (word == null ) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
        if (word.isEmpty()) {
            return 0;
        }
        return -1;
    }

    private static String getDelimiter(String word) {
        return "[,:]";
    }

    private static String[] extractNumbers(String word, String delimiter) {
        return word.split(delimiter);
    }

    private static int sumNumbers(String[] numbers) {
        int sum = 0;
        return sum;
    }
}

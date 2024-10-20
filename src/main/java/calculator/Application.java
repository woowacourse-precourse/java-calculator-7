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
        if (word == null || word.isEmpty() ) {
            return 0;
        }
        return -1;
    }

    private static String getDelimiter(String word) {

        // 커스텀 구분자가 있는 경우
        if (word.startsWith("//")) {
            int seperateIdx = word.indexOf("\\n");
            System.out.println(seperateIdx);
            if (seperateIdx == -1) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
            return word.substring(2, seperateIdx);
        } else {
            // 커스텀 구분자가 없을 경우 , 또는 :로 되어있는지 체크
            if (!word.matches(".*[,:].*")) {
                throw new IllegalArgumentException("입력값에는 구분자가 포함되어야 합니다.");
            }
        }
        return "[,:]";
    }

    private static String[] extractNumbers(String word, String delimiter) {
        if (word.startsWith("//")) {
            int idx = word.indexOf("\\n");
            word = word.substring(idx+2);
        }
        return word.split(delimiter);
    }

    private static int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            try {
                sum += Integer.parseInt(number.trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 숫자 형식입니다.");
            }
        }
        return sum;
    }
}

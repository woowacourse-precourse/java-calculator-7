package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 사용자에게 값 받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        try {
            int result = add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    private static int add(String input) {
        // 입력값이 없는 경우
        if (input.isEmpty()) {
            return 0;
        }

        // 기본 구분자 지정
        String delimiter = "[,:]";

        // 커스텀 구분자가 있을 경우
        if (input.startsWith("//")) {
            int newlineIndex = checkForCustomDelimiter(input);
            delimiter = extractCustomDelimiter(input, newlineIndex);
            input = input.substring(newlineIndex + 2);
        }

        // 입력값 나누기
        String[] numbers = input.split(delimiter);

        // 분리된 String을 int로 변환 후 더하기
        int sum = 0;
        for (String number: numbers) {
            int num = Integer.parseInt(number);
            if (num < 0) {
                throw new IllegalArgumentException("0 이하의 숫자는 입력할 수 없습니다.");
            }
            sum += num;
        }
        return sum;
    }

    /*
        커스텀 구분자가 올바른 형태로 주어졌는지 확인한다.
       커스텀 구분자의 마지막 index를 return한다.
   */
    private static int checkForCustomDelimiter(String input) {

        int newlineIndex = input.indexOf("\\n");

        if (newlineIndex == -1) {
            throw new IllegalStateException("잘못된 형식입니다. 커스텀 구분자는 //와 \n 사이에 있어야 합니다.");
        }
        return newlineIndex;
    }

    /*
        입력값에서 커스텀 구분자를 추출한다.
        특수문자가 포함된 경우, escape 처리한다.
     */
    private static String extractCustomDelimiter(String input, int newlineIndex) {

        String delimiter = input.substring(2, newlineIndex);
        if (delimiter.matches(".*[?*+()\\[\\]{}].*")) {
            delimiter = delimiter.replaceAll("([?*+()\\[\\]{}])", "\\\\$1");
        }

        return delimiter;
    }

}

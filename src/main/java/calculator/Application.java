package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String inputString = Console.readLine();
        if (inputString == null || inputString.isEmpty()) {
            throw new IllegalArgumentException("빈문자열");
        }

        String[] numbers;
        if (inputString.startsWith("//")) {
            int index = inputString.indexOf("\\n");
            if (index == -1) {
                throw new IllegalArgumentException("잘못된 문자입니다.");
            }
            String numberSplitString = inputString.substring(2, index);
            inputString = inputString.substring(index + 2);
            numbers = inputString.split(numberSplitString);

        }
        else {
            numbers = inputString.split(",|:");
        }

        int answer = 0;

        for (int i = 0; i < numbers.length; i++) {
            int number = Integer.parseInt(numbers[i]);
            if (number < 0) {
                throw new IllegalArgumentException("음수입니다");
            }
            answer += number;
        }

        System.out.println("결과 : " + answer);

    }
}

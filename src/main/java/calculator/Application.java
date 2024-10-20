package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String input;
        String[] numbers;

        System.out.println("덧셈할 문자열을 입력해주세요.");
        input = Console.readLine();

        if (input.startsWith("//")) {
            int customIndex = input.indexOf("\\n");

            if (customIndex == -1) {
                throw new IllegalArgumentException("잘못된 구분자 형식입니다. 커스텀 구분자는 //로 시작하고 \\n으로 끝나야 합니다.");
            }

            String customSeparator = input.substring(2, customIndex);
            String numbersRest = input.substring(customIndex + 2);

            numbersRest = numbersRest.replace(customSeparator, " ");
            numbers = numbersRest.split("[ ,:]");
        } else {
            numbers = input.split("[,:]");
        }

        int sum = 0;
        for (String number : numbers) {
            if (!number.trim().isEmpty()) {
                try {
                    sum += Integer.parseInt(number.trim());
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("잘못된 입력입니다.");
                }
            }
        }
        System.out.println("결과: " + sum);
    }
}

package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String input;
        String[] numbers;

        System.out.println("덧셈할 문자열을 입력해주세요.");
        input = Console.readLine();

        if (input.startsWith("//")) {
            if (!input.contains("\\n")) {
                throw new IllegalArgumentException("잘못된 구분자 형식입니다. 커스텀 구분자는 //로 시작하고 \\n으로 끝나야 합니다.");
            }

            int customIndex = input.indexOf("\\n");

            String customSeparator = input.substring(2, customIndex);
            String numbersRest = input.substring(customIndex + 2);

            numbers = numbersRest.split(customSeparator + "|,|:");
        } else {
            numbers = input.split("[,:]");
        }

        int sum = getSum(numbers);
        System.out.println("결과 : " + sum);
    }

    private static int getSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            if (number.contains(" ")) {
                throw new IllegalArgumentException("잘못된 입력입니다. 숫자에 공백을 포함할 수 없습니다.");
            } else {
                try {
                    int parsedNumber = Integer.parseInt(number.trim());

                    if (parsedNumber <= 0) {
                        throw new IllegalArgumentException("입력은 양수만 사용 가능합니다.");
                    }
                    sum += parsedNumber;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("잘못된 입력입니다. 입력은 숫자로만 이루어집니다.");
                }
            }
        }
        return sum;
    }
}

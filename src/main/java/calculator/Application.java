package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import calculator.controller.CalculatorController;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
//        CalculatorController c = new CalculatorController();
//        c.calculateString();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = readLine();

        // 입력이 비어있을 경우 처리
        if (input == null || input.isEmpty()) {
            System.out.println("결과 : 0");
            return;
        }

        // 기본 구분자
        String delimiter = ",|:";

        // 커스텀 구분자 확인
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\n");

            if (delimiterIndex == -1) {
                throw new IllegalArgumentException("[ERROR] 구분자를 찾을 수 없습니다.");
            }

            delimiter = Pattern.quote(input.substring(2, delimiterIndex));
            input = input.substring(delimiterIndex + 1);
        }

        String[] numbers = input.split(delimiter);
        int sum = Arrays.stream(numbers)
                .mapToInt(num -> {
                    int parsedNumber = Integer.parseInt(num.trim());
                    if (parsedNumber < 0) {
                        throw new IllegalArgumentException("[ERROR] 양수를 입력해야 합니다." + parsedNumber);
                    }
                    return parsedNumber;
                })
                .sum();

        System.out.println("결과 : " + sum);

    }
}

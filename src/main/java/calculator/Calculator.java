package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해주세요.\n";
    private static final String OUTPUT_MESSAGE = "결과 : ";
    private String[] defaultDelimiters = {",", ":"};

    public Calculator() {
        System.out.print(INPUT_MESSAGE);
        String input = Console.readLine();
        double result = calculate(input);

        if (result == (int) result) {
            System.out.print(OUTPUT_MESSAGE + (int) result);
        } else {
            System.out.print(OUTPUT_MESSAGE + result);
        }
    }

    public double calculate(String input) {
        List<String> delimiters = new ArrayList<>();

        // 기본 구분자 추가
        for (String delimiter : defaultDelimiters) {
            delimiters.add(delimiter);
        }

        // 커스텀 구분자 처리
        String[] parts = input.split("\\\\n", 2);

        if (parts[0].startsWith("//")) {
            String customDelimiterPart = parts[0].substring(2);
            for (String delimiter : customDelimiterPart.split("")) {
                delimiters.add("\\" + delimiter);
            }
            if (parts.length > 1) {
                input = parts[1]; // 실제 숫자 부분
            } else {
                throw new IllegalArgumentException("수가 입력되지 않음");
            }
        } else {
            input = parts[0]; // 커스텀 구분자가 없을 경우
        }

        // 구분자를 정규 표현식으로 결합
        String regexDelimiters = String.join("|", delimiters);
        String[] numbers = input.split(regexDelimiters);
        return calculateSum(numbers);
    }

    private double calculateSum(String[] numbers) {
        double sum = 0;

        for (String number : numbers) {
            try {
                double num = Double.parseDouble(number.trim());
                if (num < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않음");
                }
                sum += num;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("지정된 구분자가 아님");
            }
        }

        return sum;
    }
}

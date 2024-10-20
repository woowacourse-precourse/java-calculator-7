package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {

    public int add(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 비어 있습니다.");
        }

        String delimiter = ",";
        String numbers = input;

        // 커스텀 구분자 확인
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("잘못된 구분자 설정입니다.");
            }
            delimiter = input.substring(2, delimiterEndIndex);
            numbers = input.substring(delimiterEndIndex + 1);
        }

        // 구분자를 기준으로 숫자 분리
        String[] tokens = numbers.split(Pattern.quote(delimiter));

        List<Integer> numberList = new ArrayList<>();
        List<Integer> negativeNumbers = new ArrayList<>();

        for (String token : tokens) {
            if (token.trim().isEmpty()) {
                continue;
            }
            try {
                int number = Integer.parseInt(token.trim());
                if (number < 0) {
                    negativeNumbers.add(number);
                }
                numberList.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 입력 값입니다.");
            }
        }

        // 음수 입력 시 예외 발생
        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + negativeNumbers);
        }

        // 숫자 합산
        return numberList.stream().mapToInt(Integer::intValue).sum();
    }
}

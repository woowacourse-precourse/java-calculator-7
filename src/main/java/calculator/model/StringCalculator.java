package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class StringCalculator {

    // TODO 구분자만 있을 경우 처리
    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String delimiter = ";|,";
        String[] numbers = input.split(delimiter);
        String[] strings = extractDelimiters(numbers);

        // TODO 나중에 예외처리
        if (areAllEmpty(strings)) {
            return 0;
        }

        return sum(strings);
    }

    // 각 구분자별 처리하는 메소드 구현
    private String[] extractDelimiters(String[] delimitersPart) {
        // 새로운 배열을 만들어서 결과 저장
        List<String> result = new ArrayList<>();
        // 각 요소를 확인하여 구분자 // 또는 \n을 제거 part.equals("//") ||
        for (String part : delimitersPart) {
            if (part.contains("n")) {
                // 해당 문자열은 제거
                String cleanString = part.replace("\\n", "");
                if (cleanString != null && !cleanString.isEmpty()) {
                    result.add(cleanString);

                }
            } else if (part.contains("//")) {
                String cleanString = part.replace("//", "");

                if (cleanString != null && !cleanString.isEmpty()) {

                    result.add(cleanString);

                }

            } else {

                result.add(part.trim()); // 유효한 부분은 리스트에 추가
            }

        }
        // List를 배열로 변환하여 반환
        return result.toArray(new String[0]);
    }

    // 숫자 배열에 숫자가 없을 경우 0으로 반환
    private Boolean areAllEmpty(String[] numbers) {
        for (String number : numbers) {
            if (!number.trim().isEmpty()) {
                return false;
            }

        }
        return true;
    }



    // 숫자 합산
    private int sum(String[] numbers) {
        int total = 0;

        for (String number : numbers) {
            int num = Integer.parseInt(number.trim());  // NumberFormatException은 자동 처리됨

            // 음수인 경우에만 예외를 발생시킴
            if (num < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다 200 : " + num);
            }
            total += num;  // 음수가 아니면 합산
        }
        return total;
    }
}
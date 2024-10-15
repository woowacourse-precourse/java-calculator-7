package calculator.model;

import java.util.Locale;

public class StringCalculator {

    // TODO 구분자만 있을 경우 처리
    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String delimiter = ",|:";

        if (input.startsWith("//")) {
            String[] parts = input.split("\n", 2);
            delimiter = extractDelimiters(parts[0]);
            input = parts[1];
        }

        String[] numbers = input.split(delimiter);

        // TODO 나중에 예외처리
        if(input.trim().isEmpty() || areAllEmpty(numbers)){
            return 0;
        }

        return sum(numbers);
    }

    // 각 구분자별 처리하는 메소드 구현
    private String extractDelimiters(String delimitersPart){
        if (delimitersPart.startsWith("//[")){
            String delimiters = delimitersPart.substring(3, delimitersPart.length() -1);
            delimiters = delimiters.replace("][", "|");
            return delimiters;
        }else {
            return delimitersPart.substring(2);
        }
    }

    // 숫자 배열에 숫자가 없을 경우 0으로 반환
    private Boolean areAllEmpty(String[] numbers){
        for(String number : numbers){
            if (!number.trim().isEmpty()){
                return false;
            }

        }
        return true;
    }

    // 숫자 합산
    private int sum(String[] numbers) {
        int total = 0;
        for (String number : numbers) {
            try {
                int num = Integer.parseInt(number);
                 if (num < 0){
                     throw new IllegalArgumentException("음수는 허용되지 않습니다 : " + num);
                 }else {
                     total += num;
                 }

            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("유효하지 않은 숫자입니다 : " + number);
            }

        }
        return total;
    }
}

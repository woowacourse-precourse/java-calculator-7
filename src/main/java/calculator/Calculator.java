package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    public static int calculate(String input) {
        // 빈 문자열이 들어 왔을 경우 0 반환
        if (input == null || input.isEmpty()) {
            return 0;
        }

        // 기본 구분자 리스트 초기화
        List<String> delimiters = new ArrayList<>(Arrays.asList(",", ":"));

        // "//"으로 시작하는 경우
        if (input.startsWith("//")) {
            if (input.length() > 5 && input.substring(3,5).equals("\\n")){
                // "\n" 인덱스 추출
                int delimiterEndIndex = input.indexOf("\\n");
                String customDelimiter = input.substring(2, delimiterEndIndex); // 커스텀 구분자 추출

                delimiters.add(customDelimiter);
                input = input.substring(delimiterEndIndex + 2); // 커스텀 구분자 이후의 문자열로 업데이트
            }
            // "\n"이 존재하지 않을 경우
            else {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }

        }
        // 구분자로 문자열 분할
        String regex = String.join("|", delimiters);
        String[] numbers = input.split(regex);

        // 각 숫자를 합산
        int sum = 0;
        for (String number : numbers) {
            int num ;
            try {
              num = Integer.parseInt(number);
              // 숫자가 아닌 문자가 존재할 경우
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닙니다.");
            }
            // 양수가 아닐 경우
            if (Integer.parseInt(number) < 1){
                throw new IllegalArgumentException("양수가 아닙니다.");
            }
            sum += num; // 숫자로 변환하여 합산
        }

        return sum;
    }
}

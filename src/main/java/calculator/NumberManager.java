package calculator;

import java.util.ArrayList;

public class NumberManager {
    private ArrayList<Integer> numbers = new ArrayList<>();

    public void numberInput(String numberString, ArrayList<String> separators) {

        // 구분자들을 이스케이프 처리
        ArrayList<String> escapedSeparators = new ArrayList<>();
        for (String separator : separators) {
            escapedSeparators.add(separator.replaceAll("([\\\\*+\\[\\](){}.^$|?])", "\\\\$1"));
        }

        // 구분자를 정규식으로 변환하여 연결
        String regex = String.join("|", escapedSeparators);

        String[] numberParts = numberString.split(regex);

        // 문자열을 정수로 변환
        for (String part : numberParts) {
            if (!part.trim().isEmpty()) { // 빈 문자열은 제외
                try {
                    // 숫자 형식 검증
                    int number = Integer.parseInt(part.trim());
                    numbers.add(number); // 문자열을 정수로 변환
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("유효하지 않은 구분자입니다.");
                }
            } else {
                throw new IllegalArgumentException("입력에 연속된 구분자가 포함되어 있습니다. 형식은 숫자 + 구분자 + 숫자여야 합니다.");
            }
        }
    }

    public void calculateSum() {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        System.out.println("결과 : " + sum);
    }
}
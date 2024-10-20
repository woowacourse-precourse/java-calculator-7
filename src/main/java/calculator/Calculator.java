package calculator;

public class Calculator {
    public int add(String input) {
        if (input.isEmpty()) {
            return 0; // 빈 입력 처리
        }

        // 사용자 정의 구분자 처리
        if (input.startsWith("//")) {
            String[] parts = input.split("\n", 2);
            String delimiter = parts[0].substring(2); // 구분자 추출
            input = parts[1]; // 실제 숫자 부분
            input = input.replace(delimiter, ","); // 사용자 정의 구분자를 쉼표로 대체
        }

        // 음수 검증
        String[] numbers = input.split("[,;\n]");
        StringBuilder negativeNumbers = new StringBuilder();
        int sum = 0;

        for (String number : numbers) {
            int num = Integer.parseInt(number.trim());
            if (num < 0) {
                negativeNumbers.append(num).append(" "); // 음수 목록 추가
            } else {
                sum += num; // 합산
            }
        }

        // 음수 오류 처리
        if (negativeNumbers.length() > 0) {
            throw new IllegalArgumentException("잘못된 입력입니다: 입력값에 음수가 포함되어 있습니다: " + negativeNumbers.toString());
        }

        return sum;
    }
}

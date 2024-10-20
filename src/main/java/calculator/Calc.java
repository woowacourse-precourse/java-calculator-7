package calculator;

public class Calculator {
    public int calculate(String s, String determine) {
        int sum = 0;

        if (s.isBlank()) {  // 공백일 경우 0 반환
            return sum;
        }

        // 구분자를 사용해 입력 문자열을 분리
        String[] inputArr = s.split(determine);
        for (String c : inputArr) {
            sum += Integer.parseInt(c.trim());  // 각 숫자를 더함
        }

        return sum;
    }
}
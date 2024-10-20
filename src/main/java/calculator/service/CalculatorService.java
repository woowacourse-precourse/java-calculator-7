package calculator.service;

import java.util.List;

public class CalculatorService {

    // 문자열 List를 받아 문자열 간 덧셈을 진행
    public String add(List<String> numbers) {
        String result = "0";
        for (String number : numbers) {
            result = addString(result, number);
        }
        return result;
    }

    // 두 문자열 간 덧셈
    private String addString(String num1, String num2) {
        StringBuilder result = new StringBuilder();

        // 자리수 맞추기
        int length1 = num1.length();
        int length2 = num2.length();
        int maxLength = Math.max(length1, length2);

        // 큰 자릿수 기준으로 자릿수 통일
        // 작은 경우 왼쪽에 0을 채움
        num1 = String.format("%" + maxLength + "s", num1).replace(' ', '0');
        num2 = String.format("%" + maxLength + "s", num2).replace(' ', '0');

        // 올림수
        int carry = 0;

        for (int i = maxLength - 1; i >= 0; i--) {
            // 정수 변환
            int digit1 = num1.charAt(i) - '0';
            int digit2 = num2.charAt(i) - '0';

            int sum = digit1 + digit2 + carry;

            // 올림수 계산
            carry = sum / 10;

            // 합한 일의 자리수 추가
            result.append(sum % 10);
        }

        // 올림수가 남았다면 추가
        if (carry > 0) {
            result.append(carry);
        }

        // 뒤집어서 결과 반환
        return result.reverse().toString();
    }
}

package calculator.domain;

public class Adder {

    // 숫자 리스트의 합계를 계산하여 반환
    public int addAll(String numbers) {
        System.out.println(numbers);
        int total = 0;

        String[] numberArray = numbers.split(",");

        for (String number : numberArray) {
            if (!number.isEmpty()) {
                int parsedNumber = Integer.parseInt(number.trim());

                // 음수인 경우 예외 처리
                if (parsedNumber < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다: " + parsedNumber);
                }

                total += parsedNumber;
            }
        }

        return total;
    }
}
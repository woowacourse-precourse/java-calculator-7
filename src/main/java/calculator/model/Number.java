package calculator.model;

public class Number {

    // 문자열 배열을 숫자로 변환하고 합계를 계산하는 메서드
    public int calculateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            try {
                int num = Integer.parseInt(number.trim());
                if (num <= 0) {
                    throw new IllegalArgumentException();
                }
                sum += num;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
        return sum;
    }
}

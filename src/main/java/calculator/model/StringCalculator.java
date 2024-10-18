package calculator.model;

// 문자열 배열의 숫자를 합산하는 계산기
public class StringCalculator {

    // 배열로 전달된 숫자들을 합산하는 메소드
    public int sumNumbers(String[] numbers) {
        return calculateSum(numbers);
    }

    // 숫자 배열을 순회하면서 각 숫자를 합산하는 메소드
    private int calculateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number.trim());
        }
        return sum;
    }

}
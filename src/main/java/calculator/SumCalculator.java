package calculator;

public class SumCalculator {
    public int calculateSum(String[] numbers){ // 문자열 배열의 숫자를 int로 변환후 sum에 합하여 반환.
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}

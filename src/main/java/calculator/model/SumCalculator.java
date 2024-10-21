package calculator.model;

public class SumCalculator implements Calculator{
    // 분리된 숫자 배열을 합산하는 메서드
    @Override
    public int add(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            sum += Integer.parseInt(token);  // 각 숫자를 더한다.
        }
        return sum;
    }
}
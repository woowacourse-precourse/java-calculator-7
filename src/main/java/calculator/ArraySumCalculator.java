package calculator;

public class ArraySumCalculator {


    public int calculateSum(String[] numberList) {
        int total = 0;
        for (String number : numberList) {
            total += Integer.parseInt(number); // 숫자로 변환 후 더하기
        }
        return total;
    }

}

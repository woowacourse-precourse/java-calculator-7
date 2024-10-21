package calculator.Model;

public class CalculatorModel {

    public int[] convertToIntArray(String[] inputArr) { // String에서 int로 변환
        int[] inputIntArr = new int[inputArr.length];
        for (int i = 0; i < inputArr.length; i++) {
            inputIntArr[i] = Integer.parseInt(inputArr[i]);
        }
        return inputIntArr;
    }

    public int sum(int[] inputIntArr) { // 숫자들을 더하는 로직
        int sum = 0;
        for (int num : inputIntArr) {
            sum += num;
        }
        return sum;
    }
}

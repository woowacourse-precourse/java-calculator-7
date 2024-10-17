package calculator;

public class NumberParser {
    public String[] replaceNumber(String[] inputArr) {
        for (int i = 0; i < inputArr.length; i++) {
            inputArr[i] = inputArr[i].replaceAll("[^0-9]", "");
        }
        return inputArr;
    }

    public int sumNumber(String[] inputArr) {
        int sum = 0;
        for (int i = 0; i < inputArr.length; i++) {
            if (!inputArr[i].isEmpty()) {
                sum += Integer.parseInt(inputArr[i]);
            }
        }
        return sum;
    }
}

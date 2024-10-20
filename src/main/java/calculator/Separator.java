package calculator;

import java.util.ArrayList;
import java.util.List;

public class Separator {

    List<Character> params;
    List<Integer> nums;

    public Separator() {
        params = new ArrayList<>();
        params.add(',');
        params.add(':');
        nums = new ArrayList<>();
    }

    public List<Integer> extractNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        StringBuilder currentNumber = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)) {
                currentNumber.append(ch);
            }
            else{
                if (!currentNumber.isEmpty()) {
                    numbers.add(Integer.parseInt(String.valueOf(currentNumber)));
                    currentNumber.setLength(0);
                }
            }
        }

        if (!currentNumber.isEmpty()) {
            numbers.add(Integer.parseInt(String.valueOf(currentNumber)));
        }

        return numbers;
    }

    public List<Integer> getNums() {
        return nums;
    }

    private void saveNums(List<Integer> inputs){
        nums.addAll(inputs);
    }

}

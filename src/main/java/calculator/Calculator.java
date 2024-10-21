package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public int CalculateSum(String[] words) {
        List<String> nonNumericValues = new ArrayList<>();
        List<String> negativeValues = new ArrayList<>();
        int sum = 0;

        for (String word : words) {
            word = word.trim();
            if (word.isEmpty()) {
                word = "0";
            }
            try {
                int value = Integer.parseInt(word);
                if (value < 0) {
                    negativeValues.add(word);
                }
                sum += value;
            } catch (NumberFormatException e) {
                nonNumericValues.add(word);
            }
        }

        if(!negativeValues.isEmpty()){
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + String.join(", ", negativeValues));
        }

        if (!nonNumericValues.isEmpty()) {
            throw new IllegalArgumentException("숫자가 아닙니다: " + String.join(", ", nonNumericValues));
        }

        return sum;
    }
}


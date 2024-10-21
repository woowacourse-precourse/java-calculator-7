package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public int CalculateSum(String[] words) {
        List<String> nonNumericValues = new ArrayList<>();
        int sum = 0;

        for (String word : words) {
            word = word.trim();
            if (word.isEmpty()) {
                word = "0";
            }
            try {
                sum += Integer.parseInt(word);
            } catch (NumberFormatException e) {
                nonNumericValues.add(word);
            }
        }

        if (!nonNumericValues.isEmpty()) {
            throw new IllegalArgumentException("숫자가 아닙니다: " + String.join(", ", nonNumericValues));
        }

        return sum;
    }
}


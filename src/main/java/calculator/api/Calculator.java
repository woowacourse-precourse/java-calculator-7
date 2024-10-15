package calculator.api;

import calculator.config.ApiObjectFactory;

public class Calculator {

    public int calculate(int[] extracted) {
        int sum = 0;

        for(int i = 0; i < extracted.length; i++) {
            sum += extracted[i];
        }

        return sum;
    }

    public int[] convertNumbers(boolean[] booleans) {

    }

    public int[] selectNumbers(String sentence) {
        StrInput strInput = ApiObjectFactory.newStrInput();
        boolean[] booleans = strInput.convertBooleans(sentence);
        int[] numbers =
    }
}

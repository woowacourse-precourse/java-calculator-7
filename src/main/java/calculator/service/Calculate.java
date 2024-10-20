package calculator.service;

import calculator.model.Numbers;

public class Calculate {
    public int addition(Numbers numbers) {
        int result = 0;

        for (int i = 0; i < numbers.getValues().size(); i++) {
            result += numbers.getValues().get(i);
        }

        return result;
    }
}

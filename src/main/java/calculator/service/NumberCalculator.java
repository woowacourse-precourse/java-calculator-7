package calculator.service;

import calculator.domain.Numbers;

public class NumberCalculator {

    public Numbers calculateNumbers(String numberPart, String splitForm) {
        String[] split = numberPart.trim().split(splitForm);

        Numbers numbers = new Numbers();
        for (String temp : split) {
            numbers.add(Integer.parseInt(temp));
        }
        return numbers;
    }
}

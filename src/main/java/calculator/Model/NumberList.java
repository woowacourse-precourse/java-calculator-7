package calculator.Model;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class NumberList {
    private static ArrayList<Integer> numberList = new ArrayList<>();

    public boolean isEmpty() {
        return !this.numberList.isEmpty();
    }

    public boolean checkValidNumber(int number) {
        return Integer.MIN_VALUE <= number && number <= Integer.MAX_VALUE;
    }

    public int parseInt(String numberString) {
        try {
            return Integer.parseInt(numberString);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("입력이 올바르지 않습니다. 잘못된 구분자가 포함되어 있습니다.");
        }
    }

    public void registerNumber(String numberString) {
        int number = parseInt(numberString);
        if (checkValidNumber(number)) {
            numberList.add(number);
        }
    }

    public String[] removeDelimiter(String rawNumber, String customDelimiter) {
        rawNumber = rawNumber.replace(":", ",");
        if (customDelimiter != null) {
            rawNumber = rawNumber.replace(customDelimiter, ",");
        }
        return rawNumber.split(",");
    }

    public void makeNumberList(String rawNumber, String customDelimiter) {
        String[] inputNumber = removeDelimiter(rawNumber, customDelimiter);
        for (String number: inputNumber) {
            registerNumber(number);
        }
    }
}

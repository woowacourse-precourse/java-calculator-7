package calculator.Model;

import java.util.ArrayList;

public class Input {
    private ArrayList<Integer> numberList = new ArrayList<>();

    public boolean hasText() {
        return !numberList.isEmpty();
    }

    public int size() {
        return numberList.size();
    }

    public int get(int index) {
        return numberList.get(index);
    }

    public int getCustomDelimiterStartIndex(String rawText) {
        return rawText.indexOf("//") + 2;
    }

    public int getCustomDelimiterEndIndex(String rawText) {
        return rawText.lastIndexOf("\n");
    }

    public int checkHasCustomDelimiter(String rawText) {
        int customDelimiterStartIndex = getCustomDelimiterStartIndex(rawText);
        int customDelimiterEndIndex = getCustomDelimiterEndIndex(rawText);
        if (customDelimiterStartIndex == 2 && customDelimiterEndIndex > 2) {
            return customDelimiterEndIndex;
        }
        return 0;
    }

    public String splitCustomDelimiter(int customDelimiterEndIndex, String rawText) {
        if (customDelimiterEndIndex > 0) {
            return rawText.substring(2, customDelimiterEndIndex);
        }
        return null;
    }

    public String splitText(int customDelimiterEndIndex, String rawText) {
        if (customDelimiterEndIndex > 0) {
            return rawText.substring(customDelimiterEndIndex+1);
        }
        return rawText;
    }

    public void validInputText(char endChar) {
        if (!('0' <= endChar && endChar <= '9')) {
            throw new IllegalArgumentException("입력이 올바르지 않습니다. 마지막 문자는 숫자여야 합니다.");
        }
    }

    public String dealEmpty(String rawText) {
        if (rawText.length() == 0) {
            return "0";
        }
        return rawText;
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

    public String removeDelimiter(String rawNumber, String customDelimiter) {
        rawNumber = rawNumber.replace(":", ",");
        if (customDelimiter != null) {
            rawNumber = rawNumber.replace(customDelimiter, ",");
        }
        return rawNumber;
    }

    public void registerNumber(String numberString) {
        int number = parseInt(numberString);
        if (checkValidNumber(number)) {
            numberList.add(number);
        }
    }

    public void getInputText(String rawText) {
        rawText = dealEmpty(rawText);

        validInputText(rawText.charAt(rawText.length()-1));

        int customDelimiterEndIndex = checkHasCustomDelimiter(rawText);
        String customDelimiter = splitCustomDelimiter(customDelimiterEndIndex, rawText);

        String rawNumber = splitText(customDelimiterEndIndex, rawText);
        String delimiterRemovedNumber = removeDelimiter(rawNumber, customDelimiter);

        String[] splittedNumberList = delimiterRemovedNumber.split(",");
        for (String splittedNumber : splittedNumberList) {
            registerNumber(splittedNumber);
        }
    }
}

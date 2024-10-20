package calculator.Model;

import java.util.ArrayList;

public class Number {
    private ArrayList<Integer> numberList = new ArrayList<>();

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
        int lastIndex = rawText.indexOf("\\n");
        while (lastIndex > 0 && rawText.substring(lastIndex+2, lastIndex+4).equals("\\n")) {
            lastIndex += 2;
        }
        return lastIndex;
    }

    public int checkHasCustomDelimiter(String rawText) {
        int customDelimiterStartIndex = getCustomDelimiterStartIndex(rawText);
        int customDelimiterEndIndex = getCustomDelimiterEndIndex(rawText);
        if (customDelimiterStartIndex == 2 && customDelimiterEndIndex > 2) {
            return customDelimiterEndIndex;
        }
        return 0;
    }

    public void isCustomDelimiterNumber(String customDelimiter) {
        try {
            Integer.parseInt(customDelimiter);
        } catch (NumberFormatException exception) {
            return;
        }
        throw new IllegalArgumentException("숫자는 커스텀 구분자로 입력할 수 없습니다.");
    }
    public String splitCustomDelimiter(int customDelimiterEndIndex, String rawText) {
        if (customDelimiterEndIndex > 0) {
            String customDelimiter = rawText.substring(2, customDelimiterEndIndex);
            isCustomDelimiterNumber(customDelimiter);
            return customDelimiter;
        }
        return null;
    }

    public String splitText(int customDelimiterEndIndex, String rawText) {
        if (customDelimiterEndIndex > 0) {
            return rawText.substring(customDelimiterEndIndex+2);
        }
        return rawText;
    }

    public void validInputText(char endChar) {
        if (!('0' < endChar && endChar <= '9')) {
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
        return 0 < number && number <= Integer.MAX_VALUE;
    }

    public int parseInt(String numberString) {
        try {
            return Integer.parseInt(numberString);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("입력이 올바르지 않습니다. 잘못된 구분자가 포함되어 있거나 허용 범위를 초과하였습니다.");
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
        if (!checkValidNumber(number)) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
        numberList.add(number);
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

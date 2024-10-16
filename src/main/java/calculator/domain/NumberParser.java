package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class NumberParser {
    private final Divider divider;
    private final static String SPLIT_CRITERIA = "";

    public NumberParser(Divider divider) {
        this.divider = divider;
    }

    public void parse(CalculatedValue calculatedValue) {
        List<Integer> result = new ArrayList<>();

        extractNumberValue(calculatedValue, result);
        calculatedValue.setNumberValueToken(result);
    }

    private void extractNumberValue(CalculatedValue calculatedValue, List<Integer> result) {
        String[] splitWord = calculatedValue.getValue().split(SPLIT_CRITERIA);
        StringBuilder temporaryNumber = new StringBuilder();

        for (String value : splitWord) {
            if (handleCorrectValue(value, temporaryNumber, result)) {
                continue;
            }
            throw new IllegalArgumentException("등록되지 않는 구분자가 있습니다." + value);
        }
        saveTemporaryNumberToList(temporaryNumber, result);
    }

    private boolean handleCorrectValue(String value, StringBuilder temporaryNumber, List<Integer> result) {
        if (isDivider(value)) {
            saveTemporaryNumberToList(temporaryNumber, result);
            temporaryNumber.setLength(0);
            return true;
        } else if (isNumber(value)) {
            temporaryNumber.append(value);
            return true;
        }
        return false;
    }

    private void saveTemporaryNumberToList(StringBuilder temporaryNumber, List<Integer> result) {
        int number = Integer.parseInt(temporaryNumber.toString());
        result.add(number);
    }

    private boolean isDivider(String value) {
        return value.equals(divider.getComma()) || value.equals(divider.getClon()) || value.equals(divider.getCustomDivider());
    }

    private boolean isNumber(String value) {
        return value.matches("^[0-9]+$");
    }

}

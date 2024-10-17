package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class NumberParser {
    private final Divider divider;
    private static String DIVIDER_SPLIT_FORMAT = "%s|%s|%s";

    public NumberParser(Divider divider) {
        this.divider = divider;
    }

    public void parse(CalculatedValue calculatedValue) {
        List<Integer> numberValue = extractNumberValue(calculatedValue);
        calculatedValue.setNumberValueToken(numberValue);
    }

    private List<Integer> extractNumberValue(CalculatedValue calculatedValue) {
        List<Integer> result = new ArrayList<>();
        String dividers = formatDividerSplit();
        String[] values = calculatedValue.getValue().split(dividers);

        for (String value : values) {
            int numberValue = translateStringToInteger(value);
            validateNumberValueNegative(numberValue);

            result.add(numberValue);
        }
        return result;
    }

    private int translateStringToInteger(String value){
        try{
            return Integer.parseInt(value);
        }catch (IllegalArgumentException e){
            validateCustomDividerMinusAndNumberValueNegative(value);
            throw new IllegalArgumentException("등록되지 않는 구분자가 있습니다." + value);
        }
    }

    private void validateCustomDividerMinusAndNumberValueNegative(String value){
        if("-".equals(divider.getCustomDivider()) && value.isEmpty()){
            throw new IllegalArgumentException("음수는 계산이 불가능합니다.");
        }
    }

    private void validateNumberValueNegative(int numberValue){
        if(numberValue < 0){
            throw new IllegalArgumentException("음수는 계산이 불가능합니다.");
        }
    }

    private String formatDividerSplit(){
        return String.format(DIVIDER_SPLIT_FORMAT, divider.getClon(),divider.getComma(),divider.getCustomDivider());
    }

}

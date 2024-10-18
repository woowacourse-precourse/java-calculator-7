package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class NumberParser {
    private final Divider divider;
    private static final String DIVIDER_SPLIT_FORMAT = "%s|%s|%s";
    private static final String ESCAPE_CHARACTER = "\\";
    private static final List<String> META_CHARACTERS = new ArrayList<>(List.of(
            "*", "^", "$", ".", "+", "?", "|", "\\",
            "[", "]", "{", "}", "(", ")")
    );

    public NumberParser(Divider divider) {
        this.divider = divider;
    }

    public void parse(CalculatedValue calculatedValue) {
        List<Integer> numberValue = extractNumberValue(calculatedValue);
        calculatedValue.setNumberValueToken(numberValue);
    }

    private List<Integer> extractNumberValue(CalculatedValue calculatedValue) {
        List<Integer> result = new ArrayList<>();
        System.out.println("커스텀              " + divider.getCustomDivider());
        String dividers = formatDividerSplit();
        String[] values = calculatedValue.getValue().split(dividers);

        for (String value : values) {
            int numberValue = translateStringToInteger(value);
            validateNumberValueNegative(numberValue);

            result.add(numberValue);
        }
        return result;
    }

    private int translateStringToInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (IllegalArgumentException e) {
            validateCustomDividerMinusAndNumberValueNegative(value);

            throw new IllegalArgumentException("등록되지 않는 구분자가 있습니다." + value);
        }
    }

    private void validateCustomDividerMinusAndNumberValueNegative(String value) {
        if ("-".equals(divider.getCustomDivider()) && value.isEmpty()) {
            throw new IllegalArgumentException("음수는 계산이 불가능합니다.");
        }
    }

    private void validateNumberValueNegative(int numberValue) {
        if (numberValue < 0) {
            throw new IllegalArgumentException("음수는 계산이 불가능합니다.");
        }
    }

    private String formatDividerSplit() {
        return String.format(DIVIDER_SPLIT_FORMAT,
                divider.getClon(),
                divider.getComma()
                , handleMetaCharacter(divider.getCustomDivider()));
    }

    private String handleMetaCharacter(String customDivider) {
        if (isMetaChar(customDivider)) {
            return addEscapeCharToMetaChar(customDivider);
        }
        return customDivider;
    }

    private boolean isMetaChar(String ch) {
        return META_CHARACTERS.contains(ch);
    }

    private String addEscapeCharToMetaChar(String metaCharacter) {
        return ESCAPE_CHARACTER + metaCharacter;
    }

}

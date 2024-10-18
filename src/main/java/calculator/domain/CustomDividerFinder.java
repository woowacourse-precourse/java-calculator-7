package calculator.domain;

public class CustomDividerFinder {
    private final static String OPENER = "//";
    private final static String CLOSER = "\\n";
    private final static Integer OPENER_INDEX = 0;
    private final static Integer CLOSER_INDEX = 3;
    private final static Integer CUSTOM_DIVIDER_INDEX = 2;
    private final static Integer CALCULATED_VALUE_START_INDEX = 5;
    private final static Integer NONE_CUSTOM_DIVIDER = -1;

    public void findCustomDividers(CalculatedValue calculatedValue, Divider divider) {
        String inputValue = calculatedValue.getValue();
        validateNullCalculatedValue(inputValue);

        int openerIndex = inputValue.indexOf(OPENER);
        int closerIndex = inputValue.indexOf(CLOSER);

        if (isNonexistentCustomDivider(openerIndex, closerIndex)) {
            return;
        } else if (hasCustomDivider(openerIndex, closerIndex)) {
            handleCustomDivider(calculatedValue, divider, inputValue);
            return;
        }
        throw new IllegalArgumentException("커스텀 구분자 사용 시 양식을 지켜주세요. //커스텀문자\\n");
    }


    private void handleCustomDivider(CalculatedValue calculatedValue, Divider divider, String inputValue) {
        char charCustomDivider = inputValue.charAt(CUSTOM_DIVIDER_INDEX);
        String onlyCalculatedValue = extractCalculatedValue(inputValue);

        updateCalculatedValueAndDivider(calculatedValue, divider, onlyCalculatedValue, charCustomDivider);
    }

    private String extractCalculatedValue(String inputValue) {
        return inputValue.substring(CALCULATED_VALUE_START_INDEX);
    }

    private static void updateCalculatedValueAndDivider(CalculatedValue calculatedValue, Divider divider,
                                                        String onlyCalculatedValue, char charCustomDivider) {
        calculatedValue.setValue(onlyCalculatedValue);
        divider.setCustomDivider(String.valueOf(charCustomDivider));
    }


    private boolean hasCustomDivider(int openerIndex, int closerIndex) {
        validateStringCustomDivider(closerIndex);
        validateNullCustomDivider(closerIndex);
        return openerIndex == OPENER_INDEX && closerIndex == CLOSER_INDEX;
    }

    private boolean isNonexistentCustomDivider(int openerIndex, int closerIndex) {
        return openerIndex == NONE_CUSTOM_DIVIDER && closerIndex == NONE_CUSTOM_DIVIDER;
    }


    private void validateStringCustomDivider(int closerIndex) {
        if (closerIndex > CLOSER_INDEX) {
            throw new IllegalArgumentException("문자열 커스텀 구분자는 불가능합니다. 문자만 입력해 주세요.");
        }
    }

    private void validateNullCustomDivider(int closerIndex) {
        if (closerIndex == CUSTOM_DIVIDER_INDEX) {
            throw new IllegalArgumentException("커스텀 구분자가 비어있어요.");
        }
    }

    private void validateNullCalculatedValue(String calculatedValue) {
        if ("".equals(calculatedValue)) {
            throw new IllegalArgumentException("계산식이 비어있어요.");
        }
    }

}

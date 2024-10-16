package calculator.domain;

public class CustomDividerFinder {
    private final static String OPENER = "//";
    private final static String CLOSER = "\\n"; //note : 줄바꿈 문자를 구분해줘야하는 거기 때문에 역슬래시를 2번 사용한다.(만약 1개면 줄바꿈)
    private final static Integer OPENER_INDEX = 0;
    private final static Integer CLOSER_INDEX = 3;
    private final static Integer CUSTOM_DIVIDER_INDEX = 2;
    private final static Integer CALCULATED_VALUE_START_INDEX = 5;
    private final static Integer NONE_CUSTOM_DIVIDER = -1;

    /**
     * 만약 커스텀 문자가 1개가 아닐 경우(null or 문자열) - 커스텀 양식의 길이를 측정
     *
     */
    public void findCustomDividers(CalculatedValue calculatedValue, Divider divider) { //todo 인수를 생성자로?
        String inputValue = calculatedValue.getValue();
        int openerIndex = inputValue.indexOf(OPENER);
        int closerIndex = inputValue.indexOf(CLOSER);


        System.out.println("오픈 인덱스   " + openerIndex); //note 0
        System.out.println("클로저 인덱스   " + closerIndex); //note 3

        if(isNonexistentCustomDivider(openerIndex, closerIndex)) {
            return;
        }else if(hasCustomDivider(openerIndex, closerIndex)) {
            char charCustomDivider = inputValue.charAt(CUSTOM_DIVIDER_INDEX);
            String onlyCalculatedValue = extractCalculatedValue(inputValue);

            System.out.println("문자열   " +charCustomDivider);
            System.out.println("커스텀 양식을 뺀 계산식    " + onlyCalculatedValue);

            updateCalculatedValueAndDivider(calculatedValue, divider, onlyCalculatedValue, charCustomDivider);
            return;
        }
        throw new IllegalArgumentException("커스텀 구분자 사용시 양식을 지켜주세요. //커스텀문자\\n");
    }

    private String extractCalculatedValue(String inputValue){
        return inputValue.substring(CALCULATED_VALUE_START_INDEX);
    }

    private static void updateCalculatedValueAndDivider(CalculatedValue calculatedValue, Divider divider,
                                                        String onlyCalculatedValue, char charCustomDivider) {
        calculatedValue.setValue(onlyCalculatedValue);
        divider.setCustomDivider(String.valueOf(charCustomDivider));
    }

    private boolean hasCustomDivider(int openerIndex,int closerIndex) {
        validateStringCustomDivider(closerIndex);
        validateNullCustomDivider(closerIndex);
        return openerIndex == OPENER_INDEX && closerIndex == CLOSER_INDEX;
    }

    private boolean isNonexistentCustomDivider(int openerIndex,int closerIndex){
        return openerIndex == NONE_CUSTOM_DIVIDER && closerIndex == NONE_CUSTOM_DIVIDER;
    }

    private void validateStringCustomDivider(int closerIndex){
        if(closerIndex > CLOSER_INDEX){
            throw new IllegalArgumentException("커스텀 구분자는 문자만 입력 가능합니다. 문자열은 불가능 합니다.");
        }
    }

    private void validateNullCustomDivider(int closerIndex){
        if(closerIndex < CLOSER_INDEX){
            throw new IllegalArgumentException("커스텀 구분자를 문자로 입력해 주세요.");
        }
    }

}

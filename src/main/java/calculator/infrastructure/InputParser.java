package calculator.infrastructure;

import calculator.common.exception.ContainsBlankException;
import calculator.domain.Separators;
import java.util.Arrays;

public class InputParser {

    private static final int BEGIN_INDEX = 0;
    private static final int STR_MIN_LENGTH_FOR_SEPARATOR_EXIST = 5;
    private static final int CUSTOM_SEPARATOR_END_INDEX = 5;
    private static final String SEPARATOR_FORM_BEGIN_STR = "//";
    private static final String SEPARATOR_FORM_END_STR = "\\n";
    private static final int SEPARATOR_LOCATION_INDEX = 2;

    /*
     * 사용자 입력 문자열이 공백을 포함하는지 검증합니다.
     */
    public void validateInputStr(String inputStr) {
        validateInputStrHasNoSpaces(inputStr);
    }

    /*
     * 사용자 입력 문자열이 커스텀 구분자를 포함한 형식인지 확인합니다.
     * 포함할 경우 true 를 반환합니다.
     */
    public boolean checkIfInputStringContainsSeparator(String inputStr) {
        return checkIfSeparatorForm(inputStr);
    }

    /*
     * 구분자 리스트를 만들어 반환합니다.
     * 사용자 입력 문자열에 커스텀 구분자가 포함된 경우 이를 구분자 리스트에 추가하여 반환합니다.
     */
    public Separators getSeparatorList(boolean hasCustomSeparator, String inputStr) {
        Separators separators = new Separators();
        if (hasCustomSeparator) {
            separators.addCustomSeparator(inputStr.charAt(SEPARATOR_LOCATION_INDEX));
        }
        return separators;
    }

    /*
     * 사용자 입력 문자열이 커스텀 구분자를 포함할 경우 형식을 제거하여 반환합니다.
     */
    public String removeSeparatorForm(boolean hasCustomerSeparator, String inputStr) {
        if (hasCustomerSeparator) {
            return inputStr.substring(CUSTOM_SEPARATOR_END_INDEX);
        }
        return inputStr;
    }

    /*
     * 구분자를 기준으로 문자열을 자릅니다.
     */
    public String[] splitStrBySeparator(Separators separators, String slicedStr) {
        String delimiter = separators.getDelimiter();
        String[] splitStr = slicedStr.split(delimiter);
        return Arrays.stream(splitStr)
                .filter(str -> !str.trim().isEmpty())
                .toArray(String[]::new);
    }

    private void validateInputStrHasNoSpaces(String inputStr) {
        if (inputStr.contains(" ")) {
            throw new ContainsBlankException(inputStr);
        }
    }

    private boolean checkIfSeparatorForm(String inputStr) {
        if (inputStr.length() < STR_MIN_LENGTH_FOR_SEPARATOR_EXIST) {
            return false;
        }
        String firstFiveCharacters = inputStr.substring(BEGIN_INDEX, CUSTOM_SEPARATOR_END_INDEX);

        return firstFiveCharacters.startsWith(SEPARATOR_FORM_BEGIN_STR) &&
                firstFiveCharacters.endsWith(SEPARATOR_FORM_END_STR);
    }

}
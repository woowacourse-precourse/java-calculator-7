package calculator.service.separator;

import calculator.constant.CalConst;
import calculator.dto.CheckSeparatorDto;

public class Separator {

    /**
     * 커스텀 구분자가 있는지 확인한다. 만약 있다면, checkSeparatorDto.customSeparator 에 null 대신 커스텀 구분자를 넣는다. 또한,
     * checkSeparatorDto.inputString 에 커스텀 구분자를 확인하는 부분을 제거한 문자열을 넣는다.
     *
     * @param checkSeparatorDto inputString 만 set 되어 있는 dto.
     */
    public void checkCustomSeparator(CheckSeparatorDto checkSeparatorDto) {
        String inputString = checkSeparatorDto.getInputString();
        String customSeparator;

        if (inputString.length() >= CalConst.MINIMUM_LENGTH_IF_EXIST_CUSTOM_SEPARATOR.value()
                && inputString.startsWith("//")
                && inputString.startsWith("\\n", CalConst.END_INDEX_OF_CUSTOM_SEPARATOR.value())) {
            customSeparator = String.valueOf(inputString.charAt(CalConst.INDEX_OF_CUSTOM_SEPARATOR.value()));
            inputString = inputString.substring(CalConst.START_INDEX_OF_CALCULATING.value());

            checkSeparatorDto.setCustomSeparator(customSeparator);
            checkSeparatorDto.setInputString(inputString);
        }
    }

    /**
     * 문자열을 구분자를 이용해 나눈다.
     *
     * @param checkSeparatorDto 커스텀 구분자(or null)와 커스텀 구분자 확인 부분을 제거한 문자열을 넣은 Dto.
     * @return 구분자를 이용해 나눠진 문자열을 반환한다. 이 문자열에는 숫자 외의 문자가 존재할 수 있다. 계산에 이용하려면 추가적인 확인 과정이 필요하다.
     */
    public String[] separate(CheckSeparatorDto checkSeparatorDto) {
        String customSeparator = checkSeparatorDto.getCustomSeparator();
        String inputString = checkSeparatorDto.getInputString();

        if (customSeparator == null) {
            return inputString.split("[:,]");
        }
        if (customSeparator.equals("\\")) {
            return inputString.split("[:," + customSeparator.repeat(2) + "]");
        }
        return inputString.split("[:," + customSeparator + "]");
    }
}

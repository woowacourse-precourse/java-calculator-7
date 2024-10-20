package calculator.service.separator;

import calculator.constant.CalConst;
import calculator.dto.CheckSeparatorDto;

public class Separator {

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

    public String[] separate(CheckSeparatorDto checkSeparatorDto) {
        String customSeparator = checkSeparatorDto.getCustomSeparator();
        String inputString = checkSeparatorDto.getInputString();
        if (customSeparator==null) {
            return inputString.split("[:,]");
        }
        if (customSeparator.equals("\\")) {
            return inputString.split("[:," + customSeparator.repeat(2) + "]");
        }
        return inputString.split("[:," + customSeparator + "]");
    }
}

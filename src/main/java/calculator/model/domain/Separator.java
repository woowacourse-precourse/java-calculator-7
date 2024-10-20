package calculator.model.domain;

import calculator.model.dto.SeparatorDto;

public class Separator {
    public static String separatorGenerator(String inputString) {
        SeparatorDto separatorDto = SeparatorDto.getInstance();
        if (isCustomSeparator(inputString)) {
            separatorDto.addSeparator(inputString.charAt(2));
            return sliceCustomSeparatorPart(inputString);
        }
        return inputString;
    }


    public static boolean isCustomSeparator(String inputString) {
        return inputString.length() > 5 && inputString.charAt(0) == '/';
    }



    public static String sliceCustomSeparatorPart(String inputString) {
        return inputString.substring(5);
    }
}

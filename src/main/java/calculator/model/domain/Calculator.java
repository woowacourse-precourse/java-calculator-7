package calculator.model.domain;

import calculator.model.dto.ResultDto;
import calculator.model.dto.SeparatorDto;
import calculator.validation.SeparatorBetweenNumberValidation;
import calculator.validation.ZeroIsNotPositiveValidation;

public class Calculator {
    public static ResultDto calculate(String inputString) {
        ResultDto resultDto = new ResultDto(0);
        SeparatorDto separatorDto = SeparatorDto.getInstance();

        String numberStore = "";
        if(inputString.isEmpty()) {
            return resultDto;
        }

        for (int i = 0; i < inputString.length(); i++) {
            char inputElement = inputString.charAt(i);

            if (Character.isDigit(inputElement)) {
                numberStore = numberStore + inputElement;
            }
            else if(separatorDto.isContainSeparator(inputElement)) {
                SeparatorBetweenNumberValidation.validate(numberStore);
                ZeroIsNotPositiveValidation.validate(numberStore);
                resultDto.addResult(Integer.parseInt(numberStore));
                numberStore = "";
            }
        }
        SeparatorBetweenNumberValidation.validate(numberStore);
        ZeroIsNotPositiveValidation.validate(numberStore);
        resultDto.addResult(Integer.parseInt(numberStore));
        return resultDto;
    }

}

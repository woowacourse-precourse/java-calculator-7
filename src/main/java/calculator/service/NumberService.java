package calculator.service;

import calculator.domain.TextInfo;
import calculator.utils.Validation;


public class NumberService {

    Validation validation = new Validation();

    public void setNumbers(TextInfo textInfo) {
        for (String number : textInfo.numericStringsArray) {
            validation.isOtherStr(number);
            textInfo.convertedNumbers.add(Integer.parseInt(number));
        }
    }

    public void addNumbers(TextInfo textInfo) {
        for (int number : textInfo.convertedNumbers) {
            textInfo.result += number;
        }
    }

}

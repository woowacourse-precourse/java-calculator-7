package calculator.service;

import calculator.domain.TextInfo;

public class NumberService {
    public void setNumbers(TextInfo textInfo) {
        for (String number : textInfo.numericStringsArray) {
            textInfo.convertedNumbers.add(Integer.parseInt(number));
        }
    }


}

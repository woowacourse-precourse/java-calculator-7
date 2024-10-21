package calculator.service;

import calculator.domain.Delimiter;
import calculator.domain.Number;

public class CalcService {

    Number number = new Number();

    public String[] getNumbers(String input) {
        Delimiter delimiter = new Delimiter(input);
        return delimiter.extractDelimiterAndNumber();
    }

    public void addNumberToList(String[] numbers) {
        // 문자열의 각 요소가 숫자인지 판별하고 리스트에 저장
        for (String n : numbers) {
            number.addValidNumber(n);
        }
    }


    public int getResult() {
        return number.plusNumber();
    }

}

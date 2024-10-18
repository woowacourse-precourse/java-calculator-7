package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Delimeters {

    private List<String> delimeters = new ArrayList<>(Arrays.asList(",", ":"));

    //커스텀 Delimeter 넣기
    public void addDelimeter(final String delimeter) {

        checkDelimeter(delimeter);
        delimeters.add(delimeter);

    }

    //customDelimeter가 존재하는지 확인
    public boolean hasCustomDelimeter() {

        if (delimeters.size() >= 3) {
            return true;
        }

        return false;
    }

    //공식으로부터 Delimeter 를 활용하여 String 형식 숫자추출
    public String[] getNumbersFromCalculationFormula(final String calculationFormula) {

        String regexString = "";
        for (String regex : delimeters) {
            regexString += regex;
        }

        return calculationFormula.split("[" + regexString + "]");

    }

    //올바른 Delimeter 인지 판단.
    private void checkDelimeter(final String delimeter) {

    }


}

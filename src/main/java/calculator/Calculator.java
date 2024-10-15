package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {

    private int result;

    public Calculator(String input){
        parseInput(input); // 숫자 추출 및 합산을 메서드 호출
    }



    private void parseInput(String input){
        // 쉼표와 콜론 제거해서 list에 추가하기.
        String cleanedInput = input.replace(",", "").replace(";", "");



        for (char c :cleanedInput.toCharArray()) {
            result += Character.getNumericValue(c);
        }
    }

    public int getresult() {
        return result;
    }

}

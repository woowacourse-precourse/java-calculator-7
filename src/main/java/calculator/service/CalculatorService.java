package calculator.service;

import java.util.ArrayList;

public class CalculatorService {
    String number = "";
    int result;

    ArrayList<String> numList = new ArrayList<>();

    public String getUserInput(String input) {
        if (input.isEmpty()) { // 빈 입력값 처리
            return "0";
        }
       return input;
    }
}

package calculator.service;

import java.util.ArrayList;

public class CalculatorService {
    String number = "";
    int result = 0;
    String printNumList = "";

    ArrayList<String> numList = new ArrayList<>();

    public String getUserInput(String input) {
        if (input.isEmpty()) { // 빈 입력값 처리
            return "0";
        }
        else { // 쉼표와 콜론 구분자를 기준으로 숫자 분리
            for (int i=0; i<input.length(); i++) {
                char c = input.charAt(i);
                switch (c) {
                    case ',':
                    case ';':
                        numList.add(number);
                        number = "";
                        continue;
                    default:
                        number += c;
                        break;
                }
            }
            numList.add(number);

            for (int i=0; i<numList.size(); i++) {
                printNumList += numList.get(i) + " ";
            }

            return printNumList;
        }
    }
}

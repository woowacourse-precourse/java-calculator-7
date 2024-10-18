package calculator.service;

import java.util.ArrayList;

public class CalculatorService {
    String number = "";
    int result = 0;
    String customSeparator = "";
    String checkSeparator = "";
    String printNumList = "";

    ArrayList<String> numList = new ArrayList<>();

    public String getUserInput(String input) {
        if (input.isEmpty()) { // 빈 입력값 처리
            return "0";
        }
        else {
            int i=0;
            // 커스텀 구분자 지정
            if (input.charAt(i) == '/' && input.charAt(i+1) == '/') {
                i=2;
                while(input.charAt(i) != '\\' && input.charAt(i+1) != 'n') {
                    customSeparator += input.charAt(i);
                    i++;
                }
                i += 2;
            }

            for (;i<input.length(); i++) {
                char c = input.charAt(i);
                switch (c) {
                    case ',': // 쉼표와 콜론 구분자를 기준으로 숫자 분리
                    case ':':
                        numList.add(number);
                        number = "";
                        continue;
                    default:
                        if ((int)c >= 48 && (int)c <= 57) {
                            if (checkSeparator.equals(customSeparator)) { // 커스텀 구분자를 기준으로 숫자 분리
                                numList.add(number);
                                number = "";
                                checkSeparator = "";
                            }
                            number += c;
                        }
                        else {
                            checkSeparator += c;
                        }
                        break;
                }
            }
            numList.add(number);

            System.out.println("커스텀 구분자: " + customSeparator + "\n");
            for (int j=0; j<numList.size(); j++) {
                printNumList += numList.get(j) + " ";
            }
            return printNumList;
        }
    }
}

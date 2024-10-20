package calculator.service;

import java.util.ArrayList;

public class CalculatorService {

    public int getUserInput(String input) throws IllegalArgumentException {
        String number = "";
        int result = 0;
        String customSeparator = ""; // 사용자가 지정한 커스텀 구분자
        String checkSeparator = ""; // 같은 커스텀 구분자를 입력했는지 확인
        boolean readSeparator = false; // 이전에 문자를 읽었는지 숫자를 읽었는지 확인

        ArrayList<String> numList = new ArrayList<>();

        if (input.isEmpty()) { // 빈 입력값 처리
            return 0;
        }
        else {
            int i=0;
            // 커스텀 구분자를 지정한 경우
            if (input.charAt(i) == '/' && input.charAt(i+1) == '/') {
                i=2;
                while(true) {
                    // 커스텀 구분자 지정 방식이 잘못됐을 때와 숫자를 커스텀 구분자로 지정하려 할 때, 잘못된 입력값으로 처리
                    if (i == input.length() || (input.charAt(i) >= 48 && input.charAt(i) <= 57)) {
                        throw new IllegalArgumentException();
                    }
                    if (input.charAt(i) == '\\' && input.charAt(i+1) == 'n') {
                        break;
                    }
                    customSeparator += input.charAt(i);
                    i++;
                }
                i += 2;
            }

            for (;i<input.length(); i++) {
                char c = input.charAt(i);
                if ((int)c >= 48 && (int)c <= 57) { // 숫자
                    if (readSeparator) {
                        readSeparator = false;
                        if (checkSeparator.equals(customSeparator) ||
                                checkSeparator.equals(",") ||
                                checkSeparator.equals(":"))
                        {
                            numList.add(number);
                            number = "";
                            checkSeparator = "";
                        }
                        else {
                            throw new IllegalArgumentException(); // 잘못된 구분자를 사용했을 때, 잘못된 입력값으로 처리
                        }
                    }
                    number += c;
                }
                else { // 문자
                    if (!readSeparator) {
                        numList.add(number);
                    }
                    readSeparator = true;
                    checkSeparator += c;
                    number = "";
                }
            }
            if (checkSeparator != "") { // 입력한 문자열이 문자로 끝날 때, 잘못된 입력값으로 처리
                throw new IllegalArgumentException();
            }
            numList.add(number);

            // 결과 출력
            for (int j=0; j<numList.size(); j++) {
                if (!numList.get(j).equals(""))
                    result += Integer.parseInt(numList.get(j));
            }
            return result;
        }
    }
}

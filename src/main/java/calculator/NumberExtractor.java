package calculator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NumberExtractor {
    ArrayList<Integer> numArr = new ArrayList<>();

    public ArrayList<Integer> extractNumbers(DelimiterParser delimiterParser, String input){

        // 숫자 추출 및 구분자 처리

        StringBuilder curNum = new StringBuilder();
        int letterIndex = delimiterParser.getParseIndex();

        while (letterIndex < input.length()) {
            char currentChar = input.charAt(letterIndex);

            // 숫자인 경우 숫자를 계속 이어붙임
            if (Character.isDigit(currentChar)) {
                curNum.append(currentChar);
            } else {
                // 구분자를 만났을 경우
                if (delimiterParser.getDelimiters().contains(String.valueOf(currentChar))) {
                    if (curNum.length() > 0) {
                        numArr.add(Integer.parseInt(curNum.toString()));
                        curNum.setLength(0);  // 숫자 초기화
                    }
                } else {
                    // 구분자가 아니면 예외 처리
                    throw new IllegalArgumentException("잘못된 구분자가 포함되었습니다.");
                }
            }
            letterIndex++;
        }

        // 마지막 숫자 처리
        if (curNum.length() > 0) {
            numArr.add(Integer.parseInt(curNum.toString()));
        }

        return numArr;
    }

    public ArrayList<Integer> getNumbers(){
        return numArr;
    }
}

package calculator.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Preprocessing {
    // 첫 글자가 "/"로 시작하는지 아닌지에 따라 메소드 실행
    public boolean firstLetter(String given) {
        char firstLetter = given.charAt(0);

        if (firstLetter == '/') { // 커스텀 구분자 추출해야 됨
            return true;
        } else { // 바로 계산 ㄱㄱ
            return false;
        }
    }

    // <숫자 - 숫자 외 모든것> 분리
    public List<String> separation(String given) {
        // 결괏값으로 반환할 분리된 List
        List<String> separated = new ArrayList<>();

        // 0번째 주소에 있는 원소 temp에 저장
        String temp = given.substring(0,1); // String??

        for (int i = 1;i < given.length(); i++) {
            if (Character.isDigit(given.charAt(i)) == Character.isDigit(given.charAt(i - 1))) {
                temp += given.substring(i, i + 1);
            } else {
                separated.add(temp);
                temp = given.substring(i, i + 1);
            }
        }
        separated.add(temp);
        return separated;
    }

    // 커스텀 구분자 저장
    public List<String> findCustomSeparator(String given) {
        String temp = "";
        String customSeparator = null;
        int endIdx = -2; // 커스텀 지정 끝나는 지점 인덱스

        for (int i = 2; i < given.length(); i++) {
            if (given.substring(i - 1, i + 1).equals("\\n")) {
                customSeparator = temp.substring(0, temp.length() - 1);
                endIdx = i;
                break;
            } else {
                temp += given.substring(i, i + 1);
            }
        }

        return Arrays.asList(customSeparator, given.substring(endIdx + 1));
    }
}

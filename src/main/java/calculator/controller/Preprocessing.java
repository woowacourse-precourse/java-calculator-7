package calculator.controller;

import java.util.ArrayList;
import java.util.List;

public class Preprocessing {
    // 첫 글자가 "/"로 시작하는지 아닌지에 따라 메소드 실행
    public void firstLetter(String given) {
        String firstLetter = given.substring(0,1);

        if (firstLetter == "/") {

        } else {
            separation(given);
        }
    }

    // <숫자 - 숫자 외 모든것> 분리
    private List<String> separation(String given) {
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
        return separated;
    }

    // 커스텀 구분자 저장
}

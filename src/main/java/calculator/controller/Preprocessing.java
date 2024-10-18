package calculator.controller;

import calculator.view.InputValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Preprocessing extends InputValidator {

    // 첫 글자가 "/"로 시작하는지 아닌지에 따라 메소드 실행
    public boolean firstLetter(String given) {
        char firstLetter = given.charAt(0);
        validatingFirstLetter(firstLetter);

        if (firstLetter == '/') { // 커스텀 구분자 추출해야 됨
            return true;
        } else { // 바로 계산 ㄱㄱ
            return false;
        }
    }

    // <숫자 - 숫자 외 모든것> 분리
    public List<String> separation(String given, List<String> separtors) {
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

        //예외 검증
        validatingSeparator(separated, separtors);
        lastElement(separated);

        return separated;
    }

    // 커스텀 구분자 저장
    public List<String> findCustomSeparator(String given) {
        String customSeparator = customValidator(given);

        return Arrays.asList(customSeparator, given.substring(given.indexOf("\\n" + 2)));
    }
}

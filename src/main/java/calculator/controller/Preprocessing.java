package calculator.controller;

import calculator.view.InputValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Preprocessing {
    private final InputValidator inputValidator = new InputValidator();
    private static final List<String> DEFAULT_SEPARATORS = Arrays.asList(",", ":");

    public List<String> processInput (String input) {
        List<String> separated = new ArrayList<>();

        if (firstLetter(input)) { // 첫글자가 `/`일 경우
            // 커스텀 구분자 추출
            List<String> customAndLeft = findCustomSeparator(input);

            // 기본 구분자를 새로운 리스트에 복사하여 사용
            List<String> separators = new ArrayList<>(DEFAULT_SEPARATORS);
            separators.add(customAndLeft.get(0));

            // 숫자 - !숫자 구분
            separated = separation(customAndLeft.get(1), separators);
        } else { // 첫글자가 숫자일 경우
            // 숫자 - !숫자 구분
            separated = separation(input, DEFAULT_SEPARATORS);
        }
        return separated;
    }

    // 첫 글자가 "/"로 시작하는지 아닌지에 따라 메소드 실행
    private boolean firstLetter(String given) {
        char firstLetter = given.charAt(0);
        inputValidator.validatingFirstLetter(firstLetter);

        if (firstLetter == '/') { // 커스텀 구분자 추출해야 됨
            return true;
        } else { // 바로 계산 ㄱㄱ
            return false;
        }
    }

    // <숫자 - 숫자 외 모든것> 분리
    private List<String> separation(String given, List<String> separtors) {
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
        inputValidator.validatingSeparator(separated, separtors);
        inputValidator.lastElement(separated);

        return separated;
    }

    // 커스텀 구분자 저장
    private List<String> findCustomSeparator(String given) {
        String customSeparator = inputValidator.customValidator(given);

        return Arrays.asList(customSeparator, given.substring(given.indexOf("\\n") + 2));
    }
}

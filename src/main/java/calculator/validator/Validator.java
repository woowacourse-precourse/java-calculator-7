package calculator.validator;

import java.util.ArrayList;

public class Validator {

    //문자열이 비어있는지 검사
    public boolean checkIsEmpty(String input) {
        //문장이 비어있으면 false, 존재하면 true
        return !input.isEmpty();
    }

    //문자열에 숫자가 존재하는지 검사
    public boolean checkHasNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            //숫자가 하나라도 있으면 true
            if (Character.isDigit(input.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    //커스텀 구분자를 사용하였는지 검사
    public boolean checkCustomSeparator(String input, ArrayList<String> separators) {
        // "//"로 시작안하면 커스텀 구분자를 사용안하기 때문에 리턴
        if (input.charAt(0) != '/' && input.charAt(1) != '/') {
            return true;
        }
        for (int i = 2; i < input.length(); i++) {
            if (input.charAt(i) == '\\' && input.charAt(i + 1) == 'n') {
                separators.add(input.substring(2, i));
                return true;
            }
        }
        return false;
    }

    //구분자가 아닌 다른 문자가 있는지 검사
    public boolean checkIsCorrectString(String input, ArrayList<String> separators) {
        // 커스텀 구분자가 있는지 확인
        if (input.startsWith("//")) {
            // "\n"의 위치 찾기
            int newlineIndex = input.indexOf("\\n");
            if (newlineIndex == -1 || newlineIndex <= 2) {
                return false; // 형식이 잘못된 경우
            }
            // 커스텀 구분자 이후의 문자열만 처리
            input = input.substring(newlineIndex + 2);
        }
        int i = 0;
        while (i < input.length()) {
            boolean isSeparator = false;

            // 구분자가 여러 글자일 수 있으므로, 구분자 리스트에서 체크
            for (String separator : separators) {
                if (i + separator.length() <= input.length() && input.startsWith(separator, i)) {
                    isSeparator = true;
                    i += separator.length(); // 구분자 길이만큼 건너뛰기
                    break;
                }
            }

            // 구분자가 아닌 경우, 해당 문자가 숫자인지 확인
            if (!isSeparator) {
                char currentChar = input.charAt(i);
                if (!Character.isDigit(currentChar)) {
                    return false; // 숫자도 구분자도 아닌 경우
                }
                i++; // 다음 문자로 이동
            }
        }
        return true; // 모든 문자가 숫자이거나 구분자인 경우
    }
}

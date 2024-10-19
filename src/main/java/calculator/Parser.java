package calculator;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    public Parser() {

    }

    /**
     * 입력에서 커스텀 구분자를 파싱하는 함수 <p>
     * 1. 문장이 //로 시작하지 않을 경우 커스텀 구분자가 존재하지 않으므로 null을 반환한다. <p>
     * 2. 문장이 //로 시작하고 \n이 존재하지 않을 경우 IllegalArgumentException을 던집니다. <p>
     * 3. 문장이 //로 시작하고 \n이 존재하나, 사이에 아무런 문자도 존재하지 않는 경우 null을 반환한다.
     * @param input 입력 문자열
     * @return Character 커스텀 구분자
     */
    public Character parseCustomDelimiter(String input) {
        if (!isExistCustomDelimiter(input)) {
            return null;
        }

        int endIndex = input.indexOf("\n");
        if (endIndex == -1) {
            throw new IllegalArgumentException("올바르지 않은 문법입니다.");
        }

        // //와 \n 사이에 아무런 문자도 존재하지 않는 경우
        if (endIndex == 2) {
            return null;
        }

        return input.charAt(endIndex - 1);
    }

    /**
     * 커스텀 구분자가 존재하는지 확인하는 함수 <p>
     * 커스텀 구분자가 존재하는 경우는 아래 조건을 동시에 만족해야 합니다.<p>
     * 1. //로 시작한다. <p>
     * 2. \n을 포함한다.
     * @param input 입력 문자열
     * @return boolean 커스텀 구분자 존재 여부
     */
    private boolean isExistCustomDelimiter(String input) {
        if (!input.startsWith("//")) {
            return false;
        }

        if (!input.contains("\n")) {
            throw new IllegalArgumentException("올바르지 않은 문법입니다.");
        }

        return true;
    }

    /**
     * 입력에서 숫자를 리스트로 파싱하는 함수
     * @param input 입력 문자열
     * @param customDelimiter 커스텀 구분자
     * @return List 입력된 숫자 리스트
     */
    public List<Integer> parsePositiveIntegers(String input, Character customDelimiter) {
        String integersAndDelimiters = null;

        // customDelimiter가 존재하는 경우 = //*\n이 존재하는 경우
        if (customDelimiter != null) {
            int lastIndex = input.lastIndexOf("\n");
            integersAndDelimiters = input.substring(lastIndex + 1);
        }

        // customDelimiter가 존재하지 않는 경우 = 바로 숫자부터 시작하는 경우
        integersAndDelimiters = input;
        List<Integer> integers = new ArrayList<>();
        try {
            String[] integerStrs = integersAndDelimiters.split(",|:");
            for (String integerStr : integerStrs) {
                int number = Integer.parseInt(integerStr);
                if (number <= 0) {
                    throw new IllegalArgumentException("음수는 불가능합니다.");
                }
                integers.add(number);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("올바르지 않은 문법입니다.");
        }

        return integers;
    }
}

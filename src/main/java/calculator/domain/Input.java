package calculator.domain;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    private static String firstInput;
    private static String secondInput;


    public void readFirstInput() {
        firstInput = Console.readLine();
    }


    // 입력이 기본 형식인지 커스텀 형식인지 판단하는 메소드
    public boolean isDefaultInput() {
        if (firstInput.startsWith("//")) {
            return false;
        }
        return true;
    }

    //커스텀 문자를 분리해내는 메소드
    public void splitCustomSeparator() {
        validateCustomInputFormat();

        String[] parts = firstInput.split("\\\\n");

        // s1에는 구분자인 ';'을 넣고
        firstInput = parts[0].substring(2); // "//" 뒤에 있는 구분자를 추출
        System.out.println("firstInput :" + firstInput);

        // s2에는 숫자 문자열 '1;2;3'을 넣음
        secondInput = parts[1];
        System.out.println("secondInput :" + secondInput);
    }

    private void validateCustomInputFormat() {
        System.out.println("firstInput : " + firstInput);

        if (!firstInput.contains("\\n")) {
            throw new IllegalArgumentException("입력 문자열에 \\n이 포함되어 있지 않습니다.");
        }
    }

    public String getFirstInput() { //???
        return firstInput;
    }

    public String getSecondInput() { //???
        return secondInput;
    }
}

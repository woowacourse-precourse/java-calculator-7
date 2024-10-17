package calculator.service;

import camp.nextstep.edu.missionutils.Console;

public class InputService {

    private String userInput; // 사용자의 입력
    private char customDelimiter; // 사용자가 입력한 커스텀 구분자

    public InputService() {
        this.userInput = "//;\n1;2;3";
    }

    // 사용자의 입력을 받는다.
    public void enterInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        this.userInput = Console.readLine();
    }

    // 커스텀 구분자가 있는 문자열인지 확인한다.
    public boolean isCustomDelimiter() {
        if (userInput.length() >= 4) {
            if (userInput.startsWith("//") && userInput.charAt(3) == '\n') {
                this.customDelimiter = userInput.charAt(2);
                return true;
            }
        }
        return false;
    }

    // 커스텀 구분자 이후의 문자열에서 숫자들을 분리해서 저장한다.
    public String[] separateString() {
        String afterCustomDelimiter = this.userInput.substring(4);
        return afterCustomDelimiter.split(String.valueOf(customDelimiter));
    }

    public char getCustomDelimiter() {
        return this.customDelimiter;
    }
}

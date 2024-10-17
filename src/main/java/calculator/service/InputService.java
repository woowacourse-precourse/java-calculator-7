package calculator.service;

import camp.nextstep.edu.missionutils.Console;

public class InputService {

    private String userInput; // 사용자의 입력
    private char[] defaultDelimeter; // 기본 구분자인 쉼표와 콜론
    private char customDelimiter; // 사용자가 입력한 커스텀 구분자

    public InputService() {
        this.userInput = "//;\n1;2;3";
        this.defaultDelimeter = new char[]{',', ':'};
    }

    public void enterInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        this.userInput = Console.readLine();
    }

    public boolean isCustomDelimiter() {
        if (userInput.length() >= 5) {
            if (userInput.startsWith("//") && userInput.charAt(3) == '\n') {
                this.customDelimiter = userInput.charAt(2);
                return true;
            }
        }
        return false;
    }

    public String getUserInput() {
        return this.userInput;
    }

    public char[] getDefaultDelimeter() {
        return this.defaultDelimeter;
    }

    public char getCustomDelimiter() {
        return this.customDelimiter;
    }
}

package calculator.service;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputService {

    private String userInput; // 사용자의 입력
    private char customDelimiter; // 사용자가 입력한 커스텀 구분자

    public InputService() {
        this.userInput = "1:2:3,,,,4:,:,:,1";
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

    // 커스텀 구분자가 없을 때, 문자열에서 숫자들을 분리해서 저장한다.
    public String[] separateNumberWithDefaultDelimiter() {

        List<String> numbers = new ArrayList<>();
        // ,와 :를 사용해서 분리한다.
        String[] parts = userInput.split("[,:]");

        // 분리한 각 String이 숫자인지 확인한다.
        for (String part : parts) {
            if (part.matches("\\d+"))
                numbers.add(part);
        }

        return numbers.toArray(String[]::new);
    }

    // 커스텀 구분자 이후의 문자열에서 숫자들을 분리해서 저장한다.
    public String[] separateNumberWithCustomDelimiter() {
        String afterCustomDelimiter = this.userInput.substring(4);
        return afterCustomDelimiter.split(String.valueOf(customDelimiter));
    }

    public char getCustomDelimiter() {
        return this.customDelimiter;
    }
}

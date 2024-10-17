package calculator.service;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputService {

    private String userInput; // 사용자의 입력
    private char customDelimiter; // 사용자가 입력한 커스텀 구분자

    public InputService() {
        this.userInput = "//-\n-9223372036854775807-1";
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
    public String[] separateNumberWithDefaultDelimiter() throws IllegalArgumentException {
        // ,와 :를 사용해서 분리한다.
        String[] parts = userInput.split("[,:]");

        // 분리한 각 String이 올바른 입력 형태의 숫자인지 확인한다.
        return isWrongInput(parts);
    }

    // 커스텀 구분자 이후의 문자열에서 숫자들을 분리해서 저장한다.
    public String[] separateNumberWithCustomDelimiter() {
        String afterCustomDelimiter = this.userInput.substring(4);
        String[] parts = afterCustomDelimiter.split(String.valueOf(customDelimiter));

        // 분리한 각 String이 올바른 입력 형태의 숫자인지 확인한다.
        return isWrongInput(parts);
    }

    // 기능 4-1 : 구분자를 제외한 다른 문자가 있는지 확인한다.
    private String[] isWrongInput(String[] parts) {
        List<String> numbers = new ArrayList<>();
        for (String part : parts) {
            // 구분자로 분리하는 과정에서 빈 문자열이 생길 수도 있으니, 제외한다.
            if (!part.isEmpty()) {
                if (part.matches("\\d+")) {
                    // 기능 4-2 : 어떤 숫자가 Long 타입의 범위를 넘어서는 경우를 확인한다.
                    try {
                        long value = Long.parseLong(part);
                        numbers.add(part);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("제한 범위를 넘어서는 값을 입력했습니다. 잘못된 입력입니다.");
                    }
                } else {
                    throw new IllegalArgumentException("구분자가 아닌 문자가 포함되어 있습니다. 잘못된 입력입니다.");
                }
            }
        }
        return numbers.toArray(String[]::new);
    }
}

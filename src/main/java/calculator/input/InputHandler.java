package calculator.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputHandler implements InputHandlerImpl {
    @Override
    public List<Long> inputProcessor() {
        //입력
        System.out.println("덧셈할 문자열을 입력해 주세요");
        InputDto inputDto = new InputDto(Console.readLine());
        Console.close();

        //구분자 처리
        String convertedInput = convertInput(inputDto.getInput());
        //숫자 처리
        return getNumbers(convertedInput);
    }

    @Override
    public String convertInput(String input) {
        if (!input.startsWith("//")) {
            return input;
        }

        String separator = getSeparator(input);
        return input.substring(separator.length() + 4).replace(separator, ",");
    }

    private String getSeparator(String input) {
        StringBuilder sb = new StringBuilder();
        String[] strArr = input.substring(2).split("");

        int idx = 0;
        int strLen = strArr.length;
        while (true) {
            if (idx + 1 == strLen) {
                throw new IllegalArgumentException();
            }
            if (strArr[idx].equals("\\") && strArr[idx + 1].equals("n")) {
                break;
            }
            sb.append(strArr[idx++]);
        }

        return sb.toString();
    }

    @Override
    public List<Long> getNumbers(String input) {

        List<Long> numbers = new ArrayList<>();

        String[] splitInput = input.split("[,;]");
        for (String str : splitInput) {
            if (str.isEmpty()) {
                continue;
            }
            if (!isValidate(str)) {
                throw new IllegalArgumentException();
            }
            numbers.add(Long.parseLong(str));
        }

        return numbers;
    }

    private boolean isValidate(String str) {
        String REGEXP_ONLY_NUM = "^[\\d*$]";

        //숫자인지 검사
        if (!str.matches(REGEXP_ONLY_NUM)) {
            return false;
        }

        //Long 범위 검사
        try {
            //음수면 false
            return Long.parseLong(str) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
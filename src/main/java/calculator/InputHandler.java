package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputHandler {
    public List<Long> inputProcessor() {
        String input = getInput();
        String convertedInput = convertInput(input);

        return getNumbers(convertedInput);
    }

    private static String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요");
        String input = Console.readLine();
        Console.close();

        return input;
    }

    private String convertInput(String input) {
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

    private List<Long> getNumbers(String input) {
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
        //양수인지 검사
        String REGEXP_ONLY_NUM = "^\\d+$";
        if (!str.matches(REGEXP_ONLY_NUM)) {
            return false;
        }

        //Long 범위 검사
        try {
            Long.parseLong(str);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}
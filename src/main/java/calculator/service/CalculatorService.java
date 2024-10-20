package calculator.service;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorService {

    public void printPrompt() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public String input() {
        String text = Console.readLine().trim();
        if (text.isEmpty()) {
            return "0";
        }
        return text;
    }

    public String[] parsingInput(String rawInput) {
        if (rawInput.contains(",") || rawInput.contains(":")) {
            if (rawInput.startsWith(",") || rawInput.endsWith(":") || rawInput.startsWith(":") || rawInput.endsWith(",")) {
                throw new IllegalArgumentException("잘못된 입력값입니다.");
            }
            return rawInput.split("[,:]");
        } else if (rawInput.startsWith("//") && rawInput.contains("\\n")) {
            int index = rawInput.indexOf("\\n");
            String custom = rawInput.substring(2, index);
            rawInput = rawInput.substring(index+2);
            if ((rawInput.startsWith(custom) || rawInput.endsWith(custom))) {
                throw new IllegalArgumentException("잘못된 입력값입니다.");
            }
            return rawInput.split(custom);
        }
        return new String[]{rawInput};
    }

    public String[] validateInput(String[] paredInput) {
        for (String s : paredInput) {
            try {
                int num = Integer.parseInt(s);
                if (num < 0) {
                    throw new IllegalArgumentException("잘못된 입력값입니다.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 입력값입니다.");
            }
        }
        return paredInput;
    }

    public int sum(String[] nums) {
        int result = 0;
        for (String num : nums) {
            result += Integer.parseInt(num);
        }
        return result;
    }

    public void printResult(int result) {
        System.out.println("결과 : " + result);
    }
}

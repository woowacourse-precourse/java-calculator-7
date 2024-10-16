package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {
    public void displayInputMessage() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public String getInput() {
        return Console.readLine();
    }

    public int add(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력 값이 null입니다.");
        }
        if (input.isEmpty()) {
            return 0;
        }

        return 0;
    }

    public String preprocess(String input) {
        return input.replaceAll("\\s", "");
    }

    public String extractCustomDelimiter(String input) {
        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\n");
            if (newlineIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
            }
            String delimiter = input.substring(2, newlineIndex);

            if (delimiter.matches(".*\\d.*")) {
                throw new IllegalArgumentException("커스텀 구분자는 숫자가 될 수 없습니다.");
            }
            if (delimiter.isEmpty()) {
                throw new IllegalArgumentException("커스텀 구분자가 비어 있습니다.");
            }
            return delimiter;
        }
        return null;
    }

    public String[] splitNumbers(String input, String delimiter) {
        if (delimiter != null) {
            int startIndex = delimiter.length() + 3;
            input = input.substring(startIndex);
        } else {
            delimiter = ",|:";
        }

        String[] numbers = input.split(delimiter);

        for (String number : numbers) {
            if (number.isEmpty()) {
                throw new IllegalArgumentException("구분자 사이에 숫자가 없습니다.");
            }
        }
        return numbers;
    }

    public int calculateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            int num;
            try {
                num = Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
            }
            if (num < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
            sum += num;
        }
        return sum;
    }
}

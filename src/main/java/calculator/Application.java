package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    // 들어온 인자들의 검증 메서드들을 관장하는 메서드
    public static String[] checkInput (String input, StringBuilder delimiter) {
        String processedInput = extractCustomDelimiter(input, delimiter);
        if (!validateInput(processedInput, delimiter)) {
            throw new IllegalArgumentException("wrong arguments");
        }
        return checkDuplicateDelimiter(processedInput.split(delimiter.toString()));
    }

    // 커스텀 구분를 확인하는 메서드
    public static String extractCustomDelimiter(String input, StringBuilder delimiter) {
        String processedInput = input;
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("custom delimiter error");
            }
            delimiter.append(input, 2, delimiterEndIndex);
            processedInput = input.substring(delimiterEndIndex + 2);
        }
        delimiter.append("]");
        return processedInput;
    }

    // 들어온 인자가 맞는 형식을 지켰는지 확인하는 메서드
    public static boolean validateInput(String input, StringBuilder delimiter) {
        String regex = "^[0-9" + delimiter.substring(1) + "+$";
        return input.matches(regex);
    }

    // 구분자가 숫자 구분자 숫자 순서가 아닌 숫자 구분자 구분자 숫자 식으로 들어왔을 때를 걸러주는 메서드
    public static String[] checkDuplicateDelimiter (String[] splitInput) {
        for (String str : splitInput) {
            if (str.equals("")) {
                throw new IllegalArgumentException("delimiter duplicate");
            }
        }
        return splitInput;
    }

    // 인자들을 더해주는 메서드
    public static int calculateSum(String[] splitInput) {
        int sum = 0;
        for (String input : splitInput) {
            sum += Integer.parseInt(input);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        StringBuilder delimiter = new StringBuilder("[,:");
        String input = Console.readLine();
        String[] splitInput = checkInput(input, delimiter);
        System.out.println("결과 : " + calculateSum(splitInput));
    }
}

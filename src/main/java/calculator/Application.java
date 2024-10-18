package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String delimiter = ",|:";
//        String delimiter = ",:";
        int sum;
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = readLine();
        try {
            delimiter = checkInput(input, delimiter);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        String[] numbers = splitInput(input, delimiter);
        for (String number : numbers) {
            System.out.print(number + ' ');
        }
//        sum = getSum();
//        System.out.println("sum = " + sum);
    }

    private static String[] splitInput(String input, String delimiter) {
        return input.split(delimiter);
    }

    private static String checkInput(String input, String delimiter) throws IllegalArgumentException {
        if (input.substring(0, 2).equals("//") && input.contains("\\n")) {
            String newDelimiter = extractDelimiter(input);
            delimiter += "|" + newDelimiter;
            input = input.substring(input.indexOf("\\n") + 2, input.length());
        }
        for (char c : input.toCharArray()) {
            if (!validateInput(c, delimiter)) {
                throw new IllegalArgumentException("잘못된 입력");
            }
        }
        return delimiter;
    }

    private static boolean validateInput(char c, String delimiter) {
        return Character.isDigit(c) || delimiter.indexOf(c) != -1;
    }

    private static String extractDelimiter(String input) {
//        String newDelimiter = input.split("//")[1].split("|\n|")[0];
        return input.substring(2, input.indexOf("\\n"));
    }
}

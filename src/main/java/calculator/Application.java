package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.PatternSyntaxException;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        int result = StringCalculator.add(input);
        System.out.println("결과 : " + result);
    }
}

class StringCalculator {
    public static int add(String input) {
        if(input == null || input.isEmpty())
            return 0;

        String delimiter = ",:";
        if(input.startsWith("//")) {
            int endIdx = input.indexOf("\\n");
            if(endIdx == -1) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
            }
            delimiter = input.substring(2, endIdx);
            input = input.substring(endIdx + 2);
            if(input.isEmpty()) return 0;
        }
        String[] numbers = splitString(input, delimiter);

        int sum = 0;
        for(String number : numbers) {
            int num = parseNumber(number);
            sum += num;
        }
        return sum;
    }

    private static int parseNumber(String number) {
        try {
            int num = Integer.parseInt(number);
            if(num < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + num);
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자가 포함되어 있습니다: " + number);
        }
    }

    private static String[] splitString(String input, String delimiter) {
        try {
            if(delimiter.isEmpty()) {
                throw new IllegalArgumentException("커스텀 구분자가 입력되지 않았습니다.");
            }

            String delimiters = String.join("|", delimiter.split(""));
            if(delimiter.matches(".*\\d.*")) {
                throw new IllegalArgumentException("숫자는 커스텀 구분자가 될 수 없습니다.: " + delimiter);
            }
            return input.split(escapeMetaCharacter(delimiters));
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException("커스텀 구분자의 입력이나 처리가 올바르지 않습니다.: " + delimiter);
        }
    }

    private static String escapeMetaCharacter(String delimiter) {
        String[] metaCharacters = { ".", "^", "$", "*", "+", "?", "(", ")", "[", "]", "{", "}" };

        if(delimiter.contains("\\"))
            delimiter = delimiter.replace("\\", "\\\\");
        if(delimiter.contains("||"))
            delimiter = delimiter.replace("||", "|\\|");

        for(String meta : metaCharacters) {
            if(delimiter.contains(meta)) {
                delimiter = delimiter.replace(meta, "\\"+meta);
            }
        }
        return delimiter;
    }

}
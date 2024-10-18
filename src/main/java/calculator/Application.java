package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine(); //사용자입력

        // 입력을 구분자로 나누기
        try {
            String[] parts = splitInput(input); //배열화된 입력된 숫자
            isNum(parts); //
            int sum = sumNumbers(parts);
            System.out.println("합계: " + sum);
        } catch (IllegalArgumentException e) {
            System.out.println("error");
        }

    }

    // 입력된 문자열을 구분자로 나누는 메서드
    public static String[] splitInput(String input) {
        String numbers = removePdelimiter(input);
        return numbers.split(delimiter(input)); // 콤마와 콜론을 구분자로 사용하여 문자열을 나눔
    }

    //나눠진 문자를 합하는 메서드
    public static int sumNumbers(String[] parts) {
        int sum = 0;

        for (String part : parts) {
            sum += Integer.parseInt(part);
        }
        return sum;
    }

    //나눠진 문자들이 전부 숫자인지 확인하는 메서드
    public static boolean isNum(String[] parts) {

        for (String part : parts) {
            stringToChar(part);
        }
        return true;
    }

    //문자 배열을 char형태로 변경 후 검사하는 메서드
    public static void stringToChar(String part) {
        for (char c : part.toCharArray()) {
            isDigit(c);
        }
    }

    //char 자료를 숫자인지 확인하고 아니면 에러내는 메서드
    public static void isDigit(char c) {
        if (!Character.isDigit(c)) {
            throw new IllegalArgumentException(); //
        }
    }

    //
    public static String delimiter(String input) {
        if (input.startsWith("//") && input.contains("\\n")) {
            int index = input.indexOf("\\n");
            return "[,:" + input.substring(2, index) + "]";

        }
        return "[,:]";
    }

    public static String removePdelimiter(String input) {
        if (input.startsWith("//") && input.contains("\\n")) {
            int index = input.indexOf("\\n");
            String substring = input.substring(index + 2, input.length());
            return substring;
        }
        return input;
    }

}
